package jms.local.client;

import jms.local.mom.Messenger;

/**
 * Created by Igor_Kravchenko on 6/7/16.
 */
public class RunnableSender implements Runnable {
    private final Messenger messenger;
    private Thread t;
    private String threadName;

    RunnableSender(String name, Messenger messenger) {
        this.messenger = messenger;
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 0; i < 1000; i++) {
                messenger.sendMessage(threadName + "-msg№:" + i);
                System.out.println(threadName + " message sent: " + i);
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
