package com.kafein.garage.services.impl;

import com.kafein.garage.model.dto.VehicleDTO;
import com.kafein.garage.model.entity.Vehicle;
import com.kafein.garage.repositories.VehicleRepository;
import com.kafein.garage.services.service.IVehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements IVehicleService {
    private VehicleRepository vehicleRepository = VehicleRepository.getInstance();
    @Override
    public VehicleDTO addAndGetVehicle(VehicleDTO vehicleDTO) throws Exception {
        if(vehicleDTO == null){
            throw new IllegalArgumentException("The vehicle cannot be assigned a null value");
        }
        if(vehicleDTO.getPlate() == null ){
            throw new IllegalArgumentException("The plate cannot be assigned a null value");
        }
        VehicleRepository vehicleRepository = VehicleRepository.getInstance();
        Vehicle vehicle = vehicleRepository.getVehicleByPlate(vehicleDTO.getPlate());
        if(vehicle == null){
            vehicle = vehicleDTO.convertToEntity(vehicleDTO,new Vehicle());
            vehicleRepository.add(vehicle);
        }
        vehicleDTO =vehicleDTO.converToDTO(vehicle,vehicleDTO);
        return vehicleDTO;
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.getById(id);
    }
}
