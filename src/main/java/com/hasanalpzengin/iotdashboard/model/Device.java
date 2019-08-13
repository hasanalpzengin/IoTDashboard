package com.hasanalpzengin.iotdashboard.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Device")
public class Device implements Serializable {

    public enum DeviceType{
        Temperature,
        Proximity,
        Accelerometer,
        IR,
        Pressure,
        Light,
        Ultrasonic,
        SmokeOrGas,
        Touch,
        Color,
        Humidity,
        Tilt,
        FlowandLevel,
        GPS
    }

    @Id private Long serial;
    private DeviceType type;
    private List<Group> groups;
    private boolean isOnline;
    private String description;
    private List<Log> logs;
}