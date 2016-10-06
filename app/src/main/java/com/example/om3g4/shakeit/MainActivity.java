package com.example.om3g4.shakeit;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle toggle;
    public Button button4;

    public  void init(){
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), ToDo.class);
                startActivity(i);


            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);


        Button toDoBtn = (Button) findViewById(R.id.button);
        Button readyBtn = (Button) findViewById(R.id.button2);
        Button donateBtn = (Button) findViewById(R.id.button3);
        Button locateMeBtn = (Button) findViewById(R.id.button4);
        Button emergencyBtn = (Button) findViewById(R.id.button5);
        Button toolsBtn = (Button) findViewById(R.id.button6);
        Button safeBtn = (Button) findViewById(R.id.button7);

        toDoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                startActivity(new Intent(getApplicationContext(),ToDo.class));

            }
        });


        readyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                startActivity(new Intent(getApplicationContext(),AmiReady.class));
            }
        });

        donateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                startActivity(new Intent(getApplicationContext(),Donate.class));
            }
        });

        locateMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                startActivity(new Intent(getApplicationContext(),LocateMe.class));
            }
        });

        emergencyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                startActivity(new Intent(getApplicationContext(),Emergency.class));
            }
        });

        toolsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                startActivity(new Intent(getApplicationContext(),Tools.class));

            }
        });

        safeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                startActivity(new Intent(getApplicationContext(),AmiSafe.class));
            }
        });


        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);

    }
}
