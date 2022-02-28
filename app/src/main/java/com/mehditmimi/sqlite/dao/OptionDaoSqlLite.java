package com.mehditmimi.sqlite.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.mehditmimi.sqlite.beans.Option;
import com.mehditmimi.sqlite.utils.MyDataBaseHelper;

import java.util.List;

public class OptionDaoSqlLite implements OptionDao{
    private MyDataBaseHelper myDataBaseHelper;
    public OptionDaoSqlLite(MyDataBaseHelper myDataBaseHelper)
    {
        this.myDataBaseHelper=myDataBaseHelper;
    }
    @Override
    public Option addOption(Option option) {
        if(myDataBaseHelper==null)
            Log.e("mysql","null option");
        else
            Log.i("mysql","ok option");

        SQLiteDatabase db = myDataBaseHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("nom",option.getNom());
        values.put("description",option.getDescription());
        return db.insert("option",null,values)==-1?null:option;
    }

    @Override
    public List<Option> getOptions() {
        return null;
    }
}
