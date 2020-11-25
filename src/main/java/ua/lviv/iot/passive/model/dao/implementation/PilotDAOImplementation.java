package ua.lviv.iot.passive.model.dao.implementation;

import ua.lviv.iot.passive.DBConnector;
import ua.lviv.iot.passive.model.dao.AbstractDAO;
import ua.lviv.iot.passive.model.entity.Pilot;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PilotDAOImplementation implements AbstractDAO<Pilot> {
    private static final String PILOT_TABLE = "nykyforuk_db.pilot";

    private static final String FIND_ALL_QUERY = "SELECT * FROM " + PILOT_TABLE + " ;";

    private static final String FIND_ONE_QUERY = "SELECT * FROM " + PILOT_TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + PILOT_TABLE +
            " (surname, name, position) VALUES (?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + PILOT_TABLE +
            " SET surname = ?, name = ?, position = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + PILOT_TABLE + " WHERE id = ?;";

    @Override
    public List<Pilot> findAll() throws SQLException {
        List<Pilot> pilots = new ArrayList<>();

        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(FIND_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Pilot pilot = new Pilot(
                        resultSet.getInt("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("name"),
                        resultSet.getString("position")
                );
                pilots.add(pilot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pilots;
    }


    @Override
    public Pilot findOne(Integer id) throws SQLException {
        Pilot pilot = null;
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(FIND_ONE_QUERY)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                pilot = new Pilot(
                        resultSet.getInt("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("name"),
                        resultSet.getString("position")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pilot;

    }

    @Override
    public void create(Pilot pilot) throws SQLException {
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, String.valueOf(pilot.getSurName()));
            statement.setString(2, String.valueOf(pilot.getName()));
            statement.setString(3, String.valueOf(pilot.getPosition()));

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Pilot pilot) throws SQLException {
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, String.valueOf(pilot.getSurName()));
            statement.setString(2, String.valueOf(pilot.getName()));
            statement.setString(3, String.valueOf(pilot.getPosition()));
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

