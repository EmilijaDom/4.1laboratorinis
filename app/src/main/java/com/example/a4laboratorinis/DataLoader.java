package com.example.a4laboratorinis;


import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.PrintWriter;
import java.io.StringWriter;

import java.util.List;
import java.util.ArrayList;



public abstract class DataLoader extends AsyncTask<String, Void, List<String>> {

    @RequiresApi(api = Build.VERSION_CODES.R)
    protected List<String> doInBackground(String... params) {


        try {
            return DataManager.ECBrate();


        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));

            List<String> retrievefailed = new ArrayList<>(List.of(sw.toString() ));


            return retrievefailed;
        }
    }

    public abstract void Execute(List<String> result);
}