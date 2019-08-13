package com.hasanalpzengin.iotdashboard.model;


public class SocketMessage {

    public enum M_type{
        value,
        command,
        user
    };

    private String d_serial;
    private M_type type;
    private String message;

    public String getD_serial() {
        return d_serial;
    }

    public void setD_serial(String d_serial) {
        this.d_serial = d_serial;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public M_type getType() {
        return type;
    }

    public void setType(M_type type) {
        this.type = type;
    }
    
}