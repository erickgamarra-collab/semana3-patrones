package edu.uees.patrones.factory;

/**
 * Variante adicional incorporada para evidenciar extensibilidad.
 */
public class NotificadorPush implements Notificador {
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.printf("[PUSH] Usuario: %s | %s%n", destinatario, mensaje);
    }
}
