package com.ronaldo.gestor.front.paneles;

import com.ronaldo.gestor.back.estructuras.grafo.Grafo;
import com.ronaldo.gestor.back.estructuras.lista.generica.ListaEnlazadaGenerica;
import com.ronaldo.gestor.back.exceptions.ListaException;
import com.ronaldo.gestor.back.producto.Producto;
import com.ronaldo.gestor.back.sucursal.Sucursal;
import com.ronaldo.gestor.back.tranferencia.Transferencia;
import com.ronaldo.gestor.back.tranferencia.TransferenciaListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author ronaldo
 */
public class ProgresoPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProgresoPanel
     */
    private int progresoActual = 0;
    private int pasosTotales = 1;

    public ProgresoPanel(
            Producto producto,
            ListaEnlazadaGenerica<Sucursal> ruta,
            Grafo grafo,
            boolean esTiempo) {

        initComponents();
        StringBuilder builder = new StringBuilder();

        try {
            int tiempoEstimado = grafo.calcularTiempoEstimado(ruta, esTiempo);

            int minutos = tiempoEstimado / 60;
            int segundos = tiempoEstimado % 60;

            txtTiempoEstimado.setText("Tiempo estimado: " + minutos + ":" + segundos);

            txtOrigen.setText("Origen: " + ruta.obtenerValor(0).getInfo());
            txtDestino.setText("Destino: " + ruta.obtenerValor(ruta.getTamaño() - 1).getInfo());
            txtProducto.setText("Producto: " + producto.getNombre());
            String parametro = "Tiempo";

            if (!esTiempo) {
                parametro = "Costo";
            }
            txtParametro.setText("Peso: " + parametro);

            builder.append("RUTA: \n");
            for (int i = 0; i < ruta.getTamaño(); i++) {

                Sucursal s = ruta.obtenerValor(i);
                if (i == 0) {
                    builder.append(" ► " + s.getInfo() + "\n");
                } else if (i == ruta.getTamaño() - 1) {
                    builder.append(" |► " + s.getInfo() + "\n");

                } else {
                    builder.append(" - " + s.getInfo() + "\n");
                }

            }

            txtAreaRuta.setText(builder.toString());
        } catch (ListaException ex) {
            System.out.println(ex.getMessage());
        }

        long inicio = System.currentTimeMillis();

        int sucursales = ruta.getTamaño();
        pasosTotales = (sucursales * 3) + (sucursales - 1);
        progresoActual = 0;

        barraProgreso.setValue(0);
        barraProgreso.setStringPainted(true);
        barraProgreso.setForeground(java.awt.Color.RED);

        Transferencia hilo = new Transferencia(
                producto,
                ruta,
                grafo,
                esTiempo,
                new TransferenciaListener() {

            @Override
            public void sucursalEntrada(Producto p, Sucursal s) {
                SwingUtilities.invokeLater(() -> {
                    avanzarProgreso();
                    txtInfo.append("[" + tiempo() + "] ► Producto en cola de ingreso — " + s.getInfo() + "\n");
                    txtInfo.setCaretPosition(txtInfo.getDocument().getLength());
                });
            }

            @Override
            public void preparando(Producto p, Sucursal s) {
                SwingUtilities.invokeLater(() -> {
                    avanzarProgreso();
                    txtInfo.append("[" + tiempo() + "] ► Preparando traspaso en — (" + (s.getId()) + ") " + s.getNombre() + "\n");
                    txtInfo.setCaretPosition(txtInfo.getDocument().getLength());
                });
            }

            @Override
            public void despachando(Producto p, Sucursal s) {
                SwingUtilities.invokeLater(() -> {
                    avanzarProgreso();
                    txtInfo.append("[" + tiempo() + "] ► En cola de salida — " + s.getInfo() + "\n");
                    txtInfo.setCaretPosition(txtInfo.getDocument().getLength());
                });
            }

            @Override
            public void viajando(Producto p, Sucursal origen, Sucursal destino, int tiempoViaje) {
                SwingUtilities.invokeLater(() -> {
                    avanzarProgreso();
                    txtInfo.append("[" + tiempo() + "] --► Viajando "
                            + origen.getInfo() + " → "
                            + destino.getInfo() + " ("
                            + tiempoViaje + "s)\n");
                    txtInfo.setCaretPosition(txtInfo.getDocument().getLength());
                });
            }

            @Override
            public void exito(Producto p, Sucursal destino) {
                SwingUtilities.invokeLater(() -> {
                    barraProgreso.setValue(100);
                    barraProgreso.setForeground(java.awt.Color.GREEN);

                    txtInfo.append("[" + tiempo() + "] ✓ Entregado en: " + destino.getInfo() + "\n");
                    txtInfo.setCaretPosition(txtInfo.getDocument().getLength());
                });
            }

            @Override
            public void error(Producto p, String mensaje) {
                SwingUtilities.invokeLater(() -> {
                    barraProgreso.setForeground(java.awt.Color.RED);

                    txtInfo.append("[" + tiempo() + "] ✗ Error: " + mensaje + "\n");
                    txtInfo.setCaretPosition(txtInfo.getDocument().getLength());
                });
            }

            private String tiempo() {
                long seg = (System.currentTimeMillis() - inicio) / 1000;
                return String.format("%02d:%02d", seg / 60, seg % 60);
            }
        });

        hilo.start();
    }

    private void avanzarProgreso() {
        progresoActual++;

        int porcentaje = (int) ((progresoActual * 100.0) / pasosTotales);
        barraProgreso.setValue(porcentaje);

        // cambiar color según avance
        if (porcentaje < 30) {
            barraProgreso.setForeground(java.awt.Color.RED);
        } else if (porcentaje < 70) {
            barraProgreso.setForeground(java.awt.Color.ORANGE);
        } else {
            barraProgreso.setForeground(java.awt.Color.GREEN);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraProgreso = new javax.swing.JProgressBar();
        txtOrigen = new javax.swing.JLabel();
        txtProducto = new javax.swing.JLabel();
        txtDestino = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaRuta = new javax.swing.JTextArea();
        txtTiempoEstimado = new javax.swing.JLabel();
        txtParametro = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txtOrigen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDestino.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtInfo.setEditable(false);
        txtInfo.setBackground(new java.awt.Color(204, 204, 255));
        txtInfo.setColumns(20);
        txtInfo.setForeground(new java.awt.Color(0, 0, 0));
        txtInfo.setRows(5);
        jScrollPane1.setViewportView(txtInfo);

        txtAreaRuta.setEditable(false);
        txtAreaRuta.setColumns(20);
        txtAreaRuta.setRows(5);
        jScrollPane2.setViewportView(txtAreaRuta);

        txtTiempoEstimado.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        txtTiempoEstimado.setForeground(new java.awt.Color(0, 153, 102));
        txtTiempoEstimado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtParametro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barraProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(txtDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTiempoEstimado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtParametro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTiempoEstimado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtAreaRuta;
    private javax.swing.JLabel txtDestino;
    private javax.swing.JTextArea txtInfo;
    private javax.swing.JLabel txtOrigen;
    private javax.swing.JLabel txtParametro;
    private javax.swing.JLabel txtProducto;
    private javax.swing.JLabel txtTiempoEstimado;
    // End of variables declaration//GEN-END:variables
}
