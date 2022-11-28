package com.example.appmedia.model;

import java.io.Serializable;

public class Info implements Serializable {
    /**
     * ***************** Constantes com os códigos dos erros *****************
     */
    /**
     * Sucesso : Quando a ação é executada com sucesso.
     */
    public static final String INFO_001 = "001";

    /**
     * Erro ao executar uma operação :
     */
    public static final String INFO_002 = "002";
    public static String TIPO_MSG_DANGER = "danger";
    public static String TIPO_MSG_SUCCESS = "success";

    private String codigo;
    private String mensagem;
    private Integer mensagemInt;
    private String erro;
    private String tipo;
    private Object objeto;


    public Info(boolean erro, String mensagem, Object objeto) {
        if (erro) {
            this.codigo = Info.INFO_002;
            this.tipo = Info.TIPO_MSG_DANGER;
            this.erro = mensagem;
        } else {
            this.codigo = Info.INFO_001;
            this.tipo = Info.TIPO_MSG_SUCCESS;
            this.erro = null;
        }
        this.objeto = objeto;
        this.mensagem = mensagem;
    }

    public Info(boolean erro, Integer mensagemInt, Object objeto) {
        if (erro) {
            this.codigo = Info.INFO_002;
            this.tipo = Info.TIPO_MSG_DANGER;
        } else {
            this.codigo = Info.INFO_001;
            this.tipo = Info.TIPO_MSG_SUCCESS;
        }
        this.objeto = objeto;
        this.mensagemInt = mensagemInt;
    }

    public static Info getSuccess() {
        return new Info(false, "", null);
    }

    public static Info getSuccess(Object obj) {
        return new Info(false, "", obj);
    }

    public static Info getSuccess(String msg, Object obj) {
        return new Info(false, msg, obj);
    }

    public static Info getSuccess(Integer msg, Object obj) {
        return new Info(false, msg, obj);
    }

    public static Info getError(String msg) {
        if(msg != null){
            if(msg.startsWith("Failed to connect") || msg.startsWith("failed to connect")){
                msg = "Ops.. Você está sem internet! Por favor verifique sua conexão!";
            }
        }
        return new Info(true, msg, null);
    }

    public static Info getError(Integer msg) {
        return new Info(true, msg, null);
    }

    public static Info getError(String msg, Object obj) {
        return new Info(true, msg, obj);
    }

    public static Info getError(Integer msg, Object obj) {
        return new Info(true, msg, obj);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public Integer getMensagemInt() {
        return mensagemInt;
    }

    public void setMensagemInt(Integer mensagemInt) {
        this.mensagemInt = mensagemInt;
    }
}
