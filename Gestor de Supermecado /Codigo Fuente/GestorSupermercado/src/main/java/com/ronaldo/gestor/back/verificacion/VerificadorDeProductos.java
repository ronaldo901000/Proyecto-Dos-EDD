package com.ronaldo.gestor.back.verificacion;

import com.ronaldo.gestor.back.exceptions.ElementoExistenteException;
import com.ronaldo.gestor.back.producto.Producto;
import com.ronaldo.gestor.back.sucursal.Sucursal;

/**
 *
 * @author ronaldo
 */
public class VerificadorDeProductos {
    
    public void verificar(Producto producto, Sucursal sucursal) 
            throws ElementoExistenteException{
        
        //verificar que el codigo de barras no sea duplicado
        Producto p = sucursal.getTablaHash().buscar(producto.getCodigoBarra());
        if(p !=null){
            sucursal.getPilaErroneos().apilar(producto);
            throw new ElementoExistenteException(
                    "El codigo de barras "+ 
                            producto.getCodigoBarra()+
                            " ya ha sido registrado antes, elige otro. "
            );
        }
        
    }
}
