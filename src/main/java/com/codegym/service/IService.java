package com.codegym.service;

import com.codegym.exception.NotFoundException;

public interface IService<T> {
    Iterable<T> findAll();
    T findById(Long id) throws NotFoundException;
    T save(T t);
    void deleteById(Long id);
}
