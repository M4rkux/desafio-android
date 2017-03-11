package com.marcus.desafiomadeira;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.marcus.desafiomadeira.adapter.ItinerarioAdapter;
import com.marcus.desafiomadeira.controller.JsonFromURL;
import com.marcus.desafiomadeira.model.Itinerario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Itinerario> itinerarioList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itinerarioList = new ArrayList<Itinerario>();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);

        new JsonFromURL(new JsonFromURL.AsyncResponse() {
            @Override
            public void processFinish(JSONObject output) {
                try {
                    JSONArray json = output.getJSONArray("itinerario");
                    ArrayList<Itinerario> itinerarioList = new ArrayList<Itinerario>();
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonItinerario = json.getJSONObject(i);
                        Itinerario itinerario = new Itinerario(jsonItinerario);
                        itinerarioList.add(itinerario);
                    }

                    final ArrayList<Itinerario> itinerarioListFinal = itinerarioList;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            montaLista(itinerarioListFinal);
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).execute("http://private-2b254a-desafiomadeira.apiary-mock.com/questions");

    }

    private void montaLista (ArrayList<Itinerario> itinerarioArrayList) {
        listView = (ListView) findViewById(R.id.listView1);
        ItinerarioAdapter myAdapter = new ItinerarioAdapter(this, itinerarioArrayList);
        listView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
}
