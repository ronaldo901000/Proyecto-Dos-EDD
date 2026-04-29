package com.ronaldo.gestor.front.paneles;

import com.ronaldo.gestor.back.estructuras.grafo.Grafo;
import com.ronaldo.gestor.back.estructuras.lista.generica.ListaEnlazadaGenerica;
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

        long inicio = System.currentTimeMillis();

        int sucursales = ruta.getTamaño();
        pasosTotales = (sucursales * 3) + (sucursales - 1);
        progresoActual = 0;

        jProgressBar1.setValue(0);
        jProgressBar1.setStringPainted(true);
        jProgressBar1.setForeground(java.awt.Color.RED);

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
                    txtInfo.append("[" + tiempo() + "] ► Producto en cola de ingreso — " + s.getNombre() + "\n");
                    txtTiempo.setText("Tiempo: " + tiempo());
                    txtInfo.setCaretPosition(txtInfo.getDocument().getLength());
                });
            }

            @Override
            public void preparando(Producto p, Sucursal s) {
                SwingUtilities.invokeLater(() -> {
                    avanzarProgreso();
                    txtInfo.append("[" + tiempo() + "] ► Preparando traspaso en — " + s.getNombre() + "\n");
                    txtTiempo.setText("Tiempo: " + tiempo());
                    txtInfo.setCaretPosition(txtInfo.getDocument().getLength());
                });
            }

            @Override
            public void despachando(Producto p, Sucursal s) {
                SwingUtilities.invokeLater(() -> {
                    avanzarProgreso();
                    txtInfo.append("[" + tiempo() + "] ► En cola de salida — " + s.getNombre() + "\n");
                    txtTiempo.setText("Tiempo: " + tiempo());
                    txtInfo.setCaretPosition(txtInfo.getDocument().getLength());
                });
            }

            @Override
            public void viajando(Producto p, Sucursal origen, Sucursal destino, int tiempoViaje) {
                SwingUtilities.invokeLater(() -> {
                    avanzarProgreso();
                    txtInfo.append("[" + tiempo() + "] ✈ Viajando "
                            + origen.getNombre() + " → "
                            + destino.getNombre() + " ("
                            + tiempoViaje + "s)\n");
                    txtTiempo.setText("Tiempo: " + tiempo());
                    txtInfo.setCaretPosition(txtInfo.getDocument().getLength());
                });
            }

            @Override
            public void exito(Producto p, Sucursal destino) {
                SwingUtilities.invokeLater(() -> {
                    jProgressBar1.setValue(100);
                    jProgressBar1.setForeground(java.awt.Color.GREEN);

                    txtInfo.append("[" + tiempo() + "] ✓ Entregado en: " + destino.getNombre() + "\n");
                    txtTiempo.setText("Tiempo total: " + tiempo());
                    txtInfo.setCaretPosition(txtInfo.getDocument().getLength());
                });
            }

            @Override
            public void error(Producto p, String mensaje) {
                SwingUtilities.invokeLater(() -> {
                    jProgressBar1.setForeground(java.awt.Color.RED);

                    txtInfo.append("[" + tiempo() + "] ✗ Error: " + mensaje + "\n");
                    txtTiempo.setText("Error en: " + tiempo());
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
        jProgressBar1.setValue(porcentaje);

        // cambiar color según avance
        if (porcentaje < 30) {
            jProgressBar1.setForeground(java.awt.Color.RED);
        } else if (porcentaje < 70) {
            jProgressBar1.setForeground(java.awt.Color.ORANGE);
        } else {
            jProgressBar1.setForeground(java.awt.Color.GREEN);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        txtOrigen = new javax.swing.JLabel();
        txtRuta = new javax.swing.JLabel();
        txtDestino = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();
        txtTiempo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txtOrigen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtRuta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDestino.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtInfo.setEditable(false);
        txtInfo.setBackground(new java.awt.Color(204, 204, 255));
        txtInfo.setColumns(20);
        txtInfo.setForeground(new java.awt.Color(0, 0, 0));
        txtInfo.setRows(5);
        jScrollPane1.setViewportView(txtInfo);

        txtTiempo.setText("jLabel1");
        txtTiempo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(137, 137, 137))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                        .addGap(62, 62, 62)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRuta, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(txtDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txtDestino;
    private javax.swing.JTextArea txtInfo;
    private javax.swing.JLabel txtOrigen;
    private javax.swing.JLabel txtRuta;
    private javax.swing.JLabel txtTiempo;
    // End of variables declaration//GEN-END:variables
}
