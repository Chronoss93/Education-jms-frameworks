package com.messaging.impl.hazelcast.mom;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.messaging.Messenger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Igor on 05.06.2016.
 */
public class HazelcastQueueMessenger implements Messenger {

    private HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
    private final BlockingQueue<String> queue = hazelcastInstance.getQueue("messenger");

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
