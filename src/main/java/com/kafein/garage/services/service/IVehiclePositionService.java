package com.kafein.garage.services.service;

import com.kafein.garage.model.dto.ParkAreaDTO;
import com.kafein.garage.model.dto.VehicleDTO;
import com.kafein.garage.model.dto.VehiclePositionDTO;
import com.kafein.garage.model.entity.VehiclePosition;

import java.util.List;

public interface IVehiclePositionService {
    VehiclePositionDTO addVehiclePosition (VehicleDTO vehicleDTO) throws Exception;
    VehiclePositionDTO addVehiclePositionToParkAreaId(VehicleDTO vehicleDTO, Long id)throws Exception;
    List<VehiclePositionDTO> getVehiclePositionListByParkAreaId(Long parkAreaId);
    void leaveVehiclePositionByPlate(String plate);
    void leaveVehiclePositionById(Long id);
    VehiclePositionDTO getActiveVehiclePositionByPlate(String plate);
    VehiclePositionDTO convert(VehiclePosition vehiclePosition);

}
