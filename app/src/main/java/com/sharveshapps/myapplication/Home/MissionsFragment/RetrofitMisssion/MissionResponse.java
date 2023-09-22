package com.sharveshapps.myapplication.Home.MissionsFragment.RetrofitMisssion;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MissionResponse {
    @SerializedName("missions")
    private List<Mission> missions;

    public List<Mission> getMissions() {
        return missions;
    }
}

