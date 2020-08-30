package com.example.epda3.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.epda3.R;
import com.example.epda3.data.local.Helper;
import com.example.epda3.view.fragmen.splashCycle.SliderFragment;
import com.example.epda3.view.fragmen.splashCycle.SplashFragment;


public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Helper.replaceFragment(getSupportFragmentManager(),R.id.frame_layout,new SplashFragment());
    }
}
