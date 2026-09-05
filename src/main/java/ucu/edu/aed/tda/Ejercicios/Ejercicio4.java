package ucu.edu.aed.tda.Ejercicios;

public class Ejercicio4 {

    /*Definir pre y post - condiciones de un algoritmo para obtener la altura de un árbol binario
de búsqueda */

/*
Precondiciones:
ABB no nulo
puedes ser vacio o no
cada nodo tiene como máximo dos hijos
*/
/*
Postcondiciones:
se obtiene la altura del árbol binario de búsqueda
no se modifica el árbol existente
*/
    
/*
Casos de prueba que podemos hacer:
Arbol vacio y que devuelva 0
Con un solo nodo y que me de altura 1
Podemos cargar todo en un subarbol izquierdo o derecho y que me devuelva la cantidad de nodos.
podemos calcular la altura normalmente y luego ver que no modifica el arbol*/



/* Árbol vacío

Crear árbol vacío
alturaObtenida ← altura(arbol)

SI alturaObtenida = 0 ENTONCES
    Mostrar "Prueba correcta"
SINO
    Mostrar "Prueba incorrecta"
FIN SI */
/* Árbol con un solo nodo

Crear árbol con un solo nodo
alturaObtenida ← altura(arbol)

SI alturaObtenida = 1 ENTONCES
    Mostrar "Prueba correcta"
SINO
    Mostrar "Prueba incorrecta"
FIN SI */
/* Árbol con todos los nodos en el subárbol izquierdo

Crear árbol con todos los nodos en el subárbol izquierdo
alturaObtenida ← altura(arbol)

SI alturaObtenida = cantidadDeNodos ENTONCES
    Mostrar "Prueba correcta"
SINO
    Mostrar "Prueba incorrecta"
FIN SI */

/* Árbol con todos los nodos en el subárbol derecho

Crear árbol con todos los nodos en el subárbol derecho
alturaObtenida ← altura(arbol)

SI alturaObtenida = cantidadDeNodos ENTONCES
    Mostrar "Prueba correcta"
SINO
    Mostrar "Prueba incorrecta"
FIN SI */
/* Árbol con altura calculada normalmente

Crear árbol con varios nodos
alturaObtenida ← altura(arbol)

SI alturaObtenida = alturaEsperada ENTONCES
    Mostrar "Prueba correcta"
SINO
    Mostrar "Prueba incorrecta"
FIN SI
Y verificar que el árbol no ha sido modificado
*/
}
