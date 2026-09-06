package ucu.edu.aed.tda.Ejercicios;

import ucu.edu.aed.tda.TDAElemento;
import ucu.edu.aed.tda.impl.ArbolBinario;
import ucu.edu.aed.tda.impl.ElementoAB;

public class Ejercicio7 {
    public static void main(String[] args) {

        // creo el arbol con el cual voy a operar segun el ejercicio 7 me pide

        ArbolBinario<String> arbol = new ArbolBinario<>();
        TDAElemento<String> elemento = new ElementoAB<>("*");
        arbol.setRaiz(elemento);
        TDAElemento<String> hijoIzquierdo = new ElementoAB<>("+");
        TDAElemento<String> hijoDerecho = new ElementoAB<>("2");
        TDAElemento<String> hijoIzquierdoIzquierdo = new ElementoAB<>("3");
        TDAElemento<String> hijoIzquierdoDerecho = new ElementoAB<>("x");
        elemento.setHijoIzquierdo(hijoIzquierdo);
        elemento.setHijoDerecho(hijoDerecho);
        hijoIzquierdo.setHijoIzquierdo(hijoIzquierdoIzquierdo);
        hijoIzquierdo.setHijoDerecho(hijoIzquierdoDerecho);
        // para comprobar si me habia armado correctamente el árbol
        // arbol.inOrder(System.out::println);

        // sustituir la variable "x" por un valor dado
        sustituirVariable(elemento, "x", "5");
        arbol.inOrder(System.out::println);
        System.out.println("Resultado de la evaluación: " + evaluar(elemento));

        // PARTE 2
        /*
         * crearNodo()
         * 
         * leer siguiente elemento
         * 
         * si es un número o variable:
         * crear nodo
         * devolver nodo
         * 
         * si es un operador:
         * crear nodo operador
         * 
         * construir su hijo izquierdo
         * construir su hijo derecho
         * 
         * devolver nodo
         * 
         */

        ArbolBinario<String> arbol2 = new ArbolBinario<>();
        // la expresion ya esta en notación prefija osea tiene la forma operador primero
        // seguido de sus operandos
        String expresion = "* + 3 x 2";
        // separo las partes de la expresión por espacios
        String[] elementos = expresion.split(" ");

        // imprimir los elementos de la expresión para probar si hice bien
        for (String e : elementos) {
            System.out.println(e);
        }
        posicion = 0; // reiniciar la posición antes de crear el árbol
        arbol2.setRaiz(crearArbol(elementos));
        System.out.println("Árbol creado a partir de la expresión prefija:"); 
        arbol2.inOrder(System.out::println); //imprime el árbol en orden

    }

    static void sustituirVariable(TDAElemento<String> nodo, String variable, String valor) {
        // caso base: si el nodo es nulo, simplemente retornamos
        if (nodo == null) {
            return;
        }
        // si el nodo contiene la variable que queremos sustituir, la reemplazamos por
        // el valor dado
        if (nodo.getDato().equals(variable)) {
            nodo.setDato(valor);
        }
        // llamamos recursivamente a la función para los hijos izquierdo y derecho del
        // nodo actual
        sustituirVariable(nodo.getHijoIzquierdo(), variable, valor);
        sustituirVariable(nodo.getHijoDerecho(), variable, valor);
    }
    /*
     * Lenguaje natural:
     * 
     * Para evaluar *
     * 
     * primero evaluar +
     * → evaluar 3 → devuelve 3
     * → evaluar 5 → devuelve 5
     * → sumar 3 + 5 → devuelve 8
     * evaluar 2 → devuelve 2
     * 
     * multiplicar 8 * 2 → devuelve 16
     * 
     * Resultado final: 16
     */

    static double evaluar(TDAElemento<String> nodo) {
        // caso base: si el nodo es nulo, retornamos 0
        if (nodo == null) {
            return 0;
        }
        // obtenemos el dato del nodo actual
        String dato = nodo.getDato();

        switch (dato) {
            // evaluamos el nodo según su operador o valor numérico
            case "+":
                // sumamos los valores de los hijos izquierdo y derecho
                return evaluar(nodo.getHijoIzquierdo()) + evaluar(nodo.getHijoDerecho());
            case "-":
                // restamos los valores de los hijos izquierdo y derecho
                return evaluar(nodo.getHijoIzquierdo()) - evaluar(nodo.getHijoDerecho());
            case "*":
                // multiplicamos los valores de los hijos izquierdo y derecho
                return evaluar(nodo.getHijoIzquierdo()) * evaluar(nodo.getHijoDerecho());
            case "/":
                // dividimos los valores de los hijos izquierdo y derecho
                return evaluar(nodo.getHijoIzquierdo()) / evaluar(nodo.getHijoDerecho());

            // default: si el nodo contiene un valor numérico, lo convertimos a double y lo
            // retornamos
            default:
                return Double.parseDouble(dato);
        }
    }

