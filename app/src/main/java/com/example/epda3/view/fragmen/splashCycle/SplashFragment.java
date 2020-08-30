package com.example.epda3.view.fragmen.splashCycle;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.epda3.R;
import com.example.epda3.data.local.Helper;
import com.example.epda3.view.fragmen.BaseFragment;

import java.util.zip.Inflater;

public class SplashFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initFrag();
        View v= inflater.inflate(R.layout.fragment_splash,container,false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                try {
                    Helper.replaceFragment(getActivity().getSupportFragmentManager(),R.id.frame_layout,new SliderFragment());
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }, 3 * 1000);
    }

    @Override
    public void onBack() {
    }
}
