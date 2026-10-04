package com.cartograph.ingestion;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Popular-repository pre-warm (F0.49): repositories indexed at startup so
 * their snapshots are hot for the first visitor. Disabled by default;
 * failures never block startup.
 */
@ConfigurationProperties(prefix = "cartograph.prewarm")
public class PrewarmProperties {
    private boolean enabled = false;
    private List<String> repositories = new ArrayList<>();

    public boolean enabled() { return enabled; }
    public List<String> repositories() { return repositories; }
    public void setEnabled(boolean value) { enabled = value; }
    public void setRepositories(List<String> value) {
        repositories = value == null ? new ArrayList<>() : value;
    }
}
