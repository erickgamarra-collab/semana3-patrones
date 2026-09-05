package edu.uees.patrones.factory;

public class NotificadorSms implements Notificador {
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.printf("[SMS] Para: %s | %s%n", destinatario, mensaje);
    }
}
