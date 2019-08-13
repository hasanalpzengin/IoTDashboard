package com.hasanalpzengin.iotdashboard.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hasanalpzengin.iotdashboard.model.Device;
import com.hasanalpzengin.iotdashboard.model.User;
import com.hasanalpzengin.iotdashboard.service.DeviceService;
import com.hasanalpzengin.iotdashboard.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mutation
 */
@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private UserService userService;
    @Autowired
    private DeviceService deviceService;

    public User addUser(User user){
        return userService.addUser(user);
    }
    
    public User updateUser(User user){
        return userService.updateUser(user);
    }

    public Boolean removeUser(User user){
        return userService.removeUser(user);
    }

    public Device addDevice(Device device){
        return deviceService.addDevice(device);
    }

    public Device updateDevice(Device device){
        return deviceService.updateDevice(device);
    }

    public Boolean removeDevice(Device device){
        return deviceService.removeDevice(device);
    }

}