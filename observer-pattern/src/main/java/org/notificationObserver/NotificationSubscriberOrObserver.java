package org.notificationObserver;

import org.notificationObserver.notificationStrategy.NotificationStrategy;

public class NotificationSubscriberOrObserver {
    private String name;
    private NotificationStrategy notificationStrategy;

    public NotificationSubscriberOrObserver(String name, NotificationStrategy strategy) {
        this.name = name;
        this.notificationStrategy = strategy;
    }

    public String getName() {
        return this.name;
    }

    public void update(String message) {
        notificationStrategy.sendNotification(name, message);
    }
}
