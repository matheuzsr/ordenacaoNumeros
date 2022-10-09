/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordenacaonumeros.presenter;

import com.mycompany.ordenacaonumeros.collection.ElementoCollection;
import com.mycompany.ordenacaonumeros.model.Ordenacao;
import com.mycompany.ordenacaonumeros.service.LerElementosService;
import com.mycompany.ordenacaonumeros.view.OrdenacaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 *
 * @author logcomex
 */
public class OrdenacaoPresenter {

    private OrdenacaoView view;
    private ArrayList<Ordenacao> ordenacaoCollection;
    private LerElementosService lerElementosService;

    public OrdenacaoPresenter(LerElementosService lerElementosService, ArrayList<Ordenacao> ordenacaoCollection) {
        this.lerElementosService = lerElementosService;
        this.ordenacaoCollection = ordenacaoCollection;

        this.view = new OrdenacaoView();
        initListeners();
        view.setVisible(true);

    }

    private void initListeners() {
        view.getBtnCarregarArquivo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                carregarArquivo();

            }
        });
        JComboBox<String> cbmMetodo = view.getCmbMetodo();

        /*
         * Caso não utilizasse enum, deveria haver esse código ao invés do for abaixo
         * cbmMetodo.addItem("selectionSort");
         * cbmMetodo.addItem("bubbleSort");
         */
        for (Ordenacao metodoOrdenacao : ordenacaoCollection) {
            cbmMetodo.addItem(metodoOrdenacao.getNomeMetodo());
        }
        cbmMetodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                carregarArquivo();

            }
        });
        view.getBtnOrdenar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ordenar();

            }
        });
    }

    private void carregarArquivo() {
        ElementoCollection elementoColeCollection = lerElementosService.realizarLeitura(null);
        JList<Double> listaSemOrdenados = view.getLstSemOrdenados();

        listaSemOrdenados.setListData(convertArrayListEmVector(elementoColeCollection.getElementos()));

    }

    private ElementoCollection getElementosNaoOrdenados() {
        JList<Double> ordenacaoView = view.getLstSemOrdenados();
        int sizeList = ordenacaoView.getModel().getSize();
        // TODO: Verificar com o professor
        // Corrigir no point exception
        ArrayList<Double> elementosNaoOrdenados = null;

        for (int i = 0; i < sizeList; i++) {
            Double item = ordenacaoView.getModel().getElementAt(i);
            elementosNaoOrdenados.add(item);
        }

        return new ElementoCollection(elementosNaoOrdenados);
    }

    public void setElementosOrdenados(ElementoCollection elementoCollection) {
        // TODO: Verificar com o professor
        // Tem problema essa chamada encadeada(Visto que estou pegando coisas da view e
        // não de regra de negócio)
        view.getLstOrdenados().setListData(convertArrayListEmVector(elementoCollection.getElementos()));
    }

    public Vector<Double> convertArrayListEmVector(ArrayList<Double> arrayElementos) {
        return new Vector<Double>(arrayElementos);
    }

    public void ordenar() {
        JComboBox<String> cbmMetodo = view.getCmbMetodo();
        String itemSelecionado = cbmMetodo.getSelectedItem().toString();
        ElementoCollection elementoCollectionOrdenacao = getElementosNaoOrdenados();

        // TODO: Verificar com o professor
        // Pró de olhar o método selecionado quando clica em ordenar
        // Não precisa guardar a instância(que seria a opção de guardar no change do
        // combobox)
        // Contra: precisa percorrer todos os métodos quando for ordenar
        // Qual melhor maneira? e Porque?
        for (Ordenacao metodoOrdenacao : ordenacaoCollection) {
            if (itemSelecionado.equals(metodoOrdenacao.getNomeMetodo())) {
                // metodoOrdenacao.realizarOrdenarcao(elementoCollectionOrdenacao, true);

                setElementosOrdenados(elementoCollectionOrdenacao);
                break;
            }
        }

    }
}
