package edu.uees.patrones.factory;

public class WhatsAppFactory extends NotificacionFactory {
    @Override
    public Notificador crearNotificador() {
        return new NotificadorWhatsApp();
    }
}
