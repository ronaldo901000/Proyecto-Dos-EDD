package com.ronaldo.gestor.back.estructuras.tablaHash;

import com.ronaldo.gestor.back.exceptions.ElementoExistenteException;
import com.ronaldo.gestor.back.producto.Producto;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ronaldo
 */
public class TablaHash {

    private static final double M = 0.8;
    private static final int N_PRODUCTOS = 1000;

    private Producto[] tabla;
    private boolean[] eliminados;
    private int cantidad;
    private boolean hayDuplicados;

    public TablaHash() {
        int tamaño = siguientePrimo((int) (N_PRODUCTOS / M));
        tabla = new Producto[tamaño];
        eliminados = new boolean[tamaño];
        cantidad = 0;
    }

    /**
     *
     * @param producto
     * @throws ElementoExistenteException
     */
    public void insertar(Producto producto, boolean esCSV) throws ElementoExistenteException {
        hayDuplicados = false;
        if ((double) cantidad / tabla.length >= M) {
            rehashear();
        }

        int posicion = generaPosicionInsercion(producto.getCodigoBarra());

        if (tabla[posicion] != null && !eliminados[posicion]
                && tabla[posicion].getCodigoBarra().equals(producto.getCodigoBarra())) {

            if (esCSV) {
                try (PrintWriter log = new PrintWriter(new FileWriter("errors.log", true))) {

                    hayDuplicados = true;
                    log.println(
                            "El Codigo de Barra: "
                            + producto.getCodigoBarra()
                            + " ya ha sido registrado antes."
                    );

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                throw new ElementoExistenteException(
                        "El producto con codigo " + producto.getCodigoBarra() + " ya existe.");

            }
        }

        tabla[posicion] = producto;
        eliminados[posicion] = false;
        cantidad++;
    }

    /**
     *
     * @param codigoBarra
     * @return
     */
    public Producto buscar(String codigoBarra) {
        int posicion = generarPosicionBusqueda(codigoBarra);
        if (posicion == -1) {
            return null;
        }
        return tabla[posicion];
    }

    /**
     *
     * @param codigoBarra
     * @return
     */
    public boolean eliminar(String codigoBarra) {
        int pos = generarPosicionBusqueda(codigoBarra);
        if (pos == -1) {
            return false;
        }
        eliminados[pos] = true;
        cantidad--;
        return true;
    }

    public boolean actualizar(Producto productoActualizado) {
        int pos = generarPosicionBusqueda(productoActualizado.getCodigoBarra());
        if (pos == -1) {
            return false;
        }
        tabla[pos] = productoActualizado;
        return true;
    }

    private void rehashear() {
        Producto[] tablaVieja = tabla;
        boolean[] eliminadoViejo = eliminados;

        int nuevoTamaño = siguientePrimo(tabla.length * 2);
        tabla = new Producto[nuevoTamaño];
        eliminados = new boolean[nuevoTamaño];
        cantidad = 0;

        for (int i = 0; i < tablaVieja.length; i++) {
            if (tablaVieja[i] != null && !eliminadoViejo[i]) {
                try {
                    insertar(tablaVieja[i], false);
                } catch (ElementoExistenteException e) {

                }
            }
        }
    }

    private int siguientePrimo(int n) {
        if (n <= 2) {
            return 2;
        }
        if (n % 2 == 0) {
            n++;
        }

        while (!esPrimo(n)) {
            n += 2;
        }
        return n;
    }

    private boolean esPrimo(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int generaPosicionInsercion(String codigoBarra) {
        int i = 0;
        int tamaño = tabla.length;
        long d = transformarCadena(codigoBarra);
        long p = d % tamaño;

        while (tabla[(int) p] != null
                && !eliminados[(int) p]
                && !tabla[(int) p].getCodigoBarra().equals(codigoBarra)) {
            i++;
            p = (p + (long) i * i) % tamaño;
        }
        return (int) p;
    }

    /**
     *
     * @param codigoBarra
     * @return
     */
    private int generarPosicionBusqueda(String codigoBarra) {
        int i = 0;
        int tamaño = tabla.length;
        long d = transformarCadena(codigoBarra);
        long p = d % tamaño;

        while (i < tamaño) {
            if (tabla[(int) p] == null && !eliminados[(int) p]) {
                break;
            }
            if (tabla[(int) p] != null
                    && !eliminados[(int) p]
                    && tabla[(int) p].getCodigoBarra().equals(codigoBarra)) {
                return (int) p;
            }
            i++;
            p = (p + (long) i * i) % tamaño;
        }
        return -1;
    }

    private long transformarCadena(String codigoBarra) {
        long d = 0;
        for (int j = 0; j < codigoBarra.length(); j++) {
            d = d * 31 + codigoBarra.charAt(j);
        }
        if (d < 0) {
            d = -d;
        }
        return d;
    }

    public double factorCarga() {
        return (double) cantidad / tabla.length;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getTamaño() {
        return tabla.length;
    }

    public Producto[] getTabla() {
        return tabla;
    }

    public boolean isHayDuplicados() {
        return hayDuplicados;
    }
    
    
}
