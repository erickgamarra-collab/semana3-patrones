package edu.uees.patrones.builder;

import java.time.LocalDateTime;

public class HorarioDisponible {
    private final String id;
    private final Docente docente;
    private final LocalDateTime inicio;
    private final LocalDateTime fin;

    public HorarioDisponible(String id, Docente docente, LocalDateTime inicio, LocalDateTime fin) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El id del horario es obligatorio");
        }
        if (docente == null) {
            throw new IllegalArgumentException("El docente es obligatorio");
        }
        if (inicio == null || fin == null) {
            throw new IllegalArgumentException("Inicio y fin son obligatorios");
        }
        if (!fin.isAfter(inicio)) {
            throw new IllegalArgumentException("La fecha de fin debe ser posterior al inicio");
        }
        this.id = id;
        this.docente = docente;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getId() {
        return id;
    }

    public Docente getDocente() {
        return docente;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    @Override
    public String toString() {
        return id + " | " + docente.getNombre() + " | " + inicio + " - " + fin;
    }
}
