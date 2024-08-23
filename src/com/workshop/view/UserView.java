package com.workshop.view;

import com.workshop.repository.StatusRepo;
import com.workshop.repository.UserRepo;
import com.workshop.model.Status;
import com.workshop.model.User;
import com.workshop.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private UserService userService;

    public UserView(UserService userService){
        this.userService = userService;
    }

    public void ViewUsers(Scanner scanner){
        while (true){
            System.out.println("1. CREATE User");
            System.out.println("2. SELECT User");
            System.out.println("3. UPDATE User");
            System.out.println("4. DELETE User");
            System.out.println("5. Back to Menu");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1 :
                    System.out.println("Enter ID: ");
                    int IDuser = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter status ID: ");
                    int ID_Status = scanner.nextInt();
                    userService.createUser(IDuser, name, ID_Status);
                    break;
                case 2 :
                    List<User> users = userService.getUsers();
                    for (User user : users) {
                        System.out.println("ID: " + user.getID() + ", Name: " + user.getName() + ", Status: " + user.getStatus().getDescription());
                    }
                    break;
                case 3 :
                    System.out.println("Enter ID: ");
                    IDuser = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter new status ID: ");
                    ID_Status = scanner.nextInt();
                    userService.updateUser(IDuser, name, ID_Status);
                    break;
                case 4 :
                    System.out.println("Enter ID: ");
                    IDuser = scanner.nextInt();
                    userService.deleteUser(IDuser);
                    break;
                case 5 :
                    return;
            }
        }
    }
}
