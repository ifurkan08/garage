package com.kafein.garage.controller;

import com.kafein.garage.model.dto.ParkAreaDTO;
import com.kafein.garage.model.dto.VehiclePositionDTO;
import com.kafein.garage.model.request.AddParkAreaRequest;
import com.kafein.garage.model.request.RegisterVehicleRequest;
import com.kafein.garage.model.request.TokenRequest;
import com.kafein.garage.model.response.ParkAreaStatusResponse;
import com.kafein.garage.services.service.IParkAreaService;
import com.kafein.garage.services.service.IVehiclePositionService;
import com.kafein.garage.services.service.IVehicleService;
import com.kafein.garage.utilites.ResetSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("park")
public class ParkController {

    @Autowired
    private IParkAreaService parkAreaService;

    @Autowired
    private IVehiclePositionService vehiclePositionService;

    @PostMapping("addParkArea")
    public ResponseEntity<?> addParkArea(@Valid @RequestBody AddParkAreaRequest addParkAreaRequest){
        parkAreaService.addParkArea(addParkAreaRequest.getParkAreaDTO());
        return ResponseEntity.ok().build();
    }
    @GetMapping("getParkAreaList")
    public ResponseEntity<List<ParkAreaDTO>> getParkAreaList(){
        return ResponseEntity.ok(parkAreaService.getParkAreaList());
    }
    @PostMapping("enterVehicle")
    public ResponseEntity<?> enterVehicle(@RequestBody RegisterVehicleRequest registerVehicleRequest) throws Exception {
        VehiclePositionDTO vehiclePositionDTO = vehiclePositionService.addVehiclePosition(registerVehicleRequest.getVehicleDTO());
        if(vehiclePositionDTO == null){
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("No parking space available");
        }
        return ResponseEntity.ok(vehiclePositionDTO);
    }
    @PostMapping("leaveVehicle")
    public ResponseEntity<?> leaveVehicleById(@RequestBody Long id) {
        vehiclePositionService.leaveVehiclePositionById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("getAllParkAreaStatus")
    public ResponseEntity<ParkAreaStatusResponse> getAllParkAreaStatus() throws Exception {
        ParkAreaStatusResponse statusResponse = new ParkAreaStatusResponse();
        statusResponse.setParkAreaVehicleHolds(parkAreaService.getAllStatus());
        return ResponseEntity.ok(statusResponse);
    }
}
