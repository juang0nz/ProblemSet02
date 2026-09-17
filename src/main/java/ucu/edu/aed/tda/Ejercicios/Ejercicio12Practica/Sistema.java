package ucu.edu.aed.tda.Ejercicios.Ejercicio12Practica;

public class Sistema {

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

        grimorio.imprimirInOrden();

        System.out.println(grimorio.generarCantico());
    }
}