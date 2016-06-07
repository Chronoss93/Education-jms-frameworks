package jms.local.mom;

/**
 * Created by Igor on 07.06.2016.
 */
public interface Messenger {
    int sendMessage(String msg) throws InterruptedException;

    String receiveMessage() throws InterruptedException;
}
