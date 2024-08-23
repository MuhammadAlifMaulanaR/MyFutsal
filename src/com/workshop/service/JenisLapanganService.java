package com.workshop.service;

import com.workshop.model.JenisLapangan;
import com.workshop.repository.JenisLapanganRepo;

import java.util.List;

public class JenisLapanganService {
    private JenisLapanganRepo jenisLapanganRepo;

    public JenisLapanganService(JenisLapanganRepo jenisLapanganRepo){
        this.jenisLapanganRepo = jenisLapanganRepo;
    }

    public void createJenisLapangan(JenisLapangan jenisLapangan){
        jenisLapanganRepo.create(jenisLapangan);
    }
    public List<JenisLapangan> select(){
        return jenisLapanganRepo.select();
    }
    public void update(int ID, String name){
        JenisLapangan jenisLapangan= new JenisLapangan(ID, name);
        jenisLapanganRepo.update(jenisLapangan);
    }
    public void delete(int ID){
        jenisLapanganRepo.delete(ID);
    }
}
