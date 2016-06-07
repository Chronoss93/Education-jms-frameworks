package jms.local.mom;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Igor on 05.06.2016.
 */
public class SimpleQueueMessenger implements Messenger {

    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>(1000);
    private volatile AtomicInteger sentCount = new AtomicInteger();
    private volatile AtomicInteger receiveCount = new AtomicInteger();

    @Override
    public int sendMessage(String msg) throws InterruptedException {
        boolean sent = queue.offer(msg, 10, TimeUnit.SECONDS);
        return sentCount.incrementAndGet();
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
