package com.ronaldo.gestor.back.estructuras.lista.normal;

import com.ronaldo.gestor.back.estructuras.lista.Lista;
import com.ronaldo.gestor.back.producto.Producto;

/**
 *
 * @author ronaldo
 */
public class ListaEnlazada extends Lista {


    @Override
    public void insertar(Producto producto) {
        NodoLista nodo = new NodoLista(producto);

        if (estaVacia()) {
            this.nodoInicial = nodo;
            this.nodoFinal = nodo;
        } else {
            this.nodoFinal.setSiguienteNodo(nodo);
            nodo.setNodoAnterior(this.nodoFinal);
            this.nodoFinal = nodo;
        }
        tamaño++;
    }

}
