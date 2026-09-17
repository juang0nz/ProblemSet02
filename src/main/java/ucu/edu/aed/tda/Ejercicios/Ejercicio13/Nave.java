package ucu.edu.aed.tda.Ejercicios.Ejercicio13Practica;

public class Nave implements Comparable<Nave> {
    int codigo;
    String clase;
    double cantCombustible;


public Nave (int codigo, String clase, double cantCombustible){
    if (codigo < 0){
        System.out.println("no se puede ");
    }
    this.codigo = codigo;
    this.clase = clase;
    this.cantCombustible = cantCombustible;
}

@Override 
public int compareTo (Nave otra){
    return Integer.compare (this.codigo, otra.codigo);
}

public String getClase(){
    return clase;
}
public int  getCodigo(){
    return codigo;
}


}
