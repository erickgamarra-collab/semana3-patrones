package edu.uees.patrones.builder;

public class Estudiante extends Usuario {
    private final String carrera;

    public Estudiante(String id, String nombre, String email, String carrera) {
        super(id, nombre, email);
        if (carrera == null || carrera.isBlank()) {
            throw new IllegalArgumentException("La carrera es obligatoria");
        }
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    @Override
    public String toString() {
        return getNombre() + " (" + carrera + ")";
    }
}
