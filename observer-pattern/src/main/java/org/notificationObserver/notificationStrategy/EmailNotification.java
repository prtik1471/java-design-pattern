package org.notificationObserver.notificationStrategy;

public class EmailNotification implements NotificationStrategy{
    @Override
    public void sendNotification(String user, String message) {
        System.out.println("Email sent to user: " + user + " message: " + message);
    }
}
