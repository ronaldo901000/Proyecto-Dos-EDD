package com.ronaldo.gestor.front.paneles;

import com.ronaldo.gestor.back.estructuras.grafo.Grafo;
import com.ronaldo.gestor.back.estructuras.lista.generica.ListaEnlazadaGenerica;
import com.ronaldo.gestor.back.exceptions.ListaException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author ronaldo
 */
public class PanelGrafoTransferencias extends JPanel {

    private ListaEnlazadaGenerica<String> mensajes = new ListaEnlazadaGenerica<>();
    private ListaEnlazadaGenerica<Color> colores = new ListaEnlazadaGenerica<>();
    private ListaEnlazadaGenerica<String> idsNodos = new ListaEnlazadaGenerica<>();
    private ListaEnlazadaGenerica<Color> coloresNodos = new ListaEnlazadaGenerica<>();
    private String aristaActiva = null;
    private Grafo grafo;

    public PanelGrafoTransferencias() {
        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int separador = (int) (getWidth() * 0.70);

        dibujarGrafo(g2, 0, 0, separador, getHeight());

        g2.setColor(Color.GRAY);
        g2.drawLine(separador, 0, separador, getHeight());

        dibujarLog(g2, separador + 10, 20);
    }

    private void dibujarLog(Graphics2D g2, int x, int y) {
        g2.setFont(new Font("Monospaced", Font.PLAIN, 11));
        int lineHeight = 16;
        for (int i = 0; i < mensajes.getTamaño(); i++) {
            try {
                g2.setColor(colores.obtenerValor(i));
                g2.drawString(mensajes.obtenerValor(i), x, y + (i * lineHeight));
            } catch (ListaException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void dibujarGrafo(Graphics2D g2, int x, int y, int w, int h) {
        // aquí dibujas nodos y aristas
    }

    public void agregarMensaje(String texto, Color color) {
        mensajes.agregarElemento(texto);
        colores.agregarElemento(color);
        repaint();
    }

    public void resaltarNodo(String idSucursal, Color color) {
        idsNodos.agregarElemento(idSucursal);
        coloresNodos.agregarElemento(color);
        repaint();
    }

    public void resaltarArista(String idOrigen, String idDestino, Color color) {
        aristaActiva = idOrigen + "-" + idDestino;
        repaint();
    }

    public void limpiar() {
        mensajes = new ListaEnlazadaGenerica<>();
        colores = new ListaEnlazadaGenerica<>();
        repaint();
    }

    public void limpiarRuta() {
        idsNodos = new ListaEnlazadaGenerica<>();
        coloresNodos = new ListaEnlazadaGenerica<>();
        aristaActiva = null;
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
