package ua.lviv.iot.passive.controller.implementation;

import ua.lviv.iot.passive.controller.AbstractController;
import ua.lviv.iot.passive.model.dao.implementation.PilotDAOImplementation;
import ua.lviv.iot.passive.model.entity.Pilot;

import java.sql.SQLException;
import java.util.List;

public class PilotController implements AbstractController<Pilot> {
    private final PilotDAOImplementation pilotDAO = new PilotDAOImplementation();

    @Override
    public List<Pilot> findAll() throws SQLException {
        return pilotDAO.findAll();
    }

    @Override
    public Pilot findOne(Integer id) throws SQLException {
        return pilotDAO.findOne(id);
    }

    @Override
    public void create(Pilot pilot) throws SQLException {
        pilotDAO.create(pilot);
    }

    @Override
    public void update(Integer id, Pilot pilot) throws SQLException {
        if (pilotDAO.findOne(id) == null) {
            System.out.println("Pilot with such id does not exist");
        } else {
            pilotDAO.update(id, pilot);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (pilotDAO.findOne(id) == null) {
            System.out.println("Pilot with such id does not exist");
        } else {
            pilotDAO.delete(id);
        }
    }
}
