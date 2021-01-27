package entity;

import java.util.Map;

public class PizzaMaker extends User{
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public PizzaMaker(Map<String, String> loginAndPassword, Map<String, String> nameAndSurname) {
        super(loginAndPassword);
        this.name = (String) nameAndSurname.keySet().toArray()[0];
        this.surname = nameAndSurname.get(nameAndSurname.keySet().toArray()[0]);
    }
}
