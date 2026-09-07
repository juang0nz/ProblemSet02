package ucu.edu.aed.tda.Ejercicios.Ejercicio12;

import java.util.ArrayList;

import ucu.edu.aed.tda.TDAArbolBinario;
import ucu.edu.aed.tda.impl.ABB;

public class Grimorio {

    private TDAArbolBinario<Hechizo> arbol;

    public Grimorio() {
        arbol = new ABB<>();
    }

    public void insertar(Hechizo hechizo) {
        arbol.insertar(hechizo);
    }

public ArrayList<Hechizo> prohibidos() {

    ArrayList<Hechizo> prohibidos = new ArrayList<>();
    // Recorro el árbol en orden y agrego los hechizos con ID impar a la lista de prohibidos.
    arbol.inOrder(hechizo -> {
        if (hechizo.getId() % 2 != 0) {
            prohibidos.add(hechizo);
        }
    });
    return prohibidos;
}
//recorro el arbol y genero la lista separada con " - " para formar el cántico secreto
    public String cantoSecreto() {
        ArrayList<Hechizo> prohibidos = prohibidos();
        StringBuilder canto = new StringBuilder();
        for (int i = 0; i < prohibidos.size(); i++) {
            canto.append(prohibidos.get(i).getNombre());
            if (i < prohibidos.size() - 1) {
                canto.append(" - ");
            }
        }
        return canto.toString();
}
}
/*
psuedocódigo: descripción en lenguaje
natural, pre y post condiciones, pseudocódigo, y análisis de tiempo de ejecución

prohibidos

Lenguaje natural
Recorro el árbol en inorden y agrego a la lista de prohibidos todos los hechizos cuyo ID sea impar.

Precondición: El árbol no está vacío.
Postcondición: La lista de prohibidos contiene todos los hechizos con ID impar.

Pseudocódigo:
prohibidos = []
inOrder(hechizo):
    si hechizo.ID es impar:
        prohibidos.agregar(hechizo)
retornar prohibidos

Análisis de tiempo de ejecución:
Recorrer el árbol en inorden toma O(n).


y de generar el cánto Secreto

lenguaje natural
Recorro la lista de hechizos prohibidos y genero una cadena separada por " - " con los nombres de los hechizos.

Precondición: La lista de hechizos prohibidos no está vacía.
Postcondición: Se retorna una cadena con los nombres de los hechizos prohibidos separados por " - ".

Pseudocódigo:
canto = ""
prohibidos = prohibidos()
para i desde 0 hasta prohibidos.tamaño - 1:
    canto += prohibidos[i].nombre
    si i < prohibidos.tamaño - 1:
        canto += " - "
retornar canto

Análisis de tiempo de ejecución:
Recorrer la lista de hechizos prohibidos toma O(m), donde m es el número de hechizos prohibidos. Concatenar los nombres toma O(1) por cada hechizo, por lo que el tiempo total es O(m).

*/