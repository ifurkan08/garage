package com.kafein.garage.services.service;

import com.kafein.garage.model.dto.VehicleDTO;
import com.kafein.garage.model.entity.Vehicle;

public interface IVehicleService {
    VehicleDTO addAndGetVehicle(VehicleDTO vehicle) throws Exception;

    Vehicle getVehicleById(Long id);
}
