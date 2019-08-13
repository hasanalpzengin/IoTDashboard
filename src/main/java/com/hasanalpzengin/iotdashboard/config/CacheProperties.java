/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasanalpzengin.iotdashboard.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author hasalp
 */
@Component
@ConfigurationProperties("cache")
public class CacheProperties {
    Map<String, Long> expirations = new HashMap<String, Long>();

    public Map<String, Long> getExpirations() {
        return expirations;
    }

    public void setExpirations(Map<String, Long> expirations) {
        this.expirations = expirations;
    }
    
}
