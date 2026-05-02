package com.ronaldo.gestor.analisisRendimiento;

import com.ronaldo.gestor.back.producto.Producto;

/**
 *
 * @author ronaldo
 */
public class ResultadoRendimiento {

    private String nombreEstructura;
    private double tiempoPromedio;
    private Producto producto;

    public ResultadoRendimiento(String nombreEstructura, double tiempoPromedio, Producto producto) {
        this.nombreEstructura = nombreEstructura;
        this.tiempoPromedio = tiempoPromedio;
        this.producto = producto;
    }

    public String getNombreEstructura() {
        return nombreEstructura;
    }

    public void setNombreEstructura(String nombreEstructura) {
        this.nombreEstructura = nombreEstructura;
    }

    public double getTiempoPromedio() {
        return tiempoPromedio;
    }

    public void setTiempoPromedio(double tiempoPromedio) {
        this.tiempoPromedio = tiempoPromedio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
