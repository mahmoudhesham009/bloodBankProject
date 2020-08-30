package com.example.epda3.view.fragmen;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.epda3.view.activity.BaseActivity;


public class BaseFragment extends Fragment {
    public BaseActivity baseActivity;

    public void initFrag (){
        baseActivity= (BaseActivity) getActivity();
        baseActivity.baseFragment=this;
    }

    public void onBack (){

    }

}
