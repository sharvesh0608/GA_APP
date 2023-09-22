package com.sharveshapps.myapplication.SharedPref;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.sharveshapps.myapplication.Authentication.Retrofit.AuthData;

public class SharedPreferencesHelper {
    private static final String PREF_NAME = "YourSharedPreferencesName";
    private static final String AUTH_DATA_KEY = "authData";

    private final SharedPreferences sharedPreferences;
    private final Gson gson;

    public SharedPreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    // Save AuthData to SharedPreferences
    public void saveAuthData(AuthData authData) {
        String json = gson.toJson(authData);
        sharedPreferences.edit().putString(AUTH_DATA_KEY, json).apply();
    }

    // Retrieve AuthData from SharedPreferences
    public String getAccessToken() {
        String json = sharedPreferences.getString(AUTH_DATA_KEY, null);
        if (json != null) {
            AuthData authData = gson.fromJson(json, AuthData.class);
            return authData.getAccessToken();
        }
        return null;
    }
}
