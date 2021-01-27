package menu;

import controller.AdminController;
import hepler.StringHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminMenu implements Menu{
    private final Scanner in = new Scanner(System.in);
    private final AdminController adminController;

    public AdminMenu() {
        adminController = new AdminController();
        menu();
    }

    @Override
    public void menu() {
        //adminController.addPizza();
        while(true){
            printBasicPartOfMenu();
            String choice = in.next();
            switch (choice) {
                case "1": //view data
                    new ViewDataSubMenu(adminController);
                    break;
                case "2": //sort data
                    break;
                case "3": //add PizzaMaker
                    adminController.addPizzaMaker(StringHelper.getLoginAndPassword(), StringHelper.getNameAndSurname());
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Ошибка, попробуй ещё раз..");
                    break;
            }
        }
    }

    private void printBasicPartOfMenu(){
        System.out.println("\tМеню администратора");
        System.out.println("1. Просмотр данных");
        System.out.println("2. Сортировка данных");
        System.out.println("3. Добавление новых пользователей");
        System.out.println("0. Выход");
    }
}
