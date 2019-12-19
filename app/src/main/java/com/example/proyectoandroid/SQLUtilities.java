package com.example.proyectoandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLUtilities extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Material (id TEXT, nombre TEXT, cantidad TEXT, tipo TEXT)";

    public SQLUtilities(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Material");
        onCreate(sqLiteDatabase);

    }
}
