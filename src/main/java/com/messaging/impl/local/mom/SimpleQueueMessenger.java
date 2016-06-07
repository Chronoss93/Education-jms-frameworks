package com.messaging.impl.local.mom;

import com.messaging.Messenger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Igor on 05.06.2016.
 */
public class SimpleQueueMessenger implements Messenger {

    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>(1000);

    @Override
    public void sendMessage(String msg) throws InterruptedException {
        boolean sent = queue.offer(msg, 10, TimeUnit.SECONDS);
    }

    //test normal boolean
    private volatile AtomicBoolean stopped = new AtomicBoolean(true);

    @Override
    public String receiveMessage() throws InterruptedException {
        while (stopped.get()) {
            return queue.take();
        }
        throw new InterruptedException("BADBADTHINGS");
    }
}
