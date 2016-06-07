package com.messaging.impl.local.run;

import com.messaging.client.RunnableReceiver;
import com.messaging.client.RunnableSender;
import com.messaging.Messenger;
import com.messaging.impl.local.mom.SimpleQueueMessenger;

/**
 * Created by Igor on 07.06.2016.
 */
public class Runner {
    public static void main(String[] args) {
        final Messenger messenger = new SimpleQueueMessenger();

        RunnableSender sender1 = new RunnableSender("SENDER1", messenger);
        RunnableSender sender2 = new RunnableSender("SENDER2", messenger);
        RunnableSender sender3 = new RunnableSender("SENDER3", messenger);
        RunnableSender sender4 = new RunnableSender("SENDER4", messenger);
        sender1.start();
        sender2.start();
        sender3.start();
        sender4.start();
        RunnableReceiver receiver1 = new RunnableReceiver("RECEIVER1", messenger);
        RunnableReceiver receiver2 = new RunnableReceiver("RECEIVER2", messenger);
        RunnableReceiver receiver3 = new RunnableReceiver("RECEIVER3", messenger);
        RunnableReceiver receiver4 = new RunnableReceiver("RECEIVER4", messenger);
        RunnableReceiver receiver5 = new RunnableReceiver("RECEIVER5", messenger);
        RunnableReceiver receiver6 = new RunnableReceiver("RECEIVER6", messenger);
        RunnableReceiver receiver7 = new RunnableReceiver("RECEIVER7", messenger);
        RunnableReceiver receiver8 = new RunnableReceiver("RECEIVER8", messenger);
        receiver1.start();
        receiver2.start();
        receiver3.start();
        receiver4.start();
        receiver5.start();
        receiver6.start();
        receiver7.start();
        receiver8.start();
    }
}
