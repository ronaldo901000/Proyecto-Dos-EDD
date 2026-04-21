package com.ronaldo.gestor.back.estructuras.grafo;

import com.ronaldo.gestor.back.estructuras.lista.generica.ListaEnlazadaGenerica;
import com.ronaldo.gestor.back.exceptions.ElementoExistenteException;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.exceptions.ListaException;
import com.ronaldo.gestor.back.sucursal.Sucursal;

/**
 *
 * @author ronaldo
 */
public class Grafo {

    private Sucursal cabeza;
    private ListaEnlazadaGenerica<Sucursal> lista;
    private BuscadorSucursales buscador;
    private int totalSucursales;

    public Grafo() {
        buscador = new BuscadorSucursales();
        lista = new ListaEnlazadaGenerica<>();
    }

    /**
     *
     * @param sucursal
     */
    public void agregarSucursal(Sucursal sucursal) throws ElementoExistenteException {

        if (buscador.existeSucursal(sucursal.getId(), lista)) {
            throw new ElementoExistenteException(
                    "El ID '" + sucursal.getId() + "' ya está registrado, utiliza otro."
            );
        }

        lista.agregarElemento(sucursal);

        if (cabeza == null) {
            cabeza = sucursal;
        } else {
            sucursal.setSiguiente(cabeza);
            cabeza = sucursal;
        }
        this.totalSucursales++;
    }

    public void conectar(String idOrigen, String idDestino, int tiempo, double costo) throws ElementoNoEncontradoException {

        Sucursal temp = buscador.buscarSucursal(idOrigen, lista);

        Arista nuevaConexion = new Arista(idDestino, tiempo, costo);

        nuevaConexion.setSiguiente(temp.getCabezaLista());
        temp.setCabezaLista(nuevaConexion);
    }

    public void mostrarGrafo() {
        Sucursal sucursal = cabeza;
        System.out.println("CONEXIONES:");
        int i = 1;
        while (sucursal != null) {
            
            System.out.println(i+". "+ sucursal.getNombre()+ " "+ sucursal.getId());
            
            Arista arista = sucursal.getCabezaLista();
            
            while(arista != null){
                System.out.println("    -> "+ arista.getIdDestino());
                arista = arista.getSiguiente();
            }
            sucursal = sucursal.getSiguiente();
            i++;
        }
    }

    public void ejecutarDijkstra(String idOrigen, String idDestino, boolean esTiempo) throws ListaException {
        int n = this.totalSucursales;
        double[] distancias = new double[n];
        boolean[] visitados = new boolean[n];
        Sucursal[] padres = new Sucursal[n];

        for (int i = 0; i < n; i++) {
            distancias[i] = Double.MAX_VALUE;
            visitados[i] = false;
        }

        int indiceOrigen = obtenerIndiceSucursal(idOrigen);

        if (indiceOrigen == -1) {
            return;
        }

        //distancia hacia el mismo = 0
        distancias[indiceOrigen] = 0;

        for (int i = 0; i < n; i++) {

        }
    }

    private int obtenerIndiceSucursal(String idSucursal) throws ListaException {

        for (int i = 0; i < lista.getTamaño(); i++) {
            if (lista.obtenerValor(i).getId().equals(idSucursal)) {
                return i;
            }
        }
        return -1;
    }

    private int encontrarIndiceMenorCosto(double[] costos, boolean[] procesados) {
        double valorMinimo = Double.MAX_VALUE;
        int indiceMinimo = -1;

        for (int i = 0; i < costos.length; i++) {
            if (!procesados[i] && costos[i] <= valorMinimo) {
                valorMinimo = costos[i];
                indiceMinimo = i;
            }
        }
        return indiceMinimo;
    }

    public ListaEnlazadaGenerica<Sucursal> getLista() {
        return lista;
    }

    public int getTotalSucursales() {
        return totalSucursales;
    }

    public BuscadorSucursales getBuscador() {
        return buscador;
    }
    
    
    
    
}
