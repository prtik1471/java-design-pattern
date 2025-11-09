package org.notificationObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Flow;

public class NotificationServiceOrPublisher {
    private Map<EventType, List<NotificationSubscriberOrObserver>> subscribersMap = new HashMap<>();

    public void subscribe(EventType eventType, NotificationSubscriberOrObserver subscriber) {
        System.out.println("user: " + subscriber.getName() + " subscribed Event: " + eventType);
        subscribersMap.computeIfAbsent(eventType, k -> new ArrayList<>()).add(subscriber);
    }

    public void unsubscribe(EventType eventType, NotificationSubscriberOrObserver subscriber) {
        List<NotificationSubscriberOrObserver> subscribers = subscribersMap.get(eventType);
        if(eventType != null) {
            System.out.println("user: " + subscriber.getName() + " unsubscribed Event: " + eventType);
            subscribers.remove(subscriber);
        }
    }

    public void notify(EventType eventType, String message) {
        List<NotificationSubscriberOrObserver> subscribers = subscribersMap.get(eventType);
        if(subscribers != null) {
            subscribers.stream().forEach(subscriber -> subscriber.update(message));
        } else {
            System.out.println("No subscribers for event: " + eventType);
        }
    }
}
