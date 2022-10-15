/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordenacaonumeros.model;

import com.mycompany.ordenacaonumeros.collection.ElementoCollection;

/**
 *
 * @author logcomex
 */
public abstract class Ordenacao {

    protected String nomeMetodo;
    private long tempoGasto;

    public void realizarOrdenarcaoWithTempo(ElementoCollection elementoCollection, Boolean direcao) {
        long inicio = System.currentTimeMillis();
        realizarOrdenarcao(elementoCollection, direcao);
        long fim = System.currentTimeMillis();
        this.tempoGasto = fim - inicio;
    }

    public void realizarOrdenarcao(ElementoCollection elementoCollection, Boolean direcao) {
    }

    protected Boolean getCondicionalByDirecao(double value1, double value2, Boolean direcao) {
        return direcao
                ? value1 < value2
                : value1 > value2;
    }

    public String getNomeMetodo() {
        return this.nomeMetodo;
    }

    public long getTempoGasto() {
        return this.tempoGasto;
    }
}
