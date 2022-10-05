/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordenacaonumeros;

import com.mycompany.ordenacaonumeros.model.Ordenacao;
import com.mycompany.ordenacaonumeros.view.OrdenacaoView;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author logcomex
 */
public class OrdenacaoPresenter {

    private Ordenacao ordenacao;
    private OrdenacaoView ordenacaoView;

    public void OrdenacaoPresenter() {
        this.ordenacaoView = new OrdenacaoView();
        ordenacaoView.setVisible(true);

        this.setMetodoOrdenacao();

    }
//    public ElementoCollection getElementosNaoOrdenados() {
//    }
//
//    public ElementoCollection setElementosOrdenados() {
//    }
//
//    public File carregarArquivo() {
//    }
//

    public void setMetodoOrdenacao() {
        this.ordenacaoView.setCmbMetodos(new ArrayList<>(Arrays.asList("sa", "asas")));
    }
//
//    public void ordenar() {
//    }
}
