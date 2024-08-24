package com.workshop.view;

import com.workshop.repository.JenisLapanganRepo;
import com.workshop.repository.LapanganRepo;
import com.workshop.model.JenisLapangan;
import com.workshop.model.Lapangan;
import com.workshop.service.LapanganService;

import java.net.IDN;
import java.util.List;
import java.util.Scanner;

public class LapanganView {
    private LapanganService lapanganService;

    public LapanganView(LapanganService lapanganService){
        this.lapanganService = lapanganService;
    }
    public void ViewLapangans(Scanner scanner){
        while (true){
            System.out.println("1. CREATE Lapangan");
            System.out.println("2. SELECT Lapangan");
            System.out.println("3. UPDATE Lapangan");
            System.out.println("4. DELETE Lapangan");
            System.out.println("5. Back to Menu");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter ID jenis lapangan: ");
                    int jenisLapanganID = scanner.nextInt();
                    scanner.nextLine();
                    lapanganService.create(name, jenisLapanganID);
                    break;
                case 2:
                    List<Lapangan> lapangans = lapanganService.getAllLapangans();
                    for (Lapangan lapangan : lapangans) {
                        System.out.println("ID: " + lapangan.getID() + ", Name: " + lapangan.getName() + ", Jenis Lapangan: " + lapangan.getJenisLapangan().getName());
                    }
                    break;
                case 3:
                    System.out.println("Enter ID lapangan: ");
                    int ID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter new ID jenis lapangan: ");
                    jenisLapanganID = scanner.nextInt();
                    scanner.nextLine();
                    lapanganService.updateLapangan(ID,name,jenisLapanganID);
                    break;
                case 4:
                    System.out.println("Enter ID lapangan: ");
                    ID = scanner.nextInt();
                    scanner.nextLine();
                    lapanganService.deleteLapangan(ID);
                    System.out.println("Lapangan deleted successfully.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
