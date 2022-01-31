package com.kafein.garage.services.impl;

import com.kafein.garage.model.dto.ParkAreaDTO;
import com.kafein.garage.model.dto.VehiclePositionDTO;
import com.kafein.garage.model.entity.ParkArea;
import com.kafein.garage.model.viewmodel.ParkAreaVehicleHold;
import com.kafein.garage.model.viewmodel.VehicleHoldModel;
import com.kafein.garage.repositories.ParkAreaRepository;
import com.kafein.garage.services.service.IParkAreaService;
import com.kafein.garage.services.service.IVehiclePositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkAreaServiceImpl implements IParkAreaService {
    @Autowired
    private IVehiclePositionService vehiclePositionService;

    private ParkAreaRepository parkAreaRepository = ParkAreaRepository.getInstance();

    @Override
    public void addParkArea(ParkAreaDTO parkAreaDTO) {
        parkAreaRepository.add(parkAreaDTO.convertToEntity(parkAreaDTO, new ParkArea()));
    }

    @Override
    public List<ParkAreaDTO> getParkAreaList() {
        List<ParkAreaDTO> parkAreaDTOList = new ArrayList<>();
        List<ParkArea> parkAreaList = parkAreaRepository.getAll();
        for (ParkArea parkArea : parkAreaList) {
            parkAreaDTOList.add(new ParkAreaDTO().converToDTO(parkArea, new ParkAreaDTO()));
        }
        return parkAreaDTOList;
    }

    @Override
    public ParkAreaDTO getParkAreaDtoById(Long id) throws NoSuchFieldException {
        ParkArea parkArea = parkAreaRepository.getById(id);
        if (parkArea == null) {
            throw new NoSuchFieldException();
        }
        ParkAreaDTO parkAreaDTO = new ParkAreaDTO().converToDTO(parkArea, new ParkAreaDTO());
        return parkAreaDTO;
    }

    @Override
    public ParkArea getParkAreaById(Long id) {
        ParkArea parkArea = parkAreaRepository.getById(id);
        return parkArea;
    }

    @Override
    public List<ParkAreaVehicleHold> getAllStatus() throws Exception {
        List<ParkAreaDTO> parkAreaDTOList = getParkAreaList();

        if (parkAreaDTOList.size() == 0) {
            throw new Exception("Park Area is empty");
        }
        List<ParkAreaVehicleHold> parkAreaVehicleHoldList = new ArrayList<>();
        for (ParkAreaDTO parkAreaDTO : parkAreaDTOList) {
            List<VehicleHoldModel> vehicleHoldModel = new ArrayList<>();
            List<VehiclePositionDTO> vehiclePositionDTOList = vehiclePositionService.getVehiclePositionListByParkAreaId(parkAreaDTO.getId());
            for (VehiclePositionDTO vehiclePositionDTO : vehiclePositionDTOList) {
                vehicleHoldModel.add(new VehicleHoldModel(vehiclePositionDTO));
            }
            ParkAreaVehicleHold parkAreaVehicleHold = new ParkAreaVehicleHold();
            parkAreaVehicleHold.setParkAreaDTO(parkAreaDTO);
            parkAreaVehicleHold.setVehicleHoldModelList(vehicleHoldModel);
            parkAreaVehicleHoldList.add(parkAreaVehicleHold);
        }
        return parkAreaVehicleHoldList;
    }
}
