package ntnu.oving4.rest_server.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Equation {
    public String equation = "";
    public double result;
    public Equation(String equation) throws Exception {
        this.equation = equation;
        this.result = this.calculate();
    }

    private double calculate() throws Exception {
        List<String> numbers = new ArrayList<>();
        Matcher m = Pattern.compile("([0-9]*[.])?[0-9]+").matcher(this.equation);
        while (m.find()) {
            numbers.add(m.group());
        }
        
        if (numbers.isEmpty()) {
            throw new Exception("No numbers found in this equation");
        }

        List<String> operators = new ArrayList<>();
        Matcher match = Pattern.compile("[-+*/]").matcher(this.equation);
        while (match.find()) {
            operators.add(match.group());
        }

        double tempAns = 0;
        for (int i = 0; i<operators.size(); i++) {
            if (i == 0) {
                switch(operators.get(i)) {
                    case "+":
                        tempAns = Double.parseDouble(numbers.get(i)) + Double.parseDouble(numbers.get(i+1));
                        break;
                    case "-":
                        tempAns = Double.parseDouble(numbers.get(i)) - Double.parseDouble(numbers.get(i+1));
                        break;
                    case "*":
                        tempAns = Double.parseDouble(numbers.get(i)) * Double.parseDouble(numbers.get(i+1));
                        break;
                    case "/":
                        tempAns = Double.parseDouble(numbers.get(i)) / Double.parseDouble(numbers.get(i+1));
                        break;

                }
            } else {
                switch(operators.get(i)) {
                    case "+":
                        tempAns = tempAns + Double.parseDouble(numbers.get(i+1));
                        break;
                    case "-":
                        tempAns = tempAns - Double.parseDouble(numbers.get(i+1));
                        break;
                    case "*":
                        tempAns = tempAns * Double.parseDouble(numbers.get(i+1));
                        break;
                    case "/":
                        tempAns = tempAns / Double.parseDouble(numbers.get(i+1));
                        break;
                }
            }
        }

        return tempAns;
    }

}
