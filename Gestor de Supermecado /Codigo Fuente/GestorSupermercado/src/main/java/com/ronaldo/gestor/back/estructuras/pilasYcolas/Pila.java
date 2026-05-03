package com.ronaldo.gestor.back.estructuras.pilasYcolas;

import com.ronaldo.gestor.back.estructuras.lista.normal.ListaEnlazada;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.exceptions.PilaVaciaException;
import com.ronaldo.gestor.back.producto.Producto;

/**
 *
 * @author ronaldo
 */
public class Pila {

    private ListaEnlazada contenedor;
    private int apuntador;

    public Pila() {
        this.apuntador = -1;
        this.contenedor = new ListaEnlazada();
    }

    public void apilar(Producto producto) {
        contenedor.insertar(producto);
        apuntador++;
    }

    public Producto desapilar() throws PilaVaciaException, ElementoNoEncontradoException {
        if (pilaVacia()) {
            throw new PilaVaciaException("La pila esta vacia");
        }

        Producto p = this.contenedor.obtener(apuntador);
        apuntador--;
        return p;
    }

    public boolean pilaVacia() {
        return this.apuntador == -1;
    }

    public int getApuntador() {
        return apuntador;
    }

    public ListaEnlazada getContenedor() {
        return contenedor;
    }
    
    
    
    
    
}
