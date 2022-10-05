/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordenacaonumeros.model;

import com.mycompany.ordenacaonumeros.ElementoCollection;

/**
 *
 * @author logcomex
 */
public abstract class Ordenacao {

    protected String metodo;

    // TODO: Verificar com o professor como retornar o tempo da ordenacao?
    public void realizarOrdenarcao(ElementoCollection elementoCollection, Boolean direcao) {
    }

    public String getMetodo() {
        return metodo;
    }

}
