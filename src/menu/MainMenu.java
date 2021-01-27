package menu;

import controller.AuthController;
import hepler.StringHelper;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu implements Menu{
    private final Scanner in = new Scanner(System.in);
    private final AuthController authController;

    public MainMenu(){
        authController = new AuthController();
        System.out.println("Добро пожаловать в систему PizzaPresto <3");
        menu();
    }

    @Override
    public void menu() {
        while(true) {
            printMainMenu();
            String choice = in.next();
            switch (choice) {
                case "1": {  //custom1er
                    if(authController.login("Customer", StringHelper.getLoginAndPassword())){
                        System.out.println("\tВход выполнен!");
                        new CustomerMenu();
                    }
                    else{
                        System.out.println("Введён неверный логин или пароль");
                    }
                    break;
                }
                case "2": {  //pizzaMaker
                    if(authController.login("PizzaMaker", StringHelper.getLoginAndPassword())){
                        System.out.println("\tВход выполнен!");
                        new PizzaMakerMenu();
                    }
                    else{
                        System.out.println("Введён неверный логин или пароль");
                    }
                    break;
                }
                case "3": {  //admin
                    if(authController.getNumberOfAdmins() == 0){
                        System.out.println("В системе нет администраторов! Необходимо зарегестрироваться!");
                        authController.addAdmin(StringHelper.getLoginAndPassword());
                        System.out.println("Регистрация выполнена!");
                    }
                    if(authController.login("Admin", StringHelper.getLoginAndPassword())){
                        System.out.println("\tВход выполнен!");
                        new AdminMenu();
                    }
                    else{
                        System.out.println("Введён неверный логин или пароль");
                    }
                    break;
                }
                case "4": { //registration
                    if(authController.registration(StringHelper.getLoginAndPassword(), StringHelper.getNameAndSurname()))
                        System.out.println("Регистрация выполнена!");
                    else System.out.println("Ошибка регистрации!");
                    break;
                }
                case "0": {  //exit
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Ошибка, попробуй ещё раз..");
            }
        }
    }

    private void printMainMenu(){
        System.out.println("1. Войти как пользователь");
        System.out.println("2. Войти как пиццамейкер");
        System.out.println("3. Войти как администратор");
        System.out.println("4. Регистрация");
        System.out.println("0. Выход");
    }
}
