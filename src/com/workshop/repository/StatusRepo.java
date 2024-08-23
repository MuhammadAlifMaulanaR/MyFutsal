package com.workshop.repository;

import com.workshop.model.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatusRepo {
    private  Connection connection;
    public StatusRepo(Connection connection){
        this.connection = connection;
    }
    public void create(Status status) {
        try {
            String sql = "INSERT INTO Status (ID, description) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, status.getID());
            preparedStatement.setString(2, status.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  List<Status> select(){
        List<Status> statuses = new ArrayList<>();
        try{
            String sql = "SELECT*FROM Status";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                statuses.add(new Status(resultSet.getInt("ID"), resultSet.getString("description")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return  statuses;
    }

    public boolean update(Status status){
        try {
            String sql = "UPDATE Status SET description = ? WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, status.getDescription());
            preparedStatement.setInt(2, status.getID());
            int row = preparedStatement.executeUpdate();
            return row > 0;
        } catch (SQLException e){
            e.getMessage();
            return false;
        }
    }

    public boolean delete(int ID){
        String sql = "DELETE FROM Status WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, ID);
            int row = statement.executeUpdate();
//            statement.executeUpdate();
            return row > 0;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
