package com.marcus.desafiomadeira.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Marcus on 07/03/2017.
 */

public class Endereco {
    private String rua;
    private int numero;
    private String bairro;
    private String estado;
    private String cidade;
    private String latitude;
    private String longitude;

    public Endereco (String rua, int numero, String bairro, String estado, String cidade, String latitude, String longitude) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.estado = estado;
        this.cidade = cidade;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public Endereco (JSONObject jsonEndereco) {
        try {
            this.rua = jsonEndereco.getString("rua");
            this.numero = jsonEndereco.getInt("numero");
            this.bairro = jsonEndereco.getString("bairro");
            this.estado = jsonEndereco.getString("estado");
            this.cidade = jsonEndereco.getString("cidade");
            this.latitude = jsonEndereco.getString("latitude");
            this.longitude = jsonEndereco.getString("longitude");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**********************************************/

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
