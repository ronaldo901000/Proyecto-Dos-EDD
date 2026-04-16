package com.ronaldo.gestor.back.estructuras.arbol.bmas;

import com.ronaldo.gestor.back.estructuras.lista.ordenada.ListaEnlazadaOrdenada;

/**
 *
 * @author ronaldo
 */
public class ClaveColeccion {

    private String categoria;
    private ListaEnlazadaOrdenada coleccion;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ListaEnlazadaOrdenada getColeccion() {
        return coleccion;
    }

    public void setColeccion(ListaEnlazadaOrdenada coleccion) {
        this.coleccion = coleccion;
    }

}
