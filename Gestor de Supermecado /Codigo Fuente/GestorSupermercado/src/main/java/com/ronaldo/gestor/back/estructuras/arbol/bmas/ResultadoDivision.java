package com.ronaldo.gestor.back.estructuras.arbol.bmas;

/**
 *
 * @author ronaldo
 */
public class ResultadoDivision {
    
    private ClaveColeccion claveMediana;
    private NodoBMas hermanoDerecho;
    private boolean seDividio;

    public ClaveColeccion getClaveMediana() {
        return claveMediana;
    }

    public void setClaveMediana(ClaveColeccion claveMediana) {
        this.claveMediana = claveMediana;
    }

    public NodoBMas getHermanoDerecho() {
        return hermanoDerecho;
    }

    public void setHermanoDerecho(NodoBMas hermanoDerecho) {
        this.hermanoDerecho = hermanoDerecho;
    }

    public boolean isSeDividio() {
        return seDividio;
    }

    public void setSeDividio(boolean seDividio) {
        this.seDividio = seDividio;
    }
    
    
    
}
