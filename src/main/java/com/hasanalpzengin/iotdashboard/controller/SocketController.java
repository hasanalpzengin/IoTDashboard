package com.hasanalpzengin.iotdashboard.controller;

import com.hasanalpzengin.iotdashboard.model.SocketMessage;
import com.hasanalpzengin.iotdashboard.service.ViewHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.broker.SimpleBrokerMessageHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SocketController {

    Logger socketLogger = LoggerFactory.getLogger(SocketController.class);

    //value recieved
    @MessageMapping("/socket.send")
    @SendToUser("/topic/send")
    public SocketMessage message(@Payload SocketMessage message, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("device", message.getId());
        return message;
    }

    @MessageMapping("/app/register")
    public void userLogged(@Payload SocketMessage message, SimpMessageHeaderAccessor header){
        socketLogger.info(message.getId()+" User Connected");
    }

    @GetMapping("/socket_test")
    public ModelAndView socketTest(){
        return ViewHelper.viewWithUid("socketTest", 2321312L);
    }
}