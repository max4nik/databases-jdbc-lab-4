package ua.lviv.iot.passive.model.dao.implementation;

import ua.lviv.iot.passive.DBConnector;
import ua.lviv.iot.passive.model.dao.AbstractDAO;
import ua.lviv.iot.passive.model.entity.Flight;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDAOImplementation implements AbstractDAO<Flight> {
    private static final String FLIGHT_table = "nykyforuk_db.flight";

    private static final String FIND_ALL_QUERY = "SELECT * FROM " + FLIGHT_table + " ;";

    private static final String FIND_ONE_QUERY = "SELECT * FROM " + FLIGHT_table + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + FLIGHT_table +
            " (from_airport, to_airport, departure_time, arrival_time, pilot_id," +
            " aircraft_id, is_available, aviacompany_id, available_seats) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + FLIGHT_table +
            " SET from_airport = ?, to_airport = ?, departure_time = ?, arrival_time = ?, pilot_id = ?" +
            " aircraft_id = ?, is_available = ?, aviacompany_id = ?, available_seats = ?  WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + FLIGHT_table + " WHERE id = ?;";

    @Override
    public List<Flight> findAll() throws SQLException {
        List<Flight> flights = new ArrayList<>();

        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(FIND_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Flight flight = new Flight(
                        resultSet.getInt("id"),
                        resultSet.getInt("from_airport"),
                        resultSet.getInt("to_airport"),
                        resultSet.getString("departure_time"),
                        resultSet.getString("arrival_time"),
                        resultSet.getInt("pilot_id"),
                        resultSet.getInt("aircraft_id"),
                        resultSet.getBoolean("is_available"),
                        resultSet.getInt("aviacompany_id"),
                        resultSet.getInt("available_seats")
                );
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }


    @Override
    public Flight findOne(Integer id) throws SQLException {
        Flight flight = null;
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(FIND_ONE_QUERY)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                flight = new Flight(
                        resultSet.getInt("id"),
                        resultSet.getInt("from_airport"),
                        resultSet.getInt("to_airport"),
                        resultSet.getString("departure_time"),
                        resultSet.getString("arrival_time"),
                        resultSet.getInt("pilot_id"),
                        resultSet.getInt("aircraft_id"),
                        resultSet.getBoolean("is_available"),
                        resultSet.getInt("aviacompany_id"),
                        resultSet.getInt("available_seats")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;

    }

    @Override
    public void create(Flight flight) throws SQLException {
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, flight.getFromAirport());
            statement.setInt(2, flight.getToAirport());
            statement.setString(3, String.valueOf(flight.getDepartureTime()));
            statement.setString(4, String.valueOf(flight.getArrivalTime()));
            statement.setString(5, String.valueOf(flight.getPilotId()));
            statement.setString(6, String.valueOf(flight.getAircraftId()));
            statement.setBoolean(7, flight.getAvailable());
            statement.setInt(8, flight.getAviacompanyId());
            statement.setInt(9, flight.getAvailableSeats());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Flight flight) throws SQLException {
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, flight.getFromAirport());
            statement.setInt(2, flight.getToAirport());
            statement.setString(3, String.valueOf(flight.getDepartureTime()));
            statement.setString(4, String.valueOf(flight.getArrivalTime()));
            statement.setString(5, String.valueOf(flight.getPilotId()));
            statement.setString(6, String.valueOf(flight.getAircraftId()));
            statement.setBoolean(7, flight.getAvailable());
            statement.setInt(8, flight.getAviacompanyId());
            statement.setInt(9, flight.getAvailableSeats());
            statement.setInt(10, id);

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

