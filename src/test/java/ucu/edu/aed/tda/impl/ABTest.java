package ucu.edu.aed.tda.impl;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import ucu.edu.aed.tda.TDAElemento;

public class ABTest extends TestCase {

    public void testArbolVacio() {
        ArbolBinario<Integer> arbol = new ArbolBinario<Integer>();

        assertEquals(0, arbol.altura());
        assertEquals(0, arbol.tamanio());
        assertEquals(0, arbol.hojas());
        assertEquals(0, arbol.internos());
        assertTrue(arbol.completos().isEmpty());
        assertTrue(arbol.enNivel(0).isEmpty());
    }

    public void testMetricasBasicas() {
        ArbolBinario<Integer> arbol = crearArbolCompleto();

        assertEquals(3, arbol.altura());
        assertEquals(7, arbol.tamanio());
        assertEquals(4, arbol.hojas());
        assertEquals(3, arbol.internos());
    }

    public void testCompletos() {
        ArbolBinario<Integer> arbol = crearArbolCompleto();

        List<Integer> completos = obtenerDatos(arbol.completos());
        assertEquals(3, completos.size());
        assertEquals(Integer.valueOf(8), completos.get(0));
        assertEquals(Integer.valueOf(3), completos.get(1));
        assertEquals(Integer.valueOf(10), completos.get(2));
    }

    public void testEnNivel() {
        ArbolBinario<Integer> arbol = crearArbolCompleto();

        assertEquals(Integer.valueOf(8), arbol.enNivel(0).get(0).getDato());
        assertEquals(2, arbol.enNivel(1).size());
        assertEquals(4, arbol.enNivel(2).size());

        List<Integer> nivel1 = obtenerDatos(arbol.enNivel(1));
        assertEquals(Integer.valueOf(3), nivel1.get(0));
        assertEquals(Integer.valueOf(10), nivel1.get(1));

        List<Integer> nivel2 = obtenerDatos(arbol.enNivel(2));
        assertEquals(Integer.valueOf(1), nivel2.get(0));
        assertEquals(Integer.valueOf(6), nivel2.get(1));
        assertEquals(Integer.valueOf(9), nivel2.get(2));
        assertEquals(Integer.valueOf(12), nivel2.get(3));
    }

    private ArbolBinario<Integer> crearArbolCompleto() {
        ArbolBinario<Integer> arbol = new ArbolBinario<Integer>();

        ElementoAB<Integer> raiz = new ElementoAB<Integer>(8);
        ElementoAB<Integer> izquierdo = new ElementoAB<Integer>(3);
        ElementoAB<Integer> derecho = new ElementoAB<Integer>(10);
        ElementoAB<Integer> iIzq = new ElementoAB<Integer>(1);
        ElementoAB<Integer> iDer = new ElementoAB<Integer>(6);
        ElementoAB<Integer> dIzq = new ElementoAB<Integer>(9);
        ElementoAB<Integer> dDer = new ElementoAB<Integer>(12);

        izquierdo.setHijoIzquierdo(iIzq);
        izquierdo.setHijoDerecho(iDer);
        derecho.setHijoIzquierdo(dIzq);
        derecho.setHijoDerecho(dDer);

        raiz.setHijoIzquierdo(izquierdo);
        raiz.setHijoDerecho(derecho);

        arbol.setRaiz(raiz);
        return arbol;
    }

    private List<Integer> obtenerDatos(List<TDAElemento<Integer>> nodos) {
        List<Integer> resultado = new ArrayList<Integer>();
        for (TDAElemento<Integer> nodo : nodos) {
            resultado.add(nodo.getDato());
        }
        return resultado;
    }
}
