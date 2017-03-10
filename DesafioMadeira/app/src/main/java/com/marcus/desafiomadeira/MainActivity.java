package com.marcus.desafiomadeira;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;

import com.marcus.desafiomadeira.controller.JsonFromURL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);

        new JsonFromURL(new JsonFromURL.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                System.out.println(output);
            }
        }).execute("http://private-2b254a-desafiomadeira.apiary-mock.com/questions");

    }
}
