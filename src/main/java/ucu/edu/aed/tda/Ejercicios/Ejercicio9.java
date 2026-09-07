package ucu.edu.aed.tda.Ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ucu.edu.aed.tda.impl.ABB;

public class Ejercicio9 {

    public static void main(String[] args) {

        ABB<Integer> arbol = new ABB<>();

        cargarClaves(arbol, "clavesPrueba.txt");

        StringBuilder preorden = new StringBuilder();
        arbol.preOrder(dato -> preorden.append(dato).append(" "));
        System.out.println("Preorden: " + preorden.toString().trim());

        buscarYMostrar(arbol, 45);
        buscarYMostrar(arbol, 999);
    }

    private static void cargarClaves(ABB<Integer> arbol, String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty()) {
                    int clave = Integer.parseInt(linea);
                    arbol.insertar(clave);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void buscarYMostrar(ABB<Integer> arbol, int clave) {
        Integer resultado = arbol.buscar(clave);
        if (resultado != null) {
            System.out.println("La clave " + clave + " esta en el arbol");
        } else {
            System.out.println("La clave " + clave + " NO esta en el arbol");
        }
    }
}

/*
 * Recorridos calculados a mano (Parte 1) con las claves:
 * 45, 20, 70, 10, 30, 60, 90, 5, 15, 25
 *
 * Preorden:  45 20 10 5 15 30 25 70 60 90
 * Inorden:   5 10 15 20 25 30 45 60 70 90
 * Postorden: 5 15 10 25 30 20 60 90 70 45
 */