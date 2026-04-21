package com.ronaldo.gestor.back.lectura;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ronaldo.gestor.back.estructuras.lista.generica.ListaEnlazadaGenerica;
import com.ronaldo.gestor.back.exceptions.LecturaException;
import com.ronaldo.gestor.back.sucursal.Sucursal;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ronaldo
 */
public class LectorSucursales {

    private int totalSucursales;
    private boolean hayErrores;

    public ListaEnlazadaGenerica<Sucursal> leerCSVSucursales(String ruta) throws LecturaException {

        ListaEnlazadaGenerica<Sucursal> sucursales = new ListaEnlazadaGenerica<>();

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

                    if (fila.length < 6) {
                        String error = "Línea " + nLinea + ": se esperaban 6 columnas";
                        System.out.println(error);
                        log.println(error);
                        continue;
                    }

                    int tIngreso = Integer.parseInt(fila[3].trim());
                    int tTraspaso = Integer.parseInt(fila[4].trim());
                    int inDespacho = Integer.parseInt(fila[5].trim());

                    Sucursal sucursal = new Sucursal(fila[0], fila[1], fila[2], tIngreso, tTraspaso, inDespacho);
                    sucursales.agregarElemento(sucursal);

                } catch (NumberFormatException e) {
                    String error = "Linea " + nLinea + ": valor no numérico " + e.getMessage();
                    log.println(error);
                    hayErrores = true;
                }
            }

        } catch (IOException | CsvValidationException e) {
            throw new LecturaException("Error al leer el archivo");
        }
        this.totalSucursales = sucursales.getTamaño();
        return sucursales;
    }

    public int getTotalSucursales() {
        return this.totalSucursales;
    }

    public boolean isHayErrores() {
        return hayErrores;
    }

}
