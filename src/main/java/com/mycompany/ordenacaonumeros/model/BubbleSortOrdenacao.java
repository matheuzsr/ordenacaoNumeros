/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordenacaonumeros.model;

import com.mycompany.ordenacaonumeros.ElementoCollection;
import com.mycompany.ordenacaonumeros.enumerator.TiposOrdenacao;

/**
 *
 * @author logcomex
 */
public class BubbleSortOrdenacao extends Ordenacao {

    public BubbleSortOrdenacao() {
        super();
        this.metodo = TiposOrdenacao.BUBBLE_SORT.getName();
    }

    @Override
    public void realizarOrdenarcao(ElementoCollection elementoCollection, Boolean direcao) {
        System.out.println(elementoCollection);
        System.out.println(direcao);
    }

    @Override
    public String getMetodo() {
        return this.metodo;
    }

}
