package com.marcus.desafiomadeira.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcus on 07/03/2017.
 */

public class Itinerario implements Serializable {
    private String tipo;
    private String nome;
    private String telefone;
    private Endereco endereco;
    private List<Item> itens;

    public Itinerario (JSONObject jsonItinerario) {
        try {
            this.tipo = jsonItinerario.getString("tipo");
            this.nome = jsonItinerario.getString("nome");
            this.telefone = jsonItinerario.getString("telefone");
            this.endereco = new Endereco(jsonItinerario.getJSONObject("endereco"));
            this.itens = instanciaItens(jsonItinerario.getJSONArray("itens"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    private List<Item> instanciaItens(JSONArray jsonArray) {
        ArrayList<Item> itens = new ArrayList<Item>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                itens.add(new Item(jsonObject));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return itens;
    }
}
