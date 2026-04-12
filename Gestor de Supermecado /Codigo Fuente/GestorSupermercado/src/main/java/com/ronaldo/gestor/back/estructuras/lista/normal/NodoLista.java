package com.ronaldo.gestor.back.estructuras.lista.normal;

import com.ronaldo.gestor.back.producto.Producto;

/**
 *
 * @author ronaldo
 */
public class NodoLista {

    private NodoLista nodoAnterior;
    private NodoLista siguienteNodo;
    private Producto elemento;

    public NodoLista(Producto elemento) {
        this.elemento = elemento;
    }

    public NodoLista getNodoAnterior() {
        return nodoAnterior;
    }

    public void setNodoAnterior(NodoLista nodoAnterior) {
        this.nodoAnterior = nodoAnterior;
    }

    public NodoLista getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(NodoLista siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    public Producto getElemento() {
        return elemento;
    }

    public void setElemento(Producto elemento) {
        this.elemento = elemento;
    }

}
