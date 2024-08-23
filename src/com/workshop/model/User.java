package com.workshop.model;

public class User {
    private int ID;
    private String name;
    private Status status;

    public User(int ID, String name, Status status){
        this.ID = ID;
        this.name = name;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
