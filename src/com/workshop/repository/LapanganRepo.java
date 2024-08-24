package com.workshop.repository;

import com.workshop.model.Lapangan;
import com.workshop.model.JenisLapangan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LapanganRepo {
    private Connection connection;

    public LapanganRepo(Connection connection){

        this.connection = connection;
    }

    public void create(Lapangan lapangan){
            String query = "INSERT INTO Lapangan (name, ID_JenisLapangan) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, lapangan.getName());
            statement.setInt(2, lapangan.getJenisLapangan().getID());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public  List<Lapangan> select(){
        List<Lapangan> lapangans = new ArrayList<>();
            String query = "SELECT l.*, j.ID as ID_JenisLapangan, j.name as name_JenisLapangan FROM Lapangan l JOIN JenisLapangan j ON l.ID_JenisLapangan = j.ID";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)){
            while (resultSet.next()){
                JenisLapangan jenisLapangan = new JenisLapangan(resultSet.getInt("ID_JenisLapangan"), resultSet.getString("name_JenisLapangan"));
                lapangans.add(new Lapangan(resultSet.getString("name"), jenisLapangan));
                lapangans.get(lapangans.size() - 1).setID(resultSet.getInt("ID"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return lapangans;
    }
    public void update(Lapangan lapangan) {
            String query = "UPDATE Lapangan SET name = ?, ID_JenisLapangan = ? WHERE ID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, lapangan.getName());
            preparedStatement.setInt(2, lapangan.getJenisLapangan().getID());
            preparedStatement.setInt(3, lapangan.getID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int ID) {
            String query = "DELETE FROM Lapangan WHERE ID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
