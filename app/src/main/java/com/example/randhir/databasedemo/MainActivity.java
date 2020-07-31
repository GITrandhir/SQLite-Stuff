package com.example.randhir.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);

            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR, age INT(4), id INTEGER PRIMARY KEY)");
            //sqLiteDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Rob',20)");
            //sqLiteDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Nick',23)");
            //sqLiteDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Randhir',19)");

            sqLiteDatabase.execSQL("DELETE FROM newUsers WHERE id = 2 ");

            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM newUsers", null);
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");
            c.moveToFirst();

            while (!c.isAfterLast()) {
                Log.i("Users - name", c.getString(nameIndex));
                Log.i("Users - age", Integer.toString(c.getInt(ageIndex)));
                Log.i("Users - id", Integer.toString(c.getInt(idIndex)));

                c.moveToNext();
            }


        }catch (Exception e){
            e.printStackTrace();
        }



       /* try{
           SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Events",MODE_PRIVATE,null);

           sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (name VARCHAR, year INT(4))");
           sqLiteDatabase.execSQL("INSERT INTO events (name, year) VALUES ('Milenieum',2000)");
           sqLiteDatabase.execSQL("INSERT INTO events (name, year) VALUES ('Nick started teaching',2014)");

           Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM events", null);
           int nameIndex = c.getColumnIndex("name");
           int yearIndex = c.getColumnIndex("year");
           c.moveToFirst();

           while (!c.isAfterLast()) {
               Log.i("Results - name", c.getString(nameIndex));
               Log.i("Results - year", Integer.toString(c.getInt(yearIndex)));

               c.moveToNext();
           }


       }catch (Exception e){
           e.printStackTrace();
       } */



        /* SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);

        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR , age INT(19))");

        myDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Randhir',19)");
        myDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Jon Snow',35)");

        Cursor c = myDatabase.rawQuery("SELECT * FROM users",null);

        int nameIndex = c.getColumnIndex("name");
        int ageIndex  = c.getColumnIndex("age");

        while (c != null){
            Log.i("name",c.getString(nameIndex));
            Log.i("age",c.getString(ageIndex));
            c.moveToNext();
        } */

    }
}
