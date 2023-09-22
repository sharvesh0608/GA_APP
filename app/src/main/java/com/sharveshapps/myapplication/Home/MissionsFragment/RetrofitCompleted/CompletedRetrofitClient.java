package com.sharveshapps.myapplication.Home.MissionsFragment.RetrofitCompleted;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompletedRetrofitClient {
    private static final String BASE_URL = "https://3lk83dl4ul.execute-api.ap-south-1.amazonaws.com/dev/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
