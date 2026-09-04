package ucu.edu.aed.tda.Ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ucu.edu.aed.tda.TDAArbolBinario;
import ucu.edu.aed.tda.impl.ABB;

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
        List<Integer> entrada = Arrays.asList(12, 25, 14, 1, 33, 88, 45, 2, 7, 66, 5, 99);
        for (Integer v : entrada) {
            arbol.insertar(v);
        }

        // 2) Recorro el árbol en orden (inicial)
        System.out.println("Recorrido en orden (inicial):");
        List<Integer> inicialInorder = recorridoInOrder(arbol);
        System.out.println(inicialInorder);

        // Esperado inicial (orden ascendente de los elementos insertados)
        List<Integer> esperadoInicial = Arrays.asList(1, 2, 5, 7, 12, 14, 25, 33, 45, 66, 88, 99);
        assertListEquals("In-order inicial", esperadoInicial, inicialInorder);

        // 3) Eliminar en el orden indicado y verificar después de cada eliminación
        List<DeletionCheck> pruebas = Arrays.asList(
                new DeletionCheck(99, Arrays.asList(1, 2, 5, 7, 12, 14, 25, 33, 45, 66, 88)),
                new DeletionCheck(15, Arrays.asList(1, 2, 5, 7, 12, 14, 25, 33, 45, 66, 88)), // 15 no existe
                new DeletionCheck(2, Arrays.asList(1, 5, 7, 12, 14, 25, 33, 45, 66, 88)),
                new DeletionCheck(12, Arrays.asList(1, 5, 7, 14, 25, 33, 45, 66, 88)),
                new DeletionCheck(77, Arrays.asList(1, 5, 7, 14, 25, 33, 45, 66, 88)), // 77 no existe
                new DeletionCheck(33, Arrays.asList(1, 5, 7, 14, 25, 45, 66, 88))
        );

        for (DeletionCheck dc : pruebas) {
            boolean eliminado = arbol.eliminar(dc.clave);
            System.out.println("\nEliminando clave: " + dc.clave + "  -> eliminado? " + eliminado);

            List<Integer> actualInorder = recorridoInOrder(arbol);
            System.out.println("In-order actual: " + actualInorder);
            System.out.println("In-order esperado: " + dc.esperadoInorder);

            assertListEquals("Comprobación tras eliminar " + dc.clave, dc.esperadoInorder, actualInorder);
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
    private static List<Integer> recorridoInOrder(TDAArbolBinario<Integer> arbol) {
        List<Integer> lista = new ArrayList<>();
        arbol.inOrder(lista::add);
        return lista;
    }

    // Helper: recolecta el recorrido pre-order en una lista
    private static List<Integer> recorridoPreOrder(TDAArbolBinario<Integer> arbol) {
        List<Integer> lista = new ArrayList<>();
        arbol.preOrder(lista::add);
        return lista;
    }

    // Helper: recolecta el recorrido post-order en una lista
    private static List<Integer> recorridoPostOrder(TDAArbolBinario<Integer> arbol) {
        List<Integer> lista = new ArrayList<>();
        arbol.postOrder(lista::add);
        return lista;
    }

    private static void assertListEquals(String contexto, List<Integer> esperado, List<Integer> actual) {
        if (esperado == null && actual == null) {
            return;
        }
        if (esperado == null || actual == null) {
            throw new AssertionError(contexto + ": uno de los listados es null. Esperado=" + esperado + ", actual=" + actual);
        }
        if (esperado.size() != actual.size()) {
            throw new AssertionError(contexto + ": tamaños distintos. Esperado=" + esperado.size() + ", actual=" + actual.size()
                    + ".\nEsperado: " + esperado + "\nActual: " + actual);
        }
        for (int i = 0; i < esperado.size(); i++) {
            if (!esperado.get(i).equals(actual.get(i))) {
                throw new AssertionError(contexto + ": diferencia en posición " + i + ". Esperado=" + esperado.get(i)
                        + ", actual=" + actual.get(i) + ".\nEsperado: " + esperado + "\nActual: " + actual);
            }
        }
    }

    private static class DeletionCheck {
        final Integer clave;
        final List<Integer> esperadoInorder;

        DeletionCheck(Integer clave, List<Integer> esperadoInorder) {
            this.clave = clave;
            this.esperadoInorder = esperadoInorder;
        }
    }
}
