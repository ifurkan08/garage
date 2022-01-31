package com.kafein.garage.utilites;

import com.kafein.garage.utilites.IdGenerators.IdGenerator;
import com.kafein.garage.utilites.IdGenerators.ParkAreaIdGenerator;
import com.kafein.garage.utilites.IdGenerators.VehicleIdGenerator;
import com.kafein.garage.utilites.IdGenerators.VehiclePositionIdGenerator;

import java.lang.reflect.Field;

public class ResetSingleton {
    public static void resetAllSingleton() {
        resetSingleton(IdGenerator.class,"instance");
        resetSingleton(VehiclePositionIdGenerator.class,"instance");
    }
    public static void resetSingleton(Class clazz, String fieldName) {
        Field instance;
        try {
            instance = clazz.getDeclaredField(fieldName);
            instance.setAccessible(true);
            instance.set(null, null);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
