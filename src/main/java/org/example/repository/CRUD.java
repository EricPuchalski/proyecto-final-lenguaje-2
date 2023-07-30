package org.example.repository;

import java.util.List;

public interface CRUD <T>{
    void upLoad();
    void save(T t);
    void upDate(T t);
    List<T> findAll();
    List<T> findAllOff();
    T findOne(String id);
    void delete(String id);
}
