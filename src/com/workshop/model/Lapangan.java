package com.workshop.model;

public class Lapangan {
    private int ID;
    private String name;
    private JenisLapangan jenisLapangan;

    public Lapangan(String name, JenisLapangan jenisLapangan){
        this.name = name;
        this.jenisLapangan = jenisLapangan;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JenisLapangan getJenisLapangan() {
        return jenisLapangan;
    }

    public void setJenisLapangan(JenisLapangan jenisLapangan) {

        this.jenisLapangan = jenisLapangan;
    }
}
