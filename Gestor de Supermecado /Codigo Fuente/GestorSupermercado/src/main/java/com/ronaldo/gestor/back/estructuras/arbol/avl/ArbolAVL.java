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
        } else if (producto.getNombre().compareTo(nodo.getElemento().getNombre()) >= 0 ) {
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
    public void eliminar(String nombre) throws ElementoNoEncontradoException {
        this.raiz = eliminarRecursivo(raiz, nombre);
    }

    /**
     *
     * @param nodo
     * @param nombre
     * @return
     * @throws ElementoNoEncontradoException
     */
    public NodoAVL eliminarRecursivo(NodoAVL nodo, String nombre) throws ElementoNoEncontradoException {
        if (nodo == null) {
            throw new ElementoNoEncontradoException("No existe el producto con nombre " + nombre + " , se cancela eliminacion");
        }

        if (nombre.compareTo(nodo.getElemento().getNombre()) < 0) {
            NodoAVL izquierdo = eliminarRecursivo(nodo.getIzquierdo(), nombre);
            nodo.setIzquierdo(izquierdo);
        } else if (nombre.compareTo(nodo.getElemento().getNombre()) > 0) {
            NodoAVL derecho = eliminarRecursivo(nodo.getDerecho(), nombre);
            nodo.setDerecho(derecho);
        } else {
            if (nodo.getIzquierdo() == null || nodo.getDerecho() == null) {
                NodoAVL ref = nodo.getIzquierdo() != null ? nodo.getIzquierdo() : nodo.getDerecho();

                if (ref == null) {
                    nodo = null;
                } else {
                    nodo = ref;
                }
            } else {
                NodoAVL ref = obtenerNodoMenor(nodo);

                Producto producto = ref.getElemento();
                nodo.setElemento(producto);

                NodoAVL derecho = eliminarRecursivo(nodo.getDerecho(), ref.getElemento().getNombre());
                nodo.setDerecho(derecho);
            }
        }

        if (nodo == null) {
            return nodo;
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

    public void generarDOT(String nombreArchivo) {
        try (FileWriter fw = new FileWriter(nombreArchivo); PrintWriter pw = new PrintWriter(fw)) {

            pw.println("digraph ArbolAVL {");
            pw.println("  node [shape=circle, height=.1];");

            if (this.raiz != null) {
                escribirNodoDot(this.raiz, pw);
            }

            pw.println("}");
            System.out.println("Archivo " + nombreArchivo + " generado exitosamente.");

        } catch (IOException e) {
            System.err.println("Error al abrir el archivo para DOT: " + e.getMessage());
        }
    }

    private void escribirNodoDot(NodoAVL nodo, PrintWriter pw) {
        if (nodo == null) {
            return;
        }

        // Usamos identityHashCode para replicar el comportamiento de la dirección de memoria de C++
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
