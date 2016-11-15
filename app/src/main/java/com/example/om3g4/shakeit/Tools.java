package com.example.om3g4.shakeit;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.security.Policy;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class Tools extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button flashLightBtn=(Button)findViewById(R.id.flashLightBtn);
        Button strobeLightBtn=(Button)findViewById(R.id.strobeLightBtn);
        Button sirenBtn=(Button)findViewById(R.id.sirenBtn);
        Button radioBtn=(Button)findViewById(R.id.radioBtn);

        flashLightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Camera camera;
                    camera=Camera.open();
                    Camera.Parameters p=camera.getParameters();
                    p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(p);
                    camera.startPreview();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(), LENGTH_SHORT).show();
                }
            }
        });

        strobeLightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        sirenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playTone("siren.mp3");
            }
        });
        radioBtn.setOnClickListener(new View.OnClickListener() {
            String fmRadioPackageName="com.sec.android.app.fm";
            String pack;
            @Override
            public void onClick(View view) {
                final PackageManager pm = getPackageManager();

                //get a list of installed apps.
                List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

                for (ApplicationInfo packageInfo : packages) {
                    pack=packageInfo.packageName;
                    if(pack.contains(".fm")){
                        fmRadioPackageName=pack;
                        break;
                    }
                    //Log.d("pack", "Installed package :" + packageInfo.packageName);
                    //Log.d("pack", "Source dir : " + packageInfo.sourceDir);
                    //Log.d("pack", "Launch Activity :" + pm.getLaunchIntentForPackage(packageInfo.packageName));
                }
                // the getLaunchIntentForPackage returns an intent that you can use with startActivity()


                try { //to play fm radio
                    Intent launchIntent = getPackageManager().getLaunchIntentForPackage(fmRadioPackageName);
                    if (launchIntent != null) {
                        startActivity(launchIntent);//null pointer check in case package name was not found
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Unable to play Radio", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    void playTone(String tone){
        try {
            AssetFileDescriptor afd=getAssets().openFd(tone);
            MediaPlayer player=new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            player.prepare();
            if(!player.isPlaying()){
                player.start();
            }else{
                player.stop();
            }
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), e.toString(), LENGTH_SHORT).show();
        }
    }

}
