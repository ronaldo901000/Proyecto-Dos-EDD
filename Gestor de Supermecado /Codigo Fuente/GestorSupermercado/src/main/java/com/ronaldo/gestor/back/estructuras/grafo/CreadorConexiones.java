package com.ronaldo.gestor.back.estructuras.grafo;

import com.ronaldo.gestor.back.exceptions.ElementoExistenteException;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.exceptions.ListaException;
import com.ronaldo.gestor.back.sucursal.Sucursal;

/**
 *
 * @author ronaldo
 */
public class CreadorConexiones {

    public void crear(
            Sucursal origen, int indiceDestino, int tiempo, int costo,
            int bidireccional, Grafo grafo) throws ListaException, ElementoNoEncontradoException, ElementoExistenteException {

        Sucursal destino = grafo.getLista().obtenerValor(indiceDestino);

        
        if(destino == origen){
            throw new ElementoNoEncontradoException("No se puede conectar una sucursal con si misma.");
        }
        //conexion entre origen -> destino
        grafo.conectar(origen.getId(), destino.getId(), tiempo, costo);

        // conexion entre destino -> origen
        if (bidireccional == 1) {
            grafo.conectar(destino.getId(), origen.getId(), tiempo, costo);
        }

    }

}
