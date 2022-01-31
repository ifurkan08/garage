package com.kafein.garage.utilities;

import com.kafein.garage.model.entity.ParkArea;
import com.kafein.garage.model.entity.VehiclePosition;
import com.kafein.garage.utilites.IdGenerators.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.kafein.garage.utilites.ResetSingleton;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class IdGeneratorTest {

    @BeforeAll
    public static void init(){
        ResetSingleton.resetSingleton(IdGenerator.class,"instance");
        ResetSingleton.resetSingleton(VehiclePositionIdGenerator.class,"instance");
        ResetSingleton.resetSingleton(ParkAreaIdGenerator.class,"instance");
    }

    @Test
    @Order(1)
    public void testDifferentTypeId(){
        IIdGenerator generator = IdGenerator.getInstance().getGenerator(ParkArea.class);
        Long parkAreaId = generator.createId();
        IIdGenerator generator2 = IdGenerator.getInstance().getGenerator(VehiclePosition.class);
        Long vehiclePositionId = generator2.createId();
        assertEquals(parkAreaId,vehiclePositionId);
    }
    @Test
    @Order(2)
    public void testId(){
        IIdGenerator generator = IdGenerator.getInstance().getGenerator(ParkArea.class);
        Long parkAreaId = generator.createId();
        Long parkAreaId2 = generator.createId();
        assertNotEquals(parkAreaId,parkAreaId2);
    }
}
