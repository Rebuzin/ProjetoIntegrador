package com.example.appmedia.model;

public class Viagem {
    private String data;
    private String kmInicial;
    private String kmFinal;
    private String litros;
    private String cPFMotorista;
    private Double media;

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

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public String getCPFMotorista() {
        return cPFMotorista;
    }

    public void setCPFMotorista(String cPFMotorista) {
        this.cPFMotorista = cPFMotorista;
    }
}
