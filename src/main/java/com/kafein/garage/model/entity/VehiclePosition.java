package com.kafein.garage.model.entity;

public class VehiclePosition extends BaseEntity {
    private ParkArea parkArea;
    private Vehicle vehicle;
    private Integer position;

    public VehiclePosition(ParkArea parkArea, Vehicle vehicle, Integer position) {
        this.parkArea = parkArea;
        this.vehicle = vehicle;
        this.position = position;
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
}
