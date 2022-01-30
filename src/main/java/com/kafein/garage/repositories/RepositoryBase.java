package com.kafein.garage.repositories;

import com.kafein.garage.model.entity.BaseEntity;
import com.kafein.garage.utilites.IdGenerators.IIdGenerator;
import com.kafein.garage.utilites.IdGenerators.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class RepositoryBase<T extends BaseEntity> {
    private List<T> list = new ArrayList<>();

    public void add(T obj) {
        IIdGenerator iIdGenerator = IdGenerator.getInstance().getGenerator(obj.getClass());
        obj.setId(iIdGenerator.createId());
        list.add(obj);
    }

    public T getById(Long id) {
        return list.stream().filter(k -> k.getId().equals(id)).findFirst().orElse(null);
    }

    public List<T> getAll() {
        return list;
    }
}
