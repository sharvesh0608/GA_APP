package com.sharveshapps.myapplication.Authentication.Retrofit;

import com.google.gson.annotations.SerializedName;

public class AuthData {
    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("expires_in")
    private long expiresIn;

    @SerializedName("refresh_token")
    private String refreshToken;

    public String getAccessToken() {
        return accessToken;
    }

//    public long getExpiresIn() {
//        return expiresIn;
//    }
//
//    public String getRefreshToken() {
//        return refreshToken;
//    }
}
