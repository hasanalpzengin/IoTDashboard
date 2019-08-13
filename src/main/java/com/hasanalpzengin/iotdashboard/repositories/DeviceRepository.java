package com.hasanalpzengin.iotdashboard.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hasanalpzengin.iotdashboard.model.Device;

@Repository
public interface DeviceRepository extends CrudRepository<Device, String> {
}