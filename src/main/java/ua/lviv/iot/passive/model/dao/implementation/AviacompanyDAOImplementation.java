package ua.lviv.iot.passive.model.dao.implementation;

import ua.lviv.iot.passive.DBConnector;
import ua.lviv.iot.passive.model.dao.AbstractDAO;
import ua.lviv.iot.passive.model.entity.Aviacompany;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AviacompanyDAOImplementation implements AbstractDAO<Aviacompany> {
    private static final String AVIACOMPANY_TABLE = "nykyforuk_db.aviacompany";

    private static final String FIND_ALL_QUERY = "SELECT * FROM " + AVIACOMPANY_TABLE + " ;";

    private static final String FIND_ONE_QUERY = "SELECT * FROM " + AVIACOMPANY_TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + AVIACOMPANY_TABLE +
            " (name, creation_date) VALUES (?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + AVIACOMPANY_TABLE +
            " SET name = ?, creation_date = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + AVIACOMPANY_TABLE + " WHERE id = ?;";

    @Override
    public List<Aviacompany> findAll() throws SQLException {
        List<Aviacompany> aviacompanies = new ArrayList<>();

        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(FIND_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Aviacompany aviacompany = new Aviacompany(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("creation_date")
                );
                aviacompanies.add(aviacompany);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aviacompanies;
    }


    @Override
    public Aviacompany findOne(Integer id) throws SQLException {
        Aviacompany aviacompany = null;
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(FIND_ONE_QUERY)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                aviacompany = new Aviacompany(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("creation_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aviacompany;

    }

    @Override
    public void create(Aviacompany aviacompany) throws SQLException {
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(CREATE_QUERY)) {

            statement.setString(1, String.valueOf(aviacompany.getName()));
            statement.setString(2, String.valueOf(aviacompany.getCreationDate()));


            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Aviacompany aviacompany) throws SQLException {
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, String.valueOf(aviacompany.getName()));
            statement.setString(2, String.valueOf(aviacompany.getCreationDate()));
            statement.setInt(3, id);

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

