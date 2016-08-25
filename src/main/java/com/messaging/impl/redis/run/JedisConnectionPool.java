//package com.messaging.impl.redis.run;
//
//import lombok.extern.slf4j.Slf4j;
//
//import qa.qcri.aidr.common.util.EmailClient;
//import qa.qcri.aidr.utils.PersisterConfigurationProperty;
//import qa.qcri.aidr.utils.PersisterConfigurator;
//import qa.qcri.aidr.utils.PersisterErrorHandler;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//import redis.clients.jedis.exceptions.JedisConnectionException;
//
//@Slf4j
//public class JedisConnectionPool  {
//
//
//    static JedisPool jedisPool;
//
//    public JedisConnectionPool() {
//        jedisPool = null;
//    }
//
//    public synchronized Jedis getJedisConnection() {  // koushik: removed static
//        try {
//            if (jedisPool == null) {
//                JedisPoolConfig config = new JedisPoolConfig();
//                config.setMaxTotal(1000);
//                config.setMaxIdle(10);
//                config.setMinIdle(1);
//                config.setMaxWaitMillis(30000);
//
//                jedisPool = new JedisPool(config, PersisterConfigurator.getInstance().getProperty(PersisterConfigurationProperty.REDIS_HOST), Integer.parseInt(PersisterConfigurator.getInstance().getProperty(PersisterConfigurationProperty.REDIS_PORT)));
//            }
//            return jedisPool.getResource();
//        } catch (JedisConnectionException e) {
//            log.error("Could not establish Redis connection. Is the Redis running?");
//            PersisterErrorHandler.sendErrorMail(e.getLocalizedMessage(), "Could not establish Redis connection. Is the Redis running?");
//            throw e;
//        }
//    }
//
//    public synchronized void close(Jedis resource) {  // koushik: removed static, added code to increase robustness
//        if (jedisPool != null) {
//            try {
//                if (resource != null) {
//                    jedisPool.returnResource(resource);
//                    resource = null;
//                }
//            } catch (JedisConnectionException e) {
//                jedisPool.returnBrokenResource(resource);
//                resource = null;
//            } finally {
//                if (resource != null)
//                    jedisPool.returnResource(resource);
//                resource = null;
//            }
//        }
//    }
//}
