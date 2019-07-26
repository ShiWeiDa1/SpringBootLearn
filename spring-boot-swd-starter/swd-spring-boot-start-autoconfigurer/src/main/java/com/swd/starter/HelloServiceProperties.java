package com.swd.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author swd
 */
@ConfigurationProperties(prefix = "swd.hello")
public class HelloServiceProperties {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
