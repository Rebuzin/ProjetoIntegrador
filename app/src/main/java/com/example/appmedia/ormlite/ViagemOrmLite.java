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

    public static final String ALIAS_CLASSE = "filial_orm_lite";
    public static final String ALIAS_CLASSE_ID = "id";

    public static final String ID = "id";
    public static final String ESTAB = "estab";
    public static final String REDUZIDO = "reduzido";
    public static final String USERS_COM_ACESSO = "usersComAcesso";
    public static final String VISUALIZA_QTD_NOTA_COLETOR = "visualizaQtdNotaColetor";

    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField()
    private String data;
    @DatabaseField()
    private Double kmInicial;
    @DatabaseField()
    private Double kmFinal;
    @DatabaseField()
    private Double litros;


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

    public Double getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(Double kmInicial) {
        this.kmInicial = kmInicial;
    }

    public Double getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(Double kmFinal) {
        this.kmFinal = kmFinal;
    }

    public Double getLitros() {
        return litros;
    }

    public void setLitros(Double litros) {
        this.litros = litros;
    }
}
