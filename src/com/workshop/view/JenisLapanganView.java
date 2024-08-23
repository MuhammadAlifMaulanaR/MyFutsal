package com.workshop.view;

import com.workshop.repository.JenisLapanganRepo;
import com.workshop.model.JenisLapangan;
import com.workshop.service.JenisLapanganService;

import java.util.List;
import java.util.Scanner;

public class JenisLapanganView {
    private JenisLapanganService jenisLapanganService;

    public JenisLapanganView(JenisLapanganService jenisLapanganService){
        this.jenisLapanganService = jenisLapanganService;
    }
    public void ViewJenisLapangans(Scanner scanner){
        while (true){
            System.out.println("1. CEREATE Jenis Lapangan");
            System.out.println("2. SELECT Jenis Lapangans");
            System.out.println("3. UPDATE Jenis Lapangan");
            System.out.println("4. DELETE Jenis Lapangan");
            System.out.println("5. Back to Menu");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    jenisLapanganService.createJenisLapangan(new JenisLapangan(0, name));
                    break;
                case 2:
                    List<JenisLapangan> jenisLapangans = jenisLapanganService.select();
                    for (JenisLapangan jenisLapangan : jenisLapangans) {
                        System.out.println("ID: " + jenisLapangan.getID() + ", Name: " + jenisLapangan.getName());
                    }
                    break;
                case 3:
                    System.out.println("Enter ID: ");
                    int IDJenisLapangan = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter new name: ");
                    name = scanner.nextLine();
                    jenisLapanganService.update(IDJenisLapangan, name);
                    break;
                case 4:
                    System.out.println("Enter ID: ");
                    IDJenisLapangan = scanner.nextInt();
                    jenisLapanganService.delete(IDJenisLapangan);
                    break;
                case 5:
                    return;
            }
        }
    }
}
