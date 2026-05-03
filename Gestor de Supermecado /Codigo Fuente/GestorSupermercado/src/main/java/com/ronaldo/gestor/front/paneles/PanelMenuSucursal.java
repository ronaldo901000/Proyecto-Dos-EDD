package com.ronaldo.gestor.front.paneles;

import com.ronaldo.gestor.analisisRendimiento.AnalizadorRendimiento;
import com.ronaldo.gestor.analisisRendimiento.ResultadoRendimiento;
import com.ronaldo.gestor.back.controlador.Controlador;
import com.ronaldo.gestor.back.estructuras.grafo.Arista;
import com.ronaldo.gestor.back.estructuras.lista.Lista;
import com.ronaldo.gestor.back.estructuras.lista.generica.ListaEnlazadaGenerica;
import com.ronaldo.gestor.back.estructuras.lista.normal.ListaEnlazada;
import com.ronaldo.gestor.back.estructuras.lista.ordenada.ListaEnlazadaOrdenada;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.exceptions.EstructuraVaciaException;
import com.ronaldo.gestor.back.exceptions.ListaException;
import com.ronaldo.gestor.back.producto.Producto;
import com.ronaldo.gestor.back.sucursal.Sucursal;
import com.ronaldo.gestor.front.dialogs.ColasDespachoDialog;
import com.ronaldo.gestor.front.dialogs.NuevaConexionDialog;
import com.ronaldo.gestor.front.dialogs.NuevoProductoDialog;
import com.ronaldo.gestor.front.dialogs.PilaErroneosDialog;
import com.ronaldo.gestor.front.frame.FrameGeneral;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author ronaldo
 */
public class PanelMenuSucursal extends javax.swing.JPanel {

    private Controlador controlador;
    private Sucursal sucursal;
    private PanelPrincipal principal;

