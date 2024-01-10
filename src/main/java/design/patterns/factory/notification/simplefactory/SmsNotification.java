package design.patterns.factory.notification.simplefactory;


public class SmsNotification extends Notification {

    public SmsNotification(String recipient,  String message) {
        super(recipient, message);
    }

    public void sendNotification() {
        // Logic to send an SMS
        System.out.println("SMS sent to " + this.getRecipient());
        System.out.println("Message: " + this.getMessage());
    }

    public NotificationType notificationType() {
        return NotificationType.SMS;
    }
}
