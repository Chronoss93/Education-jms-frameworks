package com.messaging;

/**
 * Created by Igor on 07.06.2016.
 */
public interface Messenger {
    void sendMessage(String msg) throws InterruptedException;

    String receiveMessage() throws InterruptedException;
}
