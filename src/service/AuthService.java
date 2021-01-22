package service;

import entity.User;
import repo.AdminRepo;
import repo.CustomerRepo;
import repo.PizzaMakerRepo;

import java.util.Map;

public class AuthService {
    private AdminRepo adminRepo;
    private CustomerRepo customerRepo;
    private PizzaMakerRepo pizzaMakerRepo;

    public AuthService() {
        customerRepo = CustomerRepo.getInstance();
        pizzaMakerRepo = PizzaMakerRepo.getInstance();
        adminRepo = AdminRepo.getInstance();
    }

    public boolean loginAdmin(Map<String, String> loginAndPassword){
        return adminRepo.login(loginAndPassword);
    }

    public boolean loginCustomer(Map<String, String> loginAndPassword){
        return customerRepo.login(loginAndPassword);
    }

    public boolean loginPizzaMaker(Map<String, String> loginAndPassword){
        return pizzaMakerRepo.login(loginAndPassword);
    }

    public int getNumberOfAdmins(){
        return adminRepo.getNumberOfAdmins();
    }

    public void addAdmin(Map<String, String> loginAndPassword){
        User addAdmin = new User(loginAndPassword);
        adminRepo.add(addAdmin);
    }


}
