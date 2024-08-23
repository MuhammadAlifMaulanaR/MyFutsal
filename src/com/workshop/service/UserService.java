package com.workshop.service;

import com.workshop.model.Status;
import com.workshop.model.User;
import com.workshop.repository.StatusRepo;
import com.workshop.repository.UserRepo;

import java.util.List;

public class UserService {
    private UserRepo userRepo;
    private StatusRepo statusRepo;

    public UserService (UserRepo userRepo, StatusRepo statusRepo){
        this.userRepo = userRepo;
        this.statusRepo = statusRepo;
    }

    public void createUser(int ID, String name, int ID_Status){
        Status status = statusRepo.select().stream().filter(s -> s.getID() == ID_Status).findFirst().orElse(null);
        if (status != null) {
            userRepo.create(new User(ID, name, status));
        } else {
            System.out.println("Status not found.");
        }
    }
    public List<User> getUsers() {
        return userRepo.select();
    }
    public void updateUser(int ID, String name, int ID_Status) {
        Status status = statusRepo.select().stream().filter(s -> s.getID() == ID_Status).findFirst().orElse(null);
        if (status != null) {
            User user = new User(ID, name, status);
            userRepo.update(user);
        } else {
            System.out.println("Status not found.");
        }
    }

    public void deleteUser(int ID) {
        userRepo.delete(ID);
    }
}
