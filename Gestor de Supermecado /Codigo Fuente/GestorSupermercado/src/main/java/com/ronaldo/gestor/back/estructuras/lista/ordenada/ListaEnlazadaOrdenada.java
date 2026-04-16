package com.ronaldo.gestor.back.estructuras.lista.ordenada;

import com.ronaldo.gestor.back.estructuras.lista.Lista;
import com.ronaldo.gestor.back.estructuras.lista.normal.NodoLista;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.producto.Producto;

/**
 *
 * @author ronaldo
 */
public class ListaEnlazadaOrdenada extends Lista {

    @Override
    public void insertar(Producto producto) throws ElementoNoEncontradoException {
        NodoLista nodo = new NodoLista(producto);

        if (estaVacia()) {
            this.nodoInicial = nodo;
            this.nodoFinal = nodo;
            this.tamaño++;
            return;
        }

        int posicion = encontrarPosicion(producto.getNombre());

        if (vaAlInicio(posicion)) {
            nodo.setSiguienteNodo(this.nodoInicial);
            this.nodoInicial.setNodoAnterior(nodo);
            this.nodoInicial = nodo;
        } else if (vaAlFinal(posicion)) {
            this.nodoFinal.setSiguienteNodo(nodo);
            nodo.setNodoAnterior(this.nodoFinal);
            this.nodoFinal = nodo;
        } else {
            NodoLista anterior = obtenerNodo(posicion - 1);
            NodoLista siguiente = anterior.getSiguienteNodo();
            anterior.setSiguienteNodo(nodo);
            nodo.setNodoAnterior(anterior);
            nodo.setSiguienteNodo(siguiente);
            siguiente.setNodoAnterior(nodo);
        }

        this.tamaño++;
    }

    private int encontrarPosicion(String nombre) {
        int indice = 0;
        NodoLista actual = this.nodoInicial;

        while (actual != null && actual.getElemento().getNombre().compareTo(nombre) < 0) {
            actual = actual.getSiguienteNodo();
            indice++;
        }

        return indice;
    }

    private boolean vaAlInicio(int indice) {
        return indice == 0;
    }

    public boolean vaAlFinal(int indice) {
        return indice >= this.tamaño;
    }
}
