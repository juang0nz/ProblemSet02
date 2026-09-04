package ucu.edu.aed.tda.impl;

import java.util.function.Consumer;

import ucu.edu.aed.tda.TDAElemento;

public class ElementImpl<T extends Comparable<T>> implements TDAElemento<T> {
    private T dato;
    private TDAElemento<T> hijoIzq;
    private TDAElemento<T> hijoDer;
    
    @Override
    public ElementImpl(T DatoElemento){
        this.dato=DatoElemento;
        hijoDer=null;
        hijoIzq=null;
    }
    @Override
    public void setHijoIzquierdo(TDAElemento<T> hijoIzquierdo){
        this.hijoIzq = hijoIzquierdo;
        
    }

    /**
     * Asigna el nodo derecho del nodo actual. Puede ser nulo.
     */
    @Override
    public void setHijoDerecho(TDAElemento<T> hijoDerecho){
    this.hijoDer = hijoDerecho;
        
    }

    /**
     * Devuelve el hijo derecho del nodo actual. El valor es nulo si no tiene hijo derecho.
     */
    @Override
    public TDAElemento<T> getHijoIzquierdo(){
        return hijoIzq;
    }

    /**
     * Devuelve el hijo izquierdo del nodo actual. El valor es nulo si no tiene hijo izquierdo.
     */
    @Override
    public TDAElemento<T> getHijoDerecho(){
         return hijoDer;
    }

    /**
     * Actualiza el dato del nodo actual.
     */
    @Override
    public void setDato(T datoNuevo){
        this.dato=datoNuevo;
    }

    /**
     * devuelve el dato del nodo actual.
     */
    @Override
    public T getDato(){
        return dato;
    }
    /**
     * Busca un nodo por un criterio de búsqueda.
     * Si no se encuentra, retorna nulo.
     */
    @Override
    public TDAElemento<T> buscar(Comparable<T> criterioBusqueda){
        TDAElemento<T> resultado=null;
        if (criterioBusqueda(this.dato)==0){
            resultado=this;
        }
        else{
            if (criterioBusqueda(this.dato)<0) {
                if (hijoIzq!=null){
                    resultado=hijoIzq.buscar(criterioBusqueda);
                }
        else{
            if(hijoDer!=null){
                resultado=hijoDer.buscar(criterioBusqueda);}
        
            }

        }
    
        }
        return resultado;
    }
    /**
     * Elimina un nodo del árbol según el criterio de búsqueda.
     * Si se encuentra, se retorna el nodo borrado. En otro caso retornar null.
     */
    @Override
    public TDAElemento<T> eliminar(Comparable<T> criterioBusqueda){
        if(criterioBusqueda(this.dato)<0){
            if (this.hijoIzq(criterioBusqueda)){
                this.hijoIzq=this.hijoIzq.eliminar(criterioBusqueda);
            }
            else{
                if (criterioBusqueda.compareTo(this.dato)>0) {
                    if (this.hijoDer !=null){
                        this.hijoDer=this.hijoDer.eliminar(criterioBusqueda);
                    }
                    return this;
                }
            }
        return quitarNodo();
        }
    }
    
    private TDAElemento<T> quitarNodo(){
        if (this.hijoIzq == null){
            return this.hijoDer;
        }
        else{
            if (this.hijoDer == null){
            return this.hijoIzq;
            }   
            else{
                    //es un nodo completo
                TDAElemento<T> elHijo = this.hijoIzq;
                TDAElemento<T> elPadre = this;
                while (elHijo.getHijoDerecho() != null){
                    elPadre = elHijo;
                    elHijo = elHijo.getHijoDerecho();
                }
                if (elPadre != this){
                    elPadre.setHijoDerecho(elHijo.getHijoIzquierdo());
                    elHijo.setHijoIzquierdo(this.hijoIzq);
                }
                elHijo.setHijoDerecho(hijoDer);
                return elHijo;
            }
        }
    }
    /**
     * Agrega un nuevo elemento al árbol
     * Si el nuevoDato existe, no se agrega
     */
    @Override
    public boolean insertar(T nuevoDato){
        if (nuevoDato.compareTo(this.dato)>0){
            if (hijoDer=null){
                hijoDer = new Elementoimpl<>(nuevoDato);
            return true;
            }
            else{
                hijoDe.insertar(nuevoDato);
            }
        }
        else{ if (nuevoDato.compareTo(this.dato)<0) {
            if (hijoIzq==null) {
                    hijoIzq = new ElementImpl<>(nuevoDato);
                return true;    
                }
                else {hijoIzq.insertar(nuevoDato);}
            }    
             

        }
        return false;
    }
    /**
     * {@snippet :
     * // ejemplo de uso
     * elemento.inOrder(dato ->{
     *     // procesar dato
     *     // esta función se llama tantas veces como nodos halla en el árbol
     * });
     *}
     */
    @Override
    public void inOrder(Consumer<TDAElemento<T>> consumidor){
            if(this.hijoIzq !=null) this.hijoIzq.inOrden(consumidor);
            consumer.accept(this);
            if (this.hijoDer !=null) this.hijoDer.inOrder(consumidor);

    }

