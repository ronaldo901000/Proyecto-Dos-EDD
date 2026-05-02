package com.ronaldo.gestor.back.estructuras.grafo;

import com.ronaldo.gestor.back.estructuras.lista.generica.ListaEnlazadaGenerica;
import com.ronaldo.gestor.back.exceptions.ElementoExistenteException;
import com.ronaldo.gestor.back.exceptions.ElementoNoEncontradoException;
import com.ronaldo.gestor.back.exceptions.ListaException;
import com.ronaldo.gestor.back.sucursal.Sucursal;

/**
 *
 * @author ronaldo
 */
public class Grafo {

    private Sucursal cabeza;
    private ListaEnlazadaGenerica<Sucursal> lista;
    private BuscadorSucursales buscador;
    private int totalSucursales;

    public Grafo() {
        buscador = new BuscadorSucursales();
        lista = new ListaEnlazadaGenerica<>();
    }

    /**
     *
     * @param sucursal
     * @throws ElementoExistenteException
     */
    public void agregarSucursal(Sucursal sucursal) throws ElementoExistenteException {

        if (buscador.existeSucursal(sucursal.getId(), lista)) {
            throw new ElementoExistenteException(
                    "El ID '" + sucursal.getId() + "' ya está registrado, utiliza otro."
            );
        }

        lista.agregarElemento(sucursal);

        if (cabeza == null) {
            cabeza = sucursal;
        } else {
            sucursal.setSiguiente(cabeza);
            cabeza = sucursal;
        }
        this.totalSucursales++;
    }

    /**
     *
     * @param idOrigen
     * @param idDestino
     * @param tiempo
     * @param costo
     * @throws ElementoNoEncontradoException
     * @throws ElementoExistenteException
     */
    public void conectar(String idOrigen, String idDestino, int tiempo, double costo) throws ElementoNoEncontradoException, ElementoExistenteException {
        Sucursal temp = buscador.buscarSucursal(idOrigen, lista);

        Arista arista = temp.getCabezaLista();
        while (arista != null) {
            if (arista.getIdDestino().equals(idDestino)) {

                //actualizar arista
                arista.setTiempo(tiempo);
                arista.setCosto(costo);

                throw new ElementoExistenteException(
                        "Ya existe una conexión de " + idOrigen + " hacia " + idDestino + ", Se actualizaron los pesos."
                );
            }
            arista = arista.getSiguiente();
        }

        Arista nuevaConexion = new Arista(idDestino, tiempo, costo);
        nuevaConexion.setSiguiente(temp.getCabezaLista());
        temp.setCabezaLista(nuevaConexion);
    }

    public ListaEnlazadaGenerica<Sucursal> ejecutarDijkstra(String idOrigen, String idDestino, boolean esTiempo) throws ListaException, ElementoNoEncontradoException {
        int n = this.totalSucursales;
        double[] distancias = new double[n];
        boolean[] visitados = new boolean[n];
        int[] anteriores = new int[n];

        for (int i = 0; i < n; i++) {
            distancias[i] = Double.MAX_VALUE;
            visitados[i] = false;
            anteriores[i] = -1;
        }

        int indiceOrigen = obtenerIndiceSucursal(idOrigen);
        int indiceDestino = obtenerIndiceSucursal(idDestino);

        if (indiceOrigen == -1) {
            throw new ElementoNoEncontradoException("Sucursal no encontrada");
        }

        //distancia hacia el mismo = 0
        distancias[indiceOrigen] = 0;

        for (int i = 0; i < n; i++) {

            int actual = encontrarIndiceMenorCosto(distancias, visitados);

            if (actual == -1) {
                break;
            }

            visitados[actual] = true;

            Sucursal sActual = lista.obtenerValor(actual);

            Arista arista = sActual.getCabezaLista();

            while (arista != null) {

                int indiceVecino = obtenerIndiceSucursal(arista.getIdDestino());

                if (indiceVecino == -1) {
                    arista = arista.getSiguiente();
                    continue;
                }

                if (visitados[indiceVecino]) {
                    arista = arista.getSiguiente();
                    continue;
                }

                double peso = esTiempo ? arista.getTiempo() : arista.getCosto();
                double nuevaDistancia = distancias[actual] + peso;

                if (nuevaDistancia < distancias[indiceVecino]) {
                    distancias[indiceVecino] = nuevaDistancia;
                    anteriores[indiceVecino] = actual;
                }

                arista = arista.getSiguiente();

            }

        }

        return reconstruirRuta(anteriores, indiceOrigen, indiceDestino);
    }

