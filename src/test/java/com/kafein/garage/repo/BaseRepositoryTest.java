package com.kafein.garage.repo;

import com.kafein.garage.model.entity.VehiclePosition;
import com.kafein.garage.repositories.VehiclePositionRepository;
import com.kafein.garage.utilites.ParkAreaIdGenerator;
import com.kafein.garage.utilites.VehiclePositionIdGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseRepositoryTest {
    @Test
    @Order(1)
    public void testIdAndGetAll(){
        VehiclePositionRepository vehiclePositionRepository = VehiclePositionRepository.getInstance();
        vehiclePositionRepository.add(new VehiclePosition(null,null,5,new Long("5")));
        VehiclePosition vehiclePosition = vehiclePositionRepository.getById(new Long("5"));
        assertEquals(vehiclePosition.getPosition(),5);
    }
}
