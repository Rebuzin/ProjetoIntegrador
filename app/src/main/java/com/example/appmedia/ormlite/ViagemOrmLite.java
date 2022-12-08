package com.example.appmedia.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;

@DatabaseTable(tableName = "viagem_orm_lite")
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode
public class ViagemOrmLite {

    public static final String ALIAS_CLASSE = "viagem_orm_lite";
    public static final String ALIAS_CLASSE_ID = "id";

    public static final String ID = "id";
    public static final String DATA = "data";
    public static final String KM_INICIAL = "kmInicial";
    public static final String KM_FINAL = "kmFinal";
    public static final String LITROS = "litros";

    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField()
    private String data;
    @DatabaseField()
    private String kmInicial;
    @DatabaseField()
    private String kmFinal;
    @DatabaseField()
    private String litros;
    @DatabaseField()
    private Double media;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
