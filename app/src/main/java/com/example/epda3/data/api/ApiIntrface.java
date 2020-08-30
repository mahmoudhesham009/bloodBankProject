package com.example.epda3.data.api;

import com.example.epda3.data.model.cities.Citise;
import com.example.epda3.data.model.forgetPasswors.ForgetPasswors;
import com.example.epda3.data.model.logIn.LogIn;
import com.squareup.okhttp.ResponseBody;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiIntrface {
    @GET("cities")
    Call<Citise> getCities(@Query("governorate_id")int governorateId);

    @GET("governorates")
    Call<Citise> getGovernorate();

    @GET("blood-types")
    Call<Citise> getBloodTypy();

    @POST("login")
    @FormUrlEncoded
    Call<LogIn> logIn(@Field("phone") String phone,
                      @Field("password") String passWord);

    @POST("signup")
    @FormUrlEncoded
    Call<LogIn> regist(@Field("name") String name,
                       @Field("email") String email,
                       @Field("birth_date") String birth,
                       @Field("city_id") int city,
                       @Field("phone") String phone,
                       @Field("donation_last_date") String donation,
                       @Field("blood_type_id") int blood,
                       @Field("password") String passWord,
                       @Field("password_confirmation") String passwordCon);

    @POST("reset-password")
    @FormUrlEncoded
    Call<ForgetPasswors> forgetPass(@Field("phone") String phone);

    @POST("new-password")
    @FormUrlEncoded
    Call<ForgetPasswors> newPass(@Field("phone") String phone,
                                 @Field("pin_code") String code,
                                 @Field("password") String pass,
                                 @Field("password_confirmation") String repass);
}
