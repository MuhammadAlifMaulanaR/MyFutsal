package com.workshop.service;

import com.workshop.model.JenisLapangan;
import com.workshop.model.Lapangan;
import com.workshop.repository.JenisLapanganRepo;
import com.workshop.repository.LapanganRepo;

import java.util.List;

public class LapanganService {
    private LapanganRepo lapanganRepo;
    private  JenisLapanganRepo  jenisLapanganRepo;

    public LapanganService(LapanganRepo LapanganRepo, JenisLapanganRepo jenisLapanganRepo){
        this.lapanganRepo = LapanganRepo;
        this.jenisLapanganRepo = jenisLapanganRepo;
    }
    public void create(String name, int jenisLapanganID){
                JenisLapangan jenisLapangan = jenisLapanganRepo.select().stream()
                .filter(j -> j.getID() == jenisLapanganID)
                .findFirst()
                .orElse(null);

        if (jenisLapangan != null) {
            Lapangan lapangan = new Lapangan(name, jenisLapangan);
            lapanganRepo.create(lapangan);
            System.out.println("Lapangan created successfully.");
        } else {
            System.out.println("Jenis Lapangan not found.");
        }
    }

    public List<Lapangan> getAllLapangans() {
        return lapanganRepo.select();
    }

    public Lapangan getLapanganById(int ID) {
        return lapanganRepo.select().stream()
                .filter(lapangan -> lapangan.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public void updateLapangan(int ID, String name, int jenisLapanganID) {
        Lapangan lapangan = getLapanganById(ID);
        if (lapangan != null) {
            JenisLapangan newJenisLapangan = jenisLapanganRepo.select().stream()
                    .filter(j -> j.getID() == jenisLapanganID)
                    .findFirst()
                    .orElse(null);

            if (newJenisLapangan != null) {
                lapangan.setName(name);
                lapangan.setJenisLapangan(newJenisLapangan);
                lapanganRepo.update(lapangan);
                System.out.println("Lapangan updated successfully.");
            } else {
                System.out.println("Jenis Lapangan not found.");
            }
        } else {
            System.out.println("Lapangan not found.");
        }
    }

    public void deleteLapangan(int ID) {
        Lapangan lapangan = getLapanganById(ID);
        if (lapangan != null) {
            lapanganRepo.delete(ID);
            System.out.println("Lapangan deleted successfully.");
        } else {
            System.out.println("Lapangan not found.");
        }
    }
}
