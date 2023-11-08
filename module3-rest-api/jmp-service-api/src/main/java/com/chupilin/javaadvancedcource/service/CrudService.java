package com.chupilin.javaadvancedcource.service;


import java.util.List;

public interface CrudService<T> {

    T save(T user);

    void delete(Long id);

    T find(Long id);

    List<T> findAll();

}
