package com.sharveshapps.myapplication.Home.MissionsFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sharveshapps.myapplication.Home.MissionsFragment.RetrofitMisssion.Mission;
import com.sharveshapps.myapplication.Home.MissionsFragment.RetrofitMisssion.MissionApiService;
import com.sharveshapps.myapplication.Home.MissionsFragment.RetrofitMisssion.MissionResponse;
import com.sharveshapps.myapplication.Home.MissionsFragment.RetrofitMisssion.MissionRetrofitClient;
import com.sharveshapps.myapplication.Home.MissionsFragment.Upcoming.RecycView.MissionAdapter;
import com.sharveshapps.myapplication.R;
import com.sharveshapps.myapplication.SharedPref.SharedPreferencesHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CompletedFragment extends Fragment {

    private SharedPreferencesHelper sharedPreferencesHelper;

    private MissionAdapter adapter;
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_completed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferencesHelper = new SharedPreferencesHelper(getContext());

        // Retrieve the access token from SharedPreferences
        String accessToken = sharedPreferencesHelper.getAccessToken();
        // Create a map for query parameters (if needed)
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("offset", "0");  // Replace with your desired offset
        queryParameters.put("limit", "10");   // Replace with your desired limit
        queryParameters.put("status", "completed");
        queryParameters.put("customer_id", "1186");  // Replace with your customer ID
        queryParameters.put("sort", "DESC");
        recyclerView = view.findViewById(R.id.completedRV);
        adapter = new MissionAdapter(new ArrayList<>());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        fetchCompletedMissions(accessToken, queryParameters);
    }
    private void fetchCompletedMissions(String accessToken, Map<String, String> queryParameters) {
        Retrofit retrofit = MissionRetrofitClient.getClient();
        MissionApiService apiService = retrofit.create(MissionApiService.class);
        String authorizationHeader = "Bearer " + accessToken;
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", authorizationHeader);
        Call<MissionResponse> call = apiService.getUpcomingMissions(
                headers,
                Integer.parseInt(Objects.requireNonNull(queryParameters.get("offset"))),
                Integer.parseInt(Objects.requireNonNull(queryParameters.get("limit"))),
                queryParameters.get("status"),
                Integer.parseInt(Objects.requireNonNull(queryParameters.get("customer_id"))),
                queryParameters.get("sort")
        );

        // Execute the API call (enqueue it)
        call.enqueue(new Callback<MissionResponse>() {
            @Override
            public void onResponse(Call<MissionResponse> call, Response<MissionResponse> response) {
                if (response.isSuccessful()) {
                    // Retrieve the list of missions from the response
                    List<Mission> missionsList = response.body().getMissions();

                    // Update your existing RecyclerView adapter with the missionsList
                    adapter.setMissions(missionsList);
                } else {
                    // Handle the error response
                    // You can display an error message or handle it as needed
                    Toast.makeText(getContext(), "Failed to fetch missions", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MissionResponse> call, Throwable t) {
                // Handle network or other errors here
                Toast.makeText(getContext(), "Network error", Toast.LENGTH_SHORT).show();
            }
        });


    }
}