package ua.lviv.iot.passive.controller.implementation;

import ua.lviv.iot.passive.controller.AbstractController;
import ua.lviv.iot.passive.model.dao.implementation.AviacompanyDAOImplementation;
import ua.lviv.iot.passive.model.entity.Aviacompany;

import java.sql.SQLException;
import java.util.List;

public class AviacompanyController implements AbstractController<Aviacompany> {
    private final AviacompanyDAOImplementation aviacompanyDAO = new AviacompanyDAOImplementation();


    @Override
    public List<Aviacompany> findAll() throws SQLException {
        return aviacompanyDAO.findAll();
    }

    @Override
    public Aviacompany findOne(Integer id) throws SQLException {
        return aviacompanyDAO.findOne(id);
    }

    @Override
    public void create(Aviacompany aviacompany) throws SQLException {
        aviacompanyDAO.create(aviacompany);
    }

    @Override
    public void update(Integer id, Aviacompany aviacompany) throws SQLException {
        if (aviacompanyDAO.findOne(id) == null) {
            System.out.println("Aviacompany with such id does not exist");
        } else {
            aviacompanyDAO.update(id, aviacompany);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (aviacompanyDAO.findOne(id) == null) {
            System.out.println("Aviacompany with such id does not exist");
        } else {
            aviacompanyDAO.delete(id);
        }
    }
}
