package menu;

import controller.CustomerController;

import java.util.Scanner;

public class CustomerMenu implements Menu{
    private final Scanner in = new Scanner(System.in);
    private final CustomerController customerController;

    public CustomerMenu() {
        customerController = new CustomerController();
        menu();
    }

    @Override
    public void menu() {
        while(true){
            printBasicPartOfMenu();
            String choice = in.next();
            switch(choice){
                case "1":
                    customerController.newOrder();
                    break;
                case "2":
                    System.out.println("2. Просмотреть историю заказов");
                    break;
                case "3":
                    System.out.println("3. Просмотр меню");
                    break;
                case "4":
                    System.out.println("4. Изменение личных данных");
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
        System.out.println("\tМеню клиента");
        System.out.println("1. Сделать заказ");
        System.out.println("2. Просмотреть историю заказов");
        System.out.println("3. Просмотр меню");
        System.out.println("4. Изменение личных данных");
        System.out.println("0. Выход");
    }
}
