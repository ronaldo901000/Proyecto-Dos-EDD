package com.ronaldo.gestor.back.verificacion;

import com.ronaldo.gestor.back.estructuras.lista.normal.ListaEnlazada;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.producto.Producto;
import com.ronaldo.gestor.back.sucursal.Sucursal;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ronaldo
 */
public class VerificadorExistencias {

    private boolean hayDuplicados;

    public ListaEnlazada filtrar(Sucursal sucursal, ListaEnlazada pEntrantes) throws ElementoNoEncontradoException {

        ListaEnlazada listaFiltrada = new ListaEnlazada();

        for (int i = 0; i < pEntrantes.getTamaño(); i++) {
            Producto p = p = pEntrantes.obtener(i);

            if (sucursal.getAvl().buscar(p.getNombre()) == null) {
                listaFiltrada.insertar(p);
            } else {
                try (PrintWriter log = new PrintWriter(new FileWriter("errors.log", true))) {
                    log.println("El nombre: " + p.getNombre() + " ya ha sido registrado antes.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return listaFiltrada;
    }

    public boolean isHayDuplicados() {
        return hayDuplicados;
    }

}
