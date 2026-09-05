package ucu.edu.aed.tda.impl;

import java.util.function.Consumer;
import ucu.edu.aed.tda.TDAArbolBinario;
import ucu.edu.aed.tda.TDAElemento;

public class ABB<T> implements TDAArbolBinario<T> {

    public TDAElemento<T> raiz;

    public ABB() {
        this.raiz = null;
    }

    // métodos de TDAArbolBinario

    // buscar
    @Override
    public T buscar(Comparable<T> predicate) {
        if (raiz == null) {
            return null;
        }

        TDAElemento<T> resultado = raiz.buscar(predicate);

        if (resultado == null) {
            return null;
        }

        return resultado.getDato();
    }

    @Override
    public boolean esVacio() {
        return raiz == null;
    }

    // Retorna el elemento raíz del árbol.
    @Override
    public TDAElemento<T> obtenerRaiz() {
        return raiz;
    }

    // eliminar
    @Override
    public boolean eliminar(Comparable<T> criterioBusqueda) {
        if (raiz == null) {
            return false;
        }

        // Primero verificamos si existe
        TDAElemento<T> encontrado = raiz.buscar(criterioBusqueda);

        if (encontrado == null) {
            return false;
        }

        raiz = raiz.eliminar(criterioBusqueda);

        return true;
    }

    /**
     * Agrega un dato al árbol.
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean insertar(Comparable<T> dato) {

        T nuevoDato = (T) dato;

        if (raiz == null) {
            raiz = new ElementoABB<T>(nuevoDato);
            return true;
        }

        return raiz.insertar(nuevoDato);
    }

    // recorridos
    @Override
    public void inOrder(Consumer<T> consumidor) {
        if (raiz != null) {
            raiz.inOrder(elemento -> consumidor.accept(elemento.getDato()));
        }
    }

    @Override
    public void preOrder(Consumer<T> consumidor) {
        if (raiz != null) {
            raiz.preOrder(elemento -> consumidor.accept(elemento.getDato()));
        }
    }

    @Override
    public void postOrder(Consumer<T> consumidor) {
        if (raiz != null) {
            raiz.postOrder(elemento -> consumidor.accept(elemento.getDato()));
        }
    }

    @Override
    public int cantidadNodos() {

        if (raiz == null) {
            return 0;
        }

        return raiz.cantidadNodos();
    }

    @Override
    public int cantidadHojas() {
        // Implementación para contar la cantidad de hojas en el ABB
        if (raiz == null) {
            return 0;
        }

        return raiz.cantidadHojas();
    }

    @Override
    public int cantidadNodosInternos() {
        // Implementación para contar la cantidad de nodos internos en el ABB
        if (raiz == null) {
            return 0;
        }

        return raiz.cantidadNodosInternos();
    }
    public int altura() {
        if (raiz == null) {
            return 0;
        }

        return raiz.altura();
    }
    
    public int ObtenerTamanio() {
        return cantidadNodos();
    }

}
