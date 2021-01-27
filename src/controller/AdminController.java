package controller;

import service.AdminService;

import java.util.Map;

public class AdminController {
    private final AdminService adminService;

    public AdminController() {
        adminService = new AdminService();
    }

    public void addPizzaMaker(Map<String, String> loginAndPassword, Map<String, String> nameAndSurname){
        adminService.addPizzaMaker(loginAndPassword, nameAndSurname);
    }

    public void addPizza(){
        adminService.addPizza();
    }

    public void viewAdmins(){
        adminService.viewAdmins();
    }

    public void viewCustomers(){
        adminService.viewCustomers();
    }

    public void viewPizzaMakers(){
        adminService.viewPizzaMakers();
    }

    public void viewOrders(){
        adminService.viewOrders();
    }

    public void viewMenu(){
        adminService.viewMenu();
    }


}
