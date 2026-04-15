package com.ronaldo.gestor.back.estructuras.arbol.b;

import com.ronaldo.gestor.back.producto.Producto;

/**
 *
 * @author ronaldo
 */
public class Clave {

    private String fecha;
    private Producto producto;

    public Clave(Producto producto) {
        this.fecha = producto.getFechaVencimiento();
        this.producto = producto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
    
}
