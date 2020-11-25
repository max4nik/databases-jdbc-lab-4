package ua.lviv.iot.passive.model.dao;


import java.sql.SQLException;
import java.util.List;

public interface AbstractDAO<T> {
    List<T> findAll() throws SQLException;

    T findOne(Integer id) throws SQLException;

    void create(T object) throws SQLException;

    void update(Integer id, T object) throws SQLException;

    void delete(Integer id) throws SQLException;

}
