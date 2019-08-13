package com.hasanalpzengin.iotdashboard.service;

import java.util.Optional;

import com.hasanalpzengin.iotdashboard.model.Device;
import com.hasanalpzengin.iotdashboard.repositories.DeviceRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lettuce.core.RedisException;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;
    private Logger logger = LoggerFactory.getLogger(DeviceService.class);

    public Optional<Device> device(String id) {
        return deviceRepository.findById(id);
    }

    public Device addDevice(Device device){
        return deviceRepository.save(device);
    }

    public Boolean removeDevice(Device device){
        try{
            deviceRepository.delete(device);
            return true;
        }catch(RedisException e){
            logger.error("Redis Error: "+e.getMessage());
            return false;
        }
    }

    public Device updateDevice(Device device){
        if(deviceRepository.existsById(device.getSerial().toString())){
            return deviceRepository.save(device);
        }
        return null;
    }

    public Iterable<Device> allDevices(){
        return deviceRepository.findAll();
    }
}