package ntnu.oving4.rest_server.model;

import java.util.ArrayList;

public class User {
    private int id;
    private String username;
    private String password;
    private ArrayList<Equation> equations;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.equations = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public void addEquation(Equation equation) {
        this.equations.add(equation);
    }

}
