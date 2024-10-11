package com.rightlydivide.backend.dao;

import java.util.List;

public interface GenericDAO<T, ID> {
    void save(T entity);
    T findById(ID id);
    List<T> findAll();
    void update(T entity);
    void delete(ID id);
}

