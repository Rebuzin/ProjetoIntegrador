package com.example.appmedia.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "veiculo_orm_lite")
public class VeiculoOrmLite {

    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField()
    private String placa;
    @DatabaseField()
    private String renavam;
    @DatabaseField()
    private String eixos;
    @DatabaseField()
    private String modelo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getEixos() {
        return eixos;
    }

    public void setEixos(String eixos) {
        this.eixos = eixos;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
