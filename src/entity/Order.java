package entity;

import java.util.ArrayList;

public class Order {
    private int orderID;
    private int loginOfCustomer;
    private int loginOfPizzaMaker;
    private ArrayList<Pizza> pizzas;

    public Order(int orderID, int loginOfCustomer, int loginOfPizzaMaker, ArrayList<Pizza> pizzas) {
        this.orderID = orderID;
        this.loginOfCustomer = loginOfCustomer;
        this.loginOfPizzaMaker = loginOfPizzaMaker;
        this.pizzas = pizzas;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getLoginOfCustomer() {
        return loginOfCustomer;
    }

    public void setLoginOfCustomer(int loginOfCustomer) {
        this.loginOfCustomer = loginOfCustomer;
    }

    public int getLoginOfPizzaMaker() {
        return loginOfPizzaMaker;
    }

    public void setLoginOfPizzaMaker(int loginOfPizzaMaker) {
        this.loginOfPizzaMaker = loginOfPizzaMaker;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
