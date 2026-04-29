package com.ronaldo.gestor.back.lectura;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ronaldo.gestor.back.estructuras.grafo.Grafo;
import com.ronaldo.gestor.back.exceptions.ElementoExistenteException;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.exceptions.LecturaException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ronaldo
 */
public class LectorConexiones {

    private Grafo grafo;
    private boolean hayErrores;
    private int totalConexiones;

    public LectorConexiones(Grafo grafo) {
        this.grafo = grafo;
    }

    public void leerCSVConexion(String ruta) throws LecturaException, ElementoNoEncontradoException {
        totalConexiones = 0;
        hayErrores = false;
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

                    if (fila.length < 4) {
                        String error = "Linea " + nLinea + ": se esperaban 4 columnas";
                        System.out.println(error);
                        log.println(error);
                        continue;
                    }

                    String idOrigen = fila[0].trim();
                    String idDestino = fila[1].trim();
                    int tiempo = Integer.parseInt(fila[2].trim());
                    double costo = Double.parseDouble(fila[3].trim());

                    try {

                        grafo.conectar(idOrigen, idDestino, tiempo, costo);
                        totalConexiones++;
                    } catch (ElementoExistenteException e) {
                        String error = "Linea " + nLinea + ": " + e.getMessage();
                        log.println(error);
                        hayErrores = true;
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

    public int getTotalConexiones() {
        return totalConexiones;
    }

}
