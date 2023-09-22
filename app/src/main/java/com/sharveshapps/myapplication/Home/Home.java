package com.sharveshapps.myapplication.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.sharveshapps.myapplication.R;

public class Home extends AppCompatActivity {
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        NavHostFragment navHostFragment =(NavHostFragment) getSupportFragmentManager().findFragmentById( R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        navController.navigate(R.id.missionsFragment);

    }
}