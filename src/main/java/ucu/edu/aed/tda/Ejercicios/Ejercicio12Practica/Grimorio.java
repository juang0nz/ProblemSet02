package ucu.edu.aed.tda.Ejercicios.Ejercicio12Practica;

import ucu.edu.aed.tda.TDAArbolBinario;
import ucu.edu.aed.tda.TDALista;
import ucu.edu.aed.tda.impl.ABB;
import ucu.edu.aed.tda.impl.TDAListaConArregloImpl;


public class Grimorio {

    TDAArbolBinario<Hechizo> coleccion;

    public Grimorio() {
        coleccion = new ABB<>();
    }

    public void insertar(Hechizo hechizo) {
        coleccion.insertar(hechizo);
    }

    

public TDALista<Hechizo> prohibidos() {

    TDALista<Hechizo> prohibidos = new TDAListaConArregloImpl<>();
    // Recorro el árbol en orden y agrego los hechizos con ID impar a la lista de prohibidos.
    coleccion.inOrder(hechizo -> {
        if (hechizo.getId() % 2 != 0) {
            prohibidos.agregar(hechizo);
        }
    });
    return prohibidos;
}
public String generarCantico() {

    String canto = "";

    TDALista<Hechizo> prohibidos = prohibidos();

    for (int i = 0; i < prohibidos.tamanio(); i++) {
        canto = canto + prohibidos.obtener(i).getNombre() + "-";
    }

    return canto;
}

public void imprimirInOrden() {

    coleccion.inOrder(hechizo -> {
        System.out.println(hechizo.getNombre());
    });
}


}