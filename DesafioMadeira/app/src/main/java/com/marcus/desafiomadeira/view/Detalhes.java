package com.marcus.desafiomadeira.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.marcus.desafiomadeira.R;
import com.marcus.desafiomadeira.model.Itinerario;

import java.io.Serializable;

public class Detalhes extends AppCompatActivity implements Serializable {

    private Intent it;
    Itinerario itinerarioItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        it = getIntent();

        itinerarioItem = (Itinerario) it.getExtras().getParcelable("itinerarioItem");

        Toast.makeText(this.getApplicationContext(), "Posição do array: " + itinerarioItem.getNome(), Toast.LENGTH_SHORT).show();
    }
}
