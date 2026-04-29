package com.ronaldo.gestor.front.paneles;

import com.ronaldo.gestor.back.controlador.Controlador;
import com.ronaldo.gestor.back.sucursal.Sucursal;
import com.ronaldo.gestor.front.dialogs.NuevaSucursalDialog;
import com.ronaldo.gestor.front.frame.FrameGeneral;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class PanelSucursal extends javax.swing.JPanel {

    private Sucursal sucursal;
    private Controlador controlador;
    private PanelPrincipal panel;

    public PanelSucursal(Sucursal sucursal, Controlador controlador, PanelPrincipal panel) {
        initComponents();
        this.panel= panel;
        this.sucursal = sucursal;
        this.controlador = controlador;
        txtID.setText(sucursal.getId());
        txtNombre1.setText(sucursal.getNombre());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtID = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JLabel();
        btnIr = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtID.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N

        txtNombre1.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N

        btnIr.setBackground(new java.awt.Color(0, 204, 102));
        btnIr.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        btnIr.setForeground(new java.awt.Color(0, 0, 0));
        btnIr.setText("IR");
        btnIr.addActionListener(this::btnIrActionPerformed);

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("ELIMIAR");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnEditar.setBackground(new java.awt.Color(255, 204, 51));
        btnEditar.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnIr, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIr, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(txtNombre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Seguro que quieres Eliminar?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            System.out.println("Seleccionaste: SÍ");
           
        } else {
            System.out.println("Seleccionaste: CANCELAR o cerraste la ventana");
            
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrActionPerformed
         FrameGeneral.ponerPanelEnFramePrincipal(new PanelMenuSucursal(sucursal, controlador, panel));
    }//GEN-LAST:event_btnIrActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        NuevaSucursalDialog dialog = new NuevaSucursalDialog(controlador.getGrafo(), true, sucursal);
        dialog.setVisible(true);
        panel.cargarSucursales();
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIr;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtNombre1;
    // End of variables declaration//GEN-END:variables
}
