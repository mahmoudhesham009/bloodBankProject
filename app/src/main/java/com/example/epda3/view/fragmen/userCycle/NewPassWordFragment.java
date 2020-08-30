package com.example.epda3.view.fragmen.userCycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

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

public class NewPassWordFragment extends BaseFragment {

    View v;
    EditText code;
    EditText newPass;
    EditText reNewpass;
    ApiIntrface apiIntrface;
    String phone;

    public NewPassWordFragment(String phone) {
        this.phone = phone;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initFrag();
        v=inflater.inflate(R.layout.fragment_new_password,container,false);

        code=v.findViewById(R.id.fragment_user_repass_code);
        newPass=v.findViewById(R.id.fragment_user_repass_newpass);
        reNewpass=v.findViewById(R.id.fragment_user_repass_renewpass);
        apiIntrface=getClient().create(ApiIntrface.class);
        apiIntrface.newPass(phone,code.getText().toString(),newPass.getText().toString(),reNewpass.getText().toString()).enqueue(new Callback<ForgetPasswors>() {
            @Override
            public void onResponse(Call<ForgetPasswors> call, Response<ForgetPasswors> response) {

            }

            @Override
            public void onFailure(Call<ForgetPasswors> call, Throwable t) {

            }
        });


        return v;
    }


    @Override
    public void onBack() {
        Helper.replaceFragment(getFragmentManager(),R.id.frame_user,new ForgetPassWordFragment());

    }
}
