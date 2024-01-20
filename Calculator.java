
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the first number
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        // Get the operation
        System.out.print("Enter the operation of your choice (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        // Get the second number
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        double result = 0;

        // Perform the calculation based on the operation
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
                    System.out.println("There was an error defining division with zero");
                    System.exit(1); // Exit the program with an error code
                }
                break;
            default:
                System.out.println("Error: Invalid operation.");
                System.exit(1); // Exit the program with an error code
        }

        // Display the result
        System.out.println("Result: " + result);

        // Close the scanner
        scanner.close();
    }
}
