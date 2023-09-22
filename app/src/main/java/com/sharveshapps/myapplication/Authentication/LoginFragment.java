package com.sharveshapps.myapplication.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sharveshapps.myapplication.Authentication.Retrofit.AuthData;
import com.sharveshapps.myapplication.Authentication.Retrofit.LoginRequest;
import com.sharveshapps.myapplication.Authentication.Retrofit.LoginRetroInterface;
import com.sharveshapps.myapplication.Authentication.Retrofit.RetrofitClient;
import com.sharveshapps.myapplication.Home.Home;
import com.sharveshapps.myapplication.R;
import com.sharveshapps.myapplication.SharedPref.SharedPreferencesHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {
    private EditText emailEdt, passEdt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inside onViewCreated or any other appropriate method
        Button loginButton = view.findViewById(R.id.lgnBtn);
        emailEdt = view.findViewById(R.id.etdEmail);
        passEdt = view.findViewById(R.id.etdPass);
        loginButton.setOnClickListener(v -> {
            // Call the method to initiate the API request
            loginUser();
        });
    }

    private void loginUser() {
        // Get the entered email and password
        String email = emailEdt.getText().toString();
        String password = passEdt.getText().toString();

        // Create a LoginRequest object with the entered email and password
        LoginRequest request = new LoginRequest("ga-pilot-app", email, password, true);

        // Make the API request using Retrofit
        LoginRetroInterface apiService = RetrofitClient.getRetrofitInstance().create(LoginRetroInterface.class);

        Call<LoginRequest> call = apiService.login(request);

        call.enqueue(new Callback<LoginRequest>() {
            @Override
            public void onResponse(Call<LoginRequest> call, Response<LoginRequest> response) {
                // Handle the API response here
                if (response.isSuccessful()) {
                    LoginRequest loginResponse = response.body();
                    AuthData authData = loginResponse.getAuthData();
                    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(getContext());
                    sharedPreferencesHelper.saveAuthData(authData);
                    // Authentication successful, navigate to HomeActivity
                    Intent intent = new Intent(getActivity(), Home.class);
                    startActivity(intent);
                    getActivity().finish(); // Optional: Finish the login activity if needed
                } else {
                    // Authentication failed, display an error message or handle it as needed
                    Toast.makeText(getContext(), "Authentication failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginRequest> call, Throwable t) {
                // Handle network or other errors here
                Toast.makeText(getContext(), "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
