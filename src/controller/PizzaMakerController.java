package controller;

import service.PizzaMakerService;

public class PizzaMakerController {
    private final PizzaMakerService pizzaMakerService;

    public PizzaMakerController() {
        pizzaMakerService = new PizzaMakerService();
    }
    
}
