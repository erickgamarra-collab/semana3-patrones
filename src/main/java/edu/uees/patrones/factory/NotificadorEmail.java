package edu.uees.patrones.factory;

public class NotificadorEmail implements Notificador {
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.printf("[EMAIL] Para: %s | %s%n", destinatario, mensaje);
    }
}
