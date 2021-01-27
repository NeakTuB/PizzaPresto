package menu;

import controller.AdminController;
import hepler.StringHelper;

import java.util.Scanner;

public class ViewDataSubMenu implements Menu{
    private final Scanner in = new Scanner(System.in);
    private final AdminController adminController;

    public ViewDataSubMenu(AdminController adminController) {
        this.adminController = adminController;
        menu();
    }

    @Override
    public void menu() {
        while(true){
            printBasicPartOfMenu();
            String choice = in.next();
            switch (choice) {
                case "1": //view admins
                    adminController.viewAdmins();
                    break;
                case "2": //view pizzaMakers
                    adminController.viewPizzaMakers();
                    break;
                case "3": //view customers
                    adminController.viewCustomers();
                    break;
                case "4": //view menu
                    adminController.viewMenu();
                    break;
                case "5": //view orders
                    adminController.viewOrders();
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
        System.out.println("\tМеню просмотра данных");
        System.out.println("1. Просмотр всех администраторов");
        System.out.println("2. Просмотр всех пицца-мейкеров");
        System.out.println("3. Просмотр всех клиентов");
        System.out.println("4. Просмотр меню");
        System.out.println("5. Просомтр всех заказов");
        System.out.println("0. Выход");
    }
}
