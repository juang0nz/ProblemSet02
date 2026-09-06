package ucu.edu.aed.tda.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import junit.framework.TestCase;

public class Ejercicio11Test extends TestCase {

    // Caso base / caso borde: árbol vacío y árbol válido con niveles existentes y no existentes.
    public void testCantidadNodosEnNivel() {
        ABB<Integer> arbolVacio = new ABB<Integer>();
        ABB<Integer> arbol = crearArbolValido();

        assertEquals(0, arbolVacio.cantidadNodosEnNivel(0));
        assertEquals(1, arbol.cantidadNodosEnNivel(0));
        assertEquals(2, arbol.cantidadNodosEnNivel(1));
        assertEquals(4, arbol.cantidadNodosEnNivel(2));
        assertEquals(0, arbol.cantidadNodosEnNivel(5));
    }

    // Caso borde + caso normal: árbol vacío, árbol con varias hojas y árbol con una sola hoja.
    public void testListarHojasConNivel() {
        ABB<Integer> arbolVacio = new ABB<Integer>();
        ABB<Integer> arbol = crearArbolValido();
        ABB<Integer> arbolUnico = new ABB<Integer>();
        arbolUnico.insertar(10);

        final List<String> hojasVacias = new ArrayList<String>();
        final List<String> hojas = new ArrayList<String>();
        final List<String> hojasUnicas = new ArrayList<String>();

        arbolVacio.listarHojasConNivel(new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer dato, Integer nivel) {
                hojasVacias.add(dato + ":" + nivel);
            }
        });

        arbol.listarHojasConNivel(new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer dato, Integer nivel) {
                hojas.add(dato + ":" + nivel);
            }
        });

        arbolUnico.listarHojasConNivel(new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer dato, Integer nivel) {
                hojasUnicas.add(dato + ":" + nivel);
            }
        });

        assertTrue(hojasVacias.isEmpty());
        assertEquals(4, hojas.size());
        assertTrue(hojas.contains("1:2"));
        assertTrue(hojas.contains("6:2"));
        assertTrue(hojas.contains("9:2"));
        assertTrue(hojas.contains("12:2"));
        assertEquals(1, hojasUnicas.size());
        assertTrue(hojasUnicas.contains("10:0"));
    }

    // Caso normal + casos inválidos: árbol válido, vacío, de un solo nodo y con violaciones profundas.
    public void testEsArbolDeBusqueda() {
        ABB<Integer> valido = crearArbolValido();
        assertTrue(valido.esArbolDeBusqueda());

        ABB<Integer> arbolVacio = new ABB<Integer>();
        assertTrue(arbolVacio.esArbolDeBusqueda());

        ABB<Integer> arbolUnico = new ABB<Integer>();
        arbolUnico.insertar(8);
        assertTrue(arbolUnico.esArbolDeBusqueda());

        ABB<Integer> invalido = new ABB<Integer>();
        invalido.raiz = new ElementoABB<Integer>(8);
        invalido.raiz.setHijoIzquierdo(new ElementoABB<Integer>(10));
        invalido.raiz.setHijoDerecho(new ElementoABB<Integer>(12));
        assertFalse(invalido.esArbolDeBusqueda());

        // Caso inválido profundo: 7 está en la rama derecha del árbol, pero es menor que la raíz 8,
        // por lo que rompe la propiedad del ABB aunque el árbol tenga varios niveles.
        ABB<Integer> invalidoProfundo = new ABB<Integer>();
        invalidoProfundo.raiz = new ElementoABB<Integer>(8);
        invalidoProfundo.raiz.setHijoIzquierdo(new ElementoABB<Integer>(3));
        invalidoProfundo.raiz.setHijoDerecho(new ElementoABB<Integer>(10));
        invalidoProfundo.raiz.getHijoIzquierdo().setHijoIzquierdo(new ElementoABB<Integer>(1));
        invalidoProfundo.raiz.getHijoIzquierdo().setHijoDerecho(new ElementoABB<Integer>(6));
        invalidoProfundo.raiz.getHijoDerecho().setHijoIzquierdo(new ElementoABB<Integer>(7));
        invalidoProfundo.raiz.getHijoDerecho().setHijoDerecho(new ElementoABB<Integer>(15));
        invalidoProfundo.raiz.getHijoDerecho().getHijoDerecho().setHijoIzquierdo(new ElementoABB<Integer>(12));
        assertFalse(invalidoProfundo.esArbolDeBusqueda());
    }

    // Caso base + caso borde: árbol con un solo nodo y árbol normal con varios niveles.
    public void testMenorYMayorClave() {
        ABB<Integer> arbolUnico = new ABB<Integer>();
        arbolUnico.insertar(15);
        ABB<Integer> arbol = crearArbolValido();

        assertEquals(Integer.valueOf(15), arbolUnico.menorClave());
        assertEquals(Integer.valueOf(15), arbolUnico.mayorClave());
        assertEquals(Integer.valueOf(1), arbol.menorClave());
        assertEquals(Integer.valueOf(12), arbol.mayorClave());
    }

    // Caso normal + caso borde: clave mínima, clave con hijo izquierdo, clave sin hijo izquierdo y clave máxima.
    public void testClaveAnterior() {
        ABB<Integer> arbol = crearArbolValido();

        assertNull(arbol.claveAnterior(1));
        assertEquals(Integer.valueOf(6), arbol.claveAnterior(7));
        assertEquals(Integer.valueOf(6), arbol.claveAnterior(8));
        assertEquals(Integer.valueOf(8), arbol.claveAnterior(9));
        assertEquals(Integer.valueOf(9), arbol.claveAnterior(10));
        assertEquals(Integer.valueOf(10), arbol.claveAnterior(12));
    }

    private ABB<Integer> crearArbolValido() {
        ABB<Integer> arbol = new ABB<Integer>();
        int[] valores = {8, 3, 10, 1, 6, 9, 12};

        for (int valor : valores) {
            arbol.insertar(valor);
        }

        return arbol;
    }
}
