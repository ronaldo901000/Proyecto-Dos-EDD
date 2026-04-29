package com.ronaldo.gestor.back.estructuras.arbol.bmas;

import com.ronaldo.gestor.back.estructuras.lista.ordenada.ListaEnlazadaOrdenada;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.exceptions.EstructuraVaciaException;
import com.ronaldo.gestor.back.producto.Producto;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ronaldo
 */
public class ArbolBMas {

    private NodoBMas raiz;
    private ReestructuradorBMas reestructurador;
    private static final int D = 2;

    public ArbolBMas() {
        this.reestructurador = new ReestructuradorBMas();
    }

    public void insertar(Producto producto) throws ElementoNoEncontradoException {

        if (this.raiz == null) {
            this.raiz = new NodoBMas(true);
            this.raiz.insertarClaveYProducto(0, producto.getCategoria(), producto);
            return;
        }

        ResultadoDivision res = insertarRecursivo(this.raiz, producto);

        if (res.isSeDividio()) {

            NodoBMas nuevaRaiz = new NodoBMas(false);

            nuevaRaiz.insertarClaveEnNodoInterno(
                    0,
                    res.getClaveMediana().getCategoria(),
                    res.getHermanoDerecho()
            );

            nuevaRaiz.setHijoPorIndice(0, this.raiz);
            nuevaRaiz.setHijoPorIndice(1, res.getHermanoDerecho());

            this.raiz = nuevaRaiz;
        }
    }

    private ResultadoDivision insertarRecursivo(NodoBMas nodo, Producto producto)
            throws ElementoNoEncontradoException {

        ResultadoDivision res = new ResultadoDivision();

        if (nodo.isEsHoja()) {

            int posicion = localizarPosicionDeClave(nodo, producto.getCategoria());

            if (nodo.yaExisteLaCategotia(producto.getCategoria())) {
                nodo.agregarProductoAColeccion(producto);
            } else {
                nodo.insertarClaveYProducto(posicion, producto.getCategoria(), producto);
            }

            if (nodo.nodoSobreCargado()) {
                return dividirNodo(nodo);
            }

            return res;

        } else {

            NodoBMas hijo = localizarHijo(nodo, producto.getCategoria());

            res = insertarRecursivo(hijo, producto);

            if (res.isSeDividio()) {

                int pos = localizarPosicionDeClave(
                        nodo,
                        res.getClaveMediana().getCategoria()
                );

                nodo.insertarClaveEnNodoInterno(
                        pos,
                        res.getClaveMediana().getCategoria(),
                        res.getHermanoDerecho()
                );

                if (nodo.nodoSobreCargado()) {
                    return dividirNodo(nodo);
                }

                res.setSeDividio(false);
            }

            return res;
        }
    }

    private ResultadoDivision dividirNodo(NodoBMas nodo) throws ElementoNoEncontradoException {

        ResultadoDivision res = new ResultadoDivision();
        int total = nodo.getContadorClaves();
        int medio = D;

        NodoBMas hermanoDerecho = new NodoBMas(nodo.isEsHoja());

        if (nodo.isEsHoja()) {

            int j = 0;

            for (int i = medio; i < total; i++) {

                ClaveColeccion original = nodo.getClaveColeccionPorIndice(i);

                ClaveColeccion nueva = new ClaveColeccion();
                nueva.setCategoria(original.getCategoria());

                if (original.getColeccion() != null) {

                    ListaEnlazadaOrdenada nuevaLista = new ListaEnlazadaOrdenada();

                    for (int k = 0; k < original.getColeccion().getTamaño(); k++) {
                        nuevaLista.insertar(original.getColeccion().obtener(k));
                    }

                    nueva.setColeccion(nuevaLista);
                }

                hermanoDerecho.setClavePorIndice(j, nueva);
                j++;
            }

            hermanoDerecho.setContadorClaves(j);

            for (int i = medio; i < total; i++) {
                nodo.setClavePorIndice(i, null);
            }

            nodo.setContadorClaves(medio);

            ClaveColeccion claveSubir = new ClaveColeccion();
            claveSubir.setCategoria(
                    hermanoDerecho.getClaveColeccionPorIndice(0).getCategoria()
            );

            res.setClaveMediana(claveSubir);

        } else {

            ClaveColeccion claveMediana = nodo.getClaveColeccionPorIndice(medio);

            int j = 0;

            for (int i = medio + 1; i < total; i++) {

                ClaveColeccion original = nodo.getClaveColeccionPorIndice(i);

                ClaveColeccion nueva = new ClaveColeccion();
                nueva.setCategoria(original.getCategoria());

                hermanoDerecho.setClavePorIndice(j, nueva);

                nodo.setClavePorIndice(i, null);
                j++;
            }

            hermanoDerecho.setContadorClaves(j);

            int k = 0;

            for (int i = medio + 1; i <= total; i++) {
                hermanoDerecho.setHijoPorIndice(k, nodo.getHijoPorIndice(i));
                nodo.setHijoPorIndice(i, null);
                k++;
            }

            nodo.setClavePorIndice(medio, null);
            nodo.setContadorClaves(medio);

            res.setClaveMediana(claveMediana);
        }

        res.setHermanoDerecho(hermanoDerecho);
        res.setSeDividio(true);

        return res;
    }

