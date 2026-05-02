package com.ronaldo.gestor.analisisRendimiento;

import com.ronaldo.gestor.back.estructuras.lista.Lista;
import com.ronaldo.gestor.back.estructuras.lista.generica.ListaEnlazadaGenerica;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.producto.Producto;
import com.ronaldo.gestor.back.sucursal.Sucursal;
import java.util.Random;

/**
 *
 * @author ronaldo
 */
public class AnalizadorRendimiento {

    private Sucursal sucursal;
    private int nConsultas;
    private int nRepeticiones;
    private static final String AVL = "Arbol AVL";
    private static final String LISTA_ENLAZADA_DESOR = "Lista Enlazada no Ordenada";
    private static final String LISTA_ENLAZADA_ORDE = "Lista Enlazada Ordenada";
    private static final String TABLA_HASH = "Tabla Hash";

    public AnalizadorRendimiento(Sucursal sucursal, int nConsultas, int nRepeticiones) {
        this.sucursal = sucursal;
        this.nConsultas = nConsultas;
        this.nRepeticiones = nRepeticiones;
    }

    public ListaEnlazadaGenerica<ResultadoRendimiento> buscarAleatorio() throws ElementoNoEncontradoException {

        Random rand = new Random();
        int indice = rand.nextInt(sucursal.getListaDesordenada().getTamaño());

        Producto p = sucursal.getListaDesordenada().obtener(indice);

        return empaquetar(p);
    }

    public ListaEnlazadaGenerica<ResultadoRendimiento> buscarExtremo(int indiceExtremo) throws ElementoNoEncontradoException {
        Producto p = sucursal.getListaDesordenada().obtener(indiceExtremo);

        return empaquetar(p);
    }

    /**
     *
     * @param p
     * @return
     * @throws ElementoNoEncontradoException
     */
    private ListaEnlazadaGenerica<ResultadoRendimiento> empaquetar(Producto p) throws ElementoNoEncontradoException {
        ListaEnlazadaGenerica<ResultadoRendimiento> lista = new ListaEnlazadaGenerica<>();
        ResultadoRendimiento r1 = new ResultadoRendimiento(AVL, obtenerPromedioAVL(p), p);

        ResultadoRendimiento r2 = new ResultadoRendimiento(
                LISTA_ENLAZADA_DESOR,
                obtenerPromedioLista(
                        p,
                        sucursal.getListaDesordenada()
                ),
                p
        );

        ResultadoRendimiento r3 = new ResultadoRendimiento(
                LISTA_ENLAZADA_ORDE,
                obtenerPromedioLista(
                        p,
                        sucursal.getListaOrdenada()
                ),
                p
        );
        ResultadoRendimiento r4 = new ResultadoRendimiento(TABLA_HASH, obtenerPromedioHash(p), p);

        lista.agregarElemento(r1);
        lista.agregarElemento(r2);
        lista.agregarElemento(r3);
        lista.agregarElemento(r4);

        return lista;
    }

    /**
     *
     * @param p
     * @return
     */
    private double obtenerPromedioAVL(Producto p) {
        long totalNano = 0;
        int totalOperaciones = nConsultas * nRepeticiones;

        for (int i = 0; i < nConsultas; i++) {
            for (int j = 0; j < nRepeticiones; j++) {

                long inicio = System.nanoTime();

                sucursal.getAvl().buscar(p.getNombre());

                long fin = System.nanoTime();

                totalNano += (fin - inicio);
            }
        }

        double promedioNano = (double) totalNano / totalOperaciones;
        return promedioNano / 1000.0;
    }

    /**
     *
     * @param producto
     * @param lista
     * @return
     * @throws ElementoNoEncontradoException
     */
    private double obtenerPromedioLista(Producto producto, Lista lista) throws ElementoNoEncontradoException {
        long totalNano = 0;
        int totalOperaciones = nConsultas * nRepeticiones;

        for (int i = 0; i < nConsultas; i++) {
            for (int j = 0; j < nRepeticiones; j++) {

                long inicio = System.nanoTime();

                for (int k = 0; k < lista.getTamaño(); k++) {
                    Producto p = lista.obtener(k); 
                    if (p.getCodigoBarra().equals(producto.getCodigoBarra())) {
                        break;
                    }
                }

                long fin = System.nanoTime();

                totalNano += (fin - inicio);
            }
        }

        double promedioNano = (double) totalNano / totalOperaciones;
        return promedioNano / 1000.0;
    }

    /**
     *
     * @param p
     * @return
     */
    private double obtenerPromedioHash(Producto p) {
        long totalNano = 0;
        int totalOperaciones = nConsultas * nRepeticiones;

        for (int i = 0; i < nConsultas; i++) {
            for (int j = 0; j < nRepeticiones; j++) {

                long inicio = System.nanoTime();

                sucursal.getTablaHash().buscar(p.getNombre());

                long fin = System.nanoTime();

                totalNano += (fin - inicio);
            }
        }

        double promedioNano = (double) totalNano / totalOperaciones;
        return promedioNano / 1000.0;
    }

}
