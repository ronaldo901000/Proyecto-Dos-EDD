package com.ronaldo.gestor.back.estructuras.arbol.avl;

import com.ronaldo.gestor.back.estructuras.lista.normal.ListaEnlazada;
import com.ronaldo.gestor.back.exceptions.ElementoExistenteException;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.producto.Producto;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ronaldo
 */
public class ArbolAVL {

    private NodoAVL raiz;

    /**
     *
     * @param producto
     */
    public void insertar(Producto producto) {
        this.raiz = insertarRecursivo(raiz, producto);
    }

    /**
     *
     * @param nodo
     * @param producto
     * @return
     * @throws ElementoExistenteException
     */
    private NodoAVL insertarRecursivo(NodoAVL nodo, Producto producto) {
        if (nodo == null) {
            return new NodoAVL(producto);
        }

        if (producto.getNombre().compareTo(nodo.getElemento().getNombre()) < 0) {
            NodoAVL izquierdo = insertarRecursivo(nodo.getIzquierdo(), producto);
            nodo.setIzquierdo(izquierdo);
        } else if (producto.getNombre().compareTo(nodo.getElemento().getNombre()) >= 0) {
            NodoAVL derecho = insertarRecursivo(nodo.getDerecho(), producto);
            nodo.setDerecho(derecho);
        }

        return verificarEquilibrio(nodo);
    }

    /**
     *
     * @param nodo
     * @return
     */
    private NodoAVL verificarEquilibrio(NodoAVL nodo) {
        if (nodo == null) {
            return null;
        }

        nodo.actualizarAltura();
        int FE = nodo.getFactorEquilibrio();

        if (FE < -1) {
            if (nodo.getIzquierdo() != null && nodo.getIzquierdo().getFactorEquilibrio() <= 0) {
                return equilibrarII(nodo);
            }
            if (nodo.getIzquierdo() != null && nodo.getIzquierdo().getFactorEquilibrio() > 0) {
                return equilibrarID(nodo);
            }
        }

        if (FE > 1) {
            if (nodo.getDerecho() != null && nodo.getDerecho().getFactorEquilibrio() >= 0) {
                return equilibrarDD(nodo);
            }
            if (nodo.getDerecho() != null && nodo.getDerecho().getFactorEquilibrio() < 0) {
                return equilibrarDI(nodo);
            }
        }

        return nodo;
    }

    /**
     *
     * @param nodo
     * @return
     */
    private NodoAVL equilibrarII(NodoAVL nodo) {
        NodoAVL nodo1 = nodo.getIzquierdo();

        nodo.setIzquierdo(nodo1.getDerecho());
        nodo1.setDerecho(nodo);

        nodo.actualizarAltura();
        nodo1.actualizarAltura();

        return nodo1;
    }

    /**
     *
     * @param nodo
     * @return
     */
    private NodoAVL equilibrarDD(NodoAVL nodo) {

        NodoAVL nodo1 = nodo.getDerecho();

        nodo.setDerecho(nodo1.getIzquierdo());
        nodo1.setIzquierdo(nodo);

        nodo.actualizarAltura();
        nodo1.actualizarAltura();

        return nodo1;
    }

    /**
     *
     * @param nodo
     * @return
     */
    private NodoAVL equilibrarID(NodoAVL nodo) {

        NodoAVL nodo1 = nodo.getIzquierdo();
        NodoAVL nodo2 = nodo1.getDerecho();

        nodo1.setDerecho(nodo2.getIzquierdo());
        nodo.setIzquierdo(nodo2.getDerecho());

        nodo2.setIzquierdo(nodo1);
        nodo2.setDerecho(nodo);

        nodo.actualizarAltura();
        nodo1.actualizarAltura();
        nodo2.actualizarAltura();

        return nodo2;
    }

    /**
     *
     * @param nodo
     * @return
     */
    private NodoAVL equilibrarDI(NodoAVL nodo) {

        NodoAVL nodo1 = nodo.getDerecho();
        NodoAVL nodo2 = nodo1.getIzquierdo();

        nodo1.setIzquierdo(nodo2.getDerecho());
        nodo.setDerecho(nodo2.getIzquierdo());

        nodo2.setDerecho(nodo1);
        nodo2.setIzquierdo(nodo);

        nodo.actualizarAltura();
        nodo1.actualizarAltura();
        nodo2.actualizarAltura();

        return nodo2;
    }

    /**
     *
     * @param nombre
     * @return
     * @throws ElementoNoEncontradoException
     */
    public Producto buscar(String nombre) {
        NodoAVL nodo = buscarRecursivo(raiz, nombre);

        if (nodo == null) {
            return null;
        }
        return nodo.getElemento();
    }

