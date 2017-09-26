package com.example.azurlanekantaibrowser;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.InputStream;

/**
 * Created by yihan on 26/9/2017.
 */

public class KantaiDbHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "kantai.db";
    private SQLiteDatabase db;

    public static String[] data;

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + KantaiContract.KantaiEntry.TABLE_NAME;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE `KANTAI` (" +
                    "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "`fullName` TEXT," +
                    "`subName` TEXT," +
                    "`No` TEXT," +
                    "`lvl` TEXT," +
                    "`type` TEXT," +
                    "`rare` TEXT," +
                    "`camp` TEXT," +
                    "`buildTime` TEXT," +
                    "`dropPoint` TEXT," +
                    "`value` TEXT," +
                    "`returnValue` TEXT," +
                    "`main` TEXT," +
                    "`sub` TEXT," +
                    "`hp` TEXT," +
                    "`amor` TEXT," +
                    "`filling` TEXT," +
                    "`atk` TEXT," +
                    "`tAtk` TEXT," +
                    "`agi` TEXT," +
                    "`airDef` TEXT," +
                    "`airAtk` TEXT," +
                    "`compsum` TEXT," +
                    "`speed` TEXT," +
                    "`lvlAtk` TEXT," +
                    "`lvlHp` TEXT," +
                    "`lvlAirDef` TEXT," +
                    "`lvlAgi` TEXT," +
                    "`lvlAirAtk` TEXT," +
                    "`lvlTAtk` TEXT," +
                    "`star1` TEXT," +
                    "`star2` TEXT," +
                    "`star3` TEXT," +
                    "`usage1` TEXT," +
                    "`startEquip1` TEXT," +
                    "`equipType1` TEXT," +
                    "`usage2` TEXT," +
                    "`startEquip2` TEXT," +
                    "`equipType2` TEXT," +
                    "`usage3` TEXT," +
                    "`startEquip3` TEXT," +
                    "`equipType3` TEXT," +
                    "`usage4` TEXT," +
                    "`startEquip4` TEXT," +
                    "`equipType4` TEXT," +
                    "`usage5` TEXT," +
                    "`startEquip5` TEXT," +
                    "`equipType5` TEXT," +
                    "`skill1` TEXT," +
                    "`skillEffect1` TEXT," +
                    "`skill2` TEXT," +
                    "`skillEffect2` TEXT," +
                    "`skill3` TEXT," +
                    "`skillEffect3` TEXT" +
                    ");";


    public KantaiDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        InputStream inputStream = context.getResources().openRawResource(R.raw.database);
        dbDataFileReader rf = new dbDataFileReader(inputStream);
        data = rf.getText();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        //db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_CREATE_ENTRIES);
        for (int j = 0 ; j < data.length ; j++)
        {
            if(data[j] != null){
                db.execSQL(data[j]);
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }


    public void close(){
        if(db != null){
            db.close();
        }
    }

}
