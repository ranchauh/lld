package design.patterns.factory.notification.simplefactory;

public abstract class Notification {

    private String recipient;
    private String message;

    public Notification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipient() {
        return this.recipient;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public abstract void sendNotification();

    public abstract NotificationType notificationType();

}
