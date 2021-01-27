package hepler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringHelper {
    private static final Scanner in = new Scanner(System.in);

    public static Map<String, String> getLoginAndPassword(){
        System.out.println("Введите логин: ");
        String login = in.next();
        System.out.println("Введите пароль: ");
        String password = in.next();
        Map<String, String> loginAndPassword = new HashMap<>();
        loginAndPassword.put(login, password);
        return loginAndPassword;
    }

    public static Map<String, String> getNameAndSurname(){
        System.out.println("Введите имя: ");
        String name = in.next();
        System.out.println("Введите фамилию: ");
        String surname = in.next();
        Map<String, String> nameAndPassword = new HashMap<>();
        nameAndPassword.put(name, surname);
        return nameAndPassword;
    }
}
