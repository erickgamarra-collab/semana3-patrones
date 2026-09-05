package edu.uees.patrones;

import edu.uees.patrones.builder.Docente;
import edu.uees.patrones.builder.Estudiante;
import edu.uees.patrones.builder.HorarioDisponible;
import edu.uees.patrones.builder.Reserva;
import edu.uees.patrones.builder.ReservaBuilder;
import edu.uees.patrones.factory.EmailFactory;
import edu.uees.patrones.factory.NotificacionFactory;
import edu.uees.patrones.factory.PushFactory;
import edu.uees.patrones.factory.SmsFactory;
import edu.uees.patrones.factory.WhatsAppFactory;

import java.time.LocalDateTime;
import java.util.List;

public class App {

    public static void main(String[] args) {
        demostrarFactoryMethod();
        System.out.println();
        demostrarBuilder();
    }

    private static void demostrarFactoryMethod() {
        System.out.println("=== FACTORY METHOD ===");

        List<NotificacionFactory> fabricas = List.of(
                new EmailFactory(),
                new SmsFactory(),
                new WhatsAppFactory(),
                new PushFactory());

        for (NotificacionFactory fabrica : fabricas) {
            fabrica.notificar(
                    "erick.gamarra@uees.edu.ec",
                    "Su tutoría fue registrada correctamente.");
        }
    }

    private static void demostrarBuilder() {
        System.out.println("=== BUILDER ===");

        Estudiante estudiante = new Estudiante(
                "E-001",
                "Erick Gamarra",
                "erick.gamarra@uees.edu.ec",
                "Computación");

        Docente docente = new Docente(
                "D-001",
                "Jaime Sayago",
                "jaime.sayago@uees.edu.ec",
                "Diseño de Software");

        HorarioDisponible horario1 = new HorarioDisponible(
                "H-001",
                docente,
                LocalDateTime.of(2026, 9, 7, 10, 0),
                LocalDateTime.of(2026, 9, 7, 11, 0));

        HorarioDisponible horario2 = new HorarioDisponible(
                "H-002",
                docente,
                LocalDateTime.of(2026, 9, 8, 15, 0),
                LocalDateTime.of(2026, 9, 8, 16, 0));

        // Configuración 1: solo los campos obligatorios.
        Reserva reservaBasica = new ReservaBuilder()
                .id("R-001")
                .estudiante(estudiante)
                .horario(horario1)
                .build();

        // Configuración 2: obligatorios + opcionales.
        Reserva reservaCompleta = new ReservaBuilder()
                .id("R-002")
                .estudiante(estudiante)
                .horario(horario2)
                .tema("Aplicación de patrones de diseño")
                .observaciones("Revisar Factory Method y Builder")
                .enviarRecordatorio(true)
                .build();

        System.out.println(reservaBasica);
        System.out.println(reservaCompleta);
    }
}
