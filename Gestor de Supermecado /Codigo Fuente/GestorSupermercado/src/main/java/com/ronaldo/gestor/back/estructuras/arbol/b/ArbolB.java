package com.ronaldo.gestor.back.estructuras.arbol.b;

import com.ronaldo.gestor.back.estructuras.lista.normal.ListaEnlazada;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.producto.Producto;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ronaldo
 */
public class ArbolB {

    private static final int D = 2;

    private NodoB raiz;
    private AuxiliarB aux;

    public ArbolB() {
        this.aux = new AuxiliarB();
    }

    /**
     *
     * @param fInicial
     * @param fFinal
     * @return
     */
    public ListaEnlazada buscar(String fInicial, String fFinal) {
        ListaEnlazada lista = new ListaEnlazada();
        buscarRecursivo(raiz, fInicial, fFinal, lista);
        return lista;
    }

    /**
     *
     * @param nodo
     * @param fInicial
     * @param fFinal
     * @param lista
     */
    private void buscarRecursivo(NodoB nodo, String fInicial, String fFinal, ListaEnlazada lista) {
        if (nodo == null) {
            return;
        }

        for (int i = 0; i < nodo.getContador(); i++) {
            buscarRecursivo(nodo.getHijoPorIndice(i), fInicial, fFinal, lista);

            String fecha = nodo.getClavePorIndice(i).getFecha();

            if (fecha.compareTo(fInicial) >= 0 && fecha.compareTo(fFinal) <= 0) {
                lista.insertar(nodo.getClavePorIndice(i).getProducto());
            }
        }
        buscarRecursivo(nodo.getHijoPorIndice(nodo.getContador()), fInicial, fFinal, lista);
    }

    /**
     *
     * @param producto
     */
    public void insertar(Producto producto) {
        Clave clave = new Clave(producto);

        if (this.raiz == null) {
            this.raiz = new NodoB(true);
            this.raiz.insetarNuevaClave(clave);
            return;
        }

        ResultadoDivision resultado = insertarRecursivo(raiz, clave);

        if (resultado.isSeDividio()) {
            NodoB nuevaRaiz = new NodoB(false);

            nuevaRaiz.insetarNuevaClave(resultado.getClaveMediana());
            nuevaRaiz.setHijoPorIndice(0, raiz);
            nuevaRaiz.setHijoPorIndice(1, resultado.getHermanoDerecho());
            this.raiz = nuevaRaiz;
        }

    }

    /**
     *
     * @param nodo
     * @param clave
     * @return
     */
    private ResultadoDivision insertarRecursivo(NodoB nodo, Clave clave) {
        ResultadoDivision resultado = new ResultadoDivision();

        if (nodo == null) {
            return resultado;
        }

        if (nodo.isHoja()) {
            nodo.insetarNuevaClave(clave);
            aux.ordenarNodo(nodo.getTodasLasClaves(), nodo.getTodosLosHijos(), nodo.getContador());

            if (nodo.nodoSobrePasado()) {
                return dividirNodo(nodo);
            }

            return resultado;
        } else {
            NodoB hijo = localizarHijo(nodo, clave.getFecha());
            resultado = insertarRecursivo(hijo, clave);

            if (resultado.isSeDividio()) {
                // Encontrar posición correcta para la clave mediana
                int pos = 0;
                while (pos < nodo.getContador()
                        && resultado.getClaveMediana().getFecha()
                                .compareTo(nodo.getClavePorIndice(pos).getFecha()) > 0) {
                    pos++;
                }

                // Desplazar claves a la derecha
                for (int i = nodo.getContador(); i > pos; i--) {
                    nodo.setClavePorIndice(i, nodo.getClavePorIndice(i - 1));
                }

                // Desplazar hijos a la derecha
                for (int i = nodo.getContador() + 1; i > pos + 1; i--) {
                    nodo.setHijoPorIndice(i, nodo.getHijoPorIndice(i - 1));
                }

                // Insertar clave y hermano derecho en posición correcta
                nodo.setClavePorIndice(pos, resultado.getClaveMediana());
                nodo.setHijoPorIndice(pos + 1, resultado.getHermanoDerecho());
                nodo.setContador(nodo.getContador() + 1);

                if (nodo.nodoSobrePasado()) {
                    return dividirNodo(nodo);
                }

                resultado.setSeDividio(false);
                resultado.setClaveMediana(null);
                resultado.setHermanoDerecho(null);
            }
            return resultado;
        }
    }

