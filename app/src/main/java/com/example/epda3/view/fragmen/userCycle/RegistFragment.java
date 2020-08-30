package com.example.epda3.view.fragmen.userCycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.epda3.R;
import com.example.epda3.data.api.ApiIntrface;
import com.example.epda3.data.local.Helper;
import com.example.epda3.data.model.cities.Citise;
import com.example.epda3.data.model.logIn.LogIn;
import com.example.epda3.view.fragmen.BaseFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.epda3.data.api.ApiClient.getClient;

public class RegistFragment extends BaseFragment {

    View v;

    Spinner gov;
    Spinner city;
    Spinner blood;

    EditText name_edit;
    EditText phone_edit;
    EditText email_edit;
    EditText birth_edit;
    EditText donation_edit;
    EditText pass_edit;
    EditText repass_edit;


    Button send;
    ApiIntrface apiIntrface;
    ArrayList<String> govName=new ArrayList<String>();
    ArrayAdapter <String> govSpinnerAdabter;

    ArrayList<String> cityName=new ArrayList<String>();
    ArrayAdapter <String>citySpinnerAdabter ;

    ArrayList<String> bloodType=new ArrayList<String>();
    ArrayAdapter <String> typeSpinnerAdabter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initFrag();
        v=inflater.inflate(R.layout.fragment_regist,container,false);
        gov=v.findViewById(R.id.fragment_user_regist_country);
        city=v.findViewById(R.id.fragment_user_regist_city);
        blood=v.findViewById(R.id.fragment_user_regist_type);
        send=v.findViewById(R.id.fragment_user_regist_send_btn);
        apiIntrface=getClient().create(ApiIntrface.class);
        apiIntrface.getGovernorate().enqueue(new Callback<Citise>() {
            @Override
            public void onResponse(Call<Citise> call, Response<Citise> response) {

                if (response.body().getStatus()==1){
                    for (int i=0;i<response.body().getData().size();i++){
                        govName.add(response.body().getData().get(i).getName());
                    }

                    govSpinnerAdabter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,govName);
                    gov.setAdapter(govSpinnerAdabter);
                }
            }

            @Override
            public void onFailure(Call<Citise> call, Throwable t) {

            }
        });

        gov.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                apiIntrface.getCities(position+1).enqueue(new Callback<Citise>() {
                    @Override
                    public void onResponse(Call<Citise> call, Response<Citise> response) {
                        if (response.body().getStatus()==1){
                            cityName.clear();
                            for (int i=0;i<response.body().getData().size();i++){
                                cityName.add(response.body().getData().get(i).getName());
                            }
                            citySpinnerAdabter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,cityName);
                            city.setAdapter(citySpinnerAdabter);
                        }

                    }

                    @Override
                    public void onFailure(Call<Citise> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        apiIntrface.getBloodTypy().enqueue(new Callback<Citise>() {
            @Override
            public void onResponse(Call<Citise> call, Response<Citise> response) {

                if (response.body().getStatus()==1){
                    for (int i=0;i<response.body().getData().size();i++){
                        bloodType.add(response.body().getData().get(i).getName());
                    }

                    typeSpinnerAdabter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,bloodType);
                    blood.setAdapter(typeSpinnerAdabter);
                }
            }

            @Override
            public void onFailure(Call<Citise> call, Throwable t) {

            }
        });



        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        name_edit=v.findViewById(R.id.fragment_user_regist_name);
        phone_edit=v.findViewById(R.id.fragment_user_regist_phone);
        email_edit=v.findViewById(R.id.fragment_user_regist_mail);
        birth_edit=v.findViewById(R.id.fragment_user_regist_date);
        donation_edit=v.findViewById(R.id.fragment_user_regist_last_donation);
        pass_edit=v.findViewById(R.id.fragment_user_regist_password);
        repass_edit=v.findViewById(R.id.fragment_user_regist_repassword);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                apiIntrface.regist( name_edit.getText().toString(),
                                    email_edit.getText().toString(),
                                    birth_edit.getText().toString(),
                               city.getSelectedItemPosition()+1,
                                    phone_edit.getText().toString(),
                                    donation_edit.getText().toString(),
                             blood.getSelectedItemPosition()+1,
                                    pass_edit.getText().toString(),
                                    repass_edit.getText().toString()).enqueue(new Callback<LogIn>() {
                    @Override
                    public void onResponse(Call<LogIn> call, Response<LogIn> response) {
                        if(response.body().getStatus()==1){
                            Toast.makeText(getActivity(),"done "+response.body().getData().getClient().getName()+"!",Toast.LENGTH_SHORT).show();
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
    }

    @Override
    public void onBack() {
        Helper.replaceFragment(getFragmentManager(),R.id.frame_user,new LoginFragment());

    }
}
