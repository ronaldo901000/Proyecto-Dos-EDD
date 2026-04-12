package com.ronaldo.gestor.back.producto;

/**
 *
 * @author ronaldo
 */
public class Producto {

    private String nombre;
    private String codigoBarra;
    private String categoria;
    private String fechaVencimiento;
    private String marca;
    private double precio;
    private int existencias;

    public Producto(String nombre, String codigoBarra, String categoria, String fechaVencimiento, String marca, double precio, int existencias) {
        this.nombre = nombre;
        this.codigoBarra = codigoBarra;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.marca = marca;
        this.precio = precio;
        this.existencias = existencias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

}
