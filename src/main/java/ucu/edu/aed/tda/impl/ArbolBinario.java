package ucu.edu.aed.tda.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import ucu.edu.aed.tda.TDAArbolBinario;
import ucu.edu.aed.tda.TDAElemento;

public class ArbolBinario <T> implements TDAArbolBinario <T>{

    private TDAElemento<T> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public TDAElemento<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(TDAElemento<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public T buscar(Comparable<T> predicate) {
        if (raiz == null) {
            return null;
        }
        TDAElemento<T> encontrado = raiz.buscar(predicate);
        return encontrado == null ? null : encontrado.getDato();
    }

    @Override
    public TDAElemento<T> obtenerRaiz() {
        return raiz;
    }

    @Override
    public boolean eliminar(Comparable<T> criterioBusqueda) {
        if (raiz == null) {
            return false;
        }

        TDAElemento<T> encontrado = raiz.buscar(criterioBusqueda);
        if (encontrado == null) {
            return false;
        }

        raiz = raiz.eliminar(criterioBusqueda);
        return true;
    }

    @Override
    public boolean insertar(Comparable<T> dato) {
        if (raiz == null) {
            raiz = new ElementoAB<>((T) dato);
            return true;
        }
        return raiz.insertar((T) dato);
    }

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
    public boolean esVacio() {
        return raiz == null;
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
        if (raiz == null) {
            return 0;
        }
        return raiz.cantidadHojas();
    }

    @Override
    public int cantidadNodosInternos() {
        if (raiz == null) {
            return 0;
        }
        return raiz.cantidadNodosInternos();
    }

    @Override
    public int altura() {
        if (raiz == null) {
            return 0;
        }
        return raiz.altura();
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
        if (raiz == null) {
            return new ArrayList<>();
        }
        return ((ElementoAB<T>) raiz).completos();
    }

    public List<TDAElemento<T>> enNivel(int nivel) {
        if (raiz == null) {
            return new ArrayList<>();
        }
        return ((ElementoAB<T>) raiz).enNivel(nivel);
    }
}
