package menu;

import java.util.Scanner;

public class PizzaMakerMenu implements Menu{
    private final Scanner in = new Scanner(System.in);
    public PizzaMakerMenu() {
        menu();
    }

    @Override
    public void menu() {
        while(true){
            printBasicPartOfMenu();
            String choice = in.next();
            switch (choice){
                case "1":
                    System.out.println("1. Просмотр активных заказов");
                    break;
                case "2":
                    System.out.println("2. Выполнение заказа");
                    break;
                case "3":
                    System.out.println("3. Отчёт");
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
        System.out.println("\tМеню пицца-мейкера");
        System.out.println("1. Просмотр активных заказов");
        System.out.println("2. Выполнение заказа");
        System.out.println("3. Отчёт");
        System.out.println("0. Выход");
    }
}
