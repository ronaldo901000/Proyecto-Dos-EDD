package com.ronaldo.gestor.back.lectura;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ronaldo.gestor.back.estructuras.lista.generica.ListaEnlazadaGenerica;
import com.ronaldo.gestor.back.estructuras.lista.normal.ListaEnlazada;
import com.ronaldo.gestor.back.exceptions.DatoInvalidoException;
import com.ronaldo.gestor.back.exceptions.ElementoExistenteException;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.exceptions.LecturaException;
import com.ronaldo.gestor.back.exceptions.ListaException;
import com.ronaldo.gestor.back.producto.Producto;
import com.ronaldo.gestor.back.sucursal.Sucursal;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ronaldo
 */
public class LectorProductos {

    private boolean hayErrores;
    private static final int TOTAL_PARAMS = 8;

    public void leerCSVProductos(String ruta, ListaEnlazadaGenerica<Sucursal> sucursales) throws LecturaException, FileNotFoundException, IOException, ListaException {

        try (CSVReader reader = new CSVReader(new FileReader(ruta)); PrintWriter log = new PrintWriter(new FileWriter("errors.log", true))) {

            String[] fila;
            int nLinea = 0;

            while ((fila = reader.readNext()) != null) {
                Sucursal sucursal = null;

                if (nLinea == 0) {
                    nLinea++;
                    continue;
                }
                nLinea++;

                try {

                    if (fila.length < TOTAL_PARAMS) {
                        String error = "Línea " + nLinea + ": se esperaban " + TOTAL_PARAMS + " parametros";
                        log.println(error);
                        continue;
                    }
                    String idSucursal = fila[0];
                    boolean existeSucursal = false;

                    for (int i = 0; i < sucursales.getTamaño(); i++) {
                        Sucursal s = sucursales.obtenerValor(i);
                        if (s.getId().equals(idSucursal)) {
                            sucursal = s;
                            existeSucursal = true;
                            break;
                        }
                    }
                    if (!existeSucursal) {
                        String error = "Línea " + nLinea + ": no existe la sucursal con id " + idSucursal + ".";
                        log.println(error);
                        hayErrores = true;
                        continue;
                    }

                    double precio = Double.parseDouble(fila[6].trim());
                    int stock = Integer.parseInt(fila[7].trim());

                    Producto producto = new Producto(
                            fila[1],
                            fila[2],
                            fila[3],
                            fila[4],
                            fila[5],
                            precio,
                            stock
                    );

                    //verificacion de los datos obtenidos
                    try {
                        producto.datosValidos();
                    } catch (DatoInvalidoException e1) {
                        String error = "Linea " + nLinea + " " + e1.getMessage();
                        log.println(error);
                        hayErrores = true;
                    }

                    if (!producto.isDatoInvalido()) {
                        try {
                            sucursal.insertarProducto(producto);
                        } catch (ElementoExistenteException | ElementoNoEncontradoException e) {
                            String error = "Linea: " + nLinea + "      " + e.getMessage();
                            log.println(error);
                            hayErrores = true;
                        }

                    }

                } catch (NumberFormatException e) {
                    String error = "Linea " + nLinea + ": valor no numerico " + e.getMessage();
                    log.println(error);
                    hayErrores = true;
                }
            }

        } catch (IOException | CsvValidationException e) {
            throw new LecturaException("Error al leer el archivo");
        }
    }

    public boolean isHayErrores() {
        return hayErrores;
    }

}
