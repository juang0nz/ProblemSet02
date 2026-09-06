package ucu.edu.aed.tda.Ejercicios.Ejercicio12;

public class Hechizo implements Comparable<Hechizo> {

    private int Id;
    private String nombre;

    public Hechizo(int Id, String nombre) {
        this.Id = Id;
        this.nombre = nombre;
    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return nombre;
    }

    //tengo que organizarla por hechizo
    @Override
    public int compareTo(Hechizo otro) {
        return Integer.compare(this.Id, otro.Id);
    }
}
