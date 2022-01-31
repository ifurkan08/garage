package com.kafein.garage.model.dto;

import com.kafein.garage.model.entity.Vehicle;
import com.kafein.garage.model.types.Color;
import com.kafein.garage.model.types.VehicleType;

public class VehicleDTO extends BaseDTO <VehicleDTO, Vehicle> {
    private VehicleType vehicleType;
    private Color color;
    private String plate;
    private Long id;

    public VehicleDTO() {
    }

    public VehicleDTO(VehicleType vehicleType, Color color, String plate) {
        this.vehicleType = vehicleType;
        this.color = color;
        this.plate = plate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
