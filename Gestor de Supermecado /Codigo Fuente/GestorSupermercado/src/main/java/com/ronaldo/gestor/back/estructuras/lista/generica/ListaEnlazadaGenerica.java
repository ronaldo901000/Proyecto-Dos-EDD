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

    public void eliminarElemento(T valor) throws ListaException {
        if (estaVacia()) {
            throw new ListaException("La lista está vacía.");
        }

        if (inicio.getValor().equals(valor)) {
            inicio = inicio.getSiguiente();
            if (inicio == null) {
                fin = null;
            }
            tamaño--;
            return;
        }

        NodoGenerico<T> anterior = inicio;
        NodoGenerico<T> actual = inicio.getSiguiente();

        while (actual != null) {
            if (actual.getValor().equals(valor)) {
                anterior.setSiguiente(actual.getSiguiente());
                if (actual.getSiguiente() == null) {
                    fin = anterior;
                }
                tamaño--;
                return;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }

        throw new ListaException("El elemento no existe en la lista.");
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public int getTamaño() {
        return tamaño;
    }

}
