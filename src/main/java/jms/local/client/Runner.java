package jms.local.client;

import jms.local.mom.Messenger;
import jms.local.mom.SimpleQueueMessenger;

/**
 * Created by Igor on 07.06.2016.
 */
public class Runner {
    public static void main(String[] args) {
        final Messenger messenger = new SimpleQueueMessenger();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        int sentCount = messenger.sendMessage("msg");
                        System.out.println("thread1: message sent: " + sentCount);
                        Thread.sleep(1000l);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String s = messenger.receiveMessage();
                        System.out.println("thread2: message received: " + s);
                        Thread.sleep(1000l);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.run();
        thread2.run();
    }
}
