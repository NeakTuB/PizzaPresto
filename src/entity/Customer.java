package entity;

import java.util.ArrayList;

public class Customer extends User{
    private String name;
    private String surname;
    //private ArrayList<User> userRepo;


    public Customer(String login, String password) {
        super(login, password);
    }
}
