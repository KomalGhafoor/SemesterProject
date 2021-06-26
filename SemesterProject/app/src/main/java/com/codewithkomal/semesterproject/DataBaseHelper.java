package com.codewithkomal.semesterproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USER_RECORD";
    private static final String TABLE_NAME = "USER_DATA";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "FULLNAME";
    private static final String COL_3 = "USERNAME";
    private static final String COL_4 = "SEMESTER";
    private static final String COL_5 = "EMAIL";
    //private static final String COL_6 = "COUNTRYCODE";
    private static final String COL_6 = "PHONENO";
    private static final String COL_7 = "PASSWORD";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT ,FULLNAME TEXT, USERNAME TEXT ,SEMESTER TEXT, EMAIL TEXT , PHONENO TEXT, PASSWORD TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean registerUser(String name , String username,String semester , String email,String phone,String password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2 , name);
        values.put(COL_3 , username);
        values.put(COL_4 , semester);
        values.put(COL_5 , email);
        //values.put(COL_6 , country);
        values.put(COL_6 , phone);
        values.put(COL_7 , password);

        long result = db.insert(TABLE_NAME , null , values);
        if(result == -1)
            return false;
        else
            return true;
    }
    //String user;
    public boolean checkUserName(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery( "select * from  USER_DATA  where  USERNAME =?",new String[] {username}    );
        if(cursor.getCount() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public boolean checkUser(String username , String password){

        SQLiteDatabase db = this.getWritableDatabase();
        String [] columns = { COL_1 };
        String selection = COL_3 + "=?" + " and " + COL_7 + "=?";
        String [] selectionargs = { username , password};
        Cursor cursor = db.query(TABLE_NAME , columns , selection ,selectionargs , null , null , null);
        int count = cursor.getCount();
        db.close();
        cursor.close();
        return count > 0;

    }
    public Cursor ViewData(){

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null,null);

        return cursor;


    }
}
