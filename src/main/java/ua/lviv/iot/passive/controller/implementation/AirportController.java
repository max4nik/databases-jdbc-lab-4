package ua.lviv.iot.passive.controller.implementation;

import ua.lviv.iot.passive.controller.AbstractController;
import ua.lviv.iot.passive.model.dao.implementation.AirportDAOImplementation;
import ua.lviv.iot.passive.model.entity.Airport;

import java.sql.SQLException;
import java.util.List;

public class AirportController implements AbstractController<Airport> {
    private final AirportDAOImplementation airportDAO = new AirportDAOImplementation();


    @Override
    public List<Airport> findAll() throws SQLException {
        return airportDAO.findAll();
    }

    @Override
    public Airport findOne(Integer id) throws SQLException {
        return airportDAO.findOne(id);
    }

    @Override
    public void create(Airport airport) throws SQLException {
        airportDAO.create(airport);
    }

    @Override
    public void update(Integer id, Airport airport) throws SQLException {
        if (airportDAO.findOne(id) == null) {
            System.out.println("Airport with such id does not exist");
        } else {
            airportDAO.update(id, airport);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (airportDAO.findOne(id) == null) {
            System.out.println("Airport with such id does not exist");
        } else {
            airportDAO.delete(id);
        }
    }
}
