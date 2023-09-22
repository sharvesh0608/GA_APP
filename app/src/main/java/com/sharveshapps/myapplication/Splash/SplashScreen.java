package com.sharveshapps.myapplication.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.sharveshapps.myapplication.Authentication.Authentication;
import com.sharveshapps.myapplication.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(() -> {
            Intent intent =  new Intent(SplashScreen.this, Authentication.class);
            startActivity(intent);
            finish();
        },2000);
    }
}