    private ListaEnlazadaGenerica<Sucursal> reconstruirRuta(int[] anteriores, int indiceOrigen, int indiceDestino) throws ListaException {

        ListaEnlazadaGenerica<Sucursal> ruta = new ListaEnlazadaGenerica<>();

        if (anteriores[indiceDestino] == -1 && indiceDestino != indiceOrigen) {
            return ruta;
        }

        ListaEnlazadaGenerica<Sucursal> rutaInvertida = new ListaEnlazadaGenerica<>();
        int actual = indiceDestino;

        while (actual != -1) {
            rutaInvertida.agregarElemento(lista.obtenerValor(actual));
            actual = anteriores[actual];
        }

        for (int i = rutaInvertida.getTamaño() - 1; i >= 0; i--) {
            ruta.agregarElemento(rutaInvertida.obtenerValor(i));
        }

        return ruta;
    }

    private int obtenerIndiceSucursal(String idSucursal) throws ListaException {

        for (int i = 0; i < lista.getTamaño(); i++) {
            if (lista.obtenerValor(i).getId().equals(idSucursal)) {
                return i;
            }
        }
        return -1;
    }

    private int encontrarIndiceMenorCosto(double[] costos, boolean[] visitados) {
        double valorMinimo = Double.MAX_VALUE;
        int indiceMinimo = -1;

        for (int i = 0; i < costos.length; i++) {
            if (!visitados[i] && costos[i] <= valorMinimo) {
                valorMinimo = costos[i];
                indiceMinimo = i;
            }
        }
        return indiceMinimo;
    }

    public void generarImagen(String nombreArchivo) {
        String rutaDot = nombreArchivo.replace(".png", ".dot");
        try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(rutaDot))) {
            pw.println("digraph Grafo {");
            pw.println("  rankdir=LR;");
            pw.println("  node [shape=circle, style=filled, fillcolor=lightblue];");
            pw.println("  edge [fontsize=10];");
            for (int i = 0; i < lista.getTamaño(); i++) {
                Sucursal s = lista.obtenerValor(i);
                pw.println("  \"" + s.getId() + "\" [label=\"" + s.getId() + "\\n" + s.getNombre() + "\"];");
                Arista arista = s.getCabezaLista();
                while (arista != null) {
                    pw.println("  \"" + s.getId() + "\" -> \"" + arista.getIdDestino() + "\""
                            + " [label=\"t=" + arista.getTiempo()
                            + "\\nc=" + arista.getCosto() + "\"];");
                    arista = arista.getSiguiente();
                }
            }
            pw.println("}");
        } catch (Exception e) {
            System.err.println("Error al generar .dot: " + e.getMessage());
            return;
        }
        try {
            ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng", rutaDot, "-o", nombreArchivo);
            pb.redirectErrorStream(true);
            Process proceso = pb.start();
            String output = new String(proceso.getInputStream().readAllBytes());
            int exitCode = proceso.waitFor();

            if (exitCode != 0) {
                System.err.println("Graphviz error: " + output);
            }

        } catch (Exception e) {
            System.err.println("Error al ejecutar Graphviz: " + e.getMessage());
        }
    }

    public int calcularTiempoEstimado(ListaEnlazadaGenerica<Sucursal> ruta, boolean esTiempo) throws ListaException {
        int tiempo = 0;

        for (int i = 0; i < ruta.getTamaño(); i++) {
            Sucursal s = ruta.obtenerValor(i);

            tiempo += s.getTiempoIngreso();

            if (i < ruta.getTamaño() - 1) {
                tiempo += s.getTiempoTraspaso();
                tiempo += s.getIntervaloDespacho();

                Sucursal siguiente = ruta.obtenerValor(i + 1);
                Arista arista = s.getCabezaLista();

                while (arista != null) {
                    if (arista.getIdDestino().equals(siguiente.getId())) {
                        tiempo += esTiempo ? arista.getTiempo() : arista.getCosto();
                        break;
                    }
                    arista = arista.getSiguiente();
                }
            }
        }

        return tiempo;
    }

    public ListaEnlazadaGenerica<Sucursal> getLista() {
        return lista;
    }

    public int getTotalSucursales() {
        return totalSucursales;
    }

    public BuscadorSucursales getBuscador() {
        return buscador;
    }

}