    public PanelMenuSucursal(Sucursal sucursal, Controlador controlador, PanelPrincipal principal) {
        initComponents();
        this.controlador = controlador;
        this.principal = principal;
        this.sucursal = sucursal;

        txtTIngreso.setText("Tiempo Ingreso: " + sucursal.getTiempoIngreso() + "s");
        txtTPreparacion.setText("Tiempo preparacion de traspaso: " + sucursal.getTiempoTraspaso() + "s");
        txtIntervalo.setText("Intervalo de despacho: " + sucursal.getIntervaloDespacho() + "s");

        txtNombre.setText("Sucursal: " + sucursal.getNombre());
        txtUbicacion.setText("Ubicacion: " + sucursal.getUbicacion());
        txtID.setText("ID: " + sucursal.getId());
        txtTotalProductos.setText("Total de Productos: " + sucursal.getListaDesordenada().getTamaño());
        cargarConexiones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEncabezado = new javax.swing.JPanel();
        txtNombre = new javax.swing.JLabel();
        txtUbicacion = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        txtTotalProductos = new javax.swing.JLabel();
        txtTIngreso = new javax.swing.JLabel();
        txtTPreparacion = new javax.swing.JLabel();
        txtIntervalo = new javax.swing.JLabel();
        panelContenido = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        fieldBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbTipoBusqueda = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtFInicial = new javax.swing.JTextField();
        txtFFinal = new javax.swing.JTextField();
        btnBuscarPoFechas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaResultado = new javax.swing.JTable();
        btnListar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConexiones = new javax.swing.JTable();
        btnAgregarConex = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnVerAVL = new javax.swing.JButton();
        btnB = new javax.swing.JButton();
        btnBMas = new javax.swing.JButton();
        btnVerHash = new javax.swing.JButton();
        btnPilaErroneos = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        spnN = new javax.swing.JSpinner();
        spnM = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        btnIniciarAnalisis = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        txtAleatorio = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaAleatorio = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        txtPrimero = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaPrimero = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        txtUltimo = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaUltimo = new javax.swing.JTable();

        panelEncabezado.setBackground(new java.awt.Color(204, 255, 204));
        panelEncabezado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        txtNombre.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N

        txtUbicacion.setFont(new java.awt.Font("Liberation Sans", 0, 21)); // NOI18N

        txtID.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N

        btnRegresar.setBackground(new java.awt.Color(51, 102, 255));
        btnRegresar.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(this::btnRegresarActionPerformed);

        txtTotalProductos.setFont(new java.awt.Font("Liberation Sans", 1, 21)); // NOI18N

        txtTIngreso.setFont(new java.awt.Font("Liberation Sans", 0, 21)); // NOI18N

        txtTPreparacion.setFont(new java.awt.Font("Liberation Sans", 0, 21)); // NOI18N

        txtIntervalo.setFont(new java.awt.Font("Liberation Sans", 0, 21)); // NOI18N

        javax.swing.GroupLayout panelEncabezadoLayout = new javax.swing.GroupLayout(panelEncabezado);
        panelEncabezado.setLayout(panelEncabezadoLayout);
        panelEncabezadoLayout.setHorizontalGroup(
            panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEncabezadoLayout.createSequentialGroup()
                        .addComponent(txtUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTPreparacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIntervalo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(109, 109, 109))
                    .addGroup(panelEncabezadoLayout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelEncabezadoLayout.setVerticalGroup(
            panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEncabezadoLayout.createSequentialGroup()
                .addGroup(panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEncabezadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotalProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTPreparacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIntervalo, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                    .addGroup(panelEncabezadoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelContenido.setBackground(new java.awt.Color(255, 255, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 236));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMaximumSize(new java.awt.Dimension(3500, 1500));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("INVENTARIO");

        jPanel2.setBackground(new java.awt.Color(192, 218, 192));

        fieldBuscar.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Buscar Producto");

        cmbTipoBusqueda.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        cmbTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALV (Nombre)", "Hash (Codigo Barras)", "B+ (Categoria)", "Lista Ordenada  (Codigo Barras)", "Lista Desordenada  (Codigo Barras)" }));

        btnBuscar.setBackground(new java.awt.Color(209, 209, 54));
        btnBuscar.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        btnBuscarPoFechas.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        btnBuscarPoFechas.setText("Buscar");
        btnBuscarPoFechas.addActionListener(this::btnBuscarPoFechasActionPerformed);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Fecha Inicial");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha Final");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(txtFFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(btnBuscarPoFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBuscarPoFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 124, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(cmbTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnInsertar.setBackground(new java.awt.Color(0, 153, 51));
        btnInsertar.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        btnInsertar.setForeground(new java.awt.Color(0, 0, 0));
        btnInsertar.setText("AGREGAR NUEVO PRODUCTO");
        btnInsertar.addActionListener(this::btnInsertarActionPerformed);

        btnEliminar.setBackground(new java.awt.Color(255, 51, 0));
        btnEliminar.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("ELIMINAR PRODUCTO");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        tablaResultado.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        tablaResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Codigo", "Nombre", "Categoria", "Fecha Vencimiento", "Marca", "Precio", "Existencias", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaResultado);

        btnListar.setBackground(new java.awt.Color(51, 204, 255));
        btnListar.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        btnListar.setForeground(new java.awt.Color(0, 0, 0));
        btnListar.setText("LISTAR IN-ORDEN");
        btnListar.addActionListener(this::btnListarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInsertar)
                        .addGap(90, 90, 90)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 236));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CONEXIONES");

        tablaConexiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Costo", "Tiempo", "ID Destino"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaConexiones);

        btnAgregarConex.setText("AGREGAR");
        btnAgregarConex.addActionListener(this::btnAgregarConexActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btnAgregarConex, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarConex, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 236));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("VISUALIZACIONES");

        btnVerAVL.setBackground(new java.awt.Color(255, 204, 102));
        btnVerAVL.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnVerAVL.setForeground(new java.awt.Color(0, 0, 0));
        btnVerAVL.setText("Ver Arbol AVL");
        btnVerAVL.addActionListener(this::btnVerAVLActionPerformed);

        btnB.setBackground(new java.awt.Color(255, 204, 102));
        btnB.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnB.setForeground(new java.awt.Color(0, 0, 0));
        btnB.setText("Ver Arbol B");
        btnB.addActionListener(this::btnBActionPerformed);

        btnBMas.setBackground(new java.awt.Color(255, 204, 102));
        btnBMas.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnBMas.setForeground(new java.awt.Color(0, 0, 0));
        btnBMas.setText("Ver Arbol B +");
        btnBMas.addActionListener(this::btnBMasActionPerformed);

        btnVerHash.setBackground(new java.awt.Color(255, 204, 102));
        btnVerHash.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnVerHash.setForeground(new java.awt.Color(0, 0, 0));
        btnVerHash.setText("Ver Tabla Hash");
        btnVerHash.addActionListener(this::btnVerHashActionPerformed);

        btnPilaErroneos.setBackground(new java.awt.Color(0, 204, 153));
        btnPilaErroneos.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnPilaErroneos.setForeground(new java.awt.Color(0, 0, 0));
        btnPilaErroneos.setText("Ver Pila Erroneos");
        btnPilaErroneos.addActionListener(this::btnPilaErroneosActionPerformed);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBMas, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(btnB, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(btnVerAVL, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(btnVerHash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPilaErroneos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVerAVL, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBMas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVerHash, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnPilaErroneos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 236));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ANALISIS RENDIMIENTO");

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Numero Consultas:");

        spnN.setFont(new java.awt.Font("Liberation Sans", 1, 21)); // NOI18N
        spnN.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        spnM.setFont(new java.awt.Font("Liberation Sans", 1, 21)); // NOI18N
        spnM.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 0, 19)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Numero Repeticiones:");

        btnIniciarAnalisis.setBackground(new java.awt.Color(0, 153, 102));
        btnIniciarAnalisis.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        btnIniciarAnalisis.setForeground(new java.awt.Color(0, 0, 0));
        btnIniciarAnalisis.setText("INICIAR");
        btnIniciarAnalisis.addActionListener(this::btnIniciarAnalisisActionPerformed);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(spnN, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spnM, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnIniciarAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spnM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spnN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnIniciarAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setOpaque(false);

        txtAleatorio.setFont(new java.awt.Font("Liberation Sans", 0, 13)); // NOI18N
        txtAleatorio.setForeground(new java.awt.Color(0, 0, 0));
        txtAleatorio.setText("Busqueda Aleatoria");

        tablaAleatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estructura", "Tiempo Promedio"
            }
        ));
        jScrollPane3.setViewportView(tablaAleatorio);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAleatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addGap(12, 12, 12)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAleatorio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addGap(10, 10, 10)))
        );

