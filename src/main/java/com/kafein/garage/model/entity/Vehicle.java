package com.kafein.garage.model.entity;

import com.kafein.garage.model.types.Color;
import com.kafein.garage.model.types.VehicleType;

public class Vehicle extends BaseEntity {
    private VehicleType vehicleType;
    private Color color;
    private String plate;

    public Vehicle(VehicleType vehicleType, Color color, String plate) {
        this.vehicleType = vehicleType;
        this.color = color;
        this.plate = plate;
    }

    public Vehicle() {
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

}
