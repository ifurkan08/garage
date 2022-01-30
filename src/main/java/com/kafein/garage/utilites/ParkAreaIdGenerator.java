package com.kafein.garage.utilites;

public class ParkAreaIdGenerator extends IdGenerator {

    private static ParkAreaIdGenerator instance;

    private ParkAreaIdGenerator(){}

    public static ParkAreaIdGenerator getInstance(){
        if(instance == null) {
            synchronized (ParkAreaIdGenerator.class) {
                if (instance == null) {
                    instance = new ParkAreaIdGenerator();
                }
            }
        }
        return instance;
    }

    public Long getId() {
        return createId();
    }
}
