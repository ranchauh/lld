package design.patterns.factory.notification.simplefactory;

public class NotificationFactory {
    public static Notification createNotification(NotificationType notificationType, String recipient, String message, String sender) {
        switch (notificationType) {
            case SMS -> {
                return new SmsNotification(recipient, message);
            }
            case PUSH -> {
                return new PushNotification(recipient, message);
            }
            case EMAIL -> {
                return new EmailNotification(recipient, message, sender);
            }
        }
        return null;
    }
}
