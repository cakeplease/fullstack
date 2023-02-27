package ntnu.oving4.rest_server.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculate() {
        String equation = "2+2-5*2";
        Calculator calc = new Calculator(equation);
        float ans = calc.calculate();
        assertTrue(ans == -2);
    }
}