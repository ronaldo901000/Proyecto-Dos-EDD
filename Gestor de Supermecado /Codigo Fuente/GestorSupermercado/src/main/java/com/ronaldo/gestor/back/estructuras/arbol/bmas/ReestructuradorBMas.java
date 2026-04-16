package com.ronaldo.gestor.back.estructuras.arbol.bmas;

/**
 * @author ronaldo
 */

public class ReestructuradorBMas {

    public ReestructuradorBMas() {
    }

    public void prestarDelIzquierdo(NodoBMas padre, NodoBMas hijo, NodoBMas hermanoIzq, int indiceClavePivote) {
        dejarLibreIndiceCero(hijo);

        int ultimoIdxIzquierdo = hermanoIzq.getContadorClaves() - 1;

        hijo.setClavePorIndice(0, hermanoIzq.getClaveColeccionPorIndice(ultimoIdxIzquierdo));

        if (!hijo.isEsHoja()) {
            hijo.setHijoPorIndice(0, hermanoIzq.getHijoPorIndice(ultimoIdxIzquierdo + 1));
        }

        hijo.setContadorClaves(hijo.getContadorClaves() + 1);

        hermanoIzq.getClavesColeccion()[ultimoIdxIzquierdo] = null;
        hermanoIzq.setContadorClaves(ultimoIdxIzquierdo);

        ClaveColeccion nuevaPivote = new ClaveColeccion();
        nuevaPivote.setCategoria(hijo.getClavePorIndice(0));
        padre.setClavePorIndice(indiceClavePivote, nuevaPivote);
    }

    public void prestarDelDerecho(NodoBMas padre, NodoBMas hijo, NodoBMas hermanoDer, int indiceClavePivote) {
        int idxInsercion = hijo.getContadorClaves();

        hijo.setClavePorIndice(idxInsercion, hermanoDer.getClaveColeccionPorIndice(0));

        if (!hijo.isEsHoja()) {
            hijo.setHijoPorIndice(idxInsercion + 1, hermanoDer.getHijoPorIndice(0));
        }

        hijo.setContadorClaves(idxInsercion + 1);

        llenarIndiceCero(hermanoDer);
        hermanoDer.setContadorClaves(hermanoDer.getContadorClaves() - 1);

        ClaveColeccion nuevaPivote = new ClaveColeccion();
        nuevaPivote.setCategoria(hermanoDer.getClavePorIndice(0));
        padre.setClavePorIndice(indiceClavePivote, nuevaPivote);
    }

    public void fusionar(NodoBMas padre, NodoBMas hermano1, NodoBMas hermano2, int indiceClavePivote) {
        if (hermano1.isEsHoja()) {
            for (int i = 0; i < hermano2.getContadorClaves(); i++) {
                int pos = hermano1.getContadorClaves();
                hermano1.setClavePorIndice(pos, hermano2.getClaveColeccionPorIndice(i));
                hermano1.setContadorClaves(pos + 1);
            }
        } else {
            int pos = hermano1.getContadorClaves();
            hermano1.setClavePorIndice(pos, padre.getClaveColeccionPorIndice(indiceClavePivote));
            hermano1.setHijoPorIndice(pos + 1, hermano2.getHijoPorIndice(0));
            hermano1.setContadorClaves(pos + 1);

            for (int i = 0; i < hermano2.getContadorClaves(); i++) {
                int nuevaPos = hermano1.getContadorClaves();
                hermano1.setClavePorIndice(nuevaPos, hermano2.getClaveColeccionPorIndice(i));
                hermano1.setHijoPorIndice(nuevaPos + 1, hermano2.getHijoPorIndice(i + 1));
                hermano1.setContadorClaves(nuevaPos + 1);
            }
        }

        for (int i = indiceClavePivote; i < padre.getContadorClaves() - 1; i++) {
            padre.setClavePorIndice(i, padre.getClaveColeccionPorIndice(i + 1));
            padre.setHijoPorIndice(i + 1, padre.getHijoPorIndice(i + 2));
        }

        int totalPadre = padre.getContadorClaves();
        padre.getClavesColeccion()[totalPadre - 1] = null;
        padre.getHijos()[totalPadre] = null;
        padre.setContadorClaves(totalPadre - 1);
    }

    private void dejarLibreIndiceCero(NodoBMas nodo) {
        int n = nodo.getContadorClaves();
        for (int i = n; i > 0; i--) {
            nodo.setClavePorIndice(i, nodo.getClaveColeccionPorIndice(i - 1));
            if (!nodo.isEsHoja()) {
                nodo.setHijoPorIndice(i + 1, nodo.getHijoPorIndice(i));
            }
        }
        if (!nodo.isEsHoja()) {
            nodo.setHijoPorIndice(1, nodo.getHijoPorIndice(0));
        }
    }

    private void llenarIndiceCero(NodoBMas nodo) {
        int n = nodo.getContadorClaves();
        for (int i = 0; i < n - 1; i++) {
            nodo.setClavePorIndice(i, nodo.getClaveColeccionPorIndice(i + 1));
            if (!nodo.isEsHoja()) {
                nodo.setHijoPorIndice(i, nodo.getHijoPorIndice(i + 1));
            }
        }
        if (!nodo.isEsHoja()) {
            nodo.setHijoPorIndice(n - 1, nodo.getHijoPorIndice(n));
            nodo.setHijoPorIndice(n, null);
        }
        nodo.getClavesColeccion()[n - 1] = null;
    }

    public void ordenarNodo(ClaveColeccion[] claves, NodoBMas[] hijos, int nClaves) {
        boolean hayCambio;
        do {
            hayCambio = false;
            for (int i = 0; i < nClaves - 1; i++) {
                if (claves[i] != null && claves[i + 1] != null) {
                    String actual = claves[i].getCategoria();
                    String siguiente = claves[i + 1].getCategoria();

                    if (actual.compareTo(siguiente) > 0) {
                        ClaveColeccion tempClave = claves[i];
                        claves[i] = claves[i + 1];
                        claves[i + 1] = tempClave;

                        if (hijos != null) {
                            NodoBMas tempHijo = hijos[i + 1];
                            hijos[i + 1] = hijos[i + 2];
                            hijos[i + 2] = tempHijo;
                        }
                        hayCambio = true;
                    }
                }
            }
        } while (hayCambio);
    }
}
