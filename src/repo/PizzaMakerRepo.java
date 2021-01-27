package repo;

import entity.Customer;
import entity.PizzaMaker;
import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class PizzaMakerRepo implements Serializable {
    private transient static PizzaMakerRepo pizzaMakerRepoInstance;

    private transient final String pizzaMakerFilePath = "pizzaMakerRepo.txt";
    private ArrayList<PizzaMaker> pizzaMakers;

    public PizzaMakerRepo(){
        pizzaMakers = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(pizzaMakerFilePath))) {
            pizzaMakers = (ArrayList<PizzaMaker>) in.readObject();
        }catch(EOFException e){
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static PizzaMakerRepo getInstance(){
        if(pizzaMakerRepoInstance == null){
            pizzaMakerRepoInstance = new PizzaMakerRepo();
        }
        return pizzaMakerRepoInstance;
    }

    public boolean login(Map<String, String> loginAndPassword){
        for(User pizzaMaker:pizzaMakers){
            if(pizzaMaker.getLogin().equals(loginAndPassword.keySet().toArray()[0]) &&
                pizzaMaker.getPassword().equals(loginAndPassword.get(loginAndPassword.keySet().toArray()[0]))){
                return true;
            }
        }
        return false;
    }

    public void add(PizzaMaker pizzaMaker){
        pizzaMakers.add(pizzaMaker);
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(pizzaMakerFilePath));
            out.writeObject(pizzaMakers);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void viewPizzaMakers(){
        System.out.println("\tСписок пицца-мейкеров:");
        for(PizzaMaker pizzaMaker :pizzaMakers){
            System.out.println("Login: " + pizzaMaker.getLogin() + "  Password: " + pizzaMaker.getPassword());
            System.out.println("\tИмя: " + pizzaMaker.getName() + "  Фамилия: " + pizzaMaker.getSurname());
        }
    }
}
