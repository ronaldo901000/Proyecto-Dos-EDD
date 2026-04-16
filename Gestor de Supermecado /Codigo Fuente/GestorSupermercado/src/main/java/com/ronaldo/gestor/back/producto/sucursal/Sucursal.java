package com.ronaldo.gestor.back.producto.sucursal;

import com.ronaldo.gestor.back.estructuras.arbol.avl.ArbolAVL;
import com.ronaldo.gestor.back.estructuras.arbol.b.ArbolB;
import com.ronaldo.gestor.back.estructuras.arbol.bmas.ArbolBMas;
import com.ronaldo.gestor.back.producto.Producto;

/**
 *
 * @author ronaldo
 */
public class Sucursal {

    private String id;
    private String nombre;
    private String ubicacion;
    private int tiempoIngreso;
    private int tiempoTraspaso;
    private int intervaloDespacho;

    private ArbolAVL avl;
    private ArbolB b;
    private ArbolBMas bMas;

    public Sucursal(String id, String nombre, String ubicacion, int tiempoIngreso, int tiempoTraspaso, int intervaloDespacho) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tiempoIngreso = tiempoIngreso;
        this.tiempoTraspaso = tiempoTraspaso;
        this.intervaloDespacho = intervaloDespacho;
        this.avl = new ArbolAVL();
        this.b = new ArbolB();
        this.bMas = new ArbolBMas();
    }

    public void insertarProducto(Producto producto) {
        //insertar en todas las estructuras
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getTiempoIngreso() {
        return tiempoIngreso;
    }

    public void setTiempoIngreso(int tiempoIngreso) {
        this.tiempoIngreso = tiempoIngreso;
    }

    public int getTiempoTraspaso() {
        return tiempoTraspaso;
    }

    public void setTiempoTraspaso(int tiempoTraspaso) {
        this.tiempoTraspaso = tiempoTraspaso;
    }

    public int getIntervaloDespacho() {
        return intervaloDespacho;
    }

    public void setIntervaloDespacho(int intervaloDespacho) {
        this.intervaloDespacho = intervaloDespacho;
    }

    public ArbolAVL getAvl() {
        return avl;
    }

    public void setAvl(ArbolAVL avl) {
        this.avl = avl;
    }

    public ArbolB getB() {
        return b;
    }

    public void setB(ArbolB b) {
        this.b = b;
    }

    public ArbolBMas getbMas() {
        return bMas;
    }

    public void setbMas(ArbolBMas bMas) {
        this.bMas = bMas;
    }

}
