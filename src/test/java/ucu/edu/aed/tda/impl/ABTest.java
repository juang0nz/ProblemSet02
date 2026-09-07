package ucu.edu.aed.tda.impl;

import ucu.edu.aed.tda.TDALista;
import ucu.edu.aed.tda.impl.TDAListaConArregloImpl;

import junit.framework.TestCase;
import ucu.edu.aed.tda.TDAElemento;

public class ABTest extends TestCase {

    public void testArbolVacio() {
        ArbolBinario<Integer> arbol = new ArbolBinario<>();

        assertEquals(0, arbol.altura());
        assertEquals(0, arbol.tamanio());
        assertEquals(0, arbol.hojas());
        assertEquals(0, arbol.internos());
        assertTrue(arbol.completos().esVacio());
        assertTrue(arbol.enNivel(0).esVacio());
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

        TDALista<Integer> completos = obtenerDatos(arbol.completos());
        assertEquals(3, completos.tamanio());
        assertEquals(Integer.valueOf(8), completos.obtener(0));
        assertEquals(Integer.valueOf(3), completos.obtener(1));
        assertEquals(Integer.valueOf(10), completos.obtener(2));
    }

    public void testEnNivel() {
        ArbolBinario<Integer> arbol = crearArbolCompleto();

        assertEquals(Integer.valueOf(8), arbol.enNivel(0).obtener(0).getDato());
        assertEquals(2, arbol.enNivel(1).tamanio());
        assertEquals(4, arbol.enNivel(2).tamanio());

        TDALista<Integer> nivel1 = obtenerDatos(arbol.enNivel(1));
        assertEquals(Integer.valueOf(3), nivel1.obtener(0));
        assertEquals(Integer.valueOf(10), nivel1.obtener(1));

        TDALista<Integer> nivel2 = obtenerDatos(arbol.enNivel(2));
        assertEquals(Integer.valueOf(1), nivel2.obtener(0));
        assertEquals(Integer.valueOf(6), nivel2.obtener(1));
        assertEquals(Integer.valueOf(9), nivel2.obtener(2));
        assertEquals(Integer.valueOf(12), nivel2.obtener(3));
    }

    private ArbolBinario<Integer> crearArbolCompleto() {
        ArbolBinario<Integer> arbol = new ArbolBinario<>();

        ElementoAB<Integer> raiz = new ElementoAB<>(8);
        ElementoAB<Integer> izquierdo = new ElementoAB<>(3);
        ElementoAB<Integer> derecho = new ElementoAB<>(10);
        ElementoAB<Integer> iIzq = new ElementoAB<>(1);
        ElementoAB<Integer> iDer = new ElementoAB<>(6);
        ElementoAB<Integer> dIzq = new ElementoAB<>(9);
        ElementoAB<Integer> dDer = new ElementoAB<>(12);

        izquierdo.setHijoIzquierdo(iIzq);
        izquierdo.setHijoDerecho(iDer);
        derecho.setHijoIzquierdo(dIzq);
        derecho.setHijoDerecho(dDer);

        raiz.setHijoIzquierdo(izquierdo);
        raiz.setHijoDerecho(derecho);

        arbol.setRaiz(raiz);
        return arbol;
    }

    private TDALista<Integer> obtenerDatos(TDALista<TDAElemento<Integer>> nodos) {
        TDALista<Integer> resultado = new TDAListaConArregloImpl<>();
        for (int i = 0; i < nodos.tamanio(); i++) {
            resultado.agregar(nodos.obtener(i).getDato());
        }
        return resultado;
    }
}
