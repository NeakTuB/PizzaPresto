package controller;

import service.AuthService;

import java.util.Map;

public class AuthController {
    private final AuthService authService;

    public AuthController() {
        this.authService = new AuthService();
    }

    public boolean login(String mode, Map<String, String> loginAndPassword){
        if(mode.equals("Admin")){
            return authService.loginAdmin(loginAndPassword);
        }
        else if(mode.equals("Customer")){
            return authService.loginCustomer(loginAndPassword);
        }
        else return authService.loginPizzaMaker(loginAndPassword);
    }

    public int getNumberOfAdmins(){
        return authService.getNumberOfAdmins();
    }

    public void addAdmin(Map<String, String> loginAndPassword){
        authService.addAdmin(loginAndPassword);
    }

}
