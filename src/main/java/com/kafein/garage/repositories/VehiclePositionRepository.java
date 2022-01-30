package com.kafein.garage.repositories;

import com.kafein.garage.model.entity.ParkArea;
import com.kafein.garage.model.entity.VehiclePosition;

import java.util.ArrayList;
import java.util.List;

public class VehiclePositionRepository extends RepositoryBase<VehiclePosition> {
    private static VehiclePositionRepository instance;
    public static VehiclePositionRepository getInstance(){
        if(instance == null) {
            synchronized (VehiclePositionRepository.class) {
                if (instance == null) {
                    instance = new VehiclePositionRepository();
                }
            }
        }
        return instance;
    }
}
