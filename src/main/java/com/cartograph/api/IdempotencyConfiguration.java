package com.cartograph.api;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

/** Wires the idempotency cache. */
@Configuration
@EnableConfigurationProperties(IdempotencyProperties.class)
public class IdempotencyConfiguration {
    @Bean
    IdempotencyStore idempotencyStore(IdempotencyProperties properties) {
        return new IdempotencyStore(properties.maxEntries(), properties.ttlSeconds(), Clock.systemUTC());
    }
}
