package ucu.edu.aed.tda.impl;

import ucu.edu.aed.tda.TDAArbolBinario;

public class AVLInsertTest {

    public static void main(String[] args) {
        testCase(new int[]{30,20,10}, "LL");
        testCase(new int[]{10,20,30}, "RR");
        testCase(new int[]{30,10,20}, "LR");
        testCase(new int[]{10,30,20}, "RL");

        System.out.println("Todos los casos pasaron.");
    }

    private static void testCase(int[] seq, String name) {
        TDAArbolBinario<Integer> arbol = new AVL<>();

        for (int v : seq) {
            arbol.insertar(v);
        }

        Integer root = arbol.obtenerRaiz().getDato();
        Integer left = (arbol.obtenerRaiz().getHijoIzquierdo() != null) ? arbol.obtenerRaiz().getHijoIzquierdo().getDato() : null;
        Integer right = (arbol.obtenerRaiz().getHijoDerecho() != null) ? arbol.obtenerRaiz().getHijoDerecho().getDato() : null;

        System.out.println("Caso " + name + ": root=" + root + " left=" + left + " right=" + right);

        if (root == null || left == null || right == null) {
            throw new AssertionError("Caso " + name + ": estructura inválida");
        }
        if (root != 20 || left != 10 || right != 30) {
            throw new AssertionError("Caso " + name + ": no quedó balanceado correctamente. Esperado root=20,left=10,right=30 pero fue root=" + root + ",left=" + left + ",right=" + right);
        }
    }
}
