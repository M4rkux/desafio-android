package com.marcus.desafiomadeira.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.marcus.desafiomadeira.R;
import com.marcus.desafiomadeira.model.Item;
import com.marcus.desafiomadeira.model.Itinerario;

import java.io.Serializable;

public class DetalhesActivity extends AppCompatActivity implements Serializable {

    private Intent it;
    Itinerario itinerarioItem;
    Button btItens;
    ImageButton btVoltar;
    ImageButton btMapa;
    ImageButton btTelefone;
    ImageButton btEntrega;
    ImageButton btConfirmar;
    ImageButton btErro;
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
        btItens = (Button) findViewById(R.id.bt_itens);
        btVoltar = (ImageButton) findViewById(R.id.bt_voltar);
        btMapa = (ImageButton) findViewById(R.id.bt_mapa);
        btTelefone = (ImageButton) findViewById(R.id.bt_telefone);
        btEntrega = (ImageButton) findViewById(R.id.bt_entrega);
        btConfirmar = (ImageButton) findViewById(R.id.bt_confirmar);
        btErro = (ImageButton) findViewById(R.id.bt_erro);
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

        this.setTitle(itinerarioItem.getNome());

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

        btItens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(DetalhesActivity.this).create();
                alertDialog.setTitle("Itens");
                String message = "";
                for (Item item: itinerarioItem.getItens()) {
                    message += item.getTitulo() + " \n";
                }
                alertDialog.setMessage(message);
                alertDialog.show();
            }
        });

        btTelefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(DetalhesActivity.this).create();
                alertDialog.setTitle(itinerarioItem.getTelefone());
                alertDialog.setMessage("Como pretende entrar em contato?");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Enviar SMS", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + itinerarioItem.getTelefone()));
                        intent.putExtra("sms_body", "Sua encomenda já saiu para entrega. \nBy: Desafio Madeira");
                        startActivity(intent);
                    }
                });

                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Ligar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + itinerarioItem.getTelefone()));
                        startActivity(intent);
                    }
                });
                alertDialog.show();
            }
        });


        btConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(DetalhesActivity.this).create();
                alertDialog.setTitle("Deseja informar que foi entregue?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Sim",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
            }
        });
    }


}
