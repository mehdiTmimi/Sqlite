package com.mehditmimi.sqlite.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="db";
    private static final int DATABASE_VERSION=1;
    public MyDataBaseHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String req1="create table OPTION (nom text primary key , " +
                "description text)";
        sqLiteDatabase.execSQL(req1);
        String req2="create table etudiant (cne text primary key , " +
                "nom text , prenom text, nom_option text," +
                "foreign key (nom_option) references option(nom))";
        sqLiteDatabase.execSQL(req2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS etudiant");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS option");

        onCreate(sqLiteDatabase);
    }
}
