package com.ronaldo.gestor.back.estructuras.arbol.b;

/**
 *
 * @author ronaldo
 */
public class AuxiliarB {

    public void ordenarNodo(Clave[] claves, NodoB[] hijos, int nClaves) {
        boolean hayCambios = false;
        do {
            hayCambios = false;
            for (int i = 0; i < nClaves - 1; i++) {
                if (claves[i] != null && claves[i + 1] != null) {
                    String actual = claves[i].getFecha();
                    String siguiente = claves[i + 1].getFecha();

                    if (actual.compareTo(siguiente) > 0) {
                        Clave temp = claves[i];
                        claves[i] = claves[i + 1];
                        claves[i + 1] = temp;

                        if (hijos != null) {
                            NodoB tempHijo = hijos[i + 1];
                            hijos[i + 1] = hijos[i + 2];
                            hijos[i + 2] = tempHijo;
                        }
                        hayCambios = true;
                    }
                }
            }
        } while (hayCambios);
    }
}
