package com.sharveshapps.myapplication.Authentication.Retrofit;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("client_id")
    private String clientId;

    private String username;
    private String password;

    @SerializedName("force_login")
    private boolean forceLogin;
    @SerializedName("auth_data")
    private AuthData authData;

    public AuthData getAuthData() {
        return authData;
    }

    @SerializedName("offline_token")
    private OfflineToken offlineToken;

    public LoginRequest(String clientId, String username, String password, boolean forceLogin) {
        this.clientId = clientId;
        this.username = username;
        this.password = password;
        this.forceLogin = forceLogin;
    }

    // Getters and setters (you can generate them automatically in most IDEs)
}
