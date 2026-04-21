package com.ronaldo.gestor.back.estructuras.grafo;

/**
 *
 * @author ronaldo
 */
public class Arista {

    private String idDestino;
    private int tiempo;
    private double costo;
    private Arista siguiente;

    public Arista(String idDestino, int tiempo, double costo) {
        this.idDestino = idDestino;
        this.tiempo = tiempo;
        this.costo = costo;
    }

    public String getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(String idDestino) {
        this.idDestino = idDestino;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Arista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Arista siguiente) {
        this.siguiente = siguiente;
    }

}
