package com.kafein.garage.repositories;

import com.kafein.garage.model.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class RepositoryBase<T extends BaseEntity> {
    private List<T> list = new ArrayList<>();
    public void add(T obj){
        list.add(obj);
    }
    public T getById(Long id){
       return list.stream().filter(k -> k.getId() == id).findFirst().orElse(null);
    }
    public List<T> getAll(){
        return list;
    }
}
