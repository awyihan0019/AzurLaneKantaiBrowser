package com.example.azurlanekantaibrowser;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by yihan on 26/9/2017.
 */

public class KantaiDbQueries {
    private  KantaiDbHelper dbHelper;

    public KantaiDbQueries(KantaiDbHelper dbHelper){this.dbHelper = dbHelper ; }

    public Cursor query(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        return db.query(
                "KANTAI",
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy
        );
    }

}
