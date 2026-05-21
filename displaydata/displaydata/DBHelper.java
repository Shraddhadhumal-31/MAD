package com.example.displaydata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "StudentDB";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE student(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "age INTEGER)");

        // Sample Data
        db.execSQL("INSERT INTO student(name, age) VALUES('Rahul',20)");
        db.execSQL("INSERT INTO student(name, age) VALUES('Sneha',22)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }

    // Fetch Data
    public Cursor getData() {

        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery("SELECT * FROM student", null);
    }
}