package com.workshop.repository;

import com.workshop.model.JenisLapangan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JenisLapanganRepo {
    private Connection connection;

    public JenisLapanganRepo(Connection connection){
        this.connection = connection;
    }
    public void create(JenisLapangan jenisLapangan) {
        String sql = "INSERT INTO JenisLapangan (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, jenisLapangan.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<JenisLapangan> select() {
        List<JenisLapangan> jenisLapangans = new ArrayList<>();
        String sql = "SELECT * FROM JenisLapangan";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                jenisLapangans.add(new JenisLapangan(ID, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jenisLapangans;
    }
    public void update(JenisLapangan jenisLapangan) {
        String sql = "UPDATE JenisLapangan SET name = ? WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, jenisLapangan.getName());
            statement.setInt(2, jenisLapangan.getID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int ID) {
        String sql = "DELETE FROM JenisLapangan WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
