package com.kafein.garage.model.dto;

import com.kafein.garage.model.entity.ParkArea;

import javax.validation.constraints.NotNull;


public class ParkAreaDTO extends BaseDTO<ParkAreaDTO, ParkArea> {
    @NotNull(message = "The slot is required")
    private Integer slot;
    private Long id;

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
