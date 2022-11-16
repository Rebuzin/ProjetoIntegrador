package com.example.appmedia.util;

import android.util.Log;

public class LogApp<T> {
    private final Class<T> classe;

    public static <T> LogApp<T> getLogger(Class<T> classe) {
        return new LogApp<T>(classe);
    }

    private LogApp(Class<T> classe) {
        this.classe = classe;
    }

    public void d(String msg) {
        Log.d(classe.getName(), msg);
    }

    public void d(String ... arr) {
        StringBuilder builder = new StringBuilder();
        for (String str : arr) {
            builder.append(str).append(" - ");
        }
        Log.d(classe.getName(), builder.toString());
    }

    public void d(Integer msg) {
        Log.d(classe.getName(), msg.toString());
    }

    public void d(String msg, Throwable t) {
        Log.d(classe.getName(), msg, t);
    }

    public void e(String msg) {
        Log.e(classe.getName(), msg);
    }

    public void e(Throwable t) {
        Log.e(classe.getName(), "", t);
    }

    public void e(String msg, Throwable t) {
        Log.e(classe.getName(), msg, t);
    }

    public void w(String msg) {
        Log.w(classe.getName(), msg);
    }

    public void w(String msg, Throwable t) {
        Log.w(classe.getName(), msg, t);
    }

    public void w(Throwable t) {
        Log.w(classe.getName(), t);
    }
}
