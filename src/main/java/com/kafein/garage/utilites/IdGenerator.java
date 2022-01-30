package com.kafein.garage.utilites;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private AtomicLong atomicCounter ;
    IdGenerator(){
        atomicCounter = new AtomicLong();
    }
    public Long createId() {
        return atomicCounter.getAndIncrement();
    }
}
