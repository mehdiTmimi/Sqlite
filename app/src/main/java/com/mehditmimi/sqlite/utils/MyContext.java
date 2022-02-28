package com.mehditmimi.sqlite.utils;

import android.app.Application;
import android.util.Log;

import com.mehditmimi.sqlite.beans.Option;
import com.mehditmimi.sqlite.business.DefaultServices;
import com.mehditmimi.sqlite.dao.EtudiantDaoSqlLite;
import com.mehditmimi.sqlite.dao.OptionDaoSqlLite;

public class MyContext extends Application {
    private DefaultServices defaultServices;
    public MyContext(){
        defaultServices=new DefaultServices();
        MyDataBaseHelper myDataBaseHelper=new MyDataBaseHelper(this);
        if(myDataBaseHelper==null)
            Log.e("mysql","null mydatabasehelper");
        else
            Log.i("mysql","ok mydatabasehelper");
        defaultServices.setEtudiantDao(new EtudiantDaoSqlLite(myDataBaseHelper));
        defaultServices.setOptionDao(new OptionDaoSqlLite(myDataBaseHelper));
        testeDb();
    }
    private void testeDb(){
        Option option=new Option();
        option.setNom("GL");
        option.setDescription("dev web,mobile");
        defaultServices.addOption(option);
    }
}
