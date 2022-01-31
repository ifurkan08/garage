package com.kafein.garage.services.impl;

import com.kafein.garage.model.dto.ParkAreaDTO;
import com.kafein.garage.model.dto.VehicleDTO;
import com.kafein.garage.model.dto.VehiclePositionDTO;
import com.kafein.garage.model.entity.ParkArea;
import com.kafein.garage.model.entity.Vehicle;
import com.kafein.garage.model.entity.VehiclePosition;
import com.kafein.garage.repositories.VehiclePositionRepository;
import com.kafein.garage.services.service.IParkAreaService;
import com.kafein.garage.services.service.IVehiclePositionService;
import com.kafein.garage.services.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiclePositionServiceImpl implements IVehiclePositionService {

    @Autowired
    IParkAreaService parkAreaService;
    @Autowired
    IVehicleService vehicleService;

    public VehiclePositionServiceImpl(IParkAreaService parkAreaService, IVehicleService vehicleService) {
        this.parkAreaService = parkAreaService;
        this.vehicleService = vehicleService;
    }
    public VehiclePositionServiceImpl() {

    }

    private VehiclePositionRepository vehiclePositionRepository = VehiclePositionRepository.getInstance();
    @Override
    public VehiclePositionDTO addVehiclePosition(VehicleDTO vehicleDTO) throws Exception {
        VehiclePosition vehiclePosition = vehiclePositionRepository.getActiveVehicleByPlate(vehicleDTO.getPlate());
        if(vehiclePosition != null){
            throw new Exception("Plate already in use");
        }
        List<ParkAreaDTO> parkAreaDTOList = parkAreaService.getParkAreaList();
        for (ParkAreaDTO dto: parkAreaDTOList) {
           VehiclePositionDTO added = addVehiclePositionToParkAreaId(vehicleDTO,dto.getId());
           if(added != null){
               return added;
           }
        }
        return null;
    }

    @Override
    public VehiclePositionDTO addVehiclePositionToParkAreaId(VehicleDTO vehicleDTO, Long id) throws Exception {
        ParkArea parkArea = parkAreaService.getParkAreaById(id);
        int slot = parkArea.getSlot();
        int start = 0;
        int vehicleWidth = vehicleDTO.getVehicleType().getWidth();
        List<VehiclePositionDTO> vehiclePositionDTOList = getVehiclePositionListByParkAreaId(id);
        boolean ok =false;
        for (VehiclePositionDTO vehiclePositionDTO: vehiclePositionDTOList){
            int vecPoz = vehiclePositionDTO.getPosition();
            if(vecPoz - start >= vehicleDTO.getVehicleType().getWidth()){
                ok = true;
                break;
            }
            start = vecPoz + vehiclePositionDTO.getVehicle().getVehicleType().getWidth();
        }
        if(!ok && slot -start < vehicleWidth){
            return null;
        }
        VehicleDTO addedVehicle = vehicleService.addAndGetVehicle(vehicleDTO);
        Vehicle vehicle = vehicleService.getVehicleById(addedVehicle.getId());
        VehiclePosition vehiclePosition = new VehiclePosition(parkArea,vehicle,start,true);
        vehiclePosition =vehiclePositionRepository.add(vehiclePosition);
        VehiclePositionDTO vehiclePositionDTO = convert(vehiclePosition);
        return vehiclePositionDTO;
    }

    @Override
    public List<VehiclePositionDTO> getVehiclePositionListByParkAreaId(Long parkAreaId) {
        List<VehiclePositionDTO> vehiclePositionDTOList = new ArrayList<>();
        List<VehiclePosition> vehiclePositions = vehiclePositionRepository.getActiveVehiclePositionListByParkAreaId(parkAreaId);
        for (VehiclePosition vehiclePosition:vehiclePositions) {
            vehiclePositionDTOList.add(convert(vehiclePosition) );
        }
        return vehiclePositionDTOList;
    }

    @Override
    public void leaveVehiclePositionByPlate(String plate) {
        VehiclePosition vehiclePosition = vehiclePositionRepository.getActiveVehicleByPlate(plate);
        vehiclePosition.setActive(false);
        vehiclePositionRepository.update(vehiclePosition);
    }

    @Override
    public void leaveVehiclePositionById(Long id) {
        VehiclePosition vehiclePosition = vehiclePositionRepository.getById(id);
        vehiclePosition.setActive(false);
        vehiclePositionRepository.update(vehiclePosition);
    }


    @Override
    public VehiclePositionDTO getActiveVehiclePositionByPlate(String plate) {
        VehiclePosition vehiclePosition = vehiclePositionRepository.getActiveVehicleByPlate(plate);
        return convert(vehiclePosition);
    }

    @Override
    public VehiclePositionDTO convert(VehiclePosition vehiclePosition) {
        VehicleDTO vehicleDTO = new VehicleDTO().converToDTO(vehiclePosition.getVehicle(),new VehicleDTO());
        ParkAreaDTO parkAreaDTO = new ParkAreaDTO().converToDTO(vehiclePosition.getParkArea(),new ParkAreaDTO());
        VehiclePositionDTO vehiclePositionDTO = new VehiclePositionDTO(parkAreaDTO,vehicleDTO,vehiclePosition.getPosition(),vehiclePosition.getActive(),vehiclePosition.getId());
        return vehiclePositionDTO;
    }

}
