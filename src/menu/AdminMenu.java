package menu;

public class AdminMenu implements Menu{
    public AdminMenu() {
        menu();
    }

    @Override
    public void menu() {
        while(true){
            printBasicPartOfMenu();
            String choice = in.next();
            switch (choice) {
                case "1":
                    System.out.println("1. Просмотр данных");
                    break;
                case "2":
                    System.out.println("2. Редактирование данных");
                    break;
                case "3":
                    System.out.println("3. Сортировка данных");
                    break;
                case "4":
                    System.out.println("4. Добавление новых пользователей");
                    break;
                case "5":
                    System.out.println("5. Вывод отчёта");
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
        System.out.println("2. Редактирование данных");
        System.out.println("3. Сортировка данных");
        System.out.println("4. Добавление новых пользователей");
        System.out.println("5. Вывод отчёта");
        System.out.println("0. Выход");
    }
}