    private int localizarPosicionParaNavegar(NodoBMas nodo, String categoria) {
        int contador = 0;
        while (contador < nodo.getContadorClaves() && categoria.compareTo(nodo.getClavePorIndice(contador)) >= 0) {
            contador++;
        }
        return contador;
    }

    private int localizarPosicionDeClave(NodoBMas nodo, String categoria) {
        int contador = 0;
        while (contador < nodo.getContadorClaves() && categoria.compareTo(nodo.getClavePorIndice(contador)) > 0) {
            contador++;
        }
        return contador;
    }

    private NodoBMas localizarHijo(NodoBMas nodo, String categoria) {
        int indice = localizarPosicionParaNavegar(nodo, categoria);
        return nodo.getHijoPorIndice(indice);
    }

    /**
     *
     * @param categoria
     * @return
     * @throws ElementoNoEncontradoException
     */
    public ListaEnlazadaOrdenada buscar(String categoria) throws ElementoNoEncontradoException {
        NodoBMas nodo = this.raiz;

        if (nodo == null) {
            throw new ElementoNoEncontradoException("Arbol B+ vacio, no hay nada para buscar");
        }

        while (!nodo.isEsHoja()) {
            int i = 0;
            while (i < nodo.getContadorClaves() && categoria.compareTo(nodo.getClaveColeccionPorIndice(i).getCategoria()) >= 0) {
                i++;
            }
            nodo = nodo.getHijoPorIndice(i);
        }

        for (int i = 0; i < nodo.getContadorClaves(); i++) {

            if (nodo.getClaveColeccionPorIndice(i).getCategoria().equals(categoria)) {
                return nodo.getClaveColeccionPorIndice(i).getColeccion();
            }

        }
        return new ListaEnlazadaOrdenada();
    }

    public void eliminar(String codigoBarra, String categoria)
            throws EstructuraVaciaException, ElementoNoEncontradoException {

        if (this.raiz == null) {
            throw new EstructuraVaciaException("Arbol b+ vacio, nada para eliminar");
        }

        if (this.raiz.isEsHoja()) {
            int indice = localizarPosicionDeClave(raiz, categoria);

            if (indice >= this.raiz.getContadorClaves()
                    || !this.raiz.getClavePorIndice(indice).equals(categoria)) {
                throw new ElementoNoEncontradoException(
                        "No existe producto con categoria " + categoria);
            }

            this.raiz.eliminarProductoDeColeccion(indice, codigoBarra);

            ListaEnlazadaOrdenada coleccion = this.raiz
                    .getClaveColeccionPorIndice(indice)
                    .getColeccion();

            if (coleccion != null && coleccion.estaVacia()) {
                this.raiz.eliminarClaveConSuColeccion(indice);
            }

            if (this.raiz.estaVacio()) {
                this.raiz = null;
            }

        } else {
            eliminarRecursivo(this.raiz, codigoBarra, categoria);
        }
    }

