package com.messaging.client;

import com.messaging.SimpleQueue;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Igor_Kravchenko on 6/7/16.
 */
@Slf4j
public class RunnableReceiver implements Runnable {
    private final SimpleQueue simpleQueue;
    private Thread t;
    private String threadName;

    public RunnableReceiver(String name, SimpleQueue simpleQueue) {
        this.simpleQueue = simpleQueue;
        threadName = name;
        log.info("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            while (true) {
                String s = simpleQueue.receiveMessage();
                System.out.println(threadName + ": message received: " + s);
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