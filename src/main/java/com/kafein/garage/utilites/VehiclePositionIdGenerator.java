package com.kafein.garage.utilites;

public class VehiclePositionIdGenerator extends IdGenerator {
    private static VehiclePositionIdGenerator instance;

    private VehiclePositionIdGenerator(){}

    public static VehiclePositionIdGenerator getInstance(){
        if(instance == null) {
            synchronized (VehicleIdGenerator.class) {
                if (instance == null) {
                    instance = new VehiclePositionIdGenerator();
                }
            }
        }
        return instance;
    }

    public Long getId() {
        return createId();
    }
}
