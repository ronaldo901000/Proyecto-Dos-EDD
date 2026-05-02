package com.ronaldo.gestor.front.dialogs;

import com.ronaldo.gestor.back.controlador.Controlador;
import com.ronaldo.gestor.back.estructuras.lista.generica.ListaEnlazadaGenerica;
import com.ronaldo.gestor.back.estructuras.lista.normal.ListaEnlazada;
import com.ronaldo.gestor.back.exceptions.ElementoExistenteException;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.exceptions.LecturaException;
import com.ronaldo.gestor.back.exceptions.ListaException;
import com.ronaldo.gestor.back.lectura.LectorConexiones;
import com.ronaldo.gestor.back.lectura.LectorProductos;
import com.ronaldo.gestor.back.lectura.LectorSucursales;
import com.ronaldo.gestor.back.sucursal.Sucursal;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ronaldo
 */
public class CargaCSVDialog extends javax.swing.JDialog {

    private ListaEnlazadaGenerica<Sucursal> sucursales;
    private Controlador controlador;

    public CargaCSVDialog(Controlador controlador) {
        initComponents();
        this.controlador = controlador;
        this.setLocationRelativeTo(null);
        btnCargar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        rbSucursales = new javax.swing.JRadioButton();
        rbCatalogoSucursales = new javax.swing.JRadioButton();
        rbConexionSucursales = new javax.swing.JRadioButton();
        btnCargar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setBackground(new java.awt.Color(204, 255, 153));
        jLabel1.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CARGA DE CSV");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jLabel1.setOpaque(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setOpaque(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setOpaque(false);

        rbSucursales.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroup1.add(rbSucursales);
        rbSucursales.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 24)); // NOI18N
        rbSucursales.setForeground(new java.awt.Color(0, 0, 0));
        rbSucursales.setText("Sucursales");
        rbSucursales.addActionListener(this::rbSucursalesActionPerformed);

        rbCatalogoSucursales.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroup1.add(rbCatalogoSucursales);
        rbCatalogoSucursales.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 24)); // NOI18N
        rbCatalogoSucursales.setForeground(new java.awt.Color(0, 0, 0));
        rbCatalogoSucursales.setText("Catalogo de Productos");
        rbCatalogoSucursales.addActionListener(this::rbCatalogoSucursalesActionPerformed);

        rbConexionSucursales.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroup1.add(rbConexionSucursales);
        rbConexionSucursales.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 24)); // NOI18N
        rbConexionSucursales.setForeground(new java.awt.Color(0, 0, 0));
        rbConexionSucursales.setText("Conexión entre Sucursales");
        rbConexionSucursales.addActionListener(this::rbConexionSucursalesActionPerformed);

        btnCargar.setText("CARGAR");
        btnCargar.addActionListener(this::btnCargarActionPerformed);

        jLabel2.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Selecciona la ruta del Archivo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(rbSucursales)
                        .addGap(210, 210, 210))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbCatalogoSucursales)
                            .addComponent(rbConexionSucursales))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(rbSucursales)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbConexionSucursales)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbCatalogoSucursales))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jButton2.setText("SALIR");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbSucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSucursalesActionPerformed
        btnCargar.setEnabled(true);
    }//GEN-LAST:event_rbSucursalesActionPerformed

    private void rbConexionSucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbConexionSucursalesActionPerformed
        btnCargar.setEnabled(true);
    }//GEN-LAST:event_rbConexionSucursalesActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed

        JFileChooser chooser = new JFileChooser("/home/ronaldo/Documentos/2026/Cursos/2. Estructura de Datos/Proyectos y Enunciados/Proyectos/3. Proyecto Dos/Gestor de Supermecado /CSV");

        chooser.setDialogTitle("Carga de CSV");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo CSV", "csv");
        chooser.setFileFilter(filtro);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        int resultado = chooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {

            String ruta = chooser.getSelectedFile().getAbsolutePath();

            if (rbSucursales.isSelected()) {
                LectorSucursales lector = new LectorSucursales();

                try {
                    sucursales = lector.leerCSVSucursales(ruta);

                    if (lector.isHayErrores()) {
                        JOptionPane.showMessageDialog(
                                this,
                                "Hay Errores en el csv, Revisa errors.log \n Se agregaron " + lector.getTotalSucursales() + " sucursales nuevas.",
                                "Carga exitosa",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    } else {
                        JOptionPane.showMessageDialog(
                                this,
                                "Carga exitosa, se agregaron " + lector.getTotalSucursales() + " sucursales nuevas.",
                                "Carga exitosa",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }

                } catch (LecturaException ex) {
                    JOptionPane.showMessageDialog(
                            this,
                            ex.getMessage(),
                            "Hay errores",
                            JOptionPane.ERROR_MESSAGE);
                }

            } else if (rbConexionSucursales.isSelected()) {
                LectorConexiones lector = controlador.getlConexiones();

                try {
                    lector.leerCSVConexion(ruta);

                    if (lector.isHayErrores()) {
                        JOptionPane.showMessageDialog(
                                this,
                                "Hay Errores en el csv, Revisa errors.log \n Se agregaron " + lector.getTotalConexiones() + " conexiones nuevas.",
                                "Carga exitosa",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    } else {
                        JOptionPane.showMessageDialog(
                                this,
                                "Carga exitosa, se agregaron " + lector.getTotalConexiones() + " conexiones nuevas.",
                                "Carga exitosa",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }

                } catch (LecturaException | ElementoNoEncontradoException ex) {
                    JOptionPane.showMessageDialog(
                            this,
                            ex.getMessage(),
                            "Hay errores",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else if (rbCatalogoSucursales.isSelected()) {
                LectorProductos lector = new LectorProductos();
                try {

                    lector.leerCSVProductos(ruta, controlador.getGrafo().getLista());

                    if (lector.isHayErrores()) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Hay Errores en el csv, Revisa errors.log",
                                "Carga",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    } else {
                        JOptionPane.showMessageDialog(
                                this,
                                "Carga exitosa CVS sin errores",
                                "Carga exitosa",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                } catch (LecturaException | IOException | ListaException ex) {

                    JOptionPane.showMessageDialog(
                            this,
                            ex.getMessage(),
                            "Hay errores",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        this.dispose();
    }//GEN-LAST:event_btnCargarActionPerformed

    private void rbCatalogoSucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCatalogoSucursalesActionPerformed
        btnCargar.setEnabled(true);
    }//GEN-LAST:event_rbCatalogoSucursalesActionPerformed

    public ListaEnlazadaGenerica<Sucursal> getSucursales() {
        return this.sucursales;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton rbCatalogoSucursales;
    private javax.swing.JRadioButton rbConexionSucursales;
    private javax.swing.JRadioButton rbSucursales;
    // End of variables declaration//GEN-END:variables
}
