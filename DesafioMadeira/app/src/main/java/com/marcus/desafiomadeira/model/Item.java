package com.marcus.desafiomadeira.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Marcus on 08/03/2017.
 */

public class Item implements Serializable {
    private String titulo;
    private float largura;
    private float altura;
    private float comprimento;
    private float peso;

    public Item (JSONObject jsonObject) {
        try {
            this.titulo = jsonObject.getString("titulo");
            this.largura = Float.valueOf(jsonObject.getString("largura"));
            this.altura = Float.valueOf(jsonObject.getString("altura"));
            this.comprimento = Float.valueOf(jsonObject.getString("comprimento"));
            this.peso = Float.valueOf(jsonObject.getString("peso"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /***********************************************************/

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
