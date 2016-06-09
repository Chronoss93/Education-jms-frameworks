package com.messaging.client;

import com.messaging.SimpleQueue;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Igor_Kravchenko on 6/7/16.
 */
@Slf4j
public class RunnableSender implements Runnable {
    private final SimpleQueue simpleQueue;
    private Thread t;
    private String threadName;

    public RunnableSender(String name, SimpleQueue simpleQueue) {
        this.simpleQueue = simpleQueue;
        threadName = name;
        log.debug("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 0; i < 1000; i++) {
                simpleQueue.sendMessage(threadName + "-msg№:" + i);
                log.debug(threadName + " message sent: " + i);
                Thread.sleep(3000L);
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
