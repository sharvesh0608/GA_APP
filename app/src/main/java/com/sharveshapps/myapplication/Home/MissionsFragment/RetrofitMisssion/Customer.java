package com.sharveshapps.myapplication.Home.MissionsFragment.RetrofitMisssion;

import com.google.gson.annotations.SerializedName;

public class Customer {
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }
}
