package com.example.gajdaj.myapplication.db.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

    public static final String TABLE_TITLE = "my_table";
    public static final String ID_COLUMN = "id";
    public static final String TITLE_COLUMN = "title";
    public static final String SUM_COLUMN = "sum";
    public static final String TYPE_COLUMN = "type";


    public MyDBHelper(Context context) {
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_TITLE + "("
                + ID_COLUMN + " integer primary key autoincrement,"
                + TITLE_COLUMN + " text,"
                + SUM_COLUMN + " real,"
                + TYPE_COLUMN + " text"
                + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
