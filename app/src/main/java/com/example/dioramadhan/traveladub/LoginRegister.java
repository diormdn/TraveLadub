package com.example.dioramadhan.traveladub;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LoginRegister extends AppCompatActivity implements LoginFragment.OnFragmentInteractionListener, RegisterFragment.OnFragmentInteractionListener {
    FragmentManager _FM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginregister_screen);

        _FM = getSupportFragmentManager();
        LoginFragment frL = LoginFragment.newInstance("0","0");
        _FM.beginTransaction().replace(R.id.fragmentLayout,frL).commit();

    }

    @Override
    public void onLoginFragmentInteraction() {
        RegisterFragment frR = RegisterFragment.newInstance("0","0");
        _FM.beginTransaction().replace(R.id.fragmentLayout,frR).addToBackStack(null).commit();
    }

    @Override
    public void onRegisterFragmentInteraction() {
        LoginFragment frL = LoginFragment.newInstance("0","0");
        _FM.beginTransaction().replace(R.id.fragmentLayout,frL).commit();
    }
}
