package com.hasanalpzengin.iotdashboard.service;

import java.util.Optional;

import com.hasanalpzengin.iotdashboard.model.User;
import com.hasanalpzengin.iotdashboard.repositories.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lettuce.core.RedisException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public Optional<User> user(String id){
        return userRepository.findById(id);
    }

    public Iterable<User> allUsers() {
        return userRepository.findAll();
    }

	public User login(String username, String password) {
		return null;
    }
    
    public User addUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user){
        if(userRepository.existsById(user.getId().toString())){
            return userRepository.save(user);
        }
        return null;
    }

    public Boolean removeUser(User user){
        try{
            userRepository.delete(user);
        }catch(RedisException e){
            logger.error("Redis Error: "+e.getMessage());
            return false;
        }
        return true;
    }
}