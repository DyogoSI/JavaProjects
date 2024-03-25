/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author dyogo
 */
public class CalculadoraLogic {
    private String currentInput;
    private String previousInput;
    private char operation;

    public CalculadoraLogic() {
        currentInput = "";
        previousInput = "";
        operation = ' ';
    }

    public void processNumber(int number) {
        currentInput += number;
    }

    public void processOperation(char op) {
        if (!currentInput.isEmpty()) {
            previousInput = currentInput;
            currentInput = "";
            operation = op;
        }
    }

    public void calculate() {
        if (!currentInput.isEmpty() && !previousInput.isEmpty()) {
            double num1 = Double.parseDouble(previousInput);
            double num2 = Double.parseDouble(currentInput);
            double result = 0;

            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        currentInput = "Error: Division by zero";
                        return;
                    }
                    break;
            }

            currentInput = String.valueOf(result);
        }
    }

    public void clear() {
        currentInput = "";
        previousInput = "";
        operation = ' ';
    }

    public String getCurrentInput() {
        return currentInput;
    }
}

