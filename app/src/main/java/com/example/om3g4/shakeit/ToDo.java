package com.example.om3g4.shakeit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ToDo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView before=(TextView)findViewById(R.id.textView10);
        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                ViewGroup.LayoutParams params = before.getLayoutParams();
                params.height = 280;
                before.setLayoutParams(params);
                */
            }
        });
    }

}