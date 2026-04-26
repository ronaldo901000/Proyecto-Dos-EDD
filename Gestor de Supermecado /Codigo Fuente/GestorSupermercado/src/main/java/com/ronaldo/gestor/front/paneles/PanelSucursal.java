package com.ronaldo.gestor.front.paneles;

import com.ronaldo.gestor.back.controlador.Controlador;
import com.ronaldo.gestor.back.sucursal.Sucursal;
import com.ronaldo.gestor.front.frame.FrameGeneral;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class PanelSucursal extends javax.swing.JPanel {

    private Sucursal sucursal;
    private Controlador controlador;

    public PanelSucursal(Sucursal sucursal, Controlador controlador) {
        initComponents();
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
        jButton1 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtID.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N

        txtNombre1.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 204, 102));
        jButton1.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jButton1.setText("IR");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE)
                .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(21, 21, 21)
                .addComponent(btnEliminar)
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            // Aquí va tu lógica para "Cancelar"
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         FrameGeneral.ponerPanelEnFramePrincipal(new PanelMenuSucursal(sucursal, controlador));
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtNombre1;
    // End of variables declaration//GEN-END:variables
}
