package com.cartograph.api;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Opt-in CORS: with no configured origins nothing is registered, so default
 * responses carry no CORS headers at all.
 */
@Configuration
@EnableConfigurationProperties(CorsProperties.class)
public class CorsConfiguration implements WebMvcConfigurer {
    private final CorsProperties properties;

    public CorsConfiguration(CorsProperties properties) {
        this.properties = properties;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if (properties.allowedOrigins().isEmpty()) {
            return;
        }
        registry.addMapping("/api/v1/**")
                .allowedOrigins(properties.allowedOrigins().toArray(String[]::new))
                .allowedMethods("GET", "POST", "OPTIONS")
                .allowedHeaders("Content-Type", "X-Request-Id", "Idempotency-Key")
                .maxAge(3600);
    }
}