    /**
     * {@snippet :
     * // ejemplo de uso
     * elemento.preOrder(dato ->{
     *     // procesar dato
     *     // esta función se llama tantas veces como nodos halla en el árbol
     * });
     *}
     */
    @Override
    public void preOrder(Consumer<TDAElemento<T>> consumidor){
        consumer.accept(this);
        if(this.hijoIzq !=null) this.hijoIzq.inOrden(consumidor);
        if (this.hijoDer !=null) this.hijoDer.inOrder(consumidor);

    }

    /**
     * {@snippet :
     * // ejemplo de uso
     * elemento.postOrder(dato ->{
     *     // procesar dato
     *     // esta función se llama tantas veces como nodos halla en el árbol
     * });
     *}
     */
    @Override
    public void postOrder(Consumer<TDAElemento<T>> consumidor){
    if(this.hijoIzq !=null) this.hijoIzq.inOrden(consumidor);
    if (this.hijoDer !=null) this.hijoDer.inOrder(consumidor);
    consumer.accept(this);
    }

    /**
     * retornar true si el nodo es hoja
     */
    @Override
    public boolean esHoja(){
        if (hijoIzq==null && hijoDer==null){
            return true;
        }
        return false;
    }

    /**
     * retorna la cantidad de nodos que son hijas
     */
    @Override
    public int cantidadHojas(){
    // si no tiene hijos, es una hoja
        if (this.hijoIzq == null && this.hijoDer == null){
            return 1;
        }

        int contadorIzq = 0;
        int contadorDer = 0;

    // si tiene hijo izquierdo, contar las hojas de ese lado
        if (this.hijoIzq != null){
            contadorIzq = this.hijoIzq.cantidadHojas();
        }

    // si tiene hijo derecho, contar las hojas de ese lado
        if (this.hijoDer != null){
            contadorDer = this.hijoDer.cantidadHojas();
        }

        return contadorIzq + contadorDer;
    }

    /**
     * retorna la cantidad de nodos que no son hojas
     */
    @Override
    public int cantidadNodosInternos(){
    // si es hoja, no es interno
        if (this.hijoIzq == null && this.hijoDer == null){
            return 0;
        }

        int contadorIzq = 0;
        int contadorDer = 0;

        if (this.hijoIzq != null){
            contadorIzq = this.hijoIzq.cantidadNodosInternos();
        }
        if (this.hijoDer != null){
            contadorDer = this.hijoDer.cantidadNodosInternos();
        }

    // este nodo sí es interno, por eso el +1
        return 1 + contadorIzq + contadorDer;
    }


    /**
     * retorna la cantidad de nodos que los compone
     */
    @Override
    public int cantidadNodos(){
        int contadorIzq = 0;
        int contadorDer = 0;

        if (this.hijoIzq != null){
            contadorIzq = this.hijoIzq.cantidadNodos();
        }
        if (this.hijoDer != null){
            contadorDer = this.hijoDer.cantidadNodos();
        }   

    // +1 por este nodo
        return 1 + contadorIzq + contadorDer;
    }


    /**
     * retorna la altura de este nodo
     */
    @Override
    public int altura(){
    // hoja: altura 1
    if (this.hijoIzq == null && this.hijoDer == null){
        return 1;
    }

        int alturaIzq = 0;
        int alturaDer = 0;

        if (this.hijoIzq != null){
            alturaIzq = this.hijoIzq.altura();
        }
        if (this.hijoDer != null){
            alturaDer = this.hijoDer.altura();
        }

    // me quedo con el camino más largo y sumo este nodo
        return 1 + Math.max(alturaIzq, alturaDer);
    }


    /**
     * retornar el nivel relativo del nodo que coincide con el criterio de búsqueda
     * si no se encuentra, retorna -1
     */
    @Override
    public int obtenerNivel(Comparable<T> criterioBusqueda){
    // este nodo es el buscado
        if (criterioBusqueda.compareTo(dato) == 0){
            return 0;
        }

    // buscar en el subárbol izquierdo
        if (criterioBusqueda.compareTo(dato) < 0){
            if (this.hijoIzq != null){
                int nivel = this.hijoIzq.obtenerNivel(criterioBusqueda);
                if (nivel != -1){
                    return 1 + nivel;
                }
            }
        }
        else{
        // buscar en el subárbol derecho
            if (this.hijoDer != null){
                int nivel = this.hijoDer.obtenerNivel(criterioBusqueda);
                if (nivel != -1){
                    return 1 + nivel;
                }
            }
        }

    // no se encontró
        return -1;
    }
}
