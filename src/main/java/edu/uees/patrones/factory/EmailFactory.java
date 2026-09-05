package edu.uees.patrones.factory;

public class EmailFactory extends NotificacionFactory {
    @Override
    public Notificador crearNotificador() {
        return new NotificadorEmail();
    }
}
