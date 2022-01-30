package com.kafein.garage.utilites.IdGenerators;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorBase {
    private AtomicLong atomicCounter ;
    IdGeneratorBase(){
        atomicCounter = new AtomicLong();
    }
    public Long createId() {
        return atomicCounter.getAndIncrement();
    }
}