    /**
     *
     * @param nodo
     * @param fecha
     * @return
     */
    private NodoB localizarHijo(NodoB nodo, String fecha) {
        int indice = 0;

        while (indice < nodo.getContador()
                && fecha.compareTo(nodo.getClavePorIndice(indice).getFecha()) >= 0) {
            indice++;
        }

        return nodo.getHijoPorIndice(indice);
    }

    /**
     *
     * @param nodo
     * @return
     */
    private ResultadoDivision dividirNodo(NodoB nodo) {

        ResultadoDivision resultado = new ResultadoDivision();

        int total = nodo.getContador();
        int indiceMedio = D;
        Clave claveMediana = nodo.getClavePorIndice(indiceMedio);

        NodoB hermanoDerecho = new NodoB(nodo.isHoja());

        int j = 0;
        for (int i = indiceMedio + 1; i < total; i++) {
            hermanoDerecho.insetarNuevaClave(nodo.getClavePorIndice(i));
            nodo.setClavePorIndice(i, null);
            j++;
        }
        hermanoDerecho.setContador(j);

        if (nodo.isInterno()) {
            int k = 0;
            for (int i = indiceMedio + 1; i <= total; i++) {
                hermanoDerecho.setHijoPorIndice(k, nodo.getHijoPorIndice(i));
                nodo.setHijoPorIndice(i, null);
                k++;
            }
        }

        nodo.setClavePorIndice(indiceMedio, null);
        nodo.setContador(indiceMedio);

        resultado.setClaveMediana(claveMediana);
        resultado.setHermanoDerecho(hermanoDerecho);
        resultado.setSeDividio(true);

        return resultado;
    }

    public void eliminar(Clave clave) throws ElementoNoEncontradoException {
        if (this.raiz == null) {
            System.out.println("El arbol esta vacio");
            return;
        }

        eliminarRecursivo(this.raiz, clave);

        if (this.raiz.getContador() == 0) {
            if (this.raiz.isHoja()) {
                this.raiz = null;
            } else {
                this.raiz = this.raiz.getHijoPorIndice(0);
            }
        }
    }

    private int encontrarClave(NodoB nodo, Clave clave) {
        int indice = 0;

        while (indice < nodo.getContador()
                && nodo.getClavePorIndice(indice).getFecha().compareTo(clave.getFecha()) < 0) {
            indice++;
        }

        while (indice < nodo.getContador()
                && nodo.getClavePorIndice(indice).getFecha().equals(clave.getFecha())
                && !nodo.getClavePorIndice(indice).getProducto().getCodigoBarra()
                        .equals(clave.getProducto().getCodigoBarra())) {
            indice++;
        }

        return indice;
    }

    private void eliminarRecursivo(NodoB nodo, Clave clave) throws ElementoNoEncontradoException {

        int indice = encontrarClave(nodo, clave);

        if (indice < nodo.getContador()
                && nodo.getClavePorIndice(indice).getProducto().getCodigoBarra()
                        .equals(clave.getProducto().getCodigoBarra())) {
            if (nodo.isHoja()) {
                eliminarEnHoja(nodo, indice);
            } else {
                eliminarDeInterno(nodo, indice);
            }
        } else {
            if (nodo.isHoja()) {
                throw new ElementoNoEncontradoException("El producto con codigo "
                        + clave.getProducto().getNombre() + " no existe en el arbol");
            }

            int indiceNavegar = 0;
            while (indiceNavegar < nodo.getContador()) {
                int cmpFecha = clave.getFecha().compareTo(
                        nodo.getClavePorIndice(indiceNavegar).getFecha());
                if (cmpFecha < 0) {
                    break;
                }
                if (cmpFecha == 0) {

                    int cmpCod = clave.getProducto().getCodigoBarra().compareTo(
                            nodo.getClavePorIndice(indiceNavegar).getProducto().getCodigoBarra());
                    if (cmpCod < 0) {
                        break;
                    }
                }
                indiceNavegar++;
            }

            if (nodo.getHijoPorIndice(indiceNavegar).getContador() < D) {
                rellenarNodo(nodo, indiceNavegar);

                indiceNavegar = 0;
                while (indiceNavegar < nodo.getContador()) {
                    int cmpFecha = clave.getFecha().compareTo(
                            nodo.getClavePorIndice(indiceNavegar).getFecha());
                    if (cmpFecha < 0) {
                        break;
                    }
                    if (cmpFecha == 0) {
                        int cmpCod = clave.getProducto().getCodigoBarra().compareTo(
                                nodo.getClavePorIndice(indiceNavegar).getProducto().getCodigoBarra());
                        if (cmpCod < 0) {
                            break;
                        }
                    }
                    indiceNavegar++;
                }
            }

            eliminarRecursivo(nodo.getHijoPorIndice(indiceNavegar), clave);
        }
    }

