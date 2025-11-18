package org.notificationFactory;

public class SMSNotification implements INotification{

    public void send(String recipient, String message) {
        System.out.println("sms sent to: " + recipient + " message: " + message);
    }
}
