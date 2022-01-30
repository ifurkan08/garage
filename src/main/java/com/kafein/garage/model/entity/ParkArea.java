package com.kafein.garage.model.entity;


public class ParkArea extends BaseEntity implements IEntity {
    public ParkArea(int slot) {
        this.slot = slot;
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
