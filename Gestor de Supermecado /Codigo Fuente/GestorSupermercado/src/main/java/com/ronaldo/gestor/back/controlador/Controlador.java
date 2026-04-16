package com.ronaldo.gestor.back.controlador;

import com.ronaldo.gestor.back.estructuras.lista.generica.ListaEnlazadaGenerica;
import com.ronaldo.gestor.back.producto.sucursal.Sucursal;

/**
 *
 * @author ronaldo
 */
public class Controlador {

    private ListaEnlazadaGenerica<Sucursal> sucursales;

    public Controlador() {
        this.sucursales = new ListaEnlazadaGenerica<>();
    }

    public ListaEnlazadaGenerica<Sucursal> getSucursales() {
        return sucursales;
    }

    
    
}
