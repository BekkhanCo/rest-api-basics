package DAO;

import java.util.List;
import java.util.UUID;

public interface BaseDAO<T> {

    T save(T t);

    T get(UUID id);

    List<T> getAll();

    int remove(UUID id);

}
