package com.hasanalpzengin.iotdashboard.model;

import org.springframework.data.redis.core.index.Indexed;

public class Group {
    @Indexed private String id;
    private String name;
    
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}