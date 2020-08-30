package com.example.epda3.view.fragmen.userCycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.epda3.R;
import com.example.epda3.data.api.ApiIntrface;
import com.example.epda3.data.local.Helper;
import com.example.epda3.data.model.forgetPasswors.ForgetPasswors;
import com.example.epda3.view.fragmen.BaseFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.epda3.data.api.ApiClient.getClient;

public class ForgetPassWordFragment extends BaseFragment {

    View v;

    EditText phone ;
    Button send;

    ApiIntrface apiIntrface;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initFrag();
        v=inflater.inflate(R.layout.fragment_forget_password,container,false);
        phone=v.findViewById(R.id.fragment_user_forgetpass_tex);
        send=v.findViewById(R.id.fragment_user_forgetpass_send);
        apiIntrface=getClient().create(ApiIntrface.class);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                apiIntrface.forgetPass(phone.getText().toString()).enqueue(new Callback<ForgetPasswors>() {
                    @Override
                    public void onResponse(Call<ForgetPasswors> call, Response<ForgetPasswors> response) {
                        if (response.body().getStatus()==1){
                            Helper.replaceFragment(getFragmentManager(),R.id.frame_user,new NewPassWordFragment(phone.getText().toString()));
                            Toast.makeText(getActivity(),response.body().getMsg(),Toast.LENGTH_SHORT).show();
                        }
                        else if (response.body().getStatus()==0){
                            Toast.makeText(getActivity(),response.body().getMsg(),Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ForgetPasswors> call, Throwable t) {

                    }
                });


            }
        });

        return v;
    }


    @Override
    public void onBack() {
        Helper.replaceFragment(getFragmentManager(),R.id.frame_user,new LoginFragment());


    }
}
