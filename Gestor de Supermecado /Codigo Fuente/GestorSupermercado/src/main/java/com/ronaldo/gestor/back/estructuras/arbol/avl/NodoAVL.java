package com.ronaldo.gestor.back.estructuras.arbol.avl;

import com.ronaldo.gestor.back.producto.Producto;

/**
 *
 * @author ronaldo
 */
public class NodoAVL {

    private NodoAVL izquierdo;
    private NodoAVL derecho;
    private Producto elemento;
    private int factorEquilibrio;
    private int altura;

    public NodoAVL(Producto elemento) {
        this.elemento = elemento;
    }

    
}
