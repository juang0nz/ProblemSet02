package ucu.edu.aed.tda.Ejercicios;

public class Ejercicio11 {
/* 
OBTENER LA MANERA DE LA MENOR CLAVE DEL ÁRBOL

lenguaje natural

Partiendo desde la raíz del árbol, se recorre sucesivamente el hijo izquierdo
de cada nodo hasta encontrar un nodo que no tenga hijo izquierdo.
La clave almacenada en ese nodo corresponde a la menor clave del árbol.

Precondiciones:
El árbol debe ser un árbol binario de búsqueda válido.
El árbol no debe estar vacío.

Postcondiciones:
Se devuelve la menor clave almacenada en el árbol.
El árbol no es modificado.


Casos de prueba en lenguaje natural

Caso 1: árbol con un único nodo.
La menor clave debe ser la clave de la raíz.

Caso 2: árbol con varios nodos y varios hijos izquierdos.
Debe devolver la clave del nodo ubicado más a la izquierda.

Caso 3: árbol donde la raíz no tiene hijo izquierdo.
La menor clave debe ser la clave de la propia raíz.

Caso 4: verificar que luego de ejecutar la operación el árbol conserve
la misma estructura y los mismos elementos.
    
PSEUDO:

OPERACIÓN menorClave(arbol) : Clave

SI arbol = null ENTONCES
    RETORNAR null
FIN SI

actual ← arbol.raiz

MIENTRAS actual.hijoIzquierdo ≠ null HACER
    actual ← actual.hijoIzquierdo
FIN MIENTRAS
RETORNAR actual.clave
---------------------------------------------------
OPERACIÓN menorClave(nodo) : Clave

SI nodo.hijoIzquierdo = null ENTONCES
    RETORNAR nodo.clave
FIN SI

RETORNAR menorClave(nodo.hijoIzquierdo)

EL ORDEN:
Si el arbol esta balanceado es un caso promedio y es de orden O(log n).
En el peor de los casos, cuando el árbol está degenerado en una lista enlazada hacia la izquierda, el orden es O(n).

*/
/*
OBTENER LA MAYOR CLAVE DEL ÁRBOL

lenguaje natural

Partiendo desde la raíz del árbol, se recorre sucesivamente el hijo derecho
de cada nodo hasta encontrar un nodo que no tenga hijo derecho.
La clave almacenada en ese nodo corresponde a la mayor clave del árbol.

Precondiciones:

El árbol debe ser un árbol binario de búsqueda válido.

El árbol no debe estar vacío.

Postcondiciones:

Se devuelve la mayor clave almacenada en el árbol.

El árbol no es modificado.

Casos de prueba en lenguaje natural

Caso 1: árbol con un único nodo.

La mayor clave debe ser la clave de la raíz.

Caso 2: árbol con varios nodos y varios hijos derechos.

Debe devolver la clave del nodo ubicado más a la derecha.

Caso 3: árbol donde la raíz no tiene hijo derecho.

La mayor clave debe ser la clave de la propia raíz.

Caso 4: verificar que luego de ejecutar la operación el árbol conserve
la misma estructura y los mismos elementos.

PSEUDO:

OPERACIÓN mayorClave(arbol) : Clave

SI arbol = null ENTONCES
    RETORNAR null
FIN SI

actual ← arbol.raiz

MIENTRAS actual.hijoDerecho ≠ null HACER
    actual ← actual.hijoDerecho
FIN MIENTRAS

RETORNAR actual.clave
OPERACIÓN mayorClave(nodo) : Clave

SI nodo.hijoDerecho = null ENTONCES
    RETORNAR nodo.clave
FIN SI

RETORNAR mayorClave(nodo.hijoDerecho)

EL ORDEN:

Si el árbol está balanceado es un caso promedio y es de orden O(log n).

En el peor de los casos, cuando el árbol está degenerado en una lista enlazada hacia la derecha, el orden es O(n). */

/*

OBTENER LA CLAVE INMEDIATA ANTERIOR A UNA CLAVE DADA

lenguaje natural

Partiendo desde la raíz del árbol, se busca la clave indicada.

Si el nodo encontrado tiene hijo izquierdo, la clave inmediata anterior será la mayor clave de
su subárbol izquierdo.

Si el nodo no tiene hijo izquierdo, se debe buscar entre sus antecesores el último nodo cuya clave
sea menor que la clave buscada.


Precondiciones:

El árbol debe ser un árbol binario de búsqueda válido.

El árbol no debe estar vacío.

La clave recibida debe existir en el árbol.


Postcondiciones:

Se devuelve la clave inmediatamente anterior a la clave dada.

El árbol no es modificado.

Si la clave dada es la menor del árbol, no existe una clave anterior y se devuelve null.


Casos de prueba en lenguaje natural

Caso 1: la clave buscada tiene hijo izquierdo.

Se debe devolver la mayor clave existente en su subárbol izquierdo.

Caso 2: la clave buscada no tiene hijo izquierdo.

Se debe devolver el antecesor más cercano cuya clave sea menor que la clave buscada.

Caso 3: la clave buscada es la menor clave del árbol.

No existe una clave inmediatamente anterior, por lo tanto debe devolver null.

Caso 4: verificar que luego de ejecutar la operación el árbol conserve la misma estructura y los mismos elementos.


PSEUDO:

OPERACIÓN claveAnterior(arbol, clave) : Clave

SI arbol = null ENTONCES
    RETORNAR null
FIN SI

actual ← arbol.raiz
anterior ← null

MIENTRAS actual ≠ null HACER

    SI clave > actual.clave ENTONCES
        anterior ← actual
        actual ← actual.hijoDerecho

    SINO SI clave < actual.clave ENTONCES
        actual ← actual.hijoIzquierdo

    SINO
        SI actual.hijoIzquierdo ≠ null ENTONCES
            anterior ← actual.hijoIzquierdo

            MIENTRAS anterior.hijoDerecho ≠ null HACER
                anterior ← anterior.hijoDerecho
            FIN MIENTRAS
        FIN SI

        SI anterior = null ENTONCES
            RETORNAR null
        FIN SI

        RETORNAR anterior.clave
    FIN SI

FIN MIENTRAS

RETORNAR null

OPERACIÓN DE NODO:

OPERACIÓN claveAnterior(nodo, clave, anterior) : Clave

SI nodo = null ENTONCES
    RETORNAR null
FIN SI

SI clave > nodo.clave ENTONCES
    RETORNAR claveAnterior(nodo.hijoDerecho, clave, nodo)
FIN SI

SI clave < nodo.clave ENTONCES
    RETORNAR claveAnterior(nodo.hijoIzquierdo, clave, anterior)
FIN SI

SI nodo.hijoIzquierdo ≠ null ENTONCES
    RETORNAR mayorClave(nodo.hijoIzquierdo)
FIN SI

SI anterior ≠ null ENTONCES
    RETORNAR anterior.clave
FIN SI

RETORNAR null

EL ORDEN:

Si el árbol está balanceado, se recorre como máximo una rama del árbol, por lo que el orden es O(log n).

En el peor de los casos, cuando el árbol está degenerado, puede ser necesario recorrer todos los nodos de una rama, por lo que el orden es O(n).
*/


/*
OBTENER LA CANTIDAD DE NODOS DE UN NIVEL DADO

lenguaje natural

Partiendo desde la raíz del árbol, se recorre el árbol llevando la cuenta
del nivel en el que se encuentra cada nodo.

Cuando se alcanza el nivel indicado por parámetro, se cuenta cada nodo que pertenezca a ese nivel.

La suma total de esos nodos corresponde a la cantidad de nodos del nivel solicitado.


Precondiciones:

El árbol puede estar vacío o contener nodos.

El nivel recibido debe ser mayor o igual a 0.

Se considera que la raíz se encuentra en el nivel 0.


Postcondiciones:

Se devuelve la cantidad de nodos que existen en el nivel indicado.

El árbol no es modificado.

Si el nivel no existe en el árbol, se devuelve 0.

Casos de prueba en lenguaje natural

Caso 1: árbol con un único nodo y nivel solicitado igual a 0.

Debe devolver 1.

Caso 2: árbol con varios nodos y nivel solicitado existente.

Debe devolver la cantidad exacta de nodos que se encuentran en ese nivel.

Caso 3: nivel solicitado mayor que la altura del árbol.

Debe devolver 0.

Caso 4: árbol vacío.

Debe devolver 0.

Caso 5: verificar que luego de ejecutar la operación el árbol conserve la
misma estructura y los mismos elementos.

PSEUDO:

OPERACIÓN cantidadEnNivel(arbol, nivel) : Entero

SI arbol = null ENTONCES
    RETORNAR 0
FIN SI

RETORNAR cantidadEnNivel(arbol.raiz, nivel)
OPERACIÓN cantidadEnNivel(nodo, nivel) : Entero

SI nodo = null ENTONCES
    RETORNAR 0
FIN SI

SI nivel = 0 ENTONCES
    RETORNAR 1
FIN SI

RETORNAR cantidadEnNivel(nodo.hijoIzquierdo, nivel - 1)
    + cantidadEnNivel(nodo.hijoDerecho, nivel - 1)

EL ORDEN:

En el peor de los casos, el algoritmo puede recorrer todos los nodos del árbol 
hasta llegar al nivel solicitado, por lo tanto el orden es O(n).

Si el nivel solicitado está cerca de la raíz, puede visitar menos nodos, pero el
análisis general del peor caso sigue siendo O(n).
*/


/*
LISTAR TODAS LAS HOJAS, CADA UNA CON SU NIVEL

lenguaje natural

Partiendo desde la raíz del árbol, se recorren recursivamente todos los nodos llevando 
la cuenta del nivel actual.
Cuando se encuentra un nodo que no tiene hijo izquierdo ni hijo derecho, se considera una
 hoja y se muestra su clave junto con el nivel en el que se encuentra.


Precondiciones:

El árbol puede estar vacío o contener nodos.
Se considera que la raíz se encuentra en el nivel 0.

Postcondiciones:

Se listan todas las hojas del árbol junto con el nivel en el que se encuentra cada una.
El árbol no es modificado.
Si el árbol está vacío, no se lista ninguna hoja.


Casos de prueba en lenguaje natural

Caso 1: árbol con un único nodo.

La raíz es también una hoja, por lo tanto debe listarse su clave con nivel 0.

Caso 2: árbol con varias hojas ubicadas en el mismo nivel.

Deben listarse todas las hojas indicando el mismo nivel para cada una.

Caso 3: árbol con hojas ubicadas en diferentes niveles.

Cada hoja debe listarse junto con el nivel que le corresponde.

Caso 4: árbol vacío.

No debe listarse ninguna hoja.

Caso 5: verificar que luego de ejecutar la operación el árbol conserve la misma estructura y los mismos elementos.


PSEUDO:
OPERACIÓN listarHojas(arbol)

SI arbol = null ENTONCES
    RETORNAR
FIN SI

listarHojas(arbol.raiz, 0)
OPERACIÓN listarHojas(nodo, nivel)

SI nodo = null ENTONCES
    RETORNAR
FIN SI

SI nodo.hijoIzquierdo = null Y nodo.hijoDerecho = null ENTONCES
    MOSTRAR nodo.clave, nivel
    RETORNAR
FIN SI

listarHojas(nodo.hijoIzquierdo, nivel + 1)

listarHojas(nodo.hijoDerecho, nivel + 1)

EL ORDEN:

Para determinar cuáles son las hojas, el algoritmo debe recorrer todos los nodos del árbol.

Por lo tanto, tanto si el árbol está balanceado como si está degenerado, en el peor caso el 
orden es O(n), siendo n la cantidad de nodos del árbol.
*/

/*
VERIFICAR SI EL ÁRBOL ES DE BÚSQUEDA

lenguaje natural

Partiendo desde la raíz del árbol, se verifica que para cada nodo todas las claves de su subárbol
izquierdo sean menores que la clave del nodo y todas las claves de su subárbol derecho sean mayores.
Para realizar la verificación se mantienen límites mínimo y máximo permitidos para cada nodo.
Si todos los nodos cumplen con los límites correspondientes, el árbol es un árbol binario de búsqueda.

Precondiciones:

El árbol puede estar vacío o contener nodos.
Las claves almacenadas en los nodos deben poder compararse entre sí.
No se consideran claves repetidas.

Postcondiciones:

Se devuelve verdadero si el árbol cumple con las propiedades de un árbol binario de búsqueda.
Se devuelve falso si algún nodo no cumple con las propiedades de un árbol binario de búsqueda.
El árbol no es modificado.


Casos de prueba en lenguaje natural

Caso 1: árbol vacío.
Debe devolver verdadero, ya que no existe ningún nodo que incumpla la propiedad de búsqueda.

Caso 2: árbol con un único nodo.
Debe devolver verdadero.

Caso 3: árbol con varios nodos que cumple correctamente la propiedad de búsqueda.
Debe devolver verdadero.

Caso 4: árbol donde un hijo izquierdo tiene una clave mayor que su padre.
Debe devolver falso.

Caso 5: árbol donde un hijo derecho tiene una clave menor que su padre.
Debe devolver falso.

Caso 6: árbol donde los hijos directos cumplen la condición, pero un nodo más profundo
viola la propiedad del árbol de búsqueda.
Debe devolver falso.

Caso 7: verificar que luego de ejecutar la operación el árbol conserve la misma estructura
y los mismos elementos.

PSEUDO:

OPERACIÓN esArbolDeBusqueda(arbol) : Booleano

SI arbol = null ENTONCES
    RETORNAR verdadero
FIN SI

RETORNAR esArbolDeBusqueda(arbol.raiz, null, null)

-------------------------------------------------------------
OPERACIÓN esArbolDeBusqueda(nodo, minimo, maximo) : Booleano

SI nodo = null ENTONCES
    RETORNAR verdadero
FIN SI

SI minimo ≠ null Y nodo.clave <= minimo ENTONCES
    RETORNAR falso
FIN SI

SI maximo ≠ null Y nodo.clave >= maximo ENTONCES
    RETORNAR falso
FIN SI

RETORNAR esArbolDeBusqueda(nodo.hijoIzquierdo, minimo, nodo.clave)
    Y esArbolDeBusqueda(nodo.hijoDerecho, nodo.clave, maximo)

EL ORDEN:

Para verificar que el árbol sea de búsqueda es necesario comprobar todos sus nodos.

Por lo tanto, tanto si el árbol está balanceado como si está degenerado, en el peor caso el orden es O(n), siendo n la cantidad de nodos del árbol.
*/








}