    private void eliminarEnHoja(NodoB nodo, int indice) {
        for (int i = indice + 1; i < nodo.getContador(); i++) {
            nodo.setClavePorIndice(i - 1, nodo.getClavePorIndice(i));
        }

        nodo.setClavePorIndice(nodo.getContador() - 1, null);
        nodo.setContador(nodo.getContador() - 1);
    }

    private void eliminarDeInterno(NodoB nodo, int indice) throws ElementoNoEncontradoException {
        Clave claveAEliminar = nodo.getClavePorIndice(indice);

        NodoB hijoIzquierdo = nodo.getHijoPorIndice(indice);
        NodoB hijoDerecho = nodo.getHijoPorIndice(indice + 1);

        if (hijoIzquierdo.getContador() >= D) {
            Clave predecesor = obtenerPredecesor(nodo, indice);
            nodo.setClavePorIndice(indice, predecesor);
            eliminarRecursivo(hijoIzquierdo, predecesor);
        } else if (hijoDerecho.getContador() >= D) {
            Clave sucesor = obtenerSucesor(nodo, indice);
            nodo.setClavePorIndice(indice, sucesor);
            eliminarRecursivo(hijoDerecho, sucesor);
        } else {
            fusionar(nodo, indice);
            eliminarRecursivo(hijoIzquierdo, claveAEliminar);
        }
    }

    private Clave obtenerPredecesor(NodoB nodo, int indice) {
        NodoB actual = nodo.getHijoPorIndice(indice);
        while (!actual.isHoja()) {
            actual = actual.getHijoPorIndice(actual.getContador());
        }
        return actual.getClavePorIndice(actual.getContador() - 1);
    }

    private Clave obtenerSucesor(NodoB nodo, int indice) {
        NodoB actual = nodo.getHijoPorIndice(indice + 1);
        while (!actual.isHoja()) {
            actual = actual.getHijoPorIndice(0);
        }
        return actual.getClavePorIndice(0);
    }

    private void rellenarNodo(NodoB nodo, int indice) {
        if (indice != 0 && nodo.getHijoPorIndice(indice - 1).getContador() >= D) {
            prestarAAnterior(nodo, indice);
        } else if (indice != nodo.getContador()
                && nodo.getHijoPorIndice(indice + 1).getContador() >= D) {
            prestarASiguiente(nodo, indice);
        } else {
            if (indice != nodo.getContador()) {
                fusionar(nodo, indice);
            } else {
                fusionar(nodo, indice - 1);
            }
        }
    }

    private void prestarAAnterior(NodoB padre, int indice) {
        NodoB hijo1 = padre.getHijoPorIndice(indice);
        NodoB hijo2 = padre.getHijoPorIndice(indice - 1);

        for (int i = hijo1.getContador() - 1; i >= 0; i--) {
            hijo1.setClavePorIndice(i + 1, hijo1.getClavePorIndice(i));
        }

        if (!hijo1.isHoja()) {
            for (int i = hijo1.getContador(); i >= 0; i--) {
                hijo1.setHijoPorIndice(i + 1, hijo1.getHijoPorIndice(i));
            }
        }

        hijo1.setClavePorIndice(0, padre.getClavePorIndice(indice - 1));

        if (!hijo1.isHoja()) {
            hijo1.setHijoPorIndice(0, hijo2.getHijoPorIndice(hijo2.getContador()));
        }

        padre.setClavePorIndice(indice - 1, hijo2.getClavePorIndice(hijo2.getContador() - 1));
        hijo2.setClavePorIndice(hijo2.getContador() - 1, null);

        hijo1.setContador(hijo1.getContador() + 1);
        hijo2.setContador(hijo2.getContador() - 1);
    }

