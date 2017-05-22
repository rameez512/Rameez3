package com.example.seemy.assgmnt3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.lang.reflect.Constructor;

import static android.content.ContentValues.TAG;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;



public class DbHelper extends SQLiteOpenHelper {
    public static final String TAG=DbHelper.class.getSimpleName();
    public static final String DB_Name="myapp.db";
    public static final int DB_VERSION=1;

    public static final String USER_TABLE="users";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_EMAIL="email";
    public static final String COLUMN_PASS="password";


    public static final String CREATE_TABLE_USERS="CREATE TABLE" + USER_TABLE + "("
            +COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCERMENTED,"
            +COLUMN_EMAIL+"TEXT,"
            +COLUMN_PASS+"TEXT);";


    public DbHelper(Context context) {
        super(context, DB_Name, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST" + USER_TABLE);
        onCreate(db);


    }
    /**
     * storing detail of users in database
     */
    public void addUser (String email,String password)
    {
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues v =new ContentValues();
        v.put(COLUMN_EMAIL,email);
        v.put(COLUMN_PASS,password);

        long id=db.insert(USER_TABLE,null,v);
    db.close();
        Log.d(TAG,"user inserted" +id);

    }
    public boolean getUser(String email,String pass){
        String selectQuery="select *from "+USER_TABLE +"where" +
                COLUMN_EMAIL + " m" + " '" + "and  " + COLUMN_PASS + " = " + " ' " +pass+" '";
        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectQuery , null);
//move to first row
        cursor.moveToFirst();
        if(cursor.getCount()> 0){
            return  true;
        }

     cursor.close();
        db.close();
        return false;
    }



}
