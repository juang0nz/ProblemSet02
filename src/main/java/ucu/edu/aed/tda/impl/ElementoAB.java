package ucu.edu.aed.tda.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import ucu.edu.aed.tda.TDAElemento;

public class ElementoAB <T> implements TDAElemento<T> {

    public ElementoAB() {
        this(null);
    }

    public ElementoAB(T dato) {
        this.dato = dato;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    private T dato;
    private TDAElemento<T> hijoIzquierdo;
    private TDAElemento<T> hijoDerecho;

    @Override
    public int altura() {

        int izquierda = 0;
        int derecha = 0;

        if (hijoIzquierdo != null) {
            izquierda = hijoIzquierdo.altura();
        }

        if (hijoDerecho != null) {
            derecha = hijoDerecho.altura();
        }

        return 1 + Math.max(izquierda, derecha);
    }

    @Override
    public int cantidadNodos() {

        int izquierda = 0;
        int derecha = 0;

        if (hijoIzquierdo != null) {
            izquierda = hijoIzquierdo.cantidadNodos();
        }

        if (hijoDerecho != null) {
            derecha = hijoDerecho.cantidadNodos();
        }

        return 1 + izquierda + derecha;
    }

    @Override
    public int cantidadHojas() {

        if (hijoIzquierdo == null && hijoDerecho == null) {
            return 1;
        }

        int izquierda = 0;
        int derecha = 0;

        if (hijoIzquierdo != null) {
            izquierda = hijoIzquierdo.cantidadHojas();
        }

        if (hijoDerecho != null) {
            derecha = hijoDerecho.cantidadHojas();
        }

        return izquierda + derecha;
    }

    @Override
    public int cantidadNodosInternos() {

        if (hijoIzquierdo == null && hijoDerecho == null) {
            return 0;
        }

        int izquierda = 0;
        int derecha = 0;

        if (hijoIzquierdo != null) {
            izquierda = hijoIzquierdo.cantidadNodosInternos();
        }

        if (hijoDerecho != null) {
            derecha = hijoDerecho.cantidadNodosInternos();
        }

        return 1 + izquierda + derecha;
    }

    public int tamanio() {
        return cantidadNodos();
    }

    public int hojas() {
        return cantidadHojas();
    }

    public int internos() {
        return cantidadNodosInternos();
    }

    public List<TDAElemento<T>> completos() {
        List<TDAElemento<T>> resultado = new ArrayList<>();
        completosRecursivo(this, resultado);
        return resultado;
    }
// Métodos auxiliares para obtener los nodos completos y los nodos en un nivel específico.
    private void completosRecursivo(TDAElemento<T> nodo, List<TDAElemento<T>> resultado) {
        if (nodo == null) {
            return;
        }

        if (nodo.getHijoIzquierdo() != null && nodo.getHijoDerecho() != null) {
            resultado.add(nodo);
        }
// completosRecursivo es un método auxiliar que recorre el árbol en busca de nodos completos (con ambos hijos).
        completosRecursivo(nodo.getHijoIzquierdo(), resultado);
        completosRecursivo(nodo.getHijoDerecho(), resultado);
    }
// enNivelRecursivo es un método auxiliar que recorre el árbol en busca de nodos en un nivel específico.
    public List<TDAElemento<T>> enNivel(int nivel) {
        List<TDAElemento<T>> resultado = new ArrayList<>();
        enNivelRecursivo(this, nivel, resultado);
        return resultado;
    }
// enNivel es un método que devuelve una lista de nodos en un nivel específico del árbol.
    private void enNivelRecursivo(TDAElemento<T> nodo, int nivel, List<TDAElemento<T>> resultado) {
        if (nodo == null) {
            return;
        }

        if (nivel == 0) {
            resultado.add(nodo);
            return;
        }

        enNivelRecursivo(nodo.getHijoIzquierdo(), nivel - 1, resultado);
        enNivelRecursivo(nodo.getHijoDerecho(), nivel - 1, resultado);
    }

    @Override
    public void setHijoIzquierdo(TDAElemento<T> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    @Override
    public void setHijoDerecho(TDAElemento<T> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    @Override
    public TDAElemento<T> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    @Override
    public TDAElemento<T> getHijoDerecho() {
        return hijoDerecho;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public TDAElemento<T> buscar(Comparable<T> criterioBusqueda) {
        return null;
    }

    @Override
    public TDAElemento<T> eliminar(Comparable<T> criterioBusqueda) {
        return null;
    }

    @Override
    public boolean insertar(T nuevoDato) {
        return false;
    }

@Override
public void inOrder(Consumer<TDAElemento<T>> consumidor) {

    if (hijoIzquierdo != null) {
        hijoIzquierdo.inOrder(consumidor);
    }

    consumidor.accept(this);

    if (hijoDerecho != null) {
        hijoDerecho.inOrder(consumidor);
    }
}

    @Override
    public void preOrder(Consumer<TDAElemento<T>> consumidor) {
        consumidor.accept(this);

        if (hijoIzquierdo != null) {
            hijoIzquierdo.preOrder(consumidor);
        }

        if (hijoDerecho != null) {
            hijoDerecho.preOrder(consumidor);
        }
    }

    @Override
    public void postOrder(Consumer<TDAElemento<T>> consumidor) {
        if (hijoIzquierdo != null) {
            hijoIzquierdo.postOrder(consumidor);
        }

        if (hijoDerecho != null) {
            hijoDerecho.postOrder(consumidor);
        }

        consumidor.accept(this);
    }

    @Override
    public boolean esHoja() {
        return hijoIzquierdo == null && hijoDerecho == null;
    }

    @Override
    public int obtenerNivel(Comparable<T> criterioBusqueda) {
        return -1;
    }

}
