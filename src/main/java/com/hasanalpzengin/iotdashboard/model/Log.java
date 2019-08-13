package com.hasanalpzengin.iotdashboard.model;

import java.io.Serializable;

public class Log implements Serializable {
    private String value;
    private String dateTime;
    
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}