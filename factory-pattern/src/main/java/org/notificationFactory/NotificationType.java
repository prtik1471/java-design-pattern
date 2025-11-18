package org.notificationFactory;

import java.util.List;
import java.util.function.Supplier;

public enum NotificationType {
    EMAIL(EmailNotification::new),
    SMS(SMSNotification::new);

    private final Supplier<INotification> constructor;

    private NotificationType(Supplier<INotification> constructor) {
        this.constructor = constructor;
    }

    public INotification createNotification() {
        return constructor.get();
    }
}
