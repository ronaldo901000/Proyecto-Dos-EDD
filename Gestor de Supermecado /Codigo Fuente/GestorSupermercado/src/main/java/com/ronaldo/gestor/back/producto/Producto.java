package com.ronaldo.gestor.back.producto;

import com.ronaldo.gestor.back.exceptions.DatoInvalidoException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author ronaldo
 */
public class Producto {

    private static final int CARACTERES_CODIGO_BARRA = 10;
    private String nombre;
    private String codigoBarra;
    private String categoria;
    private String fechaVencimiento;
    private String marca;
    private double precio;
    private int existencias;
    private boolean datoInvalido;
    private boolean disponible;

    public Producto(String nombre, String codigoBarra, String categoria, String fechaVencimiento, String marca, double precio, int existencias) {
        this.nombre = nombre;
        this.codigoBarra = codigoBarra;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.marca = marca;
        this.precio = precio;
        this.existencias = existencias;
        this.disponible = true;
    }

    public void datosValidos() throws DatoInvalidoException {

        if (StringUtils.isBlank(nombre)
                || StringUtils.isBlank(codigoBarra)
                || StringUtils.isBlank(categoria)
                || StringUtils.isBlank(fechaVencimiento)
                || StringUtils.isBlank(marca)) {
            datoInvalido = true;
            throw new DatoInvalidoException("Uno de los datos del producto viene vacio, o es invalido.");
        }

        if (codigoBarra.length() != CARACTERES_CODIGO_BARRA) {
            datoInvalido = true;
            throw new DatoInvalidoException("El codigo de barras debe tener EXACTAMENTE 10 caracteres");
        }

        if (precio < 0) {
            datoInvalido = true;
            throw new DatoInvalidoException("El precio no debe ser menor a Q.00");
        }

        if (existencias < 0) {
            datoInvalido = true;
            throw new DatoInvalidoException("Las existencias no debe ser menor a 0");
        }

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate.parse(fechaVencimiento, formato);

        } catch (DateTimeParseException e) {
            datoInvalido = true;
            throw new DatoInvalidoException("Error en el formato de fecha " + fechaVencimiento);
        }

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

    public boolean isDatoInvalido() {
        return datoInvalido;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getInfo(){
        return "("+this.codigoBarra+") "+this.nombre;
    }
}
