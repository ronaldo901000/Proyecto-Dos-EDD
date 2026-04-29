package com.ronaldo.gestor.front.paneles;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PanelGrafo extends JPanel {

    private BufferedImage imagen;
    private double zoom = 1.0;
    private int offsetX = 0, offsetY = 0;
    private int lastX, lastY;

    public PanelGrafo(String rutaImagen) {
        try {
            imagen = ImageIO.read(new File(rutaImagen));
        } catch (Exception e) {
            System.err.println("Error al cargar imagen: " + e.getMessage());
        }

        setBackground(Color.DARK_GRAY);

        // Zoom con rueda
        addMouseWheelListener(e -> {
            double factor = e.getWheelRotation() < 0 ? 1.1 : 0.9;
            double zoomAnterior = zoom;
            zoom = Math.max(0.1, Math.min(zoom * factor, 10.0));

            offsetX = (int) (e.getX() - (e.getX() - offsetX) * (zoom / zoomAnterior));
            offsetY = (int) (e.getY() - (e.getY() - offsetY) * (zoom / zoomAnterior));
            repaint();
        });

        // Drag
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lastX = e.getX();
                lastY = e.getY();
                setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
            }

            public void mouseReleased(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                offsetX += e.getX() - lastX;
                offsetY += e.getY() - lastY;
                lastX = e.getX();
                lastY = e.getY();
                repaint();
            }
        });
    }

    public void resetVista() {
        zoom = 1.0;
        offsetX = 0;
        offsetY = 0;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen == null) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        int w = (int) (imagen.getWidth() * zoom);
        int h = (int) (imagen.getHeight() * zoom);
        g2d.drawImage(imagen, offsetX, offsetY, w, h, this);
    }
}
