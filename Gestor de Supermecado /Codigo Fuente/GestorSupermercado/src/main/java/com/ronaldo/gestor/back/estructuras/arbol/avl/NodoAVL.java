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

    public void actualizarAltura() {
        this.altura = Math.max(getAlturaHijo(this.izquierdo), getAlturaHijo(this.derecho));
    }

    private int getAlturaHijo(NodoAVL hijo) {
        
        if (hijo == null) {
            return 0;
        }
        
        return hijo.getAltura();
    }

    public NodoAVL getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoAVL izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoAVL getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoAVL derecho) {
        this.derecho = derecho;
    }

    public Producto getElemento() {
        return elemento;
    }

    public void setElemento(Producto elemento) {
        this.elemento = elemento;
    }

    public int getFactorEquilibrio() {
        return factorEquilibrio;
    }

    public void setFactorEquilibrio(int factorEquilibrio) {
        this.factorEquilibrio = factorEquilibrio;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

}
