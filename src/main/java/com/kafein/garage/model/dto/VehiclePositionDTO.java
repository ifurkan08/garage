package com.kafein.garage.model.dto;

import com.kafein.garage.model.entity.ParkArea;
import com.kafein.garage.model.entity.Vehicle;
import com.kafein.garage.model.entity.VehiclePosition;

public class VehiclePositionDTO extends BaseDTO <VehiclePositionDTO, VehiclePosition> {
    private ParkAreaDTO parkArea;
    private VehicleDTO vehicle;
    private Integer position;
    private Boolean active;
    private Long id;

    public VehiclePositionDTO() {
    }

    public VehiclePositionDTO(ParkAreaDTO parkArea, VehicleDTO vehicle, Integer position, Boolean active, Long id) {
        this.parkArea = parkArea;
        this.vehicle = vehicle;
        this.position = position;
        this.active = active;
        this.id = id;
    }

    public ParkAreaDTO getParkArea() {
        return parkArea;
    }

    public void setParkArea(ParkAreaDTO parkArea) {
        this.parkArea = parkArea;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
