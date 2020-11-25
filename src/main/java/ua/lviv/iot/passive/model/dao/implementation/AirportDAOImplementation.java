package ua.lviv.iot.passive.model.dao.implementation;

import ua.lviv.iot.passive.DBConnector;
import ua.lviv.iot.passive.model.dao.AbstractDAO;
import ua.lviv.iot.passive.model.entity.Airport;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDAOImplementation implements AbstractDAO<Airport> {
    private static final String AIRPORT_TABLE = "nykyforuk_db.airport";

    private static final String FIND_ALL_QUERY = "SELECT * FROM " + AIRPORT_TABLE + " ;";

    private static final String FIND_ONE_QUERY = "SELECT * FROM " + AIRPORT_TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + AIRPORT_TABLE +
            " (name, amount_of_workers, city) VALUES (?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + AIRPORT_TABLE +
            " SET name = ?, amount_of_workers = ?, city = ?  WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + AIRPORT_TABLE + " WHERE id = ?;";

    @Override
    public List<Airport> findAll() throws SQLException {
        List<Airport> airports = new ArrayList<>();

        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(FIND_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Airport airport = new Airport(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("amount_of_workers"),
                        resultSet.getString("city")
                );
                airports.add(airport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airports;
    }


    @Override
    public Airport findOne(Integer id) throws SQLException {
        Airport airport = null;
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(FIND_ONE_QUERY)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                airport = new Airport(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("amount_of_workers"),
                        resultSet.getString("city")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airport;

    }

    @Override
    public void create(Airport airport) throws SQLException {
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, String.valueOf(airport.getName()));
            statement.setInt(2, airport.getAmountOfWorkers());
            statement.setString(3, String.valueOf(airport.getCity()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Airport airport) throws SQLException {
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, String.valueOf(airport.getName()));
            statement.setInt(2, airport.getAmountOfWorkers());
            statement.setString(3, String.valueOf(airport.getCity()));
            statement.setInt(4, id);

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

