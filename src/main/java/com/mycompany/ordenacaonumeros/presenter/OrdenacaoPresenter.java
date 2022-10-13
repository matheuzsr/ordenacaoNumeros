/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordenacaonumeros.presenter;

import com.mycompany.ordenacaonumeros.collection.ElementoCollection;
import com.mycompany.ordenacaonumeros.model.Ordenacao;
import com.mycompany.ordenacaonumeros.service.LerSalarioFileService;
import com.mycompany.ordenacaonumeros.view.OrdenacaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 *
 * @author logcomex
 */
public class OrdenacaoPresenter {

    private OrdenacaoView view;
    private ArrayList<Ordenacao> ordenacaoCollection;
    private LerSalarioFileService lerElementosService;

    public OrdenacaoPresenter(LerSalarioFileService lerElementosService, ArrayList<Ordenacao> ordenacaoCollection) {
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
        ElementoCollection elementoColeCollection;
        try {
            elementoColeCollection = lerElementosService.realizarLeitura();

            JList<Double> listaSemOrdenados = view.getLstSemOrdenados();
            listaSemOrdenados.setListData(convertArrayListEmVector(elementoColeCollection.getElementos()));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrdenacaoPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private ElementoCollection getElementosNaoOrdenados() {
        JList<Double> ordenacaoView = view.getLstSemOrdenados();
        int sizeList = ordenacaoView.getModel().getSize();

        ArrayList<Double> elementosNaoOrdenados = new ArrayList<>();

        for (int i = 0; i < sizeList; i++) {
            Double item = ordenacaoView.getModel().getElementAt(i);
            elementosNaoOrdenados.add(item);
        }

        return new ElementoCollection(elementosNaoOrdenados);
    }

    private void setElementosOrdenados(ElementoCollection elementoCollection) {
        view.getLstOrdenados().setListData(convertArrayListEmVector(elementoCollection.getElementos()));
    }

    private Vector<Double> convertArrayListEmVector(ArrayList<Double> arrayElementos) {
        return new Vector<Double>(arrayElementos);
    }

    private void ordenar() {
        JComboBox<String> cbmMetodo = view.getCmbMetodo();
        String itemSelecionado = cbmMetodo.getSelectedItem().toString();
        ElementoCollection elementoCollectionOrdenacao = getElementosNaoOrdenados();

        for (Ordenacao metodoOrdenacao : ordenacaoCollection) {
            if (itemSelecionado.equals(metodoOrdenacao.getNomeMetodo())) {
                Instant antes = Instant.now();

                metodoOrdenacao.realizarOrdenarcao(elementoCollectionOrdenacao, true);
                Instant depois = Instant.now();
                Duration duracao = Duration.between(antes, depois);
                setLabelTempo(duracao.getSeconds());

                setElementosOrdenados(elementoCollectionOrdenacao);
                break;
            }
        }

    }

    private void setLabelTempo(long tempo) {
        var tempoMilisegundos = tempo * 1000;
        view.getLblTempo().setText(String.valueOf(tempoMilisegundos).concat("ms"));
    }
}
