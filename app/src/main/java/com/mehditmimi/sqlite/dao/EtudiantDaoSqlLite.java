package com.mehditmimi.sqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mehditmimi.sqlite.beans.Etudiant;
import com.mehditmimi.sqlite.beans.Option;
import com.mehditmimi.sqlite.utils.MyDataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class EtudiantDaoSqlLite implements EtudiantDao{


    private MyDataBaseHelper myDataBaseHelper;
    public EtudiantDaoSqlLite(MyDataBaseHelper myDataBaseHelper)
    {
        this.myDataBaseHelper=myDataBaseHelper;
    }
    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        SQLiteDatabase db = myDataBaseHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("cne",etudiant.getCne());
        values.put("nom",etudiant.getNom());
        values.put("prenom",etudiant.getPrenom());
        values.put("nom_option",etudiant.getOption().getNom());
        return db.insert("etudiant",null,values)==-1?null:etudiant;
    }
    @Override
    public List<Etudiant> getEtudiants() {
        SQLiteDatabase db = myDataBaseHelper.getReadableDatabase();
        String requete = "select * from etudiant";
        Cursor cursor=db.rawQuery(requete,null);
        List<Etudiant> etudiants=new ArrayList<>();
        if(!cursor.moveToFirst())
        return etudiants;

        do {
            Etudiant etudiant = new Etudiant();
            etudiant.setCne(cursor.getString(0));
            etudiant.setNom(cursor.getString(1));
            etudiant.setPrenom(cursor.getString(2));
            String option_nom =cursor.getString(3);

            String requete2="select * from option where nom='"+option_nom+"'";
            Cursor cursor2=db.rawQuery(requete2,null);
            cursor2.moveToFirst();
            Option option=new Option();
            option.setNom(cursor2.getString(0));
            option.setDescription(cursor2.getString(1));

            etudiant.setOption(option);

            etudiants.add(etudiant);
        } while (cursor.moveToNext());
        return etudiants;
    }
}
