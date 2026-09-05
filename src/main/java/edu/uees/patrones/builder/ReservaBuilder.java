package edu.uees.patrones.builder;

/**
 * Builder concreto con Fluent API para construir Reserva.
 */
public class ReservaBuilder {
    private String id;
    private Estudiante estudiante;
    private HorarioDisponible horario;

    // Valores opcionales por defecto
    private String tema = "Sin especificar";
    private String observaciones = "Sin observaciones";
    private boolean enviarRecordatorio = false;

    public ReservaBuilder id(String id) {
        this.id = id;
        return this;
    }

    public ReservaBuilder estudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
        return this;
    }

    public ReservaBuilder horario(HorarioDisponible horario) {
        this.horario = horario;
        return this;
    }

    public ReservaBuilder tema(String tema) {
        if (tema != null && !tema.isBlank()) {
            this.tema = tema;
        }
        return this;
    }

    public ReservaBuilder observaciones(String observaciones) {
        if (observaciones != null && !observaciones.isBlank()) {
            this.observaciones = observaciones;
        }
        return this;
    }

    public ReservaBuilder enviarRecordatorio(boolean enviarRecordatorio) {
        this.enviarRecordatorio = enviarRecordatorio;
        return this;
    }

    public Reserva build() {
        validarObligatorios();
        return new Reserva(
                id,
                estudiante,
                horario,
                EstadoReserva.SOLICITADA,
                tema,
                observaciones,
                enviarRecordatorio);
    }

    private void validarObligatorios() {
        if (id == null || id.isBlank()) {
            throw new IllegalStateException("El id de la reserva es obligatorio");
        }
        if (estudiante == null) {
            throw new IllegalStateException("El estudiante es obligatorio");
        }
        if (horario == null) {
            throw new IllegalStateException("El horario es obligatorio");
        }
    }
}
