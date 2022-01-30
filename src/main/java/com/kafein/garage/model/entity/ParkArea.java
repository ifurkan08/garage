package com.kafein.garage.model.entity;

public class ParkArea extends BaseEntity {
    public ParkArea(int slot,Long id) {
        this.slot = slot;
        this.id = id;
    }
    public ParkArea() {

    }
    private int slot;
    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

}
