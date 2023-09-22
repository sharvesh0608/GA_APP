package com.sharveshapps.myapplication.Home.MissionsFragment.RetrofitMisssion;


import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;


//    @GET("castor/Mission/v2/pilot/missions")
//    Call<List<Mission>> getUpcomingMissions(
//            @Query("offset") int offset,
//            @Query("limit") int limit,
//            @Query("status") String status,
//            @Query("customer_id") int customerId,
//            @Query("sort") String sort
//    );

    public interface MissionApiService {
        @GET("castor/Mission/v2/pilot/missions")
        Call<MissionResponse> getUpcomingMissions(
                @HeaderMap Map<String, String> headers,
                @Query("offset") int offset,
                @Query("limit") int limit,
                @Query("status") String status,
                @Query("customer_id") int customerId,
                @Query("sort") String sort
        );
    }
