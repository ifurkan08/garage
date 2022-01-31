package com.kafein.garage.repositories;

import com.kafein.garage.model.entity.ParkArea;
import com.kafein.garage.model.entity.Vehicle;
import com.kafein.garage.model.entity.VehiclePosition;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VehiclePositionRepository extends RepositoryBase<VehiclePosition> {
    private VehiclePositionRepository(){

    }
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
    public static void setInstance(VehiclePositionRepository _instance){
        instance = _instance;
    }

    public VehiclePosition getVehiclePositionByVehicle(Vehicle vehicle){
        return list.stream().filter(k -> k.getVehicle().equals(vehicle) ).findFirst().orElse(null);
    }

    public List<VehiclePosition> getActiveVehiclePositionListByParkAreaId(Long parkAreaId) {
        return list.stream().filter(k -> k.getParkArea().getId().equals(parkAreaId) && k.getActive()).sorted(Comparator.comparingInt(VehiclePosition::getPosition)).collect(Collectors.toList());

    }

    public VehiclePosition getActiveVehicleByPlate(String plate) {
        return list.stream().filter(k -> k.getVehicle().getPlate().equals(plate) && k.getActive()).findFirst().orElse(null);
    }
}
