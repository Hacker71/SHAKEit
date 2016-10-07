package com.example.om3g4.shakeit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AmiReady extends AppCompatActivity {

    TextCollection textCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ami_ready);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        textCollection=new TextCollection();

        List<String> li=new ArrayList<String>();
        int l=textCollection.questions.length;
        String questions[]=new String[l];
        String options1[]=new String[l];
        String options2[]=new String[l];
        String options3[]=new String[l];
        questions=textCollection.questions;
        options1=textCollection.options1;
        options2=textCollection.options2;
        options3=textCollection.options3;

        for(int i=0;i<l;i++){
            li.add(String.valueOf(Html.fromHtml("[ "+(i+1)+" ] "+questions[i]+"<br>"+options1[i]+"<br>"+options2[i]+"<br>"+options3[i])));
        }

        final ListView inboxListView=(ListView) findViewById(R.id.quizListView);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.list,li);
        inboxListView.setAdapter(arrayAdapter);
    }


}
