package com.kafein.garage.repositories;

import com.kafein.garage.model.entity.ParkArea;

import java.util.ArrayList;
import java.util.List;

public  class ParkAreaRepository extends RepositoryBase<ParkArea> {
    private static ParkAreaRepository instance;
    public static ParkAreaRepository getInstance(){
        if(instance == null) {
            synchronized (ParkAreaRepository.class) {
                if (instance == null) {
                    instance = new ParkAreaRepository();
                }
            }
        }
        return instance;
    }
}
