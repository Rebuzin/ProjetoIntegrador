package com.example.appmedia.model;

public class Viagem {
    private String data;
    private String kmInicial;
    private String kmFinal;
    private String litros;

    public Viagem() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(String kmInicial) {
        this.kmInicial = kmInicial;
    }

    public String getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(String kmFinal) {
        this.kmFinal = kmFinal;
    }

    public String getLitros() {
        return litros;
    }

    public void setLitros(String litros) {
        this.litros = litros;
    }
}
