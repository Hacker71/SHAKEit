package com.example.om3g4.shakeit;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.sql.Statement;

/**
 * Created by partho on 10/7/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    Context context;

    public DatabaseHelper(Context context){
        super(context,"data",null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL("CREATE TABLE safeInfo(ID INTEGER PRIMARY KEY NOT NULL, phone1 TEXT NOT NULL, phone2 TEXT NOT NULL, phone3 TEXT NOT NULL, msg TEXT NOT NULL)");
            sqLiteDatabase.execSQL("INSERT INTO safeInfo(phone1, phone2, phone3,msg) VALUES('+88017', '+88016', '+88019', 'I am safe.')");
        }catch (Exception e){
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    SQLiteDatabase db=getReadableDatabase();

    protected Cursor getSafeInfo(){
        Cursor cursor=db.rawQuery("SELECT * FROM safeInfo",null);
        return cursor;
    }

    protected void updateSafeInfo(String phone1, String phone2, String phone3, String msg){
        String q="UPDATE safeInfo SET phone1='"+phone1+"', phone2='"+phone2+"'"+", phone3='"+phone3+"', msg='"+msg+"'";
        db.execSQL(q);
    }
}
