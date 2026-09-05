package edu.uees.patrones.factory;

/**
 * Creator del patrón Factory Method.
 */
public abstract class NotificacionFactory {

    /**
     * Factory Method: las subclases deciden qué Product concreto crear.
     */
    public abstract Notificador crearNotificador();

    /**
     * Operación común que trabaja únicamente con la abstracción Product.
     */
    public void notificar(String destinatario, String mensaje) {
        Notificador notificador = crearNotificador();
        notificador.enviar(destinatario, mensaje);
    }
}
