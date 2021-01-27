package repo;

import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class AdminRepo implements Serializable {
    private static AdminRepo adminRepoInstance;

    private final String adminFilePath = "adminRepo.txt";
    private ArrayList<User> admins;

    public AdminRepo(){
        admins = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(adminFilePath))) {
            admins = (ArrayList<User>) in.readObject();
        }catch(EOFException e){
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static AdminRepo getInstance(){
        if(adminRepoInstance == null){
            adminRepoInstance = new AdminRepo();
        }
        return adminRepoInstance;
    }

    public boolean login(Map<String, String> loginAndPassword){
        for(User admin:admins){
            if(admin.getLogin().equals(loginAndPassword.keySet().toArray()[0]) &&
                    admin.getPassword().equals(loginAndPassword.get(loginAndPassword.keySet().toArray()[0]))){
                return true;
            }
        }
        return false;
    }

    public int getNumberOfAdmins(){
        int numberOfAdmins = 0;
        for(User admin: admins){
            numberOfAdmins++;
        }
        return numberOfAdmins;
    }

    public void add(User admin){
        admins.add(admin);
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(adminFilePath));
            out.writeObject(admins);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void viewAdmins(){
        System.out.println("\tСписок администраторов:");
        for(User user:admins){
            System.out.println("Login: " + user.getLogin() + "  Password: " + user.getPassword());
        }



    }
}
