package ntnu.oving4.rest_server.service;

import ntnu.oving4.rest_server.model.Calculator;

public class Service {
    public double calculateEquation(String equation) throws Exception {
        Calculator calc = new Calculator(equation);
        double ans = 0.0;
        try {
            ans = calc.calculate();
        } catch(Exception e) {
            throw e;
        }

        return ans;
    }
}
