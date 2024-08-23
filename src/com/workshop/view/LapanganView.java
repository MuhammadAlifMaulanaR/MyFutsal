package com.workshop.view;

import com.workshop.repository.JenisLapanganRepo;
import com.workshop.repository.LapanganRepo;
import com.workshop.model.JenisLapangan;
import com.workshop.model.Lapangan;

import java.util.List;
import java.util.Scanner;

public class LapanganView {
    private LapanganRepo lapanganRepo;
    private JenisLapanganRepo jenisLapanganRepo;

    public LapanganView(LapanganRepo lapanganRepo, JenisLapanganRepo jenisLapanganRepo){
        this.lapanganRepo = lapanganRepo;
        this.jenisLapanganRepo = jenisLapanganRepo;
    }
    public void ViewLapangans(Scanner scanner){
        while (true){
            System.out.println("1. CREATE Lapangan");
            System.out.println("2. SELECT Lapangan");
            System.out.println("3. UPDATE Lapangan");
            System.out.println("4. DELETE Lapangan");
            System.out.println("5. Back to Menu");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter ID jenis lapangan: ");
                    int ID = scanner.nextInt();
                    JenisLapangan jenisLapangan = jenisLapanganRepo.select().stream().filter(j -> j.getID() == ID).findFirst().orElse(null);
                    if (jenisLapangan != null) {
                        lapanganRepo.create(new Lapangan(name, jenisLapangan));
                    } else {
                        System.out.println("Jenis lapangan not found.");
                    }
                    break;
                case 2:
                    List<Lapangan> lapangans = lapanganRepo.select();
                    for (Lapangan lapangan : lapangans) {
                        System.out.println("ID: " + lapangan.getID() + ", Name: " + lapangan.getName() + ", Jenis Lapangan: " + lapangan.getJenisLapangan().getName());
                    }
                    break;
                case 3:
                    System.out.println("Enter ID: ");
                    int IDlapangan = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter new name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter new jenis lapangan ID: ");
                    ID = scanner.nextInt();
                    jenisLapangan = jenisLapanganRepo.select().stream().filter(j -> j.getID() == ID).findFirst().orElse(null);
                    if (jenisLapangan != null) {
                        Lapangan lapangan = new Lapangan(name, jenisLapangan);
                        lapangan.setID(IDlapangan);
                        lapanganRepo.update(lapangan);
                    } else {
                        System.out.println("Jenis lapangan not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter ID: ");
                    IDlapangan = scanner.nextInt();
                    lapanganRepo.delete(IDlapangan);
                    break;
                case 5:
                    return;
            }
        }
    }
}
