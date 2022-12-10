package com.example.appmedia.funcoesvalidacao;

public class FuncoesPadrao {
    public static boolean validaCPF(String cpf) {
        return ValidaCPF.isCPF(cpf);
    }
}
