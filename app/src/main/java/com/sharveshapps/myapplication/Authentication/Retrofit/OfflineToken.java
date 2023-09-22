package com.sharveshapps.myapplication.Authentication.Retrofit;

import com.google.gson.annotations.SerializedName;

public class OfflineToken {
    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("expires_in")
    private long expiresIn;

    @SerializedName("refresh_expires_in")
    private long refreshExpiresIn;

    // Other fields in offline_token
    // ...
}
