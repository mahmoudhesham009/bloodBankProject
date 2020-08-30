package com.example.epda3.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.epda3.R;
import com.example.epda3.data.local.Helper;
import com.example.epda3.view.fragmen.userCycle.LoginFragment;


public class userCycle extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cycle);
        Helper.replaceFragment(getSupportFragmentManager(),R.id.frame_user, new LoginFragment());

    }
}
