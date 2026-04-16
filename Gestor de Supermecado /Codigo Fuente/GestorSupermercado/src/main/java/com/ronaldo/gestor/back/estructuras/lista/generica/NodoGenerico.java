package com.ronaldo.gestor.back.estructuras.lista.generica;

/**
 *
 * @author ronaldo
 */
public class NodoGenerico<T> {
    private NodoGenerico<T> siguiente;
    private T valor;

    public NodoGenerico(T valor) {
        this.valor = valor;
    }
    

    public NodoGenerico<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoGenerico<T> siguiente) {
        this.siguiente = siguiente;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
    
    
}
