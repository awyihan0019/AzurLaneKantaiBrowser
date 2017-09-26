package com.example.azurlanekantaibrowser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by yihan on 26/9/2017.
 * read from a txt after will be convert to string and execSQL to store data
 */

public class dbDataFileReader {

    public static InputStream is;
    public static String[] readList;

    public dbDataFileReader(InputStream is){
        this.is = is;
        readList = new String[200];
    }

    public static String[] getText()
    {
        InputStreamReader isr = null;
        try{
            isr = new InputStreamReader(is, "utf-8");
        }catch (UnsupportedEncodingException e1){
            e1.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(isr);
        String line;
        try{
            int i = 0;
            while ((line = reader.readLine()) != null){
                readList[i] = line;
                i++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return readList;
    }
}
