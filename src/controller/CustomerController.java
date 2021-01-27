package controller;

import service.CustomerService;

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController() {
        customerService = new CustomerService();
    }

    public void newOrder(){
        customerService.newOrder();
    }
}
