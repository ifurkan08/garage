package com.kafein.garage.utilities;

import com.kafein.garage.utilites.ParkAreaIdGenerator;
import com.kafein.garage.utilites.VehiclePositionIdGenerator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class IdGeneratorTest {

    @Test
    @Order(1)
    public void testDifferentTypeId(){
        Long parkAreaId = ParkAreaIdGenerator.getInstance().getId();
        Long vehiclePositionId = VehiclePositionIdGenerator.getInstance().getId();
        assertEquals(parkAreaId,vehiclePositionId);
    }
    @Test
    @Order(2)
    public void testId(){
        Long parkAreaId = ParkAreaIdGenerator.getInstance().getId();
        Long parkAreaId2 = ParkAreaIdGenerator.getInstance().getId();
        assertNotEquals(parkAreaId,parkAreaId2);
    }
}
