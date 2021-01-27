package repo;

import entity.Customer;
import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class CustomerRepo implements Serializable {
    private transient static CustomerRepo customerRepoInstance;

    private transient final String customerFilePath = "customerRepo.txt";
    private ArrayList<Customer> customers;

    private CustomerRepo() {
        customers = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(customerFilePath))) {
            customers = (ArrayList<Customer>) in.readObject();
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

    public boolean add(Customer customer){
        boolean checkUser = false;
        for(User user: customers){
            if(user.getLogin().equals(customer.getLogin())){
                checkUser = true;
            }
        }
        if(!checkUser){
            customers.add(customer);
            try{
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(customerFilePath));
                out.writeObject(customers);
                return true;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public void viewCustomers(){
        System.out.println("\tСписок клиентов:");
        for(Customer customer :customers){
            System.out.println("Login: " + customer.getLogin() + "  Password: " + customer.getPassword());
            System.out.println("\tИмя: " + customer.getName() + "  Фамилия: " + customer.getSurname());
        }
    }
}
