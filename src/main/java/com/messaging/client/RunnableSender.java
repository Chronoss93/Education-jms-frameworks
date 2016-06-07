package com.messaging.client;

import com.messaging.Messenger;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Igor_Kravchenko on 6/7/16.
 */
@Slf4j
public class RunnableSender implements Runnable {
    private final Messenger messenger;
    private Thread t;
    private String threadName;

    public RunnableSender(String name, Messenger messenger) {
        this.messenger = messenger;
        threadName = name;
        log.debug("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 0; i < 1000; i++) {
                messenger.sendMessage(threadName + "-msg№:" + i);
                log.debug(threadName + " message sent: " + i);
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e) {
            log.error("Thread " + threadName + " interrupted.");
        }
        log.debug("Thread " + threadName + " exiting.");
    }

    public void start() {
        log.info("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
