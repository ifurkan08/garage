package com.kafein.garage.model.request;

import com.kafein.garage.model.dto.ParkAreaDTO;

import javax.validation.constraints.NotNull;

public class AddParkAreaRequest {
    @NotNull
    private ParkAreaDTO parkAreaDTO;

    public ParkAreaDTO getParkAreaDTO() {
        return parkAreaDTO;
    }

    public void setParkAreaDTO(ParkAreaDTO parkAreaDTO) {
        this.parkAreaDTO = parkAreaDTO;
    }
}
