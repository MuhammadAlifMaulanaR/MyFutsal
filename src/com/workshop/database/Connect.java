package com.workshop.database;

import com.workshop.MainApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {
    public static Connection conn() throws SQLException{
        Connection connection = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3360/futsal1", "root", "");
//            com.workshop.MainApp mainApp = new com.workshop.MainApp(connection);
            MainApp mainApp = new MainApp(connection);
            mainApp.showMenu();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (connection != null){
                try{
                    connection.close();
                    System.out.println("Connection closed");
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return connection;
    }
}

//    public static Connection connect() throws SQLException {
//        Connection connection = null;
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3360/futsal", "root", "");
////            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/futsal", "root", "");
//            MainApp mainApp = new MainApp(connection);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return connection;
//    }

//        public static void main(String[] args) {
//                try{
//                        Connection connection = Connect.connect();
//                        if(connection != null && !connection.isClosed()){
//                                System.out.println("Connection successful!");
//                        } else {
//                                System.out.println("Connection field!");
//                        }
//                } catch (SQLException e){
//                        System.out.println("SQL Exception: " + e.getMessage());
//                }
//        }

