package com.ronaldo.gestor.back.estructuras.lista.generica;

import com.ronaldo.gestor.back.exceptions.ListaException;

/**
 *
 * @author jose
 */
public class ListaEnlazadaGenerica<T> {

    private NodoGenerico<T> inicio;
    private NodoGenerico<T> fin;
    private int tamaño = 0;

    public void agregarElemento(T valor) {
        NodoGenerico<T> nuevo = new NodoGenerico(valor);

        if (estaVacia()) {
            fin = nuevo;
            inicio = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        tamaño++;
    }

    public void agregarElemento(int index, T valor) throws ListaException {
        if (index >= tamaño || estaVacia()) {
            throw new ListaException("Indice fuera de rango: " + index);
        }

        NodoGenerico<T> nuevo = new NodoGenerico(valor);

        if (index == 0) {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        } else {

            NodoGenerico<T> anterior = obtenerNodo(index - 1);

            NodoGenerico<T> siguiente = anterior.getSiguiente();
            nuevo.setSiguiente(siguiente);

            anterior.setSiguiente(nuevo);
        }
        tamaño++;

    }

    public T obtenerValor(int index) throws ListaException {
        return obtenerNodo(index).getValor();
    }

    public NodoGenerico<T> obtenerNodo(int index) throws ListaException {
        if (index >= tamaño || estaVacia()) {
            throw new ListaException("Indice fuera de rango: " + index);
        }

        NodoGenerico<T> actual = inicio;
        for (int i = 0; i < index; i++) {
            NodoGenerico<T> siguiente = actual.getSiguiente();
            actual = siguiente;
        }
        return actual;
    }


    public boolean estaVacia() {
        return inicio == null;
    }

    public int getTamaño() {
        return tamaño;
    }

}
