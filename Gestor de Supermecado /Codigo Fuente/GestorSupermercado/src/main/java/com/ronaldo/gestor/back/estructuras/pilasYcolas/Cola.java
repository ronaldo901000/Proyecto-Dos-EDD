package com.ronaldo.gestor.back.estructuras.pilasYcolas;

import com.ronaldo.gestor.back.estructuras.lista.normal.ListaEnlazada;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.producto.Producto;

/**
 *
 * @author ronaldo
 */
public class Cola {

    private ListaEnlazada contenido;

    public Cola() {
        contenido = new ListaEnlazada();
    }

    public void ingresar(Producto producto) {
        contenido.insertar(producto);
    }

    public Producto sacar() throws ElementoNoEncontradoException {
        if (colaVacia()) {
            throw new ElementoNoEncontradoException("La cola esta vacia");
        }

        Producto p = contenido.obtener(0);
        contenido.eliminarPrimero();
        return p;
    }

    public ListaEnlazada listar() {
        return this.contenido;
    }

    public ListaEnlazada getContenido() {
        return contenido;
    }

    public boolean colaVacia() {
        return this.contenido.estaVacia();
    }

}
