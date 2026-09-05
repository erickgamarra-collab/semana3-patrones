package edu.uees.patrones.builder;

/**
 * Product construido por ReservaBuilder.
 */
public class Reserva {
    private final String id;
    private final Estudiante estudiante;
    private HorarioDisponible horario;
    private EstadoReserva estado;
    private final String tema;
    private final String observaciones;
    private final boolean enviarRecordatorio;

    Reserva(
            String id,
            Estudiante estudiante,
            HorarioDisponible horario,
            EstadoReserva estado,
            String tema,
            String observaciones,
            boolean enviarRecordatorio) {
        this.id = id;
        this.estudiante = estudiante;
        this.horario = horario;
        this.estado = estado;
        this.tema = tema;
        this.observaciones = observaciones;
        this.enviarRecordatorio = enviarRecordatorio;
    }

    public String getId() {
        return id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public HorarioDisponible getHorario() {
        return horario;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public String getTema() {
        return tema;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public boolean isEnviarRecordatorio() {
        return enviarRecordatorio;
    }

    public void confirmar() {
        if (estado != EstadoReserva.SOLICITADA && estado != EstadoReserva.REPROGRAMADA) {
            throw new IllegalStateException("Solo una reserva solicitada o reprogramada puede confirmarse");
        }
        estado = EstadoReserva.CONFIRMADA;
    }

    public void cancelar() {
        if (estado == EstadoReserva.CANCELADA || estado == EstadoReserva.COMPLETADA) {
            throw new IllegalStateException("La reserva ya no puede cancelarse");
        }
        estado = EstadoReserva.CANCELADA;
    }

    public void reprogramar(HorarioDisponible nuevoHorario) {
        if (estado == EstadoReserva.CANCELADA || estado == EstadoReserva.COMPLETADA) {
            throw new IllegalStateException("La reserva ya no puede reprogramarse");
        }
        if (nuevoHorario == null) {
            throw new IllegalArgumentException("El nuevo horario es obligatorio");
        }
        if (!horario.getDocente().getId().equals(nuevoHorario.getDocente().getId())) {
            throw new IllegalArgumentException("La reprogramación debe conservar el mismo docente");
        }
        horario = nuevoHorario;
        estado = EstadoReserva.REPROGRAMADA;
    }

    public void completar() {
        if (estado != EstadoReserva.CONFIRMADA) {
            throw new IllegalStateException("Solo una reserva confirmada puede completarse");
        }
        estado = EstadoReserva.COMPLETADA;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                ", estudiante=" + estudiante.getNombre() +
                ", horario=" + horario.getId() +
                ", estado=" + estado +
                ", tema='" + tema + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", enviarRecordatorio=" + enviarRecordatorio +
                '}';
    }
}
