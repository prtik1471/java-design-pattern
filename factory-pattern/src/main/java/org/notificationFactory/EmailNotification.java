package org.notificationFactory;

public class EmailNotification implements INotification{
    public void send(String recipient, String message) {
        System.out.println("email sent to: "+ recipient + " message: " + message);
    }
}
