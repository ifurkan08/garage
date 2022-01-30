package com.kafein.garage.repositories;

import com.kafein.garage.model.entity.ParkArea;

public class VehicleRepository extends RepositoryBase<ParkArea>{
    private VehicleRepository(){}
    private static VehicleRepository instance;
    public static VehicleRepository getInstance(){
        if(instance == null) {
            synchronized (VehicleRepository.class) {
                if (instance == null) {
                    instance = new VehicleRepository();
                }
            }
        }
        return instance;
    }
}
