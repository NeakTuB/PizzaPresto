package repo;

import entity.Customer;
import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class CustomerRepo implements Serializable {
    private transient static CustomerRepo customerRepoInstance;

    private transient final String customerFilePath = "customerRepo.txt";
    private ArrayList<User> customers;

    private CustomerRepo() {
        customers = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(customerFilePath))) {
            customers = (ArrayList<User>) in.readObject();
        }catch(EOFException e) {
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static CustomerRepo getInstance(){
        if(customerRepoInstance == null){
            customerRepoInstance = new CustomerRepo();
        }
        return customerRepoInstance;
    }

    public boolean login(Map<String, String> loginAndPassword){
        for(User customer:customers){
            if(customer.getLogin().equals(loginAndPassword.keySet().toArray()[0]) &&
                customer.getPassword().equals(loginAndPassword.get(loginAndPassword.keySet().toArray()[0]))){
                return true;
            }
        }
        return false;
    }

    public void add(Customer customer){
        customers.add(customer);
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(customerFilePath));
            out.writeObject(customers);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
