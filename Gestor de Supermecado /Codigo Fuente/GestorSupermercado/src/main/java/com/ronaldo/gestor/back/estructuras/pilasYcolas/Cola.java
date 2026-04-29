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
    private int indiceEnCurso;

    public Cola() {
        contenido = new ListaEnlazada();
        indiceEnCurso = -1;
    }

    public void ingresar(Producto producto) {
        contenido.insertar(producto);
    }

    public Producto sacar() throws ElementoNoEncontradoException {
        indiceEnCurso++;
        return contenido.obtener(indiceEnCurso);
    }

}
