package com.sharveshapps.myapplication.Authentication.Retrofit;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginRetroInterface {
    @POST("nucleus/User/v2/login")
    Call<LoginRequest> login(@Body LoginRequest request);
}
