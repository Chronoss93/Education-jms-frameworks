package com.messaging.impl.local.run;

import com.messaging.client.RunnableReceiver;
import com.messaging.client.RunnableSender;
import com.messaging.SimpleQueue;
import com.messaging.impl.local.mom.LocalSimpleQueue;

/**
 * Created by Igor on 07.06.2016.
 */
public class Runner {
    public static void main(String[] args) {
        final SimpleQueue simpleQueue = new LocalSimpleQueue();

        RunnableSender sender1 = new RunnableSender("SENDER1", simpleQueue);
        RunnableSender sender2 = new RunnableSender("SENDER2", simpleQueue);
        RunnableSender sender3 = new RunnableSender("SENDER3", simpleQueue);
        RunnableSender sender4 = new RunnableSender("SENDER4", simpleQueue);
        sender1.start();
        sender2.start();
        sender3.start();
        sender4.start();
        RunnableReceiver receiver1 = new RunnableReceiver("RECEIVER1", simpleQueue);
        RunnableReceiver receiver2 = new RunnableReceiver("RECEIVER2", simpleQueue);
        RunnableReceiver receiver3 = new RunnableReceiver("RECEIVER3", simpleQueue);
        RunnableReceiver receiver4 = new RunnableReceiver("RECEIVER4", simpleQueue);
        RunnableReceiver receiver5 = new RunnableReceiver("RECEIVER5", simpleQueue);
        RunnableReceiver receiver6 = new RunnableReceiver("RECEIVER6", simpleQueue);
        RunnableReceiver receiver7 = new RunnableReceiver("RECEIVER7", simpleQueue);
        RunnableReceiver receiver8 = new RunnableReceiver("RECEIVER8", simpleQueue);
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
