package com.tealwallet.api.config;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties(prefix = "app")
public record AppProperties(
        @NotEmpty
        String name,
        @NotEmpty
        String url
) {
}
