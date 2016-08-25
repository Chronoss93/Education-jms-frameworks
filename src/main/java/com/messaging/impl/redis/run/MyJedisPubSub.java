package com.messaging.impl.redis.run;

import redis.clients.jedis.JedisPubSub;

/**
 * Created by Igor_Kravchenko on 6/30/16.
 */
public class MyJedisPubSub extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        System.out.println("message arrived:" + message);
    }
}
