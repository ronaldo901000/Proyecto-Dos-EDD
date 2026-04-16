package com.ronaldo.gestor.back.estructuras.arbol.bmas;

import com.ronaldo.gestor.back.estructuras.lista.ordenada.ListaEnlazadaOrdenada;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.producto.Producto;

/**
 *
 * @author ronaldo
 */
public class NodoBMas {

    private static final int D = 2;
    private static final int MAX_HIJOS = 2 * D + 1;
    private static final int MAX_CLAVES = 2 * D;
    private static final int MIN_CLAVES = D;

    private NodoBMas[] hijos;
    private ClaveColeccion[] clavesColeccion;
    private boolean esHoja;
    private int contadorClaves;

    public NodoBMas(boolean esHoja) {
        this.esHoja = esHoja;
        this.clavesColeccion = new ClaveColeccion[MAX_CLAVES + 1];
        this.hijos = new NodoBMas[MAX_HIJOS + 1];
    }

    public void agregarNuevaCategoria(String categoria) {
        ClaveColeccion claveColeccion = new ClaveColeccion();
        claveColeccion.setCategoria(categoria);

        clavesColeccion[contadorClaves] = claveColeccion;
        contadorClaves++;
    }

    public void agregarProductoAColeccion(Producto producto) throws ElementoNoEncontradoException {

        for (int i = 0; i < contadorClaves; i++) {
            ClaveColeccion clave = clavesColeccion[i];

            if (clave.getCategoria().equals(producto.getCategoria())) {

                if (clave.getColeccion() == null) {
                    clave.setColeccion(new ListaEnlazadaOrdenada());
                }

                clave.getColeccion().insertar(producto);
                return;
            }
        }

        insertarClaveYProducto(
                contadorClaves,
                producto.getCategoria(),
                producto
        );
    }

    public void insertarClaveEnNodoInterno(int indice, String clave, NodoBMas hijo) {

        for (int i = contadorClaves; i > indice; i--) {
            clavesColeccion[i] = clavesColeccion[i - 1];
        }

        for (int i = contadorClaves; i >= indice + 1; i--) {
            hijos[i + 1] = hijos[i];
        }

        ClaveColeccion nueva = new ClaveColeccion();
        nueva.setCategoria(clave);

        clavesColeccion[indice] = nueva;
        hijos[indice + 1] = hijo;

        contadorClaves++;

    }

    public void eliminarProductoDeColeccion(int indiceColeccion, String codigoBarra) throws ElementoNoEncontradoException {
        ListaEnlazadaOrdenada lista = clavesColeccion[indiceColeccion].getColeccion();

        lista.eliminar(codigoBarra);
    }

    public void eliminarClaveConSuColeccion(int indice) {
        for (int i = indice; i < contadorClaves - 1; i++) {
            clavesColeccion[i] = clavesColeccion[i + 1];
        }
        clavesColeccion[contadorClaves - 1] = null;
        contadorClaves--;
    }

    public void insertarClaveYProducto(int indice, String categoria, Producto producto) throws ElementoNoEncontradoException {

        for (int i = contadorClaves; i > indice; i--) {
            clavesColeccion[i] = clavesColeccion[i - 1];
        }

        ClaveColeccion nueva = new ClaveColeccion();
        nueva.setCategoria(categoria);
        nueva.setColeccion(new ListaEnlazadaOrdenada());

        clavesColeccion[indice] = nueva;
        contadorClaves++;

        nueva.getColeccion().insertar(producto);
    }

    public boolean nodoSobreCargado() {
        return this.contadorClaves > MAX_CLAVES;
    }

    public NodoBMas[] getHijos() {
        return hijos;
    }

    public void setHijos(NodoBMas[] hijos) {
        this.hijos = hijos;
    }

    public ClaveColeccion[] getClavesColeccion() {
        return clavesColeccion;
    }

    public void setClavesColeccion(ClaveColeccion[] clavesColeccion) {
        this.clavesColeccion = clavesColeccion;
    }

    public int getContadorClaves() {
        return contadorClaves;
    }

    public void setContadorClaves(int contadorClaves) {
        this.contadorClaves = contadorClaves;
    }

    public String getClavePorIndice(int indice) {
        return this.clavesColeccion[indice].getCategoria();
    }

    public boolean isEsHoja() {
        return esHoja;
    }

    public boolean yaExisteLaCategotia(String categoria) {
        for (int i = 0; i < contadorClaves; i++) {
            if (clavesColeccion[i].getCategoria().equals(categoria)) {
                return true;
            }
        }
        return false;
    }

    public void setClavePorIndice(int indice, ClaveColeccion clave) {
        this.clavesColeccion[indice] = clave;
    }

    public ClaveColeccion getClaveColeccionPorIndice(int indice) {
        return this.clavesColeccion[indice];
    }

    public NodoBMas getHijoPorIndice(int indice) {
        return this.hijos[indice];
    }

    public void setHijoPorIndice(int indice, NodoBMas hijo) {
        this.hijos[indice] = hijo;
    }

    public boolean estaVacio() {
        return this.contadorClaves == 0;
    }

    public boolean debajoDelLimiteDeClaves() {
        return this.contadorClaves < MIN_CLAVES;
    }

    public boolean cuentaConClavesDisponibles() {
        return this.contadorClaves > MIN_CLAVES;
    }
}
