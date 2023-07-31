package LDEsystem.com.util;

import java.util.List;

public interface CRUD <T>{
    void save(T t);
    T findOne(String id);
    List<T> findAll();
    void upDate(T t);
    void delete(String id);
}