    private void eliminarRecursivo(NodoBMas nodo, String codigoBarra, String categoria)
            throws ElementoNoEncontradoException {

        int indiceHijo = localizarPosicionParaNavegar(nodo, categoria);
        NodoBMas hijo = localizarHijo(nodo, categoria);

        if (hijo.isEsHoja()) {
            int indiceClave = localizarPosicionDeClave(hijo, categoria);

            if (indiceClave >= hijo.getContadorClaves()
                    || !hijo.getClavePorIndice(indiceClave).equals(categoria)) {
                throw new ElementoNoEncontradoException(
                        "No existe producto con categoria " + categoria);
            }

            hijo.eliminarProductoDeColeccion(indiceClave, codigoBarra);

            ListaEnlazadaOrdenada coleccion = hijo
                    .getClaveColeccionPorIndice(indiceClave)
                    .getColeccion();

            if (coleccion != null && coleccion.estaVacia()) {
                hijo.eliminarClaveConSuColeccion(indiceClave);
            }

        } else {
            eliminarRecursivo(hijo, codigoBarra, categoria);
        }

        if (hijo.debajoDelLimiteDeClaves()) {

            if (indiceHijo < nodo.getContadorClaves()
                    && nodo.getHijoPorIndice(indiceHijo + 1) != null
                    && nodo.getHijoPorIndice(indiceHijo + 1).cuentaConClavesDisponibles()) {

                NodoBMas hermanoDerecho = nodo.getHijoPorIndice(indiceHijo + 1);
                reestructurador.prestarDelDerecho(nodo, hijo, hermanoDerecho, indiceHijo);

            } else if (indiceHijo > 0
                    && nodo.getHijoPorIndice(indiceHijo - 1) != null
                    && nodo.getHijoPorIndice(indiceHijo - 1).cuentaConClavesDisponibles()) {

                NodoBMas hermanoIzquierdo = nodo.getHijoPorIndice(indiceHijo - 1);
                reestructurador.prestarDelIzquierdo(nodo, hijo, hermanoIzquierdo, indiceHijo - 1);

            } else {
                if (indiceHijo < nodo.getContadorClaves()) {
                    NodoBMas hermanoDerecho = nodo.getHijoPorIndice(indiceHijo + 1);
                    if (hermanoDerecho != null) {
                        reestructurador.fusionar(nodo, hijo, hermanoDerecho, indiceHijo);
                    }
                } else if (indiceHijo > 0) {
                    NodoBMas hermanoIzquierdo = nodo.getHijoPorIndice(indiceHijo - 1);
                    if (hermanoIzquierdo != null) {
                        reestructurador.fusionar(nodo, hermanoIzquierdo, hijo, indiceHijo - 1);
                    }
                }
            }
        }

        if (nodo == this.raiz && !this.raiz.isEsHoja() && this.raiz.getContadorClaves() == 0) {
            this.raiz = this.raiz.getHijoPorIndice(0);
        }
    }

    public void generarDOT(String nombreArchivo) throws ElementoNoEncontradoException {
        try (FileWriter fw = new FileWriter(nombreArchivo); PrintWriter pw = new PrintWriter(fw)) {

            pw.println("digraph ArbolBMas {");
            pw.println("  node [shape=record, height=.1];");

            if (this.raiz != null) {
                escribirNodoDot(this.raiz, pw);
            }

            pw.println("}");
            System.out.println("Archivo " + nombreArchivo + " generado exitosamente.");

        } catch (IOException e) {
            System.err.println("Error al abrir el archivo para DOT: " + e.getMessage());
        }
    }

    private void escribirNodoDot(NodoBMas nodo, PrintWriter pw) throws ElementoNoEncontradoException {
        if (nodo == null) {
            return;
        }

        int idNodo = System.identityHashCode(nodo);
        int n = nodo.getContadorClaves();

        StringBuilder label = new StringBuilder();

        for (int i = 0; i < n; i++) {
            ClaveColeccion claveNodo = nodo.getClaveColeccionPorIndice(i);

            label.append("<hijo").append(i).append("> | ");
            label.append("{ ").append(claveNodo.getCategoria());

            if (claveNodo.getColeccion() != null && claveNodo.getColeccion().getTamaño() > 0) {

                label.append(" | ");

                for (int j = 0; j < claveNodo.getColeccion().getTamaño(); j++) {
                    Producto p = claveNodo.getColeccion().obtener(j);

                    if (p != null) {
                        label.append(p.getNombre());
                    } else {
                        label.append("NULL");
                    }

                    if (j < claveNodo.getColeccion().getTamaño() - 1) {
                        label.append("\\n");
                    }
                }
            }

            label.append(" } | ");
        }

        label.append("<hijo").append(n).append(">");

        pw.println("  nodo" + idNodo + " [label=\"" + label.toString() + "\"];");

        if (!nodo.isEsHoja()) {
            for (int i = 0; i <= n; i++) {
                NodoBMas hijo = nodo.getHijoPorIndice(i);

                if (hijo != null) {
                    int idHijo = System.identityHashCode(hijo);

                    pw.println("  nodo" + idNodo + ":hijo" + i
                            + " -> nodo" + idHijo + ";");

                    escribirNodoDot(hijo, pw);
                }
            }
        }
    }
}
