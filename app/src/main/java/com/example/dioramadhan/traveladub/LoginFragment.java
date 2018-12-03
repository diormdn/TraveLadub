package com.example.dioramadhan.traveladub;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class LoginFragment extends Fragment implements View.OnClickListener {

    private ImageView logo;
    private EditText usernameTxt, passwordTxt;
    private Button masukBtn;
    private TextView txtBelumPunyaAkun, txtDaftar;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

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
        this.logo = (ImageView) rootView.findViewById(R.id.imageView);
        this.usernameTxt = (EditText) rootView.findViewById(R.id.usernameTxt);
        this.passwordTxt = (EditText) rootView.findViewById(R.id.passwordTxt);
        this.masukBtn = (Button) rootView.findViewById(R.id.masukBtn);
        this.txtBelumPunyaAkun = (TextView) rootView.findViewById(R.id.txtBelumPunyaAkun);
        this.txtDaftar = (TextView) rootView.findViewById(R.id.txtDaftar);
        this.txtDaftar.setOnClickListener(this);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction();
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
            Log.d("aaaa","masukk");
            mListener.onFragmentInteraction();
        }
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction();
    }
}
