package com.ronaldo.gestor.back.sucursal;

import com.ronaldo.gestor.back.estructuras.arbol.avl.ArbolAVL;
import com.ronaldo.gestor.back.estructuras.arbol.b.ArbolB;
import com.ronaldo.gestor.back.estructuras.arbol.b.Clave;
import com.ronaldo.gestor.back.estructuras.arbol.bmas.ArbolBMas;
import com.ronaldo.gestor.back.estructuras.grafo.Arista;
import com.ronaldo.gestor.back.estructuras.lista.normal.ListaEnlazada;
import com.ronaldo.gestor.back.estructuras.lista.ordenada.ListaEnlazadaOrdenada;
import com.ronaldo.gestor.back.estructuras.tablaHash.TablaHash;
import com.ronaldo.gestor.back.exceptions.ElementoExistenteException;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.exceptions.EstructuraVaciaException;
import com.ronaldo.gestor.back.producto.Producto;
import com.ronaldo.gestor.back.verificacion.VerificadorDeProductos;

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
    private Arista cabezaLista;
    private Sucursal siguiente;
    private ArbolAVL avl;
    private ArbolB b;
    private ArbolBMas bMas;
    private TablaHash tablaHash;
    private int totalNuevosInsertados;
    private ListaEnlazada listaDesordenada;
    private ListaEnlazadaOrdenada listaOrdenada;
    private VerificadorDeProductos verificadorProductos;
    private boolean hayDuplicados;

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
        this.tablaHash = new TablaHash();
        this.listaDesordenada = new ListaEnlazada();
        this.listaOrdenada = new ListaEnlazadaOrdenada();
        this.verificadorProductos = new VerificadorDeProductos();
    }

    public void insertarProducto(Producto producto) throws ElementoExistenteException, ElementoNoEncontradoException {
        //verificaciones
        verificadorProductos.verificar(producto, this);

        //insertado en todas las estructuras
        tablaHash.insertar(producto, false);

        if (tablaHash.isHayDuplicados()) {
            return;
        }

        avl.insertar(producto);
        b.insertar(producto);
        bMas.insertar(producto);
        listaDesordenada.insertar(producto);
        listaOrdenada.insertar(producto);

    }

    /**
     *
     * @param nuevos
     * @throws ElementoExistenteException
     * @throws ElementoNoEncontradoException
     */
    public void insertarListaProductos(ListaEnlazada nuevos) throws ElementoExistenteException, ElementoNoEncontradoException {
        hayDuplicados = false;
        totalNuevosInsertados = 0;
        if (nuevos == null) {
            throw new ElementoNoEncontradoException("La lista de productos nuevos es nula.");
        }

        for (int i = 0; i < nuevos.getTamaño(); i++) {

            Producto p = nuevos.obtener(i);

            tablaHash.insertar(p, true);

            if (tablaHash.isHayDuplicados()) {
                hayDuplicados = true;
                continue;
            }

            listaDesordenada.insertar(p);
            listaOrdenada.insertar(p);
            avl.insertar(p);
            b.insertar(p);
            bMas.insertar(p);

            totalNuevosInsertados++;

        }
    }

    public void eliminar(String codigoBarra) throws ElementoNoEncontradoException, EstructuraVaciaException{
        
        Producto p = this.tablaHash.buscar(codigoBarra);
        
        if(p == null){
            throw new ElementoNoEncontradoException("El codigo de barras "+ codigoBarra +" no pertenece a ningun producto.");
        }
        Clave clave = new Clave(p);
        tablaHash.eliminar(codigoBarra);
        avl.eliminar(p.getNombre(), p.getCodigoBarra());
        bMas.eliminar(codigoBarra, p.getCategoria());
        b.eliminar(clave);
        listaDesordenada.eliminar(codigoBarra);
        listaOrdenada.eliminar(codigoBarra);
        
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

    public Arista getCabezaLista() {
        return cabezaLista;
    }

    public void setCabezaLista(Arista cabezaLista) {
        this.cabezaLista = cabezaLista;
    }

    public Sucursal getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Sucursal siguiente) {
        this.siguiente = siguiente;
    }

    public int getTotalNuevosInsertados() {
        return totalNuevosInsertados;
    }

    public TablaHash getTablaHash() {
        return tablaHash;
    }

    public ListaEnlazada getListaDesordenada() {
        return listaDesordenada;
    }

    public ListaEnlazadaOrdenada getListaOrdenada() {
        return listaOrdenada;
    }

    public boolean isHayDuplicados() {
        return hayDuplicados;
    }

}
