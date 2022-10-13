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

    public void realizarOrdenarcao(ElementoCollection elementoCollection, Boolean direcao) {
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

}
