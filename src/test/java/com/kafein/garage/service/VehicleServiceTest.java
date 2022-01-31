package com.kafein.garage.service;

import com.kafein.garage.model.dto.VehicleDTO;
import com.kafein.garage.model.types.Color;
import com.kafein.garage.model.types.VehicleType;
import com.kafein.garage.repositories.VehicleRepository;
import com.kafein.garage.services.impl.VehicleServiceImpl;
import com.kafein.garage.services.service.IVehicleService;
import com.kafein.garage.utilites.IdGenerators.VehicleIdGenerator;
import com.kafein.garage.utilites.ResetSingleton;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VehicleServiceTest {
    static IVehicleService vehicleService;

    @BeforeAll
    public static void init(){
        vehicleService = new VehicleServiceImpl();
    }
    @Test
    @Order(1)
    public void addAndGetVehicleTest() throws Exception {
            Exception thrown = assertThrows(
                    Exception.class,
                    () -> vehicleService.addAndGetVehicle(null)
            );
            assertTrue(thrown.getMessage().equals("The vehicle cannot be assigned a null value"));

            VehicleDTO vehicleDTO = new VehicleDTO(VehicleType.CAR, Color.BLUE, "08 AA 123");
            vehicleService.addAndGetVehicle(vehicleDTO);
    }
}
