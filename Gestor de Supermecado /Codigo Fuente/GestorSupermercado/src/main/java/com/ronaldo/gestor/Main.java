package com.ronaldo.gestor;

import com.ronaldo.gestor.back.estructuras.arbol.avl.ArbolAVL;
import com.ronaldo.gestor.back.estructuras.arbol.b.ArbolB;
import com.ronaldo.gestor.back.estructuras.arbol.bmas.ArbolBMas;
import com.ronaldo.gestor.back.exceptions.ElementoExistenteException;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.producto.Producto;
import com.ronaldo.gestor.front.frame.FrameGeneral;

/**
 *
 * @author ronaldo
 */
public class Main {

    public static void main(String[] args) {

        /*
        ArbolAVL avl = new ArbolAVL();
        ArbolB b = new ArbolB();
        ArbolBMas bMas = new ArbolBMas();

        Producto[] productos = new Producto[25];

        productos[0] = new Producto("Leche Entera 1L", "750102030401", "Lacteos", "2026-06-15", "Lala", 25.50, 100);
        productos[1] = new Producto("Yogurt Griego", "750102030402", "Lacteos", "2026-05-20", "Chobani", 18.00, 50);
        productos[2] = new Producto("Queso Panela", "750102030403", "Lacteos", "2026-05-10", "Nochebuena", 65.00, 30);
        productos[3] = new Producto("Mantequilla Sin Sal", "750102030404", "Lacteos", "2026-08-01", "Gloria", 32.50, 45);
        productos[4] = new Producto("Crema Ácida", "750102030405", "Lacteos", "2026-05-30", "Alpura", 22.00, 60);
        
        
        productos[5] = new Producto("Arroz Blanco 1kg", "740102030501", "Abarrotes", "2027-12-01", "Verde Valle", 35.00, 200);
        productos[6] = new Producto("Frijol Negro 1kg", "740102030502", "Abarrotes", "2027-10-15", "Isadora", 38.50, 150);
        productos[7] = new Producto("Aceite de Oliva", "740102030503", "Abarrotes", "2028-01-20", "Carbonell", 145.00, 40);
        productos[8] = new Producto("Pasta Spaghetti", "740102030504", "Abarrotes", "2028-05-01", "Barilla", 15.00, 300);
        productos[9] = new Producto("Azúcar Estándar", "740102030505", "Abarrotes", "2027-09-10", "Zulka", 28.00, 120);

        productos[10] = new Producto("Jabón de Tocador", "730102030601", "Limpieza", "2029-01-12", "Dove", 18.50, 80);
        productos[11] = new Producto("Detergente Polvo", "730102030602", "Limpieza", "2029-01-01", "Ariel", 45.00, 90);
        productos[12] = new Producto("Limpiador Multiusos", "730102030603", "Limpieza", "2028-12-31", "Fabuloso", 24.00, 110);
        productos[13] = new Producto("Cloro Líquido", "730102030604", "Limpieza", "2028-06-15", "Cloralex", 19.50, 70);
        productos[14] = new Producto("Lavatrastes Líquido", "730102030605", "Limpieza", "2028-10-20", "Salvo", 35.00, 85);

        productos[15] = new Producto("Papas Fritas", "720102030701", "Snacks", "2026-09-15", "Sabritas", 17.00, 200);
        productos[16] = new Producto("Galletas Chocolate", "720102030702", "Snacks", "2026-11-30", "Gamesa", 22.50, 180);
        productos[17] = new Producto("Nueces Mixtas", "720102030703", "Snacks", "2026-12-01", "Mafer", 55.00, 40);
        productos[18] = new Producto("Barras de Granola", "720102030704", "Snacks", "2026-10-10", "Quaker", 12.00, 150);
        productos[19] = new Producto("Palomitas Maíz", "720102030705", "Snacks", "2027-02-14", "ACT II", 14.50, 130);

        productos[20] = new Producto("Agua Mineral 600ml", "710102030801", "Bebidas", "2027-05-20", "Peñafiel", 13.00, 250);
        productos[21] = new Producto("Refresco Cola 2L", "710102030802", "Bebidas", "2026-12-31", "Coca-Cola", 34.00, 300);
        productos[22] = new Producto("Jugo de Naranja", "710102030803", "Bebidas", "2026-07-15", "Jumex", 26.00, 120);
        productos[23] = new Producto("Té Verde Helado", "710102030804", "Bebidas", "2026-08-20", "Lipton", 19.00, 140);
        productos[24] = new Producto("Bebida Energizante", "710102030805", "Bebidas", "2027-01-10", "Red Bull", 45.00, 95);

        for (int i = 0; i < productos.length; i++) {
            try {
                avl.insertar(productos[i]);
                b.insertar(productos[i]);
                bMas.insertar(productos[i]);
            } catch (ElementoExistenteException | ElementoNoEncontradoException ex) {
                System.out.println(ex.getMessage());
            }
        }
        avl.generarDOT("AVL");
        b.generarDOT("B");
        try {
            bMas.generarDOT("BMAS");
        } catch (ElementoNoEncontradoException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("INSERTADO EXISTOSO");
        
        */
        
        FrameGeneral frame = new FrameGeneral();
        frame.setVisible(true);
    }
}
