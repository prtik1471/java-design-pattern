package org.notificationObserver.notificationStrategy;

public class MobileAppNotification implements NotificationStrategy{
    @Override
    public void sendNotification(String user, String message) {
        System.out.println("Mobile app notification sent to user: " + user + " message: " + message);
    }
}
