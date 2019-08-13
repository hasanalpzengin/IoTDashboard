package com.hasanalpzengin.iotdashboard.controller;

import com.hasanalpzengin.iotdashboard.model.SocketMessage;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {

    //value recieved
    @MessageMapping("/device")
    public void value(SocketMessage message){

    }
}