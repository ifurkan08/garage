package com.kafein.garage.repo;

import com.kafein.garage.model.entity.VehiclePosition;
import com.kafein.garage.repositories.VehiclePositionRepository;
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
        vehiclePositionRepository.add(new VehiclePosition(null,null,5));
        VehiclePosition vehiclePosition = vehiclePositionRepository.getById(new Long("0"));
        assertEquals(vehiclePosition.getPosition(),5);
    }
    @Test
    @Order(2)
    public void testIdTest(){
        VehiclePositionRepository vehiclePositionRepository = VehiclePositionRepository.getInstance();
        VehiclePosition vehiclePosition = vehiclePositionRepository.getById(new Long("0"));
        assertEquals(vehiclePosition.getPosition(),5);
    }

}
