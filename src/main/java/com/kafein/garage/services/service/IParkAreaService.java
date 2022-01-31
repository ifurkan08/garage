package com.kafein.garage.services.service;

import com.kafein.garage.model.dto.ParkAreaDTO;
import com.kafein.garage.model.entity.ParkArea;
import com.kafein.garage.model.viewmodel.ParkAreaVehicleHold;

import java.util.List;

public interface IParkAreaService {
    void addParkArea(ParkAreaDTO parkAreaDTO);
    List<ParkAreaDTO> getParkAreaList();
    ParkAreaDTO getParkAreaDtoById(Long id) throws NoSuchFieldException;
    ParkArea getParkAreaById(Long id);
    List<ParkAreaVehicleHold> getAllStatus() throws Exception;
}
