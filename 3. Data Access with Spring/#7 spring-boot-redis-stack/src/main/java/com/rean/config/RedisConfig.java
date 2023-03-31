package com.rean.config;

import io.github.dengliming.redismodule.redisjson.RedisJSON;
import io.github.dengliming.redismodule.redisjson.client.RedisJSONClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

    @Value("${redis.host:''}")
    private String redisHost;

    @Bean
    public Config config() {
        Config config = new Config();
        config.useSingleServer().setAddress(redisHost);
        return config;
    }

    @Bean
    public RedisJSONClient redisJSONClient(Config config) {
        return new RedisJSONClient(config);
    }

    @Bean
    public RedisJSON redisJSON(RedisJSONClient redisJSONClient) {
        return redisJSONClient.getRedisJSON();
    }

}
