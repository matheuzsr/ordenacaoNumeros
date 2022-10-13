/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.principal;

import com.mycompany.ordenacaonumeros.model.BubbleSortOrdenacao;
import com.mycompany.ordenacaonumeros.model.Ordenacao;
import com.mycompany.ordenacaonumeros.model.SelectionSortOrdenacao;
import com.mycompany.ordenacaonumeros.presenter.OrdenacaoPresenter;
import com.mycompany.ordenacaonumeros.service.LerSalarioFileService;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author logcomex
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Ordenacao> ordenacaoCollection = new ArrayList<Ordenacao>(Arrays.asList(
                new BubbleSortOrdenacao(),
                new SelectionSortOrdenacao()
        ));

        new OrdenacaoPresenter(new LerSalarioFileService(), ordenacaoCollection);
    }
}
