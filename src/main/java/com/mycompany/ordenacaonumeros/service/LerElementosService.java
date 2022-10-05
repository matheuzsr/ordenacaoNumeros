/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordenacaonumeros.service;

import com.mycompany.ordenacaonumeros.ElementoCollection;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author logcomex
 */
public class LerElementosService {

    private ElementoCollection realizarLeitura(String pathArquivo) {
        ArrayList<Double> numeros = new ArrayList<>(Arrays.asList(
                10.0, 5.0, 6.0, 7.0, 8.0, 2.0
        ));

        return new ElementoCollection(numeros);
    }
}
