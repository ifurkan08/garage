package com.kafein.garage.model.request;

import com.kafein.garage.model.dto.VehicleDTO;

public class RegisterVehicleRequest {
    private VehicleDTO vehicleDTO;
    public VehicleDTO getVehicleDTO() {
        return vehicleDTO;
    }
    public void setVehicleDTO(VehicleDTO vehicleDTO) {
        this.vehicleDTO = vehicleDTO;
    }
}