        jPanel9.setOpaque(false);

        txtPrimero.setFont(new java.awt.Font("Liberation Sans", 0, 13)); // NOI18N
        txtPrimero.setForeground(new java.awt.Color(0, 0, 0));
        txtPrimero.setText("Busqueda primero");

        tablaPrimero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estructura", "Tiempo Promedio"
            }
        ));
        jScrollPane4.setViewportView(tablaPrimero);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPrimero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addGap(12, 12, 12)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPrimero)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addGap(10, 10, 10)))
        );

        jPanel10.setOpaque(false);

        txtUltimo.setFont(new java.awt.Font("Liberation Sans", 0, 13)); // NOI18N
        txtUltimo.setForeground(new java.awt.Color(0, 0, 0));
        txtUltimo.setText("Busqueda ultimo");

        tablaUltimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estructura", "Tiempo Promedio"
            }
        ));
        jScrollPane5.setViewportView(tablaUltimo);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(txtUltimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                    .addGap(12, 12, 12)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(txtUltimo)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout panelContenidoLayout = new javax.swing.GroupLayout(panelContenido);
        panelContenido.setLayout(panelContenidoLayout);
        panelContenidoLayout.setHorizontalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelContenidoLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelContenidoLayout.setVerticalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelContenido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrameGeneral.ponerPanelEnFramePrincipal(principal);
        principal.actualizarTotalProductos();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        NuevoProductoDialog dialog = new NuevoProductoDialog(sucursal);
        dialog.setVisible(true);
        txtTotalProductos.setText("Total de Productos: " + sucursal.getListaDesordenada().getTamaño());
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String atributoBusqueda = fieldBuscar.getText();

        if (StringUtils.isBlank(atributoBusqueda)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debes ingresar un valor para buscar",
                    "Campo vacio",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        ListaEnlazadaOrdenada lista = new ListaEnlazadaOrdenada();
        int tipo = cmbTipoBusqueda.getSelectedIndex();

        try {
            switch (tipo) {

                case 0:
                    Producto pAVL = sucursal.getAvl().buscar(atributoBusqueda);
                    if (pAVL != null) {
                        lista.insertar(pAVL);
                    }
                    break;

                case 1:
                    Producto pHash = sucursal.getTablaHash().buscar(atributoBusqueda);
                    if (pHash != null) {
                        lista.insertar(pHash);
                    }
                    break;

                case 2:
                    lista = sucursal.getbMas().buscar(atributoBusqueda);
                    break;
                case 3:
                    Producto pOrdenada = sucursal.getListaOrdenada().getProductoPorCodigoBarra(atributoBusqueda);
                    lista.insertar(pOrdenada);
                    break;
                case 4:
                    Producto pDesordenada = sucursal.getListaDesordenada().getProductoPorCodigoBarra(atributoBusqueda);
                    lista.insertar(pDesordenada);
                    break;
            }

        } catch (ElementoNoEncontradoException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Producto no encontrado",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (lista == null || lista.getTamaño() == 0) {
            limpiarTabla();
            JOptionPane.showMessageDialog(
                    this,
                    "No se encontró ningún producto con: " + atributoBusqueda,
                    "Sin resultados",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        cargarTablaProductos(lista);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarPoFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPoFechasActionPerformed
        String fInicial = txtFInicial.getText();
        String fFinal = txtFFinal.getText();

        if (StringUtils.isBlank(fInicial) || StringUtils.isBlank(fFinal)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ambos campos deben de llenarse",
                    "Campo vacio",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        ListaEnlazada lista = sucursal.getB().buscar(fInicial, fFinal);

        if (lista.estaVacia()) {
            limpiarTabla();
            JOptionPane.showMessageDialog(
                    this,
                    "No se encontró ningún producto en el rango de: " + fInicial + " y " + fFinal,
                    "Sin resultados",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        cargarTablaProductos(lista);
    }//GEN-LAST:event_btnBuscarPoFechasActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        ListaEnlazada lista = sucursal.getAvl().listar();

        if (lista.estaVacia()) {
            limpiarTabla();
            JOptionPane.showMessageDialog(
                    this,
                    "No hay productos Registrados",
                    "Sin resultados",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        cargarTablaProductos(lista);
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        String texto = JOptionPane.showInputDialog("Ingrese el codigo de barras del producto:");

        if (texto != null) {
            try {
                sucursal.eliminar(texto);
                JOptionPane.showMessageDialog(
                        this,
                        "Eliminacion exitosa",
                        "Exito",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } catch (ElementoNoEncontradoException | EstructuraVaciaException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Error al eliminar: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        txtTotalProductos.setText("Total de Productos: " + sucursal.getListaDesordenada().getTamaño());
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnVerAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerAVLActionPerformed
        try {
            sucursal.getAvl().generarImagen("avl-" + this.sucursal.getInfo() + ".pdf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al generar el árbol: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerAVLActionPerformed

    private void btnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBActionPerformed
        try {
            sucursal.getB().generarImagen("b-" + this.sucursal.getInfo() + ".pdf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al generar el árbol: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBActionPerformed

    private void btnBMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBMasActionPerformed
        try {
            sucursal.getbMas().generarImagen("b-mas-" + this.sucursal.getInfo() + ".pdf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al generar el árbol: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBMasActionPerformed

    private void btnAgregarConexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarConexActionPerformed
        NuevaConexionDialog dialog = new NuevaConexionDialog(sucursal, controlador.getGrafo());
        dialog.setVisible(true);
        cargarConexiones();
    }//GEN-LAST:event_btnAgregarConexActionPerformed

    private void btnIniciarAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarAnalisisActionPerformed

        if(sucursal.getListaDesordenada().estaVacia()){
            return;
        }
        
        int n = (int) spnN.getValue();
        int m = (int) spnM.getValue();

        AnalizadorRendimiento analizador = new AnalizadorRendimiento(sucursal, n, m);

        try {
            ListaEnlazadaGenerica<ResultadoRendimiento> aleatorio = analizador.buscarAleatorio();
            cargarTablaRendimiento(tablaAleatorio, aleatorio, "Aleatoria", txtAleatorio);

            ListaEnlazadaGenerica<ResultadoRendimiento> primero = analizador.buscarExtremo(0);
            cargarTablaRendimiento(tablaPrimero, primero, "Primero", txtPrimero);

            ListaEnlazadaGenerica<ResultadoRendimiento> ultimo = analizador.buscarExtremo(sucursal.getListaOrdenada().getTamaño() - 1);
            cargarTablaRendimiento(tablaUltimo, ultimo, "Ultimo", txtUltimo);

        } catch (ElementoNoEncontradoException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error al cargar resultados en tabla: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }//GEN-LAST:event_btnIniciarAnalisisActionPerformed

    private void btnVerHashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerHashActionPerformed
        try {
            sucursal.getTablaHash().generarImagen("tabla-hash-" + this.sucursal.getInfo() + ".pdf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al generar el tabla hash: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerHashActionPerformed

    private void btnPilaErroneosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilaErroneosActionPerformed
        PilaErroneosDialog dialog = new PilaErroneosDialog(sucursal);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnPilaErroneosActionPerformed

    private void cargarTablaRendimiento(JTable tabla, ListaEnlazadaGenerica<ResultadoRendimiento> lista, String busqueda, JLabel label) {

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);

        try {
            label.setText(busqueda + ": " + lista.obtenerValor(0).getProducto().getInfo());
        } catch (ListaException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error al cargar label: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        for (int i = 0; i < lista.getTamaño(); i++) {
            try {
                ResultadoRendimiento r = lista.obtenerValor(i);

                modelo.addRow(new Object[]{
                    r.getNombreEstructura(),
                    r.getTiempoPromedio() + " μs",});

            } catch (ListaException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Error al cargar datos: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private void cargarTablaProductos(Lista lista) {

        DefaultTableModel modelo = (DefaultTableModel) tablaResultado.getModel();
        modelo.setRowCount(0);

        for (int i = 0; i < lista.getTamaño(); i++) {
            try {
                Producto p = lista.obtener(i);
                String estado = "Disponible";
                if (!p.isDisponible()) {
                    estado = "En transito";
                }

                modelo.addRow(new Object[]{
                    i + 1,
                    p.getCodigoBarra(),
                    p.getNombre(),
                    p.getCategoria(),
                    p.getFechaVencimiento(),
                    p.getMarca(),
                    "Q." + p.getPrecio(),
                    p.getExistencias(),
                    estado
                });

            } catch (ElementoNoEncontradoException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Error al cargar datos: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private void cargarConexiones() {
        DefaultTableModel modelo = (DefaultTableModel) tablaConexiones.getModel();
        modelo.setRowCount(0);

        for (int i = 0; i < sucursal.getListaConexiones().getTamaño(); i++) {
            Arista a;
            try {
                a = sucursal.getListaConexiones().obtenerValor(i);
                modelo.addRow(new Object[]{
                    a.getCosto(),
                    a.getTiempo(),
                    a.getIdDestino()
                });
            } catch (ListaException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Error al cargar datos: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        }

    }

    private void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaConexiones.getModel();
        modelo.setRowCount(0);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarConex;
    private javax.swing.JButton btnB;
    private javax.swing.JButton btnBMas;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarPoFechas;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIniciarAnalisis;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnPilaErroneos;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerAVL;
    private javax.swing.JButton btnVerHash;
    private javax.swing.JComboBox<String> cmbTipoBusqueda;
    private javax.swing.JTextField fieldBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelEncabezado;
    private javax.swing.JSpinner spnM;
    private javax.swing.JSpinner spnN;
    private javax.swing.JTable tablaAleatorio;
    private javax.swing.JTable tablaConexiones;
    private javax.swing.JTable tablaPrimero;
    private javax.swing.JTable tablaResultado;
    private javax.swing.JTable tablaUltimo;
    private javax.swing.JLabel txtAleatorio;
    private javax.swing.JTextField txtFFinal;
    private javax.swing.JTextField txtFInicial;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtIntervalo;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtPrimero;
    private javax.swing.JLabel txtTIngreso;
    private javax.swing.JLabel txtTPreparacion;
    private javax.swing.JLabel txtTotalProductos;
    private javax.swing.JLabel txtUbicacion;
    private javax.swing.JLabel txtUltimo;
    // End of variables declaration//GEN-END:variables
}
