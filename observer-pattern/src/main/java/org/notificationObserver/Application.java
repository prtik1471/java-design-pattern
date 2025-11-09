package org.notificationObserver;

import org.notificationObserver.notificationStrategy.EmailNotification;
import org.notificationObserver.notificationStrategy.MobileAppNotification;

public class Application {
    public static void main(String args[]) {
        NotificationServiceOrPublisher store = new NotificationServiceOrPublisher();

        NotificationSubscriberOrObserver user1 = new NotificationSubscriberOrObserver("user1", new MobileAppNotification());
        NotificationSubscriberOrObserver user2 = new NotificationSubscriberOrObserver("user2", new EmailNotification());
        NotificationSubscriberOrObserver user3 = new NotificationSubscriberOrObserver("user3", new MobileAppNotification());

        store.subscribe(EventType.SALE, user1);
        store.subscribe(EventType.SALE, user2);
        store.subscribe(EventType.BACK_IN_STOCK, user2);
        store.subscribe(EventType.BACK_IN_STOCK, user3);
        store.subscribe(EventType.NEW_PRODUCT, user3);
        store.subscribe(EventType.NEW_PRODUCT, user1);

        store.notify(EventType.BACK_IN_STOCK, "milk is back in stock");
        store.notify(EventType.SALE, "sale starts tonight 12:00 AM");

        store.unsubscribe(EventType.SALE, user1);
        store.notify(EventType.SALE, "sale starts tomorrow");

    }
}
