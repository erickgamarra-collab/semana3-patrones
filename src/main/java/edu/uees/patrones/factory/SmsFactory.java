package edu.uees.patrones.factory;

public class SmsFactory extends NotificacionFactory {
    @Override
    public Notificador crearNotificador() {
        return new NotificadorSms();
    }
}
