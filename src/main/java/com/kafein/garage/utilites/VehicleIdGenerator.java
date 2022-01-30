package com.kafein.garage.utilites;

public class VehicleIdGenerator extends IdGenerator {
    private static VehicleIdGenerator instance;

    private VehicleIdGenerator(){}

    public static VehicleIdGenerator getInstance(){

        if(instance == null) {
            synchronized (VehicleIdGenerator.class) {
                if (instance == null) {
                    instance = new VehicleIdGenerator();
                }
            }
        }

        return instance;
    }

    public Long getId() {
        return createId();
    }
}
