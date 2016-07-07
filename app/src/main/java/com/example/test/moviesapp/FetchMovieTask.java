package com.example.test.moviesapp;


import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchMovieTask extends AsyncTask<String, Void, String> {

    public static final String TAG = "logging";

    @Override
    protected String doInBackground(String... params) {
        String query = params[0];

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        String MovieJsonStr = null;

        URL url = null;
        try {
            url = new URL(query);


            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();


            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            if (inputStream == null) {

                return null;
            }

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {

                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                return null;
            }

            MovieJsonStr = buffer.toString();

            return MovieJsonStr;

        } catch (IOException E) {
            E.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e(TAG, "Error closing stream", e);
                }
            }
        }
        return null;


    }


}
