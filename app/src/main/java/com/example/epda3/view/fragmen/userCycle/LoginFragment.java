package com.example.epda3.view.fragmen.userCycle;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.epda3.R;
import com.example.epda3.data.api.ApiIntrface;
import com.example.epda3.data.local.Helper;
import com.example.epda3.data.model.logIn.LogIn;
import com.example.epda3.view.activity.HomeActivity;
import com.example.epda3.view.fragmen.BaseFragment;
import com.example.epda3.view.fragmen.splashCycle.SliderFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.epda3.data.api.ApiClient.getClient;

public class LoginFragment extends BaseFragment {

    View v;
    ApiIntrface apiIntrface;
    EditText phone ;
    EditText passWord;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initFrag();
        v=inflater.inflate(R.layout.fragment_login,container,false);
        Button login=v.findViewById(R.id.fragment_user_login);
        Button regist=v.findViewById(R.id.fragment_user_regist);
        TextView forgetPass =v.findViewById(R.id.fragment_user_forgetpass);
        phone =v.findViewById(R.id.fragment_user_login_phone);
        passWord=v.findViewById(R.id.fragment_user_login_password);
        apiIntrface=getClient().create(ApiIntrface.class);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiIntrface.logIn(phone.getText().toString(),passWord.getText().toString()).enqueue(new Callback<LogIn>() {
                    @Override
                    public void onResponse(Call<LogIn> call, Response<LogIn> response) {
                        if(response.body().getStatus()==1){
                            Toast.makeText(getActivity(),"Hi "+response.body().getData().getClient().getName()+"!",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getActivity(), HomeActivity.class));
                        }
                        if(response.body().getStatus()==0){
                            Toast.makeText(getActivity(),response.body().getMsg()+"!",Toast.LENGTH_SHORT).show();

                        }

                    }

                    @Override
                    public void onFailure(Call<LogIn> call, Throwable t) {

                    }
                });


            }
        });

        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Helper.replaceFragment(getFragmentManager(),R.id.frame_user,new ForgetPassWordFragment());
            }
        });
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.replaceFragment(getFragmentManager(),R.id.frame_user,new RegistFragment());

            }
        });


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }

    @Override
    public void onBack() {
        baseActivity.finish();

    }
}
