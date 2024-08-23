package com.workshop.view;

import com.workshop.repository.StatusRepo;
import com.workshop.model.Status;
import com.workshop.service.StatusService;

import java.util.List;
import java.util.Scanner;

public class StatusView {
    private StatusService statusService;

    public StatusView(StatusService statusService){
        this.statusService = statusService;
    }

    public void ViewStatuses(Scanner scanner){
        while (true){
            System.out.println(" ");
            System.out.println("=========================");
            System.out.println("ADD STATUS ON YOUR FUTSAL");
            System.out.println("=========================");
            System.out.println("1. CREATE Status");
            System.out.println("2. SELECT Status");
            System.out.println("3. UPDATE Status");
            System.out.println("4. DELETE Status");
            System.out.println("5. Back to Menu");
            System.out.print("Entar: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int ID_Status = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    statusService.createStatus(ID_Status, description);
                    break;
                case 2 :
                    List<Status> statuses = statusService.getStatuses();
                    for (Status status : statuses) {
                        System.out.println("ID: " + status.getID() + ", Description: " + status.getDescription());
                    }
                    break;
                case 3 :
                    System.out.print("Enter ID: ");
                    ID_Status = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new description: ");
                    description = scanner.nextLine();
                    boolean truess = statusService.updateStatus(ID_Status, description);
                    if(truess){
                        System.out.println("ID SUCCESSFULLY UPDATED");
                    } else {
                        System.out.println("ID NOT FOUND");
                    }
                    break;
                case 4 :
                    System.out.print("Enter ID: ");
                    ID_Status = scanner.nextInt();
                    boolean trues = statusService.deleteStatus(ID_Status);
                    if(trues){
                        System.out.println("ID SUCCESSFULLY DELETED");
                    } else {
                        System.out.println("ID NOT FOUND");
                    }
                    break;
                case 5 :
                    return;
            }
        }
    }
}
