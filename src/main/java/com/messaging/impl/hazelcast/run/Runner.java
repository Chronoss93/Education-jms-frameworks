package com.messaging.impl.hazelcast.run;

import com.messaging.SimpleQueue;
import com.messaging.client.RunnableReceiver;
import com.messaging.client.RunnableSender;
import com.messaging.impl.hazelcast.mom.HazelcastSimpleQueue;

/**
 * Created by Igor on 07.06.2016.
 */
public class Runner {

    /**
     * Run this method twice to start 2 different JVM's.
     * Hazelcast members from both JVM's will find one another and they will be bound together with same Queues, maps etc.
     * Run one sender wich create messages twice faster then one consumer can
     */
    public static void main(String[] args) {
        final SimpleQueue simpleQueue = new HazelcastSimpleQueue();

        for (int i = 0; i < 0; i++) {
            RunnableSender sender = new RunnableSender("SENDER" + i, simpleQueue);
            sender.start();
        }

        for (int i = 0; i < 1; i++) {
            RunnableReceiver receiver = new RunnableReceiver("RECEIVER1", simpleQueue);
            receiver.start();
        }

    }
}
