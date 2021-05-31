package com.example.a4laboratorinis;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.URL;


import java.util.ArrayList;
import java.util.List;


public class DataManager {
    @RequiresApi(api = Build.VERSION_CODES.R)
    public static List<String> ECBrate() throws IOException {

        List<String> ratelist = new ArrayList<>(List.of("Failed"));
        InputStream stream = Urldownload(Constant.ECB);

        try {
            ratelist = ParserXml.ECBrate(stream);
        }


        finally {
            if (stream != null) {
                stream.close();
            }
        }
        return ratelist;
    }

    private static InputStream Urldownload(String StringUrl) throws IOException {

        URL url = new URL(StringUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("To get");

        conn.setDoInput(true);
        conn.connect();

        return conn.getInputStream();
    }
}
