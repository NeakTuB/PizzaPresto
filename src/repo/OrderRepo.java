package repo;

import entity.Order;
import entity.Pizza;
import entity.PizzaMaker;
import entity.User;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class OrderRepo {
    private static OrderRepo orderRepoInstance;

    private final String orderRepoFilePath = "orderRepo.txt";
    private ArrayList<Order> orders;

    private OrderRepo(){
        orders = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(orderRepoFilePath))) {
            orders = (ArrayList<Order>) in.readObject();
        }catch(EOFException e){
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static OrderRepo getInstance(){
        if(orderRepoInstance == null){
            orderRepoInstance = new OrderRepo();
        }
        return orderRepoInstance;
    }

    public void viewOrders(){
        System.out.println("\tСписок заказов:");
        for(Order order :orders){
            System.out.println("ID: " + order.getOrderID()
                    + "  LoginOfCustomer: " + order.getLoginOfCustomer()
                    + "  LoginOfPizzaMaker: " + order.getLoginOfPizzaMaker());
            for(Pizza pizza:order.getPizzas()){
                System.out.println("\tpizza.getNameOfPizza()");
            }
        }
    }
}
