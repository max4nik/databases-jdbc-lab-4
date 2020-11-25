package ua.lviv.iot.passive.model.dao.implementation;

import ua.lviv.iot.passive.DBConnector;
import ua.lviv.iot.passive.model.dao.AbstractDAO;
import ua.lviv.iot.passive.model.entity.Aircraft;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AircraftDAOImplementation implements AbstractDAO<Aircraft> {
    private static final String AIRCRAFT_TABLE = "nykyforuk_db.aircraft";

    private static final String FIND_ALL_QUERY = "SELECT * FROM " + AIRCRAFT_TABLE + " ;";

    private static final String FIND_ONE_QUERY = "SELECT * FROM " + AIRCRAFT_TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + AIRCRAFT_TABLE +
            " (model_name, type, years_in_use, max_seats, aviacompany_id) VALUES (?, ?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + AIRCRAFT_TABLE +
            " SET model_name = ?, type = ?, years_in_use = ?, max_seats = ?, aviacompany_id = ?  WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + AIRCRAFT_TABLE + " WHERE id = ?;";

    @Override
    public List<Aircraft> findAll() throws SQLException {
        List<Aircraft> aircrafts = new ArrayList<>();

        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(FIND_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Aircraft aircraft = new Aircraft(
                        resultSet.getInt("id"),
                        resultSet.getString("model_name"),
                        resultSet.getString("type"),
                        resultSet.getInt("years_in_use"),
                        resultSet.getInt("max_seats"),
                        resultSet.getInt("aviacompany_id")
                );
                aircrafts.add(aircraft);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aircrafts;
    }


    @Override
    public Aircraft findOne(Integer id) throws SQLException {
        Aircraft aircraft = null;
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(FIND_ONE_QUERY)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                aircraft = new Aircraft(
                        resultSet.getInt("id"),
                        resultSet.getString("model_name"),
                        resultSet.getString("type"),
                        resultSet.getInt("years_in_use"),
                        resultSet.getInt("max_seats"),
                        resultSet.getInt("aviacompany_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aircraft;

    }

    @Override
    public void create(Aircraft aircraft) throws SQLException {
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, String.valueOf(aircraft.getModelName()));
            statement.setString(2, String.valueOf(aircraft.getType()));
            statement.setInt(3, aircraft.getYearsInUse());
            statement.setInt(4, aircraft.getMaxSeats());
            statement.setInt(5, aircraft.getAviacompanyId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Aircraft aircraft) throws SQLException {
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, String.valueOf(aircraft.getModelName()));
            statement.setString(2, String.valueOf(aircraft.getType()));
            statement.setInt(3, aircraft.getYearsInUse());
            statement.setInt(4, aircraft.getMaxSeats());
            statement.setInt(5, aircraft.getAviacompanyId());
            statement.setInt(6, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

