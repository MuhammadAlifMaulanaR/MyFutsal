package com.workshop.repository;

import com.workshop.model.Status;
import com.workshop.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    private Connection connection;
    // add conection

    public UserRepo(Connection connection){
        this.connection = connection;
    }

    public void create(User user){
            String query = "INSERT INTO User (ID, name, ID_Status) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, user.getID());
            statement.setString(2, user.getName());
            statement.setInt(3, user.getStatus().getID());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public List<User> select() {
        List<User> users = new ArrayList<>();
            String query = "SELECT u.*, s.ID as status_id, s.description as status_description FROM User u JOIN Status s ON u.ID_Status = s.ID";
        try (Statement statement = connection.createStatement();ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Status status = new Status(resultSet.getInt("status_id"), resultSet.getString("status_description"));
                users.add(new User(resultSet.getInt("ID"), resultSet.getString("name"), status));
                users.get(users.size() - 1).setID(resultSet.getInt("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public void update(User user) {
            String query = "UPDATE User SET name = ?, ID_Status = ? WHERE ID = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, user.getName());
            ps.setInt(2, user.getStatus().getID());
            ps.setInt(3, user.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int ID) {
            String query = "DELETE FROM User WHERE ID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
