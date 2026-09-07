package ucu.edu.aed.tda.impl;

import ucu.edu.aed.tda.TDALista;
import ucu.edu.aed.tda.impl.TDAListaConArregloImpl;
import java.util.Arrays;
import java.util.function.Consumer;

import junit.framework.TestCase;
import ucu.edu.aed.tda.TDAElemento;

public class ABBTest extends TestCase {

    public void testArbolVacio() {
        ABB<Integer> arbol = new ABB<Integer>();

        assertTrue(arbol.esVacio());
        assertNull(arbol.obtenerRaiz());
        assertNull(arbol.buscar(10));
        assertFalse(arbol.eliminar(10));
        assertEquals(0, arbol.cantidadNodos());
        assertEquals(0, arbol.cantidadHojas());
        assertEquals(0, arbol.cantidadNodosInternos());
        //ejercicio4  A y B
        assertEquals(0, arbol.altura());
        assertEquals(0, arbol.ObtenerTamanio());
    }

    public void testInsertarBuscarYNoPermitirDuplicados() {
        ABB<Integer> arbol = crearArbol();

        assertEquals(Integer.valueOf(8), arbol.obtenerRaiz().getDato());
        assertEquals(Integer.valueOf(3), arbol.buscar(3));
        assertEquals(Integer.valueOf(14), arbol.buscar(14));
        assertNull(arbol.buscar(99));
        assertFalse(arbol.insertar(10));
        assertEquals(7, arbol.cantidadNodos());
    }

    public void testRecorridos() {
        ABB<Integer> arbol = crearArbol();

        Integer[] expectedIn = {1, 3, 6, 8, 10, 14, 16};
        TDALista<Integer> in = recorrerInOrder(arbol);
        assertEquals(expectedIn.length, in.tamanio());
        for (int i = 0; i < expectedIn.length; i++) {
            assertEquals(expectedIn[i], in.obtener(i));
        }

        Integer[] expectedPre = {8, 3, 1, 6, 14, 10, 16};
        TDALista<Integer> pre = recorrerPreOrder(arbol);
        assertEquals(expectedPre.length, pre.tamanio());
        for (int i = 0; i < expectedPre.length; i++) {
            assertEquals(expectedPre[i], pre.obtener(i));
        }

        Integer[] expectedPost = {1, 6, 3, 10, 16, 14, 8};
        TDALista<Integer> post = recorrerPostOrder(arbol);
        assertEquals(expectedPost.length, post.tamanio());
        for (int i = 0; i < expectedPost.length; i++) {
            assertEquals(expectedPost[i], post.obtener(i));
        }
    }

    public void testMetricasYNivel() {
        ABB<Integer> arbol = crearArbol();
        TDAElemento<Integer> raiz = arbol.obtenerRaiz();

        assertEquals(7, arbol.cantidadNodos());
        assertEquals(4, arbol.cantidadHojas());
        assertEquals(3, arbol.cantidadNodosInternos());
        assertEquals(3, raiz.altura());
        assertEquals(0, raiz.obtenerNivel(8));
        assertEquals(2, raiz.obtenerNivel(1));
        assertEquals(-1, raiz.obtenerNivel(99));
    }

    public void testEliminarHoja() {
        ABB<Integer> arbol = crearArbol();

        assertTrue(arbol.eliminar(1));
        assertNull(arbol.buscar(1));
        Integer[] expectedAfterDelete = {3, 6, 8, 10, 14, 16};
        TDALista<Integer> actualAfterDelete = recorrerInOrder(arbol);
        assertEquals(expectedAfterDelete.length, actualAfterDelete.tamanio());
        for (int i = 0; i < expectedAfterDelete.length; i++) {
            assertEquals(expectedAfterDelete[i], actualAfterDelete.obtener(i));
        }
        assertFalse(arbol.eliminar(1));
    }

    public void testEliminarNodoConUnHijo() {
        ABB<Integer> arbol = crearArbol();
        arbol.insertar(15);

        assertTrue(arbol.eliminar(16));
        assertNull(arbol.buscar(16));
        assertEquals(Integer.valueOf(15), arbol.obtenerRaiz().getHijoDerecho()
                .getHijoDerecho().getDato());
    }

