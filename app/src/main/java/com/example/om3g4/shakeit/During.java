package com.example.om3g4.shakeit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class During extends AppCompatActivity {

    TextCollection textCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_during);

        textCollection=new TextCollection();

        TextView during1TV=(TextView)findViewById(R.id.during1TV);
        TextView during2TV=(TextView)findViewById(R.id.during2TV);
        TextView during3TV=(TextView)findViewById(R.id.during3TV);
        TextView during4TV=(TextView)findViewById(R.id.during4TV);
        TextView during5TV=(TextView)findViewById(R.id.during5TV);
        TextView during6TV=(TextView)findViewById(R.id.during6TV);
        TextView during7TV=(TextView)findViewById(R.id.during7TV);
        TextView during8TV=(TextView)findViewById(R.id.during8TV);

        during1TV.setText(textCollection.during1);
        during2TV.setText(textCollection.during2);
        during3TV.setText(textCollection.during3);
        during4TV.setText(textCollection.during4);
        during5TV.setText(textCollection.during5);
        during6TV.setText(textCollection.during6);
        during7TV.setText(textCollection.during7);
        during8TV.setText(textCollection.during8);
    }
}
