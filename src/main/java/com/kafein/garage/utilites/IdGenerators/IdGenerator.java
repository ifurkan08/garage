package com.kafein.garage.utilites.IdGenerators;

import com.kafein.garage.model.entity.*;
import com.kafein.garage.repositories.ParkAreaRepository;

import java.util.HashMap;
import java.util.Map;

public class IdGenerator{

    private IdGenerator(){

    }
    private static IdGenerator instance;
    private static  Map<Class,IIdGenerator> map= new HashMap<>();
    private void fillMap (){
        map.put(ParkArea.class,ParkAreaIdGenerator.getInstance());
        map.put(Vehicle.class,VehicleIdGenerator.getInstance());
        map.put(VehiclePosition.class,VehiclePositionIdGenerator.getInstance());
    }
    public IIdGenerator getGenerator(Class T){
        return map.get(T);
    }

    public static IdGenerator getInstance() {
        if(instance == null) {
            synchronized (IdGenerator.class) {
                if (instance == null) {
                    instance = new IdGenerator();
                    instance.fillMap();
                }
            }
        }
        return instance;
    }

}
