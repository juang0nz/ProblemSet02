package ucu.edu.aed.tda.Ejercicios.Ejercicio13Practica;

import ucu.edu.aed.tda.TDAArbolBinario;
import ucu.edu.aed.tda.TDALista;
import ucu.edu.aed.tda.impl.AVL;
import ucu.edu.aed.tda.impl.TDAListaConArregloImpl;


public class Federacion {

    TDAArbolBinario<Nave> naves;

    public Federacion() {
        naves = new AVL<>();
    }

    public void insertarNave(Nave nave) {
        naves.insertar(nave);
    }

    TDALista<Integer> exploradoras = new TDAListaConArregloImpl<>();

    public TDALista navesExploradoras (){
        naves.inOrder(nave -> {
            if (nave.getClase().equals("EXPLORADORA")){
                exploradoras.agregar(nave.getCodigo());
            }
        });
        return exploradoras;
    }

    public double combustibleTotal (){
        exploradoras = navesExploradoras();
        double total = 0;
        for(int i = 0; i < exploradoras.tamanio(); i++){
            total += exploradoras.obtener(i);
        }
        return  total / exploradoras.tamanio() ;
    }
}