    // metodo auxiliar
    static boolean esOperador(String dato) {
        return dato.equals("+") ||
                dato.equals("-") ||
                dato.equals("*") ||
                dato.equals("/");
    }

    static int posicion = 0;

    static TDAElemento<String> crearArbol(String[] partes) {

        String dato = partes[posicion];
        posicion++;

        TDAElemento<String> nodo = new ElementoAB<>(dato);

        if (esOperador(dato)) {
            nodo.setHijoIzquierdo(crearArbol(partes));
            nodo.setHijoDerecho(crearArbol(partes));
        }

        return nodo;
    }

}


/*
 * POSIBLES SITUACIONES DE ERROR:
 *
 * 1. Expresión vacía.
 *    Ejemplo: ""
 *    No se puede construir un árbol porque no existen elementos.
 *
 * 2. Faltan operandos.
 *    Ejemplo: "* + 3"
 *    Como los operadores son binarios, cada operador debe tener
 *    exactamente dos operandos. En este caso la expresión termina
 *    antes de completar el árbol.
 *
 * 3. Sobran elementos.
 *    Ejemplo: "+ 3 5 8"
 *    El árbol queda completo con "+ 3 5", por lo que el "8"
 *    queda sin utilizar y la expresión no es válida.
 *
 * 4. Operador no válido.
 *    Los únicos operadores aceptados son:
 *    +, -, * y /
 *
 * 5. División entre cero.
 *    La expresión puede estar correctamente formada, pero al evaluarla
 *    se debe controlar que el divisor no sea cero.
 *
 * 6. Variable sin valor asignado.
 *    Si al momento de evaluar el árbol todavía existe una variable,
 *    no se podrá convertir su contenido a un valor numérico.
 */

/*PARTE 3

-------EJEMPLO 1

Expresión:
(4 + 2) * 3

Notación prefija:
* + 4 2 3
--------EJEMPLO 2

Expresión:
(10 - 4) / 2

Notación prefija:
/ - 10 4 2
--------EJEMPLO 3

Expresión:
8 + (6 * 2)

Notación prefija:
+ 8 * 6 2


--------EJEMPLO 4

Expresión:
(8 - 2) * (3 + 1)

Notación prefija:
* - 8 2 + 3 1*/


/*
 * EJEMPLO DE EJECUCIÓN MANUAL
 *
 * Expresión aritmética:
 * (4 + 2) * 3
 *
 * Notación prefija:
 * * + 4 2 3
 *
 * CONSTRUCCIÓN DEL ÁRBOL:
 *
 * 1. Se lee "*".
 *    Es un operador, por lo tanto se crea el nodo "*" y se deben
 *    construir su hijo izquierdo y su hijo derecho.
 *
 * 2. Se lee "+".
 *    Es un operador, por lo tanto se crea como hijo izquierdo de "*"
 *    y se deben construir sus dos hijos.
 *
 * 3. Se lee "4".
 *    No es un operador, por lo tanto se crea como hoja y queda como
 *    hijo izquierdo de "+".
 *
 * 4. Se lee "2".
 *    No es un operador, por lo tanto se crea como hoja y queda como
 *    hijo derecho de "+".
 *
 * 5. El nodo "+" ya tiene sus dos hijos, por lo que se vuelve al nodo "*".
 *
 * 6. Se lee "3".
 *    No es un operador, por lo tanto se crea como hoja y queda como
 *    hijo derecho de "*".
 *
 * El árbol resultante es:
 *
 *          *
 *         / \
 *        +   3
 *       / \
 *      4   2
 *
 *
 * EJECUCIÓN DEL ALGORITMO DE LA PARTE 1:
 *
 * En este ejemplo no existen variables, por lo que no es necesario
 * realizar ninguna sustitución.
 *
 * Para evaluar la expresión se utiliza el recorrido postorden:
 *
 * 4, 2, +, 3, *
 *
 * Primero se evalúa:
 * 4 + 2 = 6
 *
 * Luego:
 * 6 * 3 = 18
 *
 * Resultado final: 18
 */