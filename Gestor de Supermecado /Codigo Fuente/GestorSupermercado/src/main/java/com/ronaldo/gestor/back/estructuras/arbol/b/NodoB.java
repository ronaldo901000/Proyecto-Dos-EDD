package com.ronaldo.gestor.back.estructuras.arbol.b;

/**
 *
 * @author ronaldo
 */
public class NodoB {

    private static final int D = 2;
    private static final int MAX_CLAVES = 2 * D;
    private static final int MAX_HIJOS = 2 * D + 1;
    private static final int MIN_CLAVES = D;

    private Clave[] claves;
    private NodoB[] hijos;
    private int contadorClaves;
    private boolean esHoja;

    public NodoB(boolean esHoja) {
        this.esHoja = esHoja;
        this.claves = new Clave[MAX_CLAVES + 1];
        this.hijos = new NodoB[MAX_HIJOS + 1];
    }

    public boolean nodoSobrePasado() {
        return this.contadorClaves == MAX_CLAVES + 1;
    }

    public boolean nodoSemiVacio() {
        return this.contadorClaves < MIN_CLAVES;
    }

    public Clave getClavePorIndice(int indice) {
        return this.claves[indice];
    }

    public void setClavePorIndice(int indice, Clave clave) {
        this.claves[indice] = clave;
    }

    public NodoB getHijoPorIndice(int indice) {
        return this.hijos[indice];
    }

    public void setHijoPorIndice(int indice, NodoB hijo) {
        this.hijos[indice] = hijo;
    }

    public int getContador() {
        return this.contadorClaves;
    }

    public void setContador(int valor) {
        this.contadorClaves = valor;
    }

    public boolean isHoja() {
        return this.esHoja;
    }
    
    public boolean isInterno(){
        return !this.esHoja;
    }

    public void insetarNuevaClave(Clave clave) {
        this.claves[contadorClaves] = clave;
        this.contadorClaves++;
    }

    public void insertarNuevoHijo(NodoB nodo) {
        this.hijos[contadorClaves] = nodo;
    }

    public NodoB[] getTodosLosHijos() {
        return this.hijos;
    }

    public Clave[] getTodasLasClaves() {
        return this.claves;
    }
}
