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
        this.initConfiguracaoView();
        this.initListeners();
        this.view.setVisible(true);

    }

    private void initListeners() {
        this.view.getBtnCarregarArquivo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                carregarArquivo();
            }
        });
        this.view.getBtnOrdenar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ordenar();
            }
        });

        this.view.getLstSemOrdenar().addPropertyChangeListener(e -> this.handleEnableButtonOrdenacao());
    }

    private void initConfiguracaoView() {
        this.view.getGrpOrdem().add(this.view.getRbtnCrescente());
        this.view.getGrpOrdem().add(this.view.getRbtnDecrescente());
        this.view.getRbtnCrescente().setSelected(true);

        this.view.getBtnOrdenar().setEnabled(false);
        for (Ordenacao metodoOrdenacao : ordenacaoCollection) {
            this.view.getCmbMetodo().addItem(metodoOrdenacao.getNomeMetodo());
        }
    }

    private void carregarArquivo() {
        ElementoCollection elementoColeCollection;
        try {
            elementoColeCollection = lerElementosService.realizarLeitura();

            JList<Double> listaSemOrdenados = this.view.getLstSemOrdenar();
            listaSemOrdenados.setListData(convertArrayListEmVector(elementoColeCollection.getElementos()));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrdenacaoPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ElementoCollection getElementosNaoOrdenados() {
        JList<Double> ordenacaoView = this.view.getLstSemOrdenar();
        int sizeList = ordenacaoView.getModel().getSize();

        ArrayList<Double> elementosNaoOrdenados = new ArrayList<>();

        for (int i = 0; i < sizeList; i++) {
            Double item = ordenacaoView.getModel().getElementAt(i);
            elementosNaoOrdenados.add(item);
        }

        return new ElementoCollection(elementosNaoOrdenados);
    }

    private void setElementosOrdenados(ElementoCollection elementoCollection) {
        this.view.getLstOrdenados().setListData(convertArrayListEmVector(elementoCollection.getElementos()));
    }

    private Vector<Double> convertArrayListEmVector(ArrayList<Double> arrayElementos) {
        return new Vector<Double>(arrayElementos);
    }

    private void ordenar() {
        JComboBox<String> cbmMetodo = this.view.getCmbMetodo();
        String itemSelecionado = cbmMetodo.getSelectedItem().toString();
        ElementoCollection elementoCollectionOrdenacao = getElementosNaoOrdenados();

        for (Ordenacao metodoOrdenacao : ordenacaoCollection) {
            if (itemSelecionado.equals(metodoOrdenacao.getNomeMetodo())) {

                Boolean direcao = getDirecaoOrdenacao();
                metodoOrdenacao.realizarOrdenarcaoWithTempo(elementoCollectionOrdenacao, direcao);
                setLabelTempo(metodoOrdenacao.getTempoGasto());

                setElementosOrdenados(elementoCollectionOrdenacao);
                break;
            }
        }
    }

    // TODO: Talvez utilizar uma implementação onde busque o dado direto do
    // buttonGroup
    private Boolean getDirecaoOrdenacao() {
        return this.view.getRbtnCrescente().isSelected();
    }

    private void setLabelTempo(long tempo) {
        this.view.getLblTempo().setText(String.valueOf(tempo).concat("ms"));
    }

    private void handleEnableButtonOrdenacao() {
        if (this.view.getLstSemOrdenar().getModel().getSize() > 0) {
            this.view.getBtnOrdenar().setEnabled(true);
        }
    }
}
