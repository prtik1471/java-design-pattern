package org.notificationFactory;

public class Application {
    public static void main(String args[]) {
        INotification notification1 = NotificationFactory.getNotification(NotificationType.SMS);
        INotification notification2 = NotificationFactory.getNotification(NotificationType.EMAIL);
        System.out.println("send using sms : ");
        notification1.send("recipient1", "message1");

        System.out.println("send using email: ");
        notification2.send("recipient2", "message2");
    }
}
