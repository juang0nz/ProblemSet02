package ucu.edu.aed.tda.Ejercicios;

import ucu.edu.aed.tda.TDALista;
import ucu.edu.aed.tda.impl.AVL;
import ucu.edu.aed.tda.impl.TDAListaConArregloImpl;

public class Ejercicio13 {

    static class Nave implements Comparable<Nave> {
        int codigo;
        String clase;
        int combustible;

        public Nave(int codigo, String clase, int combustible) {
            this.codigo = codigo;
            this.clase = clase;
            this.combustible = combustible;
        }

        @Override
        public int compareTo(Nave otra) {
            return Integer.compare(this.codigo, otra.codigo);
        }

        @Override
        public String toString() {
            return codigo + "(" + clase + "," + combustible + ")";
        }
    }

    static TDALista<Integer> identificarExploradoras(AVL<Nave> arbol) {
        TDALista<Integer> resultado = new TDAListaConArregloImpl<>();
        arbol.preOrder(nave -> {
            if (nave.clase.equals("Explorador")) {
                resultado.agregar(nave.codigo);
            }
        });
        return resultado;
    }

    static double combustiblePromedioExploradoras(AVL<Nave> arbol) {
        int[] contador = {0};
        int[] sumaCombustible = {0};

        arbol.preOrder(nave -> {
            if (nave.clase.equals("Explorador")) {
                contador[0]++;
                sumaCombustible[0] += nave.combustible;
            }
        });

        if (contador[0] == 0) {
            return 0;
        }

        return (double) sumaCombustible[0] / contador[0];
    }

    public static void main(String[] args) {

        AVL<Nave> registro = new AVL<>();

        registro.insertar(new Nave(10, "Explorador", 0));
        registro.insertar(new Nave(20, "Destructor", 90));
        registro.insertar(new Nave(30, "Medica", 100));
        registro.insertar(new Nave(40, "Explorador", 50));
        registro.insertar(new Nave(50, "Carguero", 20));
        registro.insertar(new Nave(60, "Destructor", 28));
        registro.insertar(new Nave(70, "Explorador", 14));
        registro.insertar(new Nave(80, "Medica", 7));
        registro.insertar(new Nave(90, "Carguero", 23));
        registro.insertar(new Nave(100, "Explorador", 26));

        // Verificacion: preorden y altura del arbol (Parte 1)
        StringBuilder preorden = new StringBuilder();
        registro.preOrder(n -> preorden.append(n.codigo).append(" "));
        System.out.println("Preorden: " + preorden.toString().trim());
        System.out.println("Altura del arbol: " + registro.altura());

        // Parte 2: identificar naves exploradoras
        TDALista<Integer> exploradoras = identificarExploradoras(registro);
        System.out.println("Naves exploradoras: " + exploradoras);

        // Parte 3: combustible promedio de las exploradoras
        double promedio = combustiblePromedioExploradoras(registro);
        System.out.println("Combustible promedio exploradoras: " + promedio);
    }
}