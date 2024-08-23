package com.workshop.service;

import com.workshop.model.Status;
import com.workshop.repository.StatusRepo;

import java.util.List;

public class StatusService {
    private StatusRepo statusRepo;

    public StatusService(StatusRepo statusRepo){
        this.statusRepo = statusRepo;
    }

    public void createStatus(int ID, String description){
        statusRepo.create(new Status(ID, description));
    }
    public List<Status> getStatuses(){
        return statusRepo.select();
    }
    public boolean updateStatus(int ID, String description){
        return statusRepo.update(new Status(ID, description));
    }
    public boolean deleteStatus(int ID){
        return  statusRepo.delete(ID);
    }
}
