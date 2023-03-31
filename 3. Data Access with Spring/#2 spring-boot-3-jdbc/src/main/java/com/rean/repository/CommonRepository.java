package com.rean.repository;

public interface CommonRepository<T> {

    T save(T model);
    void delete(T model);
    T findById(Long id);
    Iterable<T> findAll();
}
