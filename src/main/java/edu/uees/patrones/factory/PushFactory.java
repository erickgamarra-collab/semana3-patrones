package edu.uees.patrones.factory;

public class PushFactory extends NotificacionFactory {
    @Override
    public Notificador crearNotificador() {
        return new NotificadorPush();
    }
}
