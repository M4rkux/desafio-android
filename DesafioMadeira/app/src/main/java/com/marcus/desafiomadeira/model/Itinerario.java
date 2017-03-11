package com.marcus.desafiomadeira.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Marcus on 07/03/2017.
 */

public class Itinerario implements Serializable {
    private String tipo;
    private String nome;
    private String telefone;
    private Endereco endereco;

    public Itinerario (JSONObject jsonItinerario) {
        try {
            this.tipo = jsonItinerario.getString("tipo");
            this.nome = jsonItinerario.getString("nome");
            this.telefone = jsonItinerario.getString("telefone");
            this.endereco = new Endereco(jsonItinerario.getJSONObject("endereco"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Itinerario (String tipo, String nome, String telefone, Endereco endereco) {
        this.tipo = tipo;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
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
}
