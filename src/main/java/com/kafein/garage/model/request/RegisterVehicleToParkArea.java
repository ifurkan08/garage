package com.kafein.garage.model.request;

import com.kafein.garage.model.dto.VehicleDTO;

public class RegisterVehicleToParkArea {
    private VehicleDTO vehicleDTO;
    private Long parkAreaId;

    public VehicleDTO getVehicleDTO() {
        return vehicleDTO;
    }

    public void setVehicleDTO(VehicleDTO vehicleDTO) {
        this.vehicleDTO = vehicleDTO;
    }

    public Long getParkAreaId() {
        return parkAreaId;
    }

    public void setParkAreaId(Long parkAreaId) {
        this.parkAreaId = parkAreaId;
    }
}
