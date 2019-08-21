package com.hasanalpzengin.iotdashboard.model;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocketMessage{

    public enum M_type{
        VALUE,
        COMMAND,
        USER
    };

    private long id;
    private M_type type;
    private String message;
    
}