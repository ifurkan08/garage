package com.kafein.garage.model.response;

import com.kafein.garage.model.dto.ParkAreaDTO;
import com.kafein.garage.model.entity.Vehicle;
import com.kafein.garage.model.viewmodel.ParkAreaVehicleHold;
import com.kafein.garage.model.viewmodel.VehicleHoldModel;

import java.util.List;

public class ParkAreaStatusResponse {
    private List<ParkAreaVehicleHold> parkAreaVehicleHolds;

    public List<ParkAreaVehicleHold> getParkAreaVehicleHolds() {
        return parkAreaVehicleHolds;
    }

    public void setParkAreaVehicleHolds(List<ParkAreaVehicleHold> parkAreaVehicleHolds) {
        this.parkAreaVehicleHolds = parkAreaVehicleHolds;
    }
}