    /**
     *
     * @param nodo
     * @param nombre
     * @return
     */
    private NodoAVL buscarRecursivo(NodoAVL nodo, String nombre) {
        if (nodo == null) {
            return null;
        }

        if (nombre.compareTo(nodo.getElemento().getNombre()) < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), nombre);
        }

        if (nombre.compareTo(nodo.getElemento().getNombre()) > 0) {
            return buscarRecursivo(nodo.getDerecho(), nombre);
        }

        return nodo;
    }

    /**
     *
     * @param nombre
     * @throws ElementoNoEncontradoException
     */
    public void eliminar(String nombre, String codigoBarra) throws ElementoNoEncontradoException {
        this.raiz = eliminarRecursivo(raiz, nombre, codigoBarra);
    }

    /**
     *
     * @param nodo
     * @param nombre
     * @return
     * @throws ElementoNoEncontradoException
     */
    public NodoAVL eliminarRecursivo(NodoAVL nodo, String nombre, String codigoBarra)
            throws ElementoNoEncontradoException {

        if (nodo == null) {
            throw new ElementoNoEncontradoException(
                    "No existe el producto con nombre " + nombre
                    + " y codigo de barras " + codigoBarra);
        }

        int cmp = nombre.compareTo(nodo.getElemento().getNombre());

        if (cmp < 0) {
            nodo.setIzquierdo(eliminarRecursivo(nodo.getIzquierdo(), nombre, codigoBarra));

        } else if (cmp > 0) {
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), nombre, codigoBarra));

        } else {
            if (!nodo.getElemento().getCodigoBarra().equals(codigoBarra)) {
                nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), nombre, codigoBarra));

            } else {
                if (nodo.getIzquierdo() == null || nodo.getDerecho() == null) {
                    NodoAVL ref;

                    if (nodo.getIzquierdo() != null) {
                        ref = nodo.getIzquierdo();
                    } else {
                        ref = nodo.getDerecho();
                    }

                    if (ref == null) {
                        nodo = null;
                    } else {
                        nodo = ref;
                    }
                } else {
                    NodoAVL ref = obtenerNodoMenor(nodo.getDerecho());
                    nodo.setElemento(ref.getElemento());
                    nodo.setDerecho(eliminarRecursivo(
                            nodo.getDerecho(),
                            ref.getElemento().getNombre(),
                            ref.getElemento().getCodigoBarra()
                    ));
                }
            }
        }

        if (nodo == null) {
            return null;
        }
        return verificarEquilibrio(nodo);
    }

    /**
     *
     * @param nodo
     * @return
     */
    private NodoAVL obtenerNodoMenor(NodoAVL nodo) {
        NodoAVL ref = nodo;

        while (ref.getIzquierdo() != null) {
            ref = ref.getIzquierdo();
        }
        return ref;
    }

    /**
     *
     * @return
     */
    public ListaEnlazada listar() {
        ListaEnlazada lista = new ListaEnlazada();

        listarInOrden(raiz, lista);

        return lista;
    }

    /**
     *
     * @param nodo
     * @param lista
     */
    private void listarInOrden(NodoAVL nodo, ListaEnlazada lista) {
        if (nodo != null) {
            listarInOrden(nodo.getIzquierdo(), lista);
            lista.insertar(nodo.getElemento());
            listarInOrden(nodo.getDerecho(), lista);
        }
    }

    public void generarImagen(String nombreArchivo) {
        String rutaDot = nombreArchivo.replace(".pdf", ".dot");

        try (FileWriter fw = new FileWriter(rutaDot); PrintWriter pw = new PrintWriter(fw)) {
            pw.println("digraph ArbolAVL {");
            pw.println("  graph [ranksep=0.5, nodesep=0.3];");
            pw.println("  node [shape=circle, style=filled, fillcolor=lightblue, fixedsize=false, fontsize=10, width=0.5, height=0.5];");
            if (this.raiz != null) {
                escribirNodoDot(this.raiz, pw);
            }
            pw.println("}");
        } catch (IOException e) {
            System.err.println("Error al generar .dot: " + e.getMessage());
            return;
        }

        try {
            ProcessBuilder pb = new ProcessBuilder("dot", "-Tpdf", rutaDot, "-o", nombreArchivo);
            pb.redirectErrorStream(true);
            Process proceso = pb.start();
            proceso.waitFor();
            System.out.println("PDF generado: " + nombreArchivo);

            // Abrir automáticamente
            java.awt.Desktop.getDesktop().open(new java.io.File(nombreArchivo));

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void escribirNodoDot(NodoAVL nodo, PrintWriter pw) {
        if (nodo == null) {
            return;
        }

        int idNodo = System.identityHashCode(nodo);

        pw.println("  nodo" + idNodo + " [label=\""
                + nodo.getElemento().getNombre() + " (FE:" + nodo.getFactorEquilibrio() + ")\"];");

        if (nodo.getIzquierdo() != null) {
            int idIzq = System.identityHashCode(nodo.getIzquierdo());
            pw.println("  nodo" + idNodo + " -> nodo" + idIzq + " [label=\"I\"];");
            escribirNodoDot(nodo.getIzquierdo(), pw);
        }

        if (nodo.getDerecho() != null) {
            int idDer = System.identityHashCode(nodo.getDerecho());
            pw.println("  nodo" + idNodo + " -> nodo" + idDer + " [label=\"D\"];");
            escribirNodoDot(nodo.getDerecho(), pw);
        }
    }

}
