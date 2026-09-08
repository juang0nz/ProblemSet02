package ucu.edu.aed.tda.impl;

import ucu.edu.aed.tda.TDAArbolBinario;
import ucu.edu.aed.tda.TDALista;

/**
 * Casos de prueba para la funcionalidad de eliminar del TDA árbol (ABB).
 *
 * Requisitos implementados:
 * 1. Insertar elementos en el árbol con claves 12, 25, 14, 1, 33, 88, 45, 2, 7, 66, 5, 99.
 * 2. Emitir por consola el recorrido en inorden (inicial).
 * 3. Eliminar las claves: 99, 15, 2, 12, 77, 33 (en ese orden).
 * 4. Emitir por consola los recorridos inorden, preorden y postorden luego de las
 *    eliminaciones.
 * 5. Verificar que la salida luego de efectuar cada eliminación es la esperada.
 */
public class Ejercicio3Test {

    public static void main(String[] args) {
        TDAArbolBinario<Integer> arbol = new ABB<>();

        // 1) Insertar elementos
        Integer[] entradaArr = {12, 25, 14, 1, 33, 88, 45, 2, 7, 66, 5, 99};
        for (Integer v : entradaArr) {
            arbol.insertar(v);
        }

        // 2) Recorro el árbol en orden (inicial)
        System.out.println("Recorrido en orden (inicial):");
        TDALista<Integer> inicialInorder = recorridoInOrder(arbol);
        System.out.println(inicialInorder);

        // Esperado inicial (orden ascendente de los elementos insertados)
        Integer[] esperadoInicial = {1, 2, 5, 7, 12, 14, 25, 33, 45, 66, 88, 99};
        assertListaEquals("In-order inicial", esperadoInicial, inicialInorder);

        // 3) Eliminar en el orden indicado y verificar después de cada eliminación
        DeletionCheck[] pruebas = new DeletionCheck[] {
                new DeletionCheck(99, new Integer[] {1, 2, 5, 7, 12, 14, 25, 33, 45, 66, 88}),
                new DeletionCheck(15, new Integer[] {1, 2, 5, 7, 12, 14, 25, 33, 45, 66, 88}), // 15 no existe
                new DeletionCheck(2, new Integer[] {1, 5, 7, 12, 14, 25, 33, 45, 66, 88}),
                new DeletionCheck(12, new Integer[] {1, 5, 7, 14, 25, 33, 45, 66, 88}),
                new DeletionCheck(77, new Integer[] {1, 5, 7, 14, 25, 33, 45, 66, 88}), // 77 no existe
                new DeletionCheck(33, new Integer[] {1, 5, 7, 14, 25, 45, 66, 88})
        };

        for (DeletionCheck dc : pruebas) {
            boolean eliminado = arbol.eliminar(dc.clave);
            System.out.println("\nEliminando clave: " + dc.clave + "  -> eliminado? " + eliminado);

            TDALista<Integer> actualInorder = recorridoInOrder(arbol);
            System.out.println("In-order actual: " + actualInorder);
            System.out.println("In-order esperado: " + java.util.Arrays.toString(dc.esperadoInorder));

            assertListaEquals("Comprobación tras eliminar " + dc.clave, dc.esperadoInorder, actualInorder);
        }

        // 4) Emitir recorridos inorden, preorden y postorden al final
        System.out.println("\nRecorridos finales:");
        System.out.println("In-order:");
        System.out.println(recorridoInOrder(arbol));

        System.out.println("Pre-order:");
        System.out.println(recorridoPreOrder(arbol));

        System.out.println("Post-order:");
        System.out.println(recorridoPostOrder(arbol));

        System.out.println("\nTodas las comprobaciones pasaron correctamente.");
    }

    // Helper: recolecta el recorrido in-order en una lista
    private static TDALista<Integer> recorridoInOrder(TDAArbolBinario<Integer> arbol) {
        TDALista<Integer> lista = new TDAListaConArregloImpl<>();
        arbol.inOrder(lista::agregar);
        return lista;
    }

    // Helper: recolecta el recorrido pre-order en una lista
    private static TDALista<Integer> recorridoPreOrder(TDAArbolBinario<Integer> arbol) {
        TDALista<Integer> lista = new TDAListaConArregloImpl<>();
        arbol.preOrder(lista::agregar);
        return lista;
    }

    // Helper: recolecta el recorrido post-order en una lista
    private static TDALista<Integer> recorridoPostOrder(TDAArbolBinario<Integer> arbol) {
        TDALista<Integer> lista = new TDAListaConArregloImpl<>();
        arbol.postOrder(lista::agregar);
        return lista;
    }

    private static void assertListaEquals(String contexto, Integer[] esperado, TDALista<Integer> actual) {
        if (esperado == null && actual == null) {
            return;
        }
        if (esperado == null || actual == null) {
            throw new AssertionError(contexto + ": uno de los listados es null. Esperado=" + java.util.Arrays.toString(esperado) + ", actual=" + actual);
        }
        if (esperado.length != actual.tamanio()) {
            throw new AssertionError(contexto + ": tamaños distintos. Esperado=" + esperado.length + ", actual=" + actual.tamanio()
                    + ".\nEsperado: " + java.util.Arrays.toString(esperado) + "\nActual: " + actual);
        }
        for (int i = 0; i < esperado.length; i++) {
            if (!esperado[i].equals(actual.obtener(i))) {
                throw new AssertionError(contexto + ": diferencia en posición " + i + ". Esperado=" + esperado[i]
                        + ", actual=" + actual.obtener(i) + ".\nEsperado: " + java.util.Arrays.toString(esperado) + "\nActual: " + actual);
            }
        }
    }

    private static class DeletionCheck {
        final Integer clave;
        final Integer[] esperadoInorder;

        DeletionCheck(Integer clave, Integer[] esperadoInorder) {
            this.clave = clave;
            this.esperadoInorder = esperadoInorder;
        }
    }
}
