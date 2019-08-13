package com.hasanalpzengin.iotdashboard.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 *
 * @author hasalp
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("User")
public class User implements Serializable{
    public enum Gender{
        MALE, FEMALE
    }
    
    @Id
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private Gender gender;
    private List<String> permissions;
    private Group group;
    private List<Log> logs;
    private List<Device> devices;
}
