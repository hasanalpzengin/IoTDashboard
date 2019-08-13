package com.hasanalpzengin.iotdashboard.repositories;

import com.hasanalpzengin.iotdashboard.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hasalp
 */
@Repository
public interface UserRepository extends CrudRepository<User, String>{
}