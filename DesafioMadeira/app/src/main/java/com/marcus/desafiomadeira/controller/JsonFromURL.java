package com.marcus.desafiomadeira.controller;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by marcus on 08/03/2017.
 */

public class JsonFromURL extends AsyncTask {

    public interface AsyncResponse {
        void processFinish(String output);
    }

    public AsyncResponse delegate = null;

    public JsonFromURL(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    public static JSONObject getJSONObjectFromURL(String urlString) throws IOException, JSONException {

        String jsonString = new String();
        try {
            HttpURLConnection urlConnection = null;
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setDoOutput(true);
            urlConnection.connect();
            BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));
            char[] buffer = new char[1024];

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line+"\n");
            }
            br.close();
            jsonString = sb.toString();
        } catch (IOException e) {
            Log.e("Erro", "IOException: " + e.getMessage(), e);
        } catch (Exception e) {
            Log.e("Erro", "Exception: " + e.getMessage(), e);
        }

        return new JSONObject(jsonString);
    }

    @Override
    protected String doInBackground(Object[] params) {
        String urlString = (String) params[0];
        JSONObject json = null;
        String retorno = "";

        try {
            json = getJSONObjectFromURL(urlString);
        } catch (Exception e) {
            Log.e("Erro", "Exception: " + e.getMessage(), e);
        }
        if (json != null) {
            retorno = json.toString();
        }

        delegate.processFinish(retorno);

        return retorno;
    }
}
