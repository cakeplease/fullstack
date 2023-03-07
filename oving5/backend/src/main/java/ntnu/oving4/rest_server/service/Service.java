package ntnu.oving4.rest_server.service;

import ntnu.oving4.rest_server.model.Equation;
import ntnu.oving4.rest_server.repository.EquationUserRepository;

public class Service {
    public double calculateEquation(String equation) throws Exception {
        double ans;
        try {
            Equation eq = new Equation(equation);
            ans = eq.result;
        } catch(Exception e) {
            throw e;
        }

        return ans;
    }

    public int login(String username, String password) {
        EquationUserRepository eqUser = new EquationUserRepository();
        int userID = eqUser.login(username, password);
        return userID;
    }


}
