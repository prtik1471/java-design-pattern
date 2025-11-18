package org.notificationFactory;

public class NotificationFactory {
    public static INotification getNotification(NotificationType type) {
            return type.createNotification();
    }
}
