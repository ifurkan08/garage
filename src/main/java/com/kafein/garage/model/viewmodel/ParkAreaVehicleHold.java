package com.kafein.garage.model.viewmodel;

import com.kafein.garage.model.dto.ParkAreaDTO;

import java.util.List;

public class ParkAreaVehicleHold {
    private ParkAreaDTO parkAreaDTO;
    private List<VehicleHoldModel> vehicleHoldModelList;

    public ParkAreaDTO getParkAreaDTO() {
        return parkAreaDTO;
    }

    public void setParkAreaDTO(ParkAreaDTO parkAreaDTO) {
        this.parkAreaDTO = parkAreaDTO;
    }

    public List<VehicleHoldModel> getVehicleHoldModelList() {
        return vehicleHoldModelList;
    }

    public void setVehicleHoldModelList(List<VehicleHoldModel> vehicleHoldModelList) {
        this.vehicleHoldModelList = vehicleHoldModelList;
    }
}
