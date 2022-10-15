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
public class SelectionSortOrdenacao extends Ordenacao {

    public SelectionSortOrdenacao() {
        super();
        this.nomeMetodo = "SelectionSort";
    }

    @Override
    public void realizarOrdenarcao(ElementoCollection elementoCollection, Boolean direcao) {
        ArrayList<Double> arraySelecao = elementoCollection.getElementos();

        for (int i = 0; i < arraySelecao.size(); i++) {
            int idAux = i;
            for (int j = i; j < arraySelecao.size(); j++) {
                if (getCondicionalByDirecao(arraySelecao.get(j), arraySelecao.get(idAux), direcao)) {
                    idAux = j;
                }
            }

            double min = arraySelecao.get(idAux);
            arraySelecao.set(idAux, arraySelecao.get(i));
            arraySelecao.set(i, min);
        }

        elementoCollection.setElementos(arraySelecao);
    }
}
