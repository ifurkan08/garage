package com.kafein.garage.model.viewmodel;

import com.kafein.garage.model.dto.VehicleDTO;
import com.kafein.garage.model.dto.VehiclePositionDTO;
import com.kafein.garage.model.entity.VehiclePosition;

import java.util.ArrayList;
import java.util.List;

public class VehicleHoldModel {
    private VehicleDTO vehicleDTO;
    private List<Integer> hold = new ArrayList<>();

    public VehicleHoldModel() {
    }

    public VehicleHoldModel(VehiclePositionDTO vehiclePositionDTO) {
        int width = vehiclePositionDTO.getVehicle().getVehicleType().getWidth();
        for (int i = 0;i<width;i++ ){
            hold.add(vehiclePositionDTO.getPosition()+i);
        }
        this.vehicleDTO = vehiclePositionDTO.getVehicle();
    }

    public VehicleDTO getVehicleDTO() {
        return vehicleDTO;
    }

    public void setVehicleDTO(VehicleDTO vehicleDTO) {
        this.vehicleDTO = vehicleDTO;
    }

    public List<Integer> getHold() {
        return hold;
    }

    public void setHold(List<Integer> hold) {
        this.hold = hold;
    }
}
