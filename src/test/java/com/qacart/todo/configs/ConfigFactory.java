package com.qacart.todo.configs;

import org.aeonbits.owner.ConfigCache;

public final class ConfigFactory {
    private ConfigFactory() {
    }

    public static FrameworkConfiguration getConfig() {
        return ConfigCache.getOrCreate(FrameworkConfiguration.class);
    }
}
