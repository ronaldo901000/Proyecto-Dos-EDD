package com.ronaldo.gestor.back.estructuras.arbol.b;

/**
 *
 * @author ronaldo
 */
public class ResultadoDivision {

    private Clave claveMediana;
    private NodoB hermanoDerecho;
    private boolean seDividio;

    public ResultadoDivision() {
    }

    public Clave getClaveMediana() {
        return claveMediana;
    }

    public void setClaveMediana(Clave claveMediana) {
        this.claveMediana = claveMediana;
    }

    public NodoB getHermanoDerecho() {
        return hermanoDerecho;
    }

    public void setHermanoDerecho(NodoB hermanoDerecho) {
        this.hermanoDerecho = hermanoDerecho;
    }

    public boolean isSeDividio() {
        return seDividio;
    }

    public void setSeDividio(boolean seDividio) {
        this.seDividio = seDividio;
    }

}
