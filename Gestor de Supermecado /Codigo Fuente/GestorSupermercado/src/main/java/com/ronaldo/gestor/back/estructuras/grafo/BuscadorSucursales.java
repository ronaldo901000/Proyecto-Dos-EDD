package com.ronaldo.gestor.back.estructuras.grafo;

import com.ronaldo.gestor.back.estructuras.lista.generica.ListaEnlazadaGenerica;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.exceptions.ListaException;
import com.ronaldo.gestor.back.sucursal.Sucursal;

/**
 *
 * @author ronaldo
 */
public class BuscadorSucursales {

    public boolean existeSucursal(String id, ListaEnlazadaGenerica<Sucursal> lista) {
        try {
            buscarSucursal(id, lista);
            return true;
        } catch (ElementoNoEncontradoException e) {
            return false;
        }
    }

    public Sucursal buscarSucursal(String id, ListaEnlazadaGenerica<Sucursal> lista) throws ElementoNoEncontradoException {
        try {
            for (int i = 0; i < lista.getTamaño(); i++) {
                Sucursal s = lista.obtenerValor(i);
                if (s.getId().equals(id)) {
                    return s;
                }
            }
        } catch (ListaException e) {
            throw new ElementoNoEncontradoException("Error al buscar sucursal: " + e.getMessage());
        }
        throw new ElementoNoEncontradoException("No existe ninguna sucursal con ID: " + id);
    }

}
