package ua.lviv.iot.passive.controller.implementation;

import ua.lviv.iot.passive.controller.AbstractController;
import ua.lviv.iot.passive.model.dao.implementation.FlightDAOImplementation;
import ua.lviv.iot.passive.model.entity.Flight;

import java.sql.SQLException;
import java.util.List;

public class FlightController implements AbstractController<Flight> {
    private final FlightDAOImplementation flightDAO = new FlightDAOImplementation();


    @Override
    public List<Flight> findAll() throws SQLException {
        return flightDAO.findAll();
    }

    @Override
    public Flight findOne(Integer id) throws SQLException {
        return flightDAO.findOne(id);
    }

    @Override
    public void create(Flight flight) throws SQLException {
        flightDAO.create(flight);
    }

    @Override
    public void update(Integer id, Flight flight) throws SQLException {
        if (flightDAO.findOne(id) == null) {
            System.out.println("Flight with such id does not exist");
        } else {
            flightDAO.update(id, flight);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (flightDAO.findOne(id) == null) {
            System.out.println("Flight with such id does not exist");
        } else {
            flightDAO.delete(id);
        }
    }
}
