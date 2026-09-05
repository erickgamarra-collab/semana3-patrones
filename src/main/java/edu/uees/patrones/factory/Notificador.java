package edu.uees.patrones.factory;

/**
 * Product del patrón Factory Method.
 */
public interface Notificador {
    void enviar(String destinatario, String mensaje);
}
