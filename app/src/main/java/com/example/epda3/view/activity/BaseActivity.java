package com.example.epda3.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.epda3.view.fragmen.BaseFragment;


public class BaseActivity extends AppCompatActivity {

    public BaseFragment baseFragment;

    @Override
    public void onBackPressed() {
        baseFragment.onBack();
    }

    public void onSuperBack (){
        super.onBackPressed();
    }
}
