package com.example.dioramadhan.traveladub;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

public class RegisterFragment extends Fragment implements View.OnClickListener {

    private EditText namaTxt, emailTxt, usernameTxt, passwordTxt;
    private ImageView imageView;
    private Button btnDaftar;
    private TextView txtSudahPunyaAkun, txtMasuk;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public RegisterFragment() {
    }

    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        View rootView = inflater.inflate(R.layout.fragment_register, container, false);
        initView(rootView);
        return rootView;
    }

    public void initView(View rootView){
        this.imageView = rootView.findViewById(R.id.imageView);
        this.namaTxt = rootView.findViewById(R.id.namaTxt);
        this.emailTxt = rootView.findViewById(R.id.emailTxt);
        this.usernameTxt = rootView.findViewById(R.id.emailTxt);
        this.passwordTxt = rootView.findViewById(R.id.passwordTxt);
        this.txtSudahPunyaAkun = rootView.findViewById(R.id.txtSudahPunyaAkun);
        this.txtMasuk = rootView.findViewById(R.id.txtMasuk);
        this.btnDaftar = rootView.findViewById(R.id.btnDaftar);
        this.txtMasuk.setOnClickListener(this);
        this.btnDaftar.setOnClickListener(this);
    }

    public void onButtonPressed(String string) {
        if (mListener != null) {
            mListener.onRegisterFragmentInteraction();
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
        if(v.getId() == R.id.txtMasuk){
            mListener.onRegisterFragmentInteraction();
        }else{

            final FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(emailTxt.getText().toString(),passwordTxt.getText().toString())
                    .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                FirebaseUser user = mAuth.getCurrentUser();
                                Pengguna mPengguna = new Pengguna(namaTxt.getText().toString(),
                                        emailTxt.getText().toString(),
                                        usernameTxt.getText().toString());

                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference myRef = database.getReference("profil");
                                myRef.child(user.getUid()).setValue(mPengguna);

                                SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
                                SharedPreferences.Editor prefsEditor = mPrefs.edit();
                                Gson gson = new Gson();
                                String json = gson.toJson(mPengguna);
                                prefsEditor.putString("pengguna", json);
                                prefsEditor.apply();
                                mListener.onRegisterFragmentInteraction();
                            }
                            else{
                                Toast.makeText(getActivity(), "Email Sudah Terdaftar, " + namaTxt.getText().toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }


    public interface OnFragmentInteractionListener {
        void onRegisterFragmentInteraction();
    }
}
