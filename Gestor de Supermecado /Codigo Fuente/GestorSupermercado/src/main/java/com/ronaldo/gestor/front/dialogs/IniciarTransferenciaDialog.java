package com.ronaldo.gestor.front.dialogs;

import com.ronaldo.gestor.back.estructuras.grafo.Grafo;
import com.ronaldo.gestor.back.estructuras.lista.generica.ListaEnlazadaGenerica;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.exceptions.ListaException;
import com.ronaldo.gestor.back.producto.Producto;
import com.ronaldo.gestor.back.sucursal.Sucursal;
import com.ronaldo.gestor.front.paneles.PanelPrincipal;
import com.ronaldo.gestor.front.paneles.ProgresoPanel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class IniciarTransferenciaDialog extends javax.swing.JDialog {

    private Grafo grafo;
    private PanelPrincipal principal;
    private ListaEnlazadaGenerica<Sucursal> sucursales;
    private Sucursal origen;
    private Producto producto;
    private Sucursal destino;
    private boolean esTiempo;

    public IniciarTransferenciaDialog(ListaEnlazadaGenerica<Sucursal> sucursales, Grafo grafo, PanelPrincipal principal) {
        initComponents();
        this.sucursales = sucursales;
        this.grafo = grafo;
        this.principal = principal;
        btnIniciar.setEnabled(false);
        btnProducto.setEnabled(false);
        btnDestino.setEnabled(false);
        btnCriterio.setEnabled(false);
        cargarComboBoxSucursales(cmbOrigen);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbOrigen = new javax.swing.JComboBox<>();
        btnOrigen = new javax.swing.JButton();
        cmbProductos = new javax.swing.JComboBox<>();
        btnProducto = new javax.swing.JButton();
        cmbDestino = new javax.swing.JComboBox<>();
        btnDestino = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        cmbCriterio = new javax.swing.JComboBox<>();
        btnCriterio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(255, 51, 51));
        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANSFERENCIA DE PRODUCTOS");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel1.setOpaque(true);

        cmbOrigen.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N

        btnOrigen.setText("Seleccionar Origen");
        btnOrigen.addActionListener(this::btnOrigenActionPerformed);

        cmbProductos.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N

        btnProducto.setText("Seleccionar Producto");
        btnProducto.addActionListener(this::btnProductoActionPerformed);

        cmbDestino.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N

        btnDestino.setText("Seleccionar Destino");
        btnDestino.addActionListener(this::btnDestinoActionPerformed);

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(this::btnIniciarActionPerformed);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        cmbCriterio.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        cmbCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiempo mínimo de envío", "Costo más bajo" }));
        cmbCriterio.setToolTipText("");

        btnCriterio.setText("Seleccionar Criterio ");
        btnCriterio.addActionListener(this::btnCriterioActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCriterio, 0, 511, Short.MAX_VALUE)
                    .addComponent(cmbDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbProductos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(129, 129, 129))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbDestino)
                    .addComponent(btnDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbCriterio)
                    .addComponent(btnCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrigenActionPerformed
        int indiceSeleccionado = cmbOrigen.getSelectedIndex();

        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor selecciona una sucursal origen",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        try {

            this.origen = sucursales.obtenerValor(indiceSeleccionado);
            cargarProductos();
            btnProducto.setEnabled(true);

        } catch (ListaException ex) {
        }
    }//GEN-LAST:event_btnOrigenActionPerformed

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        int indiceSeleccionado = cmbProductos.getSelectedIndex();

        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor selecciona un producto",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        try {

            this.producto = origen.getListaDesordenada().obtener(indiceSeleccionado);

            if (!this.producto.isDisponible()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Este producto esta en una transferencia en curso, no disponible",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            btnDestino.setEnabled(true);
            cargarComboBoxSucursales(cmbDestino);

        } catch (ElementoNoEncontradoException ex) {
        }
    }//GEN-LAST:event_btnProductoActionPerformed

    private void btnDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDestinoActionPerformed
        int indiceSeleccionado = cmbDestino.getSelectedIndex();

        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor selecciona una sucursal destino",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        try {

            this.destino = sucursales.obtenerValor(indiceSeleccionado);

            if (this.destino.getId().equals(this.origen.getId())) {
                JOptionPane.showMessageDialog(
                        this,
                        "Por favor selecciona una sucursal destino, diferente del origen",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                
                return;
            }
            

            btnCriterio.setEnabled(true);

        } catch (ListaException ex) {

        }
    }//GEN-LAST:event_btnDestinoActionPerformed

    private void btnCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriterioActionPerformed
        int indiceSeleccionado = cmbCriterio.getSelectedIndex();

        if (indiceSeleccionado == 0) {
            this.esTiempo = true;
        }
        this.btnIniciar.setEnabled(true);
    }//GEN-LAST:event_btnCriterioActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        try {
            ListaEnlazadaGenerica<Sucursal> ruta = grafo.ejecutarDijkstra(origen.getId(), destino.getId(), esTiempo);

            if (ruta.getTamaño() == 0) {
                JOptionPane.showMessageDialog(this,
                        "No existe una ruta posible entre " + origen.getInfo() + " y " + destino.getInfo(),
                        "Sin ruta",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            ProgresoPanel progreso = new ProgresoPanel(producto, ruta, grafo, esTiempo);
            producto.setDisponible(false);
            principal.agregarTransferencia(progreso);
            this.dispose();

        } catch (ListaException | ElementoNoEncontradoException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }//GEN-LAST:event_btnIniciarActionPerformed

    public Sucursal getOrigen() {
        return origen;
    }

    public Producto getProducto() {
        return producto;
    }

    public Sucursal getDestino() {
        return destino;
    }

    public boolean isEsTiempo() {
        return esTiempo;
    }

    private void cargarComboBoxSucursales(JComboBox<String> cmb) {
        for (int i = 0; i < sucursales.getTamaño(); i++) {
            Sucursal s;
            try {
                s = sucursales.obtenerValor(i);
                cmb.addItem("(" + s.getId() + ")   " + s.getNombre());
            } catch (ListaException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    private void cargarProductos() {
        for (int i = 0; i < origen.getListaDesordenada().getTamaño(); i++) {
            Producto p;
            try {
                p = origen.getListaDesordenada().obtener(i);
                cmbProductos.addItem("(" + p.getCodigoBarra() + ")   " + p.getNombre());
            } catch (ElementoNoEncontradoException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriterio;
    private javax.swing.JButton btnDestino;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnOrigen;
    private javax.swing.JButton btnProducto;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbCriterio;
    private javax.swing.JComboBox<String> cmbDestino;
    private javax.swing.JComboBox<String> cmbOrigen;
    private javax.swing.JComboBox<String> cmbProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
