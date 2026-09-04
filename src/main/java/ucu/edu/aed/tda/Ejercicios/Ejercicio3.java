package ucu.edu.aed.tda.Ejercicios;

import ucu.edu.aed.tda.TDAArbolBinario;
import ucu.edu.aed.tda.impl.ABB;

public class Ejercicio3 {

    public static void main(String[] args) {

        // Creo árbol vacío
        TDAArbolBinario<Integer> arbol;

        arbol = new ABB<>();

        // Inserto claves
        arbol.insertar(12);
        arbol.insertar(25);
        arbol.insertar(14);
        arbol.insertar(1);
        arbol.insertar(33);
        arbol.insertar(88);
        arbol.insertar(45);
        arbol.insertar(2);
        arbol.insertar(74);
        arbol.insertar(66);
        arbol.insertar(5);
        arbol.insertar(99);

        // Recorro el árbol en orden
        System.out.println("Recorrido en orden:");
        arbol.inOrder(System.out::println);
        // También puedo recorrer el árbol en preorden
        System.out.println("Recorrido en preorden:");
        arbol.preOrder(System.out::println);

        // Y en postorden
        System.out.println("Recorrido en postorden:");
        arbol.postOrder(System.out::println);
    }
}