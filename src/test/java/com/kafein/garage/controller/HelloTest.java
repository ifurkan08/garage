package com.kafein.garage.controller;

import com.kafein.garage.model.entity.ParkArea;
import com.kafein.garage.repositories.ParkAreaRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {
    @Test
    public void testDeneme(){
        ParkAreaRepository parkAreaRepository = new ParkAreaRepository();
        parkAreaRepository.add(new ParkArea(10,new Long("3")));
        assertEquals(parkAreaRepository.getById(new Long("3")).getSlot(),10);
    }
}
