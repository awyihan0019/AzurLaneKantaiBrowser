package com.example.azurlanekantaibrowser;

import android.provider.BaseColumns;

/**
 * Created by yihan on 26/9/2017.
 */

public class KantaiContract {

    private KantaiContract(){}

    public static class KantaiEntry implements BaseColumns{
        public static final String TABLE_NAME = "KANTAI";
        public static final String COLUMN_NAME_NAME = "subName";
        public static final String COLUMN_NAME_NO = "No";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_CAMP = "camp";
    }
}
