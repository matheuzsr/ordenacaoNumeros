/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordenacaonumeros.service;

import com.mycompany.ordenacaonumeros.collection.ElementoCollection;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author logcomex
 */
public class LerSalarioFileService {

    public ElementoCollection realizarLeitura() throws FileNotFoundException {
        ArrayList<Double> salarios = new ArrayList<>();

        String pathArquivo = "src/main/java/com/mycompany/ordenacaonumeros/collection/data/salarios.csv";
        File arquivo = new File(pathArquivo);

        Scanner scan = new Scanner(arquivo);
        salarios.clear();
        scan.nextLine();
        while (scan.hasNextLine()) {
            String linha = scan.nextLine();
            Scanner scanline = new Scanner(linha);

            while (scanline.hasNext()) {
                String salario = scanline.next();

                salarios.add(Double.valueOf(salario));
            }
        }

        return new ElementoCollection(salarios);
    }
}
