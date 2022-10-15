/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordenacaonumeros.model;

import com.mycompany.ordenacaonumeros.collection.ElementoCollection;
import java.util.ArrayList;

/**
 *
 * @author logcomex
 */
public class BubbleSortOrdenacao extends Ordenacao {

    public BubbleSortOrdenacao() {
        super();
        this.nomeMetodo = "BubbleSort";
    }

    @Override
    public void realizarOrdenarcao(ElementoCollection elementoCollection, Boolean direcao) {
        ArrayList<Double> arraySelecao = elementoCollection.getElementos();

        double aux;
        for (int i = 0; i < arraySelecao.size(); i++) {
            for (int j = i + 1; j < arraySelecao.size(); j++) {
                if (getCondicionalByDirecao(arraySelecao.get(i), arraySelecao.get(j), direcao)) {
                    aux = arraySelecao.get(j);
                    arraySelecao.set(j, arraySelecao.get(i));
                    arraySelecao.set(i, aux);
                }
            }
        }

        elementoCollection.setElementos(arraySelecao);
    }
}
