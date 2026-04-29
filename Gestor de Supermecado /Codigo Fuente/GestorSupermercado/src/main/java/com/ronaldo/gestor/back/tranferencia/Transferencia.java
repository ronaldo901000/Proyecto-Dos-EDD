package com.ronaldo.gestor.back.tranferencia;

import com.ronaldo.gestor.back.estructuras.grafo.Arista;
import com.ronaldo.gestor.back.estructuras.grafo.Grafo;
import com.ronaldo.gestor.back.estructuras.lista.generica.ListaEnlazadaGenerica;
import com.ronaldo.gestor.back.exceptions.ElementoExistenteException;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.exceptions.EstructuraVaciaException;
import com.ronaldo.gestor.back.exceptions.ListaException;
import com.ronaldo.gestor.back.producto.Producto;
import com.ronaldo.gestor.back.sucursal.Sucursal;

/**
 *
 * @author ronaldo
 */
public class Transferencia extends Thread {

    private Producto producto;
    private ListaEnlazadaGenerica<Sucursal> ruta;
    private Grafo grafo;
    private boolean esTiempo;
    private TransferenciaListener listener;

    private static final int UN_SEGUNDO = 1000;

    public Transferencia(Producto producto,
            ListaEnlazadaGenerica<Sucursal> ruta,
            Grafo grafo,
            boolean esTiempo,
            TransferenciaListener listener) {
        this.producto = producto;
        this.ruta = ruta;
        this.grafo = grafo;
        this.esTiempo = esTiempo;
        this.listener = listener;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < ruta.getTamaño(); i++) {
                Sucursal actual = ruta.obtenerValor(i);
                actual.getColaIngreso().ingresar(producto);
                listener.sucursalEntrada(producto, actual);
                Thread.sleep(actual.getTiempoIngreso() * UN_SEGUNDO);
                actual.getColaIngreso().sacar();

                if (!esDestino(i)) {
                    actual.getColaTraspaso().ingresar(producto);
                    listener.preparando(producto, actual);
                    Thread.sleep(actual.getTiempoTraspaso() * UN_SEGUNDO);
                    actual.getColaTraspaso().sacar();

                    actual.getColaSalida().ingresar(producto);
                    listener.despachando(producto, actual);
                    Thread.sleep(actual.getIntervaloDespacho() * UN_SEGUNDO);
                    actual.getColaSalida().sacar();

                    Sucursal siguiente = ruta.obtenerValor(i + 1);
                    int pesoArista = obtenerPesoArista(actual, siguiente);
                    listener.viajando(producto, actual, siguiente, pesoArista);
                    Thread.sleep(pesoArista * UN_SEGUNDO);
                }
            }

            Sucursal origen = ruta.obtenerValor(0);
            Sucursal destino = ruta.obtenerValor(ruta.getTamaño() - 1);

            Producto p = destino.getTablaHash().buscar(producto.getCodigoBarra());
            producto.setDisponible(true);
            
            if (p != null) {
                listener.error(producto, "El producto ya existe en " + destino.getNombre());
                return;
            }

            
            destino.insertarProducto(producto);
            origen.eliminar(producto.getCodigoBarra());
            listener.exito(producto, destino);

        } catch (InterruptedException | ListaException | ElementoNoEncontradoException
                | ElementoExistenteException | EstructuraVaciaException e) {

            listener.error(producto, e.getMessage());
        }
    }

    private int obtenerPesoArista(Sucursal origen, Sucursal destino) {
        Arista arista = origen.getCabezaLista();
        while (arista != null) {
            if (arista.getIdDestino().equals(destino.getId())) {
                if (esTiempo) {
                    return arista.getTiempo();
                } else {
                    return (int) arista.getCosto();
                }
            }
            arista = arista.getSiguiente();
        }
        return 0;
    }

    private boolean esDestino(int i) {
        return i == this.ruta.getTamaño() - 1;
    }
}
