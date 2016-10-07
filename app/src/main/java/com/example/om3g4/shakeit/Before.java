package com.example.om3g4.shakeit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Before extends AppCompatActivity {

    TextCollection textCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before);

        textCollection=new TextCollection();

        TextView before1TV=(TextView)findViewById(R.id.before1TV);
        before1TV.setText(textCollection.before1);
    }
}
