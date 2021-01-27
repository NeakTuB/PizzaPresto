package service;

import entity.PizzaMaker;
import repo.*;

import java.util.Map;

public class AdminService {
    private AdminRepo adminRepo;
    private PizzaMakerRepo pizzaMakerRepo;
    private OrderRepo orderRepo;
    private PizzaRepo pizzaRepo;
    private CustomerRepo customerRepo;

    public AdminService(){
        adminRepo = AdminRepo.getInstance();
        pizzaMakerRepo = PizzaMakerRepo.getInstance();
        orderRepo = OrderRepo.getInstance();
        pizzaRepo = PizzaRepo.getInstance();
        customerRepo = CustomerRepo.getInstance();
    }

    public void addPizzaMaker(Map<String, String> loginAndPassword, Map<String, String> nameAndSurname){
        PizzaMaker pizzaMaker = new PizzaMaker(loginAndPassword, nameAndSurname);
        pizzaMakerRepo.add(pizzaMaker);
    }

    public void addPizza(){
        pizzaRepo.add();
    }

    public void viewAdmins(){
        adminRepo.viewAdmins();
    }

    public void viewCustomers(){
        customerRepo.viewCustomers();
    }

    public void viewPizzaMakers(){
        pizzaMakerRepo.viewPizzaMakers();
    }

    public void viewOrders(){
        orderRepo.viewOrders();
    }

    public void viewMenu(){
        pizzaRepo.viewMenu();
    }

}
