package service;

import repo.PizzaRepo;

public class CustomerService {
    private final PizzaRepo pizzaRepo;

    public CustomerService() {
        pizzaRepo = PizzaRepo.getInstance();
    }

    public void newOrder(){
        pizzaRepo.viewMenu();

    }
}
