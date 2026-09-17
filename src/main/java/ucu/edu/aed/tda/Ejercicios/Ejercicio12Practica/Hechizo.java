package ucu.edu.aed.tda.Ejercicios.Ejercicio12Practica;

public class Hechizo implements Comparable <Hechizo> {

    public  int id;
    private String nombre;

    public Hechizo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Hechizo otroHechizo) {
        return Integer.compare(this.id, otroHechizo.id);
    }

    public int getId (){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String toString() {
        return "Hechizo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
