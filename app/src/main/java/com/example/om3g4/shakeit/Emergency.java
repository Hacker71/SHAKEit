package com.example.om3g4.shakeit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class Emergency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView ambulanceTV=(TextView) findViewById(R.id.ambulanceTV);
        TextView fireServiceTV=(TextView) findViewById(R.id.fireServiceTV);
        TextView policeTV=(TextView) findViewById(R.id.policeTV);

        String x="<b><u>Ambulance</u></b>"+"<br>"+"01774983692"+"<br>"+"88028010420"+"<br>"+"88028618262"+"<br>"+"88028618007"+"<br>"+"88029666497"+"<br>"+"88071711625173";
        ambulanceTV.setText(Html.fromHtml(x));
        x="<b><u>Fire Service</u></b>"+"<br>"+"01730-002216"+"<br>"+"01730-002218"+"<br>"+"58617171"+"<br>"+"01730-002218"+"<br>"+"01730-002219"+"<br>"+"01730-002225";;
        fireServiceTV.setText(Html.fromHtml(x));
        x="<b><u>Police Station</u></b>"+"<br>"+"100 9619999"+"<br>"+"9619999"+"<br>"+"961999";;
        policeTV.setText(Html.fromHtml(x));
    }

}
