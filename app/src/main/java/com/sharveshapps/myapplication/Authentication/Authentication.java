package com.sharveshapps.myapplication.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.sharveshapps.myapplication.R;

public class Authentication extends AppCompatActivity {
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        NavHostFragment navHostFragment =(NavHostFragment) getSupportFragmentManager().findFragmentById( R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        navController.navigate(R.id.loginFragment);

    }
}