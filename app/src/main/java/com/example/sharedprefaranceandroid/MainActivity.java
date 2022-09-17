package com.example.sharedprefaranceandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
                Boolean check = pref.getBoolean("flag", false);

                Intent inext;
                if(check){ //for true when user is loged in
                    inext = new Intent(MainActivity.this, DashActivity.class);
                }else{ //for false (either first time or second time)
                    inext = new Intent(MainActivity.this, LoginActivity.class);
                }

                startActivity(inext);
            }
        },5000);
    }
}