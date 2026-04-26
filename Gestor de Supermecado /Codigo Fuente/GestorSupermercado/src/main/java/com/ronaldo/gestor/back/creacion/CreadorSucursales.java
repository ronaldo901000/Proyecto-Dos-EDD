package com.ronaldo.gestor.back.creacion;

import com.ronaldo.gestor.back.estructuras.lista.generica.ListaEnlazadaGenerica;
import com.ronaldo.gestor.back.exceptions.DatoInvalidoException;
import com.ronaldo.gestor.back.exceptions.ElementoExistenteException;
import com.ronaldo.gestor.back.exceptions.ListaException;
import com.ronaldo.gestor.back.sucursal.Sucursal;

/**
 *
 * @author ronaldo
 */
public class CreadorSucursales {

    public Sucursal crearSucursal(String id, String nombre,
            String ubicacion, int tiempoIngreso,
            int tiempoTraspaso, int intervaloDespacho, ListaEnlazadaGenerica<Sucursal> sucursales, boolean esEdicion) throws DatoInvalidoException, ListaException, ElementoExistenteException {

        cadenaValida(id, "ID");
        cadenaValida(nombre, "NOMBRE");
        cadenaValida(ubicacion, "UBICACION");
        if (!esEdicion) {
            verificarExistencia(id, sucursales);
        }

        return new Sucursal(id, nombre, ubicacion, tiempoIngreso, tiempoTraspaso, intervaloDespacho);

    }

    private void cadenaValida(String cadena, String nombre) throws DatoInvalidoException {
        if (cadena != null && cadena.isBlank()) {
            throw new DatoInvalidoException("El campo " + nombre + " no debe estar vacio.");
        }
    }

    private void verificarExistencia(String id, ListaEnlazadaGenerica<Sucursal> sucursales) throws ListaException, ElementoExistenteException {
        for (int i = 0; i < sucursales.getTamaño(); i++) {
            Sucursal sucursal = sucursales.obtenerValor(i);
            if (sucursal.getId().equals(id)) {
                throw new ElementoExistenteException("El ID: " + id + " ya lo usa la sucursal " + sucursal.getNombre() + ", ingresa otro.");
            }
        }
    }
}
