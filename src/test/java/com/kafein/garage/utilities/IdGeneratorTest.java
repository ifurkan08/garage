package com.kafein.garage.utilities;

import com.kafein.garage.model.entity.ParkArea;
import com.kafein.garage.model.entity.Vehicle;
import com.kafein.garage.utilites.IdGenerators.IIdGenerator;
import com.kafein.garage.utilites.IdGenerators.IdGenerator;
import com.kafein.garage.utilites.IdGenerators.ParkAreaIdGenerator;
import com.kafein.garage.utilites.IdGenerators.VehiclePositionIdGenerator;
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
        IIdGenerator generator = IdGenerator.getInstance().getGenerator(ParkArea.class);
        Long parkAreaId = generator.createId();
        IIdGenerator generator2 = IdGenerator.getInstance().getGenerator(Vehicle.class);
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
