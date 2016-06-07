package com.messaging.impl.hazelcast.run;

import com.messaging.Messenger;
import com.messaging.client.RunnableReceiver;
import com.messaging.client.RunnableSender;
import com.messaging.impl.hazelcast.mom.HazelcastQueueMessenger;

/**
 * Created by Igor on 07.06.2016.
 */
public class Runner {
    public static void main(String[] args) {
        final Messenger messenger = new HazelcastQueueMessenger();

        for (int i = 0; i < 10000; i++) {
            RunnableSender sender = new RunnableSender("SENDER" + i, messenger);
            sender.start();
        }

        for (int i = 0; i < 10000; i++) {
            RunnableReceiver receiver = new RunnableReceiver("RECEIVER1", messenger);
            receiver.start();
        }

    }
}
