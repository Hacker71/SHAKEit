package com.example.om3g4.shakeit;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Donate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button redCrescent=(Button)findViewById(R.id.redCrescent);
        Button quantum=(Button)findViewById(R.id.quantum);
        Button islami=(Button)findViewById(R.id.islami);
        Button salimullah=(Button)findViewById(R.id.salimullah);
        Button sandhani=(Button)findViewById(R.id.sandhani);

        redCrescent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callTo("+8801939953720");
            }
        });
        quantum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callTo("01781603405");
            }
        });
        islami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callTo("");
            }
        });
        salimullah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callTo("");
            }
        });
        sandhani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callTo("");
            }
        });

    }

    private void callTo(String num) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + num));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(callIntent);
    }

}
