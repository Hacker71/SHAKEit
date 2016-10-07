package com.example.om3g4.shakeit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AmiReady extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ami_ready);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.quizLinearView);
        createRadioButton(linearLayout);
    }

    private void createRadioButton(LinearLayout linearLayout) {
        final RadioButton[] rb = new RadioButton[5];
        RadioGroup rg = new RadioGroup(this); //create the RadioGroup
        rg.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL

        int q=5;
        List<TextView> wordList = new ArrayList<TextView>(q);
        List<TextView> answerList = new ArrayList<TextView>(q*3);

        for(int i = 0; i < q; i++){
            TextView answerText = new TextView(getApplicationContext());
            TextView qText = new TextView(getApplicationContext());

            answerText.setText("ans "+(i+1));
            qText.setText("question "+(i+1));



            linearLayout.addView(qText);
            linearLayout.addView(answerText);

            wordList.add(qText);
            answerList.add(answerText);
        }


        /*
        for (int x=0;x<5;x++){
            questionTV.setText("question "+(x+1));
            if(questionTV.getParent()!=null){
                ((ViewGroup)questionTV.getParent()).removeView(questionTV);
            }
            linearLayout.addView(questionTV);
            for(int i=0; i<3; i++){
                rb[i]  = new RadioButton(this);
                rb[i].setText(" " + "option"+(i+1));
                rb[i].setId(i + 100);
                rg.addView(rb[i]);
            }
            if(rg.getParent()!=null){
                ((ViewGroup)rg.getParent()).removeView(rg);
            }
            linearLayout.addView(rg);//you add the whole RadioGroup to the layout
        }
        */

    }


}