    private void prestarASiguiente(NodoB padre, int indice) {
        NodoB hijo1 = padre.getHijoPorIndice(indice);
        NodoB hijo2 = padre.getHijoPorIndice(indice + 1);

        hijo1.setClavePorIndice(hijo1.getContador(), padre.getClavePorIndice(indice));

        if (!hijo1.isHoja()) {
            hijo1.setHijoPorIndice(hijo1.getContador() + 1, hijo2.getHijoPorIndice(0));
        }

        padre.setClavePorIndice(indice, hijo2.getClavePorIndice(0));

        for (int i = 1; i < hijo2.getContador(); i++) {
            hijo2.setClavePorIndice(i - 1, hijo2.getClavePorIndice(i));
        }

        if (!hijo2.isHoja()) {
            for (int i = 1; i <= hijo2.getContador(); i++) {
                hijo2.setHijoPorIndice(i - 1, hijo2.getHijoPorIndice(i));
            }
        }

        hijo2.setClavePorIndice(hijo2.getContador() - 1, null);

        hijo1.setContador(hijo1.getContador() + 1);
        hijo2.setContador(hijo2.getContador() - 1);
    }

    private void fusionar(NodoB padre, int indice) {
        NodoB hijo1 = padre.getHijoPorIndice(indice);
        NodoB hijo2 = padre.getHijoPorIndice(indice + 1);

        hijo1.setClavePorIndice(D - 1, padre.getClavePorIndice(indice));

        for (int i = 0; i < hijo2.getContador(); i++) {
            hijo1.setClavePorIndice(i + D, hijo2.getClavePorIndice(i));
        }

        if (!hijo1.isHoja()) {
            for (int i = 0; i <= hijo2.getContador(); i++) {
                hijo1.setHijoPorIndice(i + D, hijo2.getHijoPorIndice(i));
            }
        }

        for (int i = indice + 1; i < padre.getContador(); i++) {
            padre.setClavePorIndice(i - 1, padre.getClavePorIndice(i));
        }

        for (int i = indice + 2; i <= padre.getContador(); i++) {
            padre.setHijoPorIndice(i - 1, padre.getHijoPorIndice(i));
        }

        padre.setClavePorIndice(padre.getContador() - 1, null);
        padre.setHijoPorIndice(padre.getContador(), null);

        hijo1.setContador(hijo1.getContador() + hijo2.getContador() + 1);
        padre.setContador(padre.getContador() - 1);
    }

    public void generarDOT(String nombreArchivo) {
        try (FileWriter fw = new FileWriter(nombreArchivo); PrintWriter pw = new PrintWriter(fw)) {

            pw.println("digraph ArbolB {");
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

    private void escribirNodoDot(NodoB nodo, PrintWriter pw) {
        if (nodo == null) {
            return;
        }

        int idNodo = System.identityHashCode(nodo);
        int n = nodo.getContador();

        // Construcción del label tipo record
        StringBuilder label = new StringBuilder();

        for (int i = 0; i < n; i++) {
            label.append("<hijo").append(i).append("> ");
            label.append("| { ").append(nodo.getClavePorIndice(i).getFecha())
                    .append("\\n").append(nodo.getClavePorIndice(i).getProducto().getNombre())
                    .append(" } | ");
        }

        // último hijo
        label.append("<hijo").append(n).append(">");

        pw.println("  nodo" + idNodo + " [label=\"" + label.toString() + "\"];");

        // conexiones
        if (!nodo.isHoja()) {
            for (int i = 0; i <= n; i++) {
                NodoB hijo = nodo.getHijoPorIndice(i);

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
