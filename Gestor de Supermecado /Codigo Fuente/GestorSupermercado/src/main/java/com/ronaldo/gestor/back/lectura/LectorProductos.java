package com.ronaldo.gestor.back.lectura;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ronaldo.gestor.back.estructuras.lista.normal.ListaEnlazada;
import com.ronaldo.gestor.back.exceptions.DatoInvalidoException;
import com.ronaldo.gestor.back.exceptions.LecturaException;
import com.ronaldo.gestor.back.producto.Producto;
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

    public ListaEnlazada leerCSVProductos(String ruta) throws LecturaException, FileNotFoundException, IOException {

        ListaEnlazada productos = new ListaEnlazada();

        try (CSVReader reader = new CSVReader(new FileReader(ruta)); PrintWriter log = new PrintWriter(new FileWriter("errors.log", true))) {

            String[] fila;
            int nLinea = 0;

            while ((fila = reader.readNext()) != null) {

                if (nLinea == 0) {
                    nLinea++;
                    continue;
                }
                nLinea++;

                try {

                    if (fila.length < 7) {
                        String error = "Línea " + nLinea + ": se esperaban 7 parametros";
                        log.println(error);
                        continue;
                    }

                    double precio = Double.parseDouble(fila[5].trim());
                    int stock = Integer.parseInt(fila[6].trim());

                    Producto producto = new Producto(
                            fila[0],
                            fila[1],
                            fila[2],
                            fila[3],
                            fila[4],
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
                        productos.insertar(producto);
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
        return productos;
    }

    public boolean isHayErrores() {
        return hayErrores;
    }

}
