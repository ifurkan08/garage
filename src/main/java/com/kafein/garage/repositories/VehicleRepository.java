package com.kafein.garage.repositories;

import com.kafein.garage.model.entity.Vehicle;

public class VehicleRepository extends RepositoryBase<Vehicle>{
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
    public Vehicle getVehicleByPlate (String plate){
        return list.stream().filter(k -> k.getPlate().equals(plate)).findFirst().orElse(null);
    }
}
