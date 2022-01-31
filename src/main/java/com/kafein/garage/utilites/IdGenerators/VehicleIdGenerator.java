package com.kafein.garage.utilites.IdGenerators;

public class VehicleIdGenerator extends IdGeneratorBase implements IIdGenerator {
    private static VehicleIdGenerator instance;
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
}
