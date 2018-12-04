package com.example.dioramadhan.traveladub;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;


public class LoginFragment extends Fragment implements View.OnClickListener {

    private ImageView logo;
    private EditText emailTxt, passwordTxt;
    private Button masukBtn;
    private TextView txtBelumPunyaAkun, txtDaftar;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private FirebaseAuth mAuth;

    private OnFragmentInteractionListener mListener;

    public LoginFragment() {
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() != null){
            Intent i = new Intent(getActivity().getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_login, container, false);
        initView(rootView);
        return rootView;
    }

    public void initView(View rootView){
        this.logo = rootView.findViewById(R.id.imageView);
        this.emailTxt = rootView.findViewById(R.id.emailTxt);
        this.passwordTxt = rootView.findViewById(R.id.passwordTxt);
        this.masukBtn = rootView.findViewById(R.id.masukBtn);
        this.txtBelumPunyaAkun = rootView.findViewById(R.id.txtBelumPunyaAkun);
        this.txtDaftar = rootView.findViewById(R.id.txtDaftar);
        this.txtDaftar.setOnClickListener(this);
        this.masukBtn.setOnClickListener(this);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onLoginFragmentInteraction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.txtDaftar){
            mListener.onLoginFragmentInteraction();
        }else{
            mAuth = FirebaseAuth.getInstance();
            mAuth.signInWithEmailAndPassword(emailTxt.getText().toString(), passwordTxt.getText().toString())
                    .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                //Login berhasil
                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference myRef = database.getReference("profil").child(mAuth.getUid());
                                myRef.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        //Login Berhasil

                                        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
                                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                                        Gson gson = new Gson();
                                        Pengguna mPengguna = dataSnapshot.getValue(Pengguna.class);
                                        String json = gson.toJson(mPengguna);
                                        prefsEditor.putString("pengguna", json);
                                        prefsEditor.apply();

                                        Toast.makeText(getActivity(), "Selamat Datang, " + mPengguna.getNama(), Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                                        startActivity(i);
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError error) {
                                        Toast.makeText(getActivity(), "Maaf Gagal Membaca Biodata Anda", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            } else {
                                //Login gagal

                                Toast.makeText(getActivity(), "Maaf Email Dan Password Anda Salah", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }


    public interface OnFragmentInteractionListener {
        void onLoginFragmentInteraction();
    }
}
