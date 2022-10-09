/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordenacaonumeros.model;

import com.mycompany.ordenacaonumeros.collection.ElementoCollection;
import com.mycompany.ordenacaonumeros.enumerator.TiposOrdenacao;
import java.util.ArrayList;

/**
 *
 * @author logcomex
 */
public class SelectionSortOrdenacao extends Ordenacao {

    public SelectionSortOrdenacao() {
        super();
        this.nomeMetodo = TiposOrdenacao.SELECTION_SORT.getName();
    }

    @Override
    public void realizarOrdenarcao(ElementoCollection elementoCollection, Boolean direcao) {
        ArrayList<Double> arraySelecao = elementoCollection.getElementos();

        for (int posicaoAtual = 0; posicaoAtual < arraySelecao.size(); posicaoAtual++) {

            // find position of smallest num between (posicaoAtual + 1)th element and last element
            int indexPosicao = posicaoAtual;
            for (int posicaoAuxiliar = posicaoAtual; posicaoAuxiliar < arraySelecao.size(); posicaoAuxiliar++) {
                if (arraySelecao.get(posicaoAuxiliar) < arraySelecao.get(indexPosicao)) {
                    indexPosicao = posicaoAuxiliar;
                }
            }
            // Swap min (smallest num) to current position on array
            double min = arraySelecao.get(indexPosicao);
            arraySelecao.set(indexPosicao, arraySelecao.get(posicaoAtual));
            arraySelecao.set(posicaoAtual, min);
        }

        elementoCollection.setElementos(arraySelecao);
    }

    @Override
    public String getNomeMetodo() {
        return this.nomeMetodo;
    }

}
