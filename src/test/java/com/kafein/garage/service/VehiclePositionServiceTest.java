package com.kafein.garage.service;

import com.kafein.garage.model.dto.VehicleDTO;
import com.kafein.garage.model.dto.VehiclePositionDTO;
import com.kafein.garage.model.entity.ParkArea;
import com.kafein.garage.model.entity.VehiclePosition;
import com.kafein.garage.model.types.Color;
import com.kafein.garage.model.types.VehicleType;
import com.kafein.garage.repositories.ParkAreaRepository;
import com.kafein.garage.repositories.VehiclePositionRepository;
import com.kafein.garage.services.impl.ParkAreaServiceImpl;
import com.kafein.garage.services.impl.VehiclePositionServiceImpl;
import com.kafein.garage.services.impl.VehicleServiceImpl;
import com.kafein.garage.services.service.IParkAreaService;
import com.kafein.garage.services.service.IVehiclePositionService;
import com.kafein.garage.services.service.IVehicleService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VehiclePositionServiceTest {
    private static IVehiclePositionService vehiclePositionService ;
    private static Integer parkAreaSlot= VehicleType.TRUCK.getWidth()*2+VehicleType.JEEP.getWidth()-1;
    @BeforeAll
    public static void init(){
        IParkAreaService parkAreaService = new ParkAreaServiceImpl();
        IVehicleService vehicleService = new VehicleServiceImpl();
        vehiclePositionService = new VehiclePositionServiceImpl(parkAreaService,vehicleService);
    }
    @Test
    public void addVehiclePositionTestTest() throws Exception {
        ParkAreaRepository parkAreaRepository = ParkAreaRepository.getInstance();
        ParkArea parkArea = parkAreaRepository.add(new ParkArea(parkAreaSlot));
        VehicleDTO vehicleDTO = new VehicleDTO(VehicleType.TRUCK, Color.BLUE, "34AA348");
        VehiclePositionDTO vehiclePositionDTO = vehiclePositionService.addVehiclePositionToParkAreaId(vehicleDTO, parkArea.getId());
        assertEquals(0,vehiclePositionDTO.getPosition());
    }
    @Test
    public void addMultipleVehicePositionTest() throws Exception {
        ParkAreaRepository parkAreaRepository = ParkAreaRepository.getInstance();
        ParkArea parkArea = parkAreaRepository.add(new ParkArea(parkAreaSlot));
        VehicleDTO vehicleDTO = new VehicleDTO(VehicleType.TRUCK, Color.BLUE, "34AA348");
        VehicleDTO vehicleDTO1 = new VehicleDTO(VehicleType.TRUCK, Color.RED, "34AA123");
        vehiclePositionService.addVehiclePositionToParkAreaId(vehicleDTO, parkArea.getId());
        VehiclePositionDTO vehiclePositionDTO1 = vehiclePositionService.addVehiclePositionToParkAreaId(vehicleDTO1, parkArea.getId());
        assertEquals(VehicleType.TRUCK.getWidth(),vehiclePositionDTO1.getPosition());
    }
    @Test
    public void notEnoughSpaceTest() throws Exception {
        ParkAreaRepository parkAreaRepository = ParkAreaRepository.getInstance();
        ParkArea parkArea = parkAreaRepository.add(new ParkArea(parkAreaSlot));
        VehicleDTO vehicleDTO = new VehicleDTO(VehicleType.TRUCK, Color.BLUE, "34AA348");
        VehicleDTO vehicleDTO1 = new VehicleDTO(VehicleType.TRUCK, Color.RED, "34AA123");
        VehicleDTO vehicleDTO2 = new VehicleDTO(VehicleType.JEEP, Color.RED, "34AA124");
        vehiclePositionService.addVehiclePositionToParkAreaId(vehicleDTO, parkArea.getId());
        vehiclePositionService.addVehiclePositionToParkAreaId(vehicleDTO1, parkArea.getId());
        VehiclePositionDTO vehiclePositionDTO1 = vehiclePositionService.addVehiclePositionToParkAreaId(vehicleDTO2, parkArea.getId());
        assertNull(vehiclePositionDTO1);
    }
    @Test
    public void leaveVehicleTest() throws Exception {
        String plate = "08AA345";
        ParkAreaRepository parkAreaRepository = ParkAreaRepository.getInstance();
        ParkArea parkArea = parkAreaRepository.add(new ParkArea(parkAreaSlot));
        VehicleDTO vehicleDTO = new VehicleDTO(VehicleType.TRUCK, Color.BLUE, plate);
        VehiclePositionDTO vehiclePositionDTO =vehiclePositionService.addVehiclePositionToParkAreaId(vehicleDTO, parkArea.getId());
        vehiclePositionService.leaveVehiclePositionByPlate(plate);
        VehiclePositionRepository vehiclePositionRepository = VehiclePositionRepository.getInstance();
        assertEquals(false,vehiclePositionRepository.getById(vehiclePositionDTO.getId()).getActive());
    }


}
