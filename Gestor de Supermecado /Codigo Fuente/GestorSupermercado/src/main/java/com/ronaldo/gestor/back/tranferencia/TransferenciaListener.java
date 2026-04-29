package com.ronaldo.gestor.back.tranferencia;

import com.ronaldo.gestor.back.producto.Producto;
import com.ronaldo.gestor.back.sucursal.Sucursal;

/**
 *
 * @author ronaldo
 */
public interface TransferenciaListener {

    void sucursalEntrada(Producto producto, Sucursal sucursal);

    void preparando(Producto producto, Sucursal sucursal);

    void despachando(Producto producto, Sucursal sucursal);

    void viajando(Producto producto, Sucursal origen, Sucursal destino, int tiempo);

    void exito(Producto producto, Sucursal destino);

    void error(Producto producto, String mensaje);

}
