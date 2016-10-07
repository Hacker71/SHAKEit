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
        TextView before2TV=(TextView)findViewById(R.id.before2TV);
        TextView before3TV=(TextView)findViewById(R.id.before3TV);
        TextView before4TV=(TextView)findViewById(R.id.before4TV);
        TextView before5TV=(TextView)findViewById(R.id.before5TV);
        TextView before6TV=(TextView)findViewById(R.id.before6TV);
        TextView before7TV=(TextView)findViewById(R.id.before7TV);

        before1TV.setText(textCollection.before1);
        before2TV.setText(textCollection.before2);
        before3TV.setText(textCollection.before3);
        before4TV.setText(textCollection.before4);
        before5TV.setText(textCollection.before5);
        before6TV.setText(textCollection.before6);
        before7TV.setText(textCollection.before7);
    }
}
