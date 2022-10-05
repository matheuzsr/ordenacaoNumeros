/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordenacaonumeros.enumerator;

/**
 *
 * @author logcomex
 */
public enum TiposOrdenacao {

    BUBBLE_SORT("bubbleSort"),
    SELECTION_SORT("selectionSort");

    private String name;

    TiposOrdenacao(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
