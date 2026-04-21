package com.ronaldo.gestor.back.controlador;

import com.ronaldo.gestor.back.estructuras.grafo.Grafo;
import com.ronaldo.gestor.back.lectura.LectorConexiones;
/**
 *
 * @author ronaldo
 */
public class Controlador {
    
    private Grafo grafo;
    private LectorConexiones lConexiones;
    

    public Controlador() {
        grafo = new Grafo();
        lConexiones = new LectorConexiones(grafo);
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public LectorConexiones getlConexiones() {
        return lConexiones;
    }

    
}
