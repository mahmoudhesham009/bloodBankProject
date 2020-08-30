package com.example.epda3.data.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    static public String baseURL = "http://ipda3-tech.com/blood-bank/api/v1/";
    static public Retrofit retrofit=null;

    static public Retrofit getClient(){
        if (retrofit==null){
            retrofit=new Retrofit
                    .Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
