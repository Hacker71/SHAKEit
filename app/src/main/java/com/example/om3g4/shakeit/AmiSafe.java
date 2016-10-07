package com.example.om3g4.shakeit;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AmiSafe extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText phone1, phone2, phone3, msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ami_safe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        phone1=(EditText)findViewById(R.id.editText2);
        phone2=(EditText)findViewById(R.id.editText3);
        phone3=(EditText)findViewById(R.id.editText4);
        msg=(EditText)findViewById(R.id.editText6);
        Button updateSafeInfoBtn=(Button)findViewById(R.id.button9);
        Button sendSMS=(Button)findViewById(R.id.button8);

        try {
            databaseHelper=new DatabaseHelper(getApplicationContext());
            Log.d("msg","databaseHelper()");
        }catch (Exception e){
            Log.d("error",e.toString());
        }

        String safeInfo[]=new String[4];
        try {
            safeInfo=getSafeInfo();
            Log.d("msg","getSafeInfo()"+"---"+safeInfo[0]+"---");
            Log.d("msg","getSafeInfo()"+"---"+safeInfo[1]+"---");
        }catch (Exception e){
            Log.d("error",e.toString());
        }
        for (int i=0;i<4;i++){
            Log.d("msg",safeInfo[i]);
            phone1.setText(safeInfo[0]);
            phone2.setText(safeInfo[1]);
            phone3.setText(safeInfo[2]);
            msg.setText(safeInfo[3]);
        }

        updateSafeInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper=new DatabaseHelper(getApplicationContext());
                databaseHelper.updateSafeInfo(phone1.getText().toString(), phone2.getText().toString(), phone3.getText().toString(), msg.getText().toString());
                Toast.makeText(getApplicationContext(),"Informations Updated",Toast.LENGTH_SHORT).show();
            }
        });

        sendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String msgToSend=msg.getText().toString();
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phone1.getText().toString(), null,msgToSend, null, null);
                    smsManager.sendTextMessage(phone2.getText().toString(), null, msgToSend, null, null);
                    smsManager.sendTextMessage(phone3.getText().toString(), null, msgToSend, null, null);
                    Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
                    /*
                    Toast.makeText(getApplicationContext(),
                            ex.getMessage().toString(),
                            Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                    */
                }
            }
        });

    }

    private String[] getSafeInfo(){
        databaseHelper=new DatabaseHelper(getApplicationContext());
        String retVal[] = new String[4];
        Cursor cursor=databaseHelper.getSafeInfo();
        if(cursor!=null && cursor.moveToFirst()){
            int i=0;
            while (!cursor.isAfterLast()){
                try {
                    retVal[i++]=cursor.getString(cursor.getColumnIndex("phone1"));
                    retVal[i++]=cursor.getString(cursor.getColumnIndex("phone2"));
                    retVal[i++]=cursor.getString(cursor.getColumnIndex("phone3"));
                    retVal[i++]=cursor.getString(cursor.getColumnIndex("msg"));
                    cursor.moveToNext();
                }catch (Exception e){
                    Log.d("error",e.toString());
                }
            }
        }else{
            Log.d("msg","cursor null");
        }
        return retVal;
    }

}
