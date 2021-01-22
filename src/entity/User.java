package entity;

import java.io.Serializable;
import java.util.Map;

public class User implements Serializable {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(Map<String, String> loginAndPassword) {
        this.login = (String) loginAndPassword.keySet().toArray()[0];
        this.password = loginAndPassword.get(loginAndPassword.keySet().toArray()[0]);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
