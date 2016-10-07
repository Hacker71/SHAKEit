package com.example.om3g4.shakeit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class After extends AppCompatActivity {

    TextCollection textCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after);

        textCollection=new TextCollection();

        TextView after1TV=(TextView)findViewById(R.id.after1TV);
        TextView after2TV=(TextView)findViewById(R.id.after2TV);
        TextView after3TV=(TextView)findViewById(R.id.after3TV);
        TextView after4TV=(TextView)findViewById(R.id.after4TV);
        TextView after5TV=(TextView)findViewById(R.id.after5TV);
        TextView after6TV=(TextView)findViewById(R.id.after6TV);
        TextView after7TV=(TextView)findViewById(R.id.after7TV);
        TextView after8TV=(TextView)findViewById(R.id.after8TV);
        TextView after9TV=(TextView)findViewById(R.id.after9TV);
        TextView after10TV=(TextView)findViewById(R.id.after10TV);

        after1TV.setText(textCollection.after1);
        after2TV.setText(textCollection.after2);
        after3TV.setText(textCollection.after3);
        after4TV.setText(textCollection.after4);
        after5TV.setText(textCollection.after5);
        after6TV.setText(textCollection.after6);
        after7TV.setText(textCollection.after7);
        after8TV.setText(textCollection.after8);
        after9TV.setText(textCollection.after9);
        after10TV.setText(textCollection.after10);
    }
}
