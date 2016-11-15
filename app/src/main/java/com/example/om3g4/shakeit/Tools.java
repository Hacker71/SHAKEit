package com.example.om3g4.shakeit;

import android.content.res.AssetFileDescriptor;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.security.Policy;

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
                playTone("tone.mp3");
            }
        });
        radioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
