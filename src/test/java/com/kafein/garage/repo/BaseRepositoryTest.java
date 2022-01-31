package com.kafein.garage.repo;

import com.kafein.garage.model.entity.VehiclePosition;
import com.kafein.garage.repositories.VehiclePositionRepository;
import com.kafein.garage.utilites.IdGenerators.IdGenerator;
import com.kafein.garage.utilites.IdGenerators.ParkAreaIdGenerator;
import com.kafein.garage.utilites.IdGenerators.VehicleIdGenerator;
import com.kafein.garage.utilites.IdGenerators.VehiclePositionIdGenerator;
import com.kafein.garage.utilites.ResetSingleton;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseRepositoryTest {

    @BeforeAll
    public static void init(){
        ResetSingleton.resetSingleton(IdGenerator.class,"instance");
        ResetSingleton.resetSingleton(VehiclePositionIdGenerator.class,"instance");
        ResetSingleton.resetSingleton(VehiclePositionRepository.class,"instance");
    }

    @Test
    @Order(1)
    public void testIdAndGetAll(){
        VehiclePositionRepository vehiclePositionRepository = VehiclePositionRepository.getInstance();
        vehiclePositionRepository.add(new VehiclePosition(null,null,5,true));
        VehiclePosition vehiclePosition = vehiclePositionRepository.getById(new Long("0"));
        assertEquals(vehiclePosition.getPosition(),5);
    }
    @Test
    @Order(2)
    public void updateTest(){
        VehiclePositionRepository vehiclePositionRepository = VehiclePositionRepository.getInstance();
        VehiclePosition vehiclePosition = vehiclePositionRepository.add(new VehiclePosition(null,null,3,true));
        VehiclePosition vehicleUpdated = new VehiclePosition(null,null,5,true);
        vehicleUpdated.setId(vehiclePosition.getId());
        vehiclePositionRepository.update(vehicleUpdated);
        VehiclePosition orj = vehiclePositionRepository.getById(vehicleUpdated.getId());
        assertEquals(5,orj.getPosition());
    }


}