    public void testEliminarNodoConDosHijos() {
        ABB<Integer> arbol = crearArbol();

        assertTrue(arbol.eliminar(3));
        assertNull(arbol.buscar(3));
        Integer[] expectedAfterDelete = {1, 6, 8, 10, 14, 16};
        TDALista<Integer> actualAfterDelete = recorrerInOrder(arbol);
        assertEquals(expectedAfterDelete.length, actualAfterDelete.tamanio());
        for (int i = 0; i < expectedAfterDelete.length; i++) {
            assertEquals(expectedAfterDelete[i], actualAfterDelete.obtener(i));
        }
        assertEquals(6, arbol.cantidadNodos());
    }

    public void testEliminarRaizConDosHijos() {
        ABB<Integer> arbol = crearArbol();

        assertTrue(arbol.eliminar(8));
        assertNull(arbol.buscar(8));
        assertEquals(Integer.valueOf(6), arbol.obtenerRaiz().getDato());
        Integer[] expectedAfterDeleteRoot = {1, 3, 6, 10, 14, 16};
        TDALista<Integer> actualAfterDeleteRoot = recorrerInOrder(arbol);
        assertEquals(expectedAfterDeleteRoot.length, actualAfterDeleteRoot.tamanio());
        for (int i = 0; i < expectedAfterDeleteRoot.length; i++) {
            assertEquals(expectedAfterDeleteRoot[i], actualAfterDeleteRoot.obtener(i));
        }
    }

    private ABB<Integer> crearArbol() {
        ABB<Integer> arbol = new ABB<Integer>();
        int[] valores = {8, 3, 14, 1, 6, 10, 16};

        for (int valor : valores) {
            assertTrue(arbol.insertar(valor));
        }
        return arbol;
    }

    private TDALista<Integer> recorrerInOrder(ABB<Integer> arbol) {
        final TDALista<Integer> resultado = new TDAListaConArregloImpl<>();
        arbol.inOrder(new Consumer<Integer>() {
            @Override
            public void accept(Integer elemento) {
                resultado.agregar(elemento);
            }
        });
        return resultado;
    }

    private TDALista<Integer> recorrerPreOrder(ABB<Integer> arbol) {
        final TDALista<Integer> resultado = new TDAListaConArregloImpl<>();
        arbol.preOrder(new Consumer<Integer>() {
            @Override
            public void accept(Integer elemento) {
                resultado.agregar(elemento);
            }
        });
        return resultado;
    }

    private TDALista<Integer> recorrerPostOrder(ABB<Integer> arbol) {
        final TDALista<Integer> resultado = new TDAListaConArregloImpl<>();
        arbol.postOrder(new Consumer<Integer>() {
            @Override
            public void accept(Integer elemento) {
                resultado.agregar(elemento);
            }
        });
        return resultado;
    }
    //test con un nodo solo:
    public void testObtenerTamanio() {
        ABB<Integer> arbol = new ABB<Integer>();
        arbol.insertar(5);
        assertEquals(1, arbol.ObtenerTamanio());
    }
    //test altura del árbol con un nodo solo
    public void testAltura() {
        ABB<Integer> arbol = new ABB<Integer>();
        arbol.insertar(5);
        assertEquals(1, arbol.altura());
    }
    //Podemos cargar todo en un subárbol izquierdo o derecho y que me devuelva la cantidad de nodos.
    public void testCantidadNodosSubarbolIzquierdo() {
        ABB<Integer> arbol = new ABB<>();
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(3);
        arbol.insertar(7);
        assertEquals(4, arbol.cantidadNodos());
    }

    public void testCantidadNodosSubarbolDerecho() {
        ABB<Integer> arbol = new ABB<>();
        arbol.insertar(10);
        arbol.insertar(15);
        arbol.insertar(12);
        arbol.insertar(18);
        assertEquals(4, arbol.cantidadNodos());
    }
}
