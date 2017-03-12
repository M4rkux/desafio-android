package com.marcus.desafiomadeira.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.marcus.desafiomadeira.R;
import com.marcus.desafiomadeira.model.Itinerario;

import java.io.Serializable;

public class DetalhesActivity extends AppCompatActivity implements Serializable {

    private Intent it;
    Itinerario itinerarioItem;
    ImageButton btVoltar;
    ImageButton btMapa;
    TextView tvTipo;
    TextView tvEndereco;
    TextView tvReferencia;
    TextView tvResponsavel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        it = getIntent();
        itinerarioItem = (Itinerario) it.getExtras().getSerializable("itinerarioItem");

        binds();
    }

    private void binds() {
        btVoltar = (ImageButton) findViewById(R.id.bt_voltar);
        btMapa = (ImageButton) findViewById(R.id.bt_mapa);
        tvTipo = (TextView) findViewById(R.id.tv_tipo);
        tvEndereco = (TextView) findViewById(R.id.tv_endereco);
        tvReferencia = (TextView) findViewById(R.id.tv_referencia);
        tvResponsavel = (TextView) findViewById(R.id.tv_responsavel);

        tvTipo.setText(itinerarioItem.getTipo());
        tvEndereco.setText(itinerarioItem.getNome() + ", " + itinerarioItem.getEndereco().getRua() +
                ", nº " + itinerarioItem.getEndereco().getNumero() + ", " + itinerarioItem.getEndereco().getBairro() +
                ", " + itinerarioItem.getEndereco().getCidade() + " - " + itinerarioItem.getEndereco().getEstado());
        tvReferencia.setText("Ponto de referência: " + itinerarioItem.getEndereco().getReferencia());
        tvResponsavel.setText("Responsável pela entrega: " + itinerarioItem.getEndereco().getResponsavel());

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMaps = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=" + itinerarioItem.getEndereco().getLatitude() + "," +
                            itinerarioItem.getEndereco().getLongitude() + "( " + itinerarioItem.getTipo() + ": " + itinerarioItem.getEndereco().getBairro() +")"));
                startActivity(intentMaps);
            }
        });
    }


}
