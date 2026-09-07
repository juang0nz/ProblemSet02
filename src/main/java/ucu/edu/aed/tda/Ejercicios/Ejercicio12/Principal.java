package ucu.edu.aed.tda.Ejercicios.Ejercicio12;

import ucu.edu.aed.tda.TDALista;
import ucu.edu.aed.tda.impl.TDAListaConArregloImpl;

public class Principal {
    public static void main(String[] args) {

        Grimorio grimorio = new Grimorio();

        // insertar y crear hechizos en el grimorio
        grimorio.insertar(new Hechizo(42, "Fireball"));
        grimorio.insertar(new Hechizo(17, "Ice Lance"));
        grimorio.insertar(new Hechizo(58, "Thunder"));
        grimorio.insertar(new Hechizo(9, "Invisibility"));
        grimorio.insertar(new Hechizo(31, "Levitate"));
        grimorio.insertar(new Hechizo(73, "Summon"));
        grimorio.insertar(new Hechizo(25, "Heal"));
        grimorio.insertar(new Hechizo(50, "Teleport"));
        grimorio.insertar(new Hechizo(65, "Shield"));
        grimorio.insertar(new Hechizo(88, "Curse"));

        // consultar prohibidos
        TDALista<Hechizo> prohibidos = grimorio.prohibidos();
        // imprimo los hechizos para comprobar:
        System.out.println("Hechizos prohibidos:");
        for (int i = 0; i < prohibidos.tamanio(); i++) {
            Hechizo hechizo = prohibidos.obtener(i);
            System.out.println(hechizo.getNombre() + " (ID: " + hechizo.getId() + ")");
        }

        // Generar e imprimir el cántico secreto
        String cantoSecreto = grimorio.cantoSecreto();
        System.out.println("Canto secreto: " + cantoSecreto);

    }
}
