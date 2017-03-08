package com.marcus.desafiomadeira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.marcus.desafiomadeira.controller.RestController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestController restController = new RestController();



        TextView texto = (TextView) findViewById(R.id.texto);

        texto.setText(restController.buscaItinerario());
    }
}
