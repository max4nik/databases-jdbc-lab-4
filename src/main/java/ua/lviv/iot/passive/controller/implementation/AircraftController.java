package ua.lviv.iot.passive.controller.implementation;

import ua.lviv.iot.passive.controller.AbstractController;
import ua.lviv.iot.passive.model.dao.implementation.AircraftDAOImplementation;
import ua.lviv.iot.passive.model.entity.Aircraft;

import java.sql.SQLException;
import java.util.List;

public class AircraftController implements AbstractController<Aircraft> {
    private final AircraftDAOImplementation aircraftDAO = new AircraftDAOImplementation();


    @Override
    public List<Aircraft> findAll() throws SQLException {
        return aircraftDAO.findAll();
    }

    @Override
    public Aircraft findOne(Integer id) throws SQLException {
        return aircraftDAO.findOne(id);
    }

    @Override
    public void create(Aircraft aircraft) throws SQLException {
        aircraftDAO.create(aircraft);
    }

    @Override
    public void update(Integer id, Aircraft aircraft) throws SQLException {
        if (aircraftDAO.findOne(id) == null) {
            System.out.println("Aircraft with such id does not exist");
        } else {
            aircraftDAO.update(id, aircraft);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (aircraftDAO.findOne(id) == null) {
            System.out.println("Aircraft with such id does not exist");
        } else {
            aircraftDAO.delete(id);
        }
    }
}
