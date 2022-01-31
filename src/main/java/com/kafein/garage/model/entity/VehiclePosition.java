package com.kafein.garage.model.entity;

import com.kafein.garage.model.dto.BaseDTO;

public class VehiclePosition extends BaseEntity {
    private ParkArea parkArea;
    private Vehicle vehicle;
    private Integer position;
    private Boolean active;

    public VehiclePosition(ParkArea parkArea, Vehicle vehicle, Integer position, Boolean active) {
        this.parkArea = parkArea;
        this.vehicle = vehicle;
        this.position = position;
        this.active = active;
    }

    public VehiclePosition() {
    }

    public ParkArea getParkArea() {
        return parkArea;
    }

    public void setParkArea(ParkArea parkArea) {
        this.parkArea = parkArea;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
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
}
