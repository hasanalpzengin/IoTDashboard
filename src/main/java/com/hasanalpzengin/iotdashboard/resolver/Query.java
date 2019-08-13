package com.hasanalpzengin.iotdashboard.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hasanalpzengin.iotdashboard.model.Device;
import com.hasanalpzengin.iotdashboard.model.User;
import com.hasanalpzengin.iotdashboard.service.DeviceService;
import com.hasanalpzengin.iotdashboard.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver{
    
    @Autowired
    private UserService userService;
    @Autowired
    private DeviceService deviceService;

    public Device device(String serial){
        return deviceService.device(serial).get();
    }

    public Iterable<Device> allDevices(){
        return deviceService.allDevices();
    }

    public User user(String id){
        return userService.user(id).get();
    }

    public Iterable<User> allUsers(){
        return userService.allUsers();
    }

    public User login(String username, String password){
        return userService.login(username, password);
    }
    
}