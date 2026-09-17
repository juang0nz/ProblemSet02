package ucu.edu.aed.tda.Ejercicios.Ejercicio13Practica;

public class Sistema {

    public static void main (String[] args) {

        Federacion naves = new Federacion();

        naves.insertarNave(new Nave(10, "EXPLORADORA", 0));
        naves.insertarNave(new Nave(20, "Destructor", 90));
        naves.insertarNave(new Nave(30, "Medica", 100));
        naves.insertarNave(new Nave(40, "EXPLORADORA", 50));
        naves.insertarNave(new Nave(50, "Carguero", 20));
        naves.insertarNave(new Nave(60, "Destructor", 28));
        naves.insertarNave(new Nave(70, "EXPLORADORA", 14));
        naves.insertarNave(new Nave(80, "Medica", 7));
        naves.insertarNave(new Nave(90, "Carguero", 23));
        naves.insertarNave(new Nave(100, "EXPLORADORA", 26));

        System.out.println("Naves exploradoras: " + naves.navesExploradoras());
        System.out.println("Combustible total: " + naves.combustibleTotal());
    
    }
}
