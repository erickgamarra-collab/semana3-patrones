package edu.uees.patrones.builder;

public class Docente extends Usuario {
    private final String especialidad;

    public Docente(String id, String nombre, String email, String especialidad) {
        super(id, nombre, email);
        if (especialidad == null || especialidad.isBlank()) {
            throw new IllegalArgumentException("La especialidad es obligatoria");
        }
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return getNombre() + " (" + especialidad + ")";
    }
}
