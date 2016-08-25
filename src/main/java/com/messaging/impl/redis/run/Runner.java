package com.messaging.impl.redis.run;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by Igor_Kravchenko on 6/9/16.
 */
public class Runner {

    public static final String SINGLE = "single";

    public static void main(String[] args) {


        /**
         * You shouldn't use the same instance from different threads because you'll have strange errors.
         * And sometimes creating lots of Jedis instances is not good enough because it means lots of sockets
         * and connections, which leads to strange errors as well.
         * A single Jedis instance is not threadsafe!
         * To avoid these problems, you should use JedisPool, which is a threadsafe pool of network connections.
         * You can use the pool to reliably create several Jedis instances,
         * given you return the Jedis instance to the pool when done.
         * This way you can overcome those strange errors and achieve great performance.
         */
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(1000);
        config.setMaxIdle(10);
        config.setMinIdle(1);
        config.setMaxWaitMillis(30000);

        JedisPool pool = new JedisPool(config, "localhost", 6379);

        /**
         * Try with resource is very useful
         * Pub/sub
         * Problems with windows version. Check compatibility of redis and diver
         */
        try (Jedis jedis = pool.getResource()) {
            //consumer
            MyJedisPubSub myJedisPubSub = new MyJedisPubSub();
//            jedis.subscribe(myJedisPubSub, SINGLE);

            //publisher
            while (true) {
                jedis.publish(SINGLE, "Some info");
                System.out.println("published");
            }
//            jedis.

        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("EXC");
            System.out.println("EXC");
            System.out.println("EXC");
        }

        /**
         * simple queue
         */


    }



}
