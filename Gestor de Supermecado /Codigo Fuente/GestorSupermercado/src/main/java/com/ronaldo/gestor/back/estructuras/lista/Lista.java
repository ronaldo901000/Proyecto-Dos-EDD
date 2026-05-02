package com.ronaldo.gestor.back.estructuras.lista;

import com.ronaldo.gestor.back.estructuras.lista.normal.NodoLista;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.producto.Producto;

/**
 *
 * @author ronaldo
 */
public abstract class Lista {

    protected NodoLista nodoInicial;
    protected NodoLista nodoFinal;
    protected int tamaño;

    public abstract void insertar(Producto producto) throws ElementoNoEncontradoException;

    public Producto obtener(int indice) throws ElementoNoEncontradoException {
        return obtenerNodo(indice).getElemento();
    }

    public void eliminar(String codigoBarra) throws ElementoNoEncontradoException {
        NodoLista actual = this.nodoInicial;

        while (actual != null && !actual.getElemento().getCodigoBarra().equals(codigoBarra)) {
            actual = actual.getSiguienteNodo();
        }

        if (actual == null) {
            throw new ElementoNoEncontradoException("Producto con codigo de barras " + codigoBarra + " No registrado.");
        }

        if (actual.getNodoAnterior() != null) {
            actual.getNodoAnterior().setSiguienteNodo(actual.getSiguienteNodo());
        } else {
            this.nodoInicial = actual.getSiguienteNodo();
        }

        if (actual.getSiguienteNodo() != null) {
            actual.getSiguienteNodo().setNodoAnterior(actual.getNodoAnterior());
        } else {
            this.nodoFinal = actual.getNodoAnterior();
        }

        this.tamaño--;
    }

    public Producto getProductoPorCodigoBarra(String codigoBarra) throws ElementoNoEncontradoException {
        NodoLista nodo = this.nodoInicial;

        while (nodo != null && !nodo.getElemento().getCodigoBarra().equals(codigoBarra)) {
            nodo = nodo.getSiguienteNodo();
        }

        if (nodo == null) {
            throw new ElementoNoEncontradoException("No existe ningun producto con codigo: " + codigoBarra);
        }

        return nodo.getElemento();

    }

    protected NodoLista obtenerNodo(int indice) throws ElementoNoEncontradoException {
        if (indice < 0 || indice >= tamaño) {
            throw new ElementoNoEncontradoException("Indice " + indice + " fuera de rango.");
        }

        NodoLista actual;

        if (indice < (tamaño / 2)) {
            actual = nodoInicial;
            for (int i = 0; i < indice; i++) {
                actual = actual.getSiguienteNodo();
            }
        } else {
            actual = nodoFinal;
            for (int i = tamaño - 1; i > indice; i--) {
                actual = actual.getNodoAnterior();
            }
        }

        if (actual == null) {
            throw new ElementoNoEncontradoException("Producto en lista no encontrado");
        }

        return actual;
    }

    public int getTamaño() {
        return tamaño;
    }

    public boolean estaVacia() {
        return this.tamaño == 0;
    }

    public NodoLista getNodoInicial() {
        return nodoInicial;
    }

    public NodoLista getNodoFinal() {
        return nodoFinal;
    }

}
