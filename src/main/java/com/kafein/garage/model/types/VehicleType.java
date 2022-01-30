package com.kafein.garage.model.types;

public enum VehicleType {
    CAR (1),
    JEEP (2),
    TRUCK (4);
    VehicleType (int width){
        this.width = width;
    }
    private int width;

    public int getWidth() {
        return width;
    }
}
