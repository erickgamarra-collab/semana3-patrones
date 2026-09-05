package edu.uees.patrones.builder;

public abstract class Usuario {
    private final String id;
    private final String nombre;
    private final String email;

    protected Usuario(String id, String nombre, String email) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El id del usuario es obligatorio");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del usuario es obligatorio");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email del usuario es obligatorio");
        }
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
