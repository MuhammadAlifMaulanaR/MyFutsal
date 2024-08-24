package com.workshop;

import com.workshop.repository.JenisLapanganRepo;
import com.workshop.repository.LapanganRepo;
import com.workshop.repository.StatusRepo;
import com.workshop.repository.UserRepo;
import com.workshop.service.JenisLapanganService;
import com.workshop.service.LapanganService;
import com.workshop.service.StatusService;
import com.workshop.service.UserService;
import com.workshop.view.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {
        private Connection connection;
        public MainApp(Connection connection){
            this.connection = connection;
        }
        public void showMenu() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. View Status");
                System.out.println("2. View User");
                System.out.println("3. View Jenis Lapangan");
                System.out.println("4. View Lapangan");
                System.out.println("5. Exit");
                System.out.print("Entar: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        StatusRepo statusRepo = new StatusRepo(connection);
                        StatusService statusService =  new StatusService(statusRepo);
                        StatusView statusView =  new StatusView(statusService);
                        statusView.ViewStatuses(scanner);
                        break;
                    case 2:
                        UserRepo userRepo = new UserRepo(connection);
                        StatusRepo statusRepo1 = new StatusRepo(connection);
                        UserService userService = new UserService(userRepo, statusRepo1);
                        UserView userView = new UserView(userService);
                        userView.ViewUsers(scanner);
                        break;
                    case 3:
                        JenisLapanganRepo jenisLapanganRepo = new JenisLapanganRepo(connection);
                        JenisLapanganService jenisLapanganService = new JenisLapanganService(jenisLapanganRepo);
                        JenisLapanganView jenisLapanganView = new JenisLapanganView(jenisLapanganService);
                        jenisLapanganView.ViewJenisLapangans(scanner);
                        break;
                    case 4:
                        LapanganRepo lapanganRepo = new LapanganRepo(connection);
                        JenisLapanganRepo jenisLapanganRepo1 =  new JenisLapanganRepo(connection);
                        LapanganService lapanganService = new LapanganService(lapanganRepo, jenisLapanganRepo1);
                        LapanganView lapanganView = new LapanganView(lapanganService);
                        lapanganView.ViewLapangans(scanner);
                        break;
                    case 5:
                        return;
                }
            }
        }

        public static void main(String[] args) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/futsal1", "root", "password");
                com.workshop.MainApp mainView = new com.workshop.MainApp(connection);
                mainView.showMenu();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}
