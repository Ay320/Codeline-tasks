package ToolBox;
import java.util.Scanner;


public class ToolBoxApp {


    public static void menu() {
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Even or Odd");
        System.out.println("3. Maximum of Three Numbers");
        System.out.println("4. Factorial");
        System.out.println("5. Multiplication Table");
        System.out.println("6. Star Triangle");
        System.out.println("7. Prime Number Check");
        System.out.println("8. Reverse a Number");
        System.out.println("9. Number Pyramid");
        System.out.println("0. Exit");
    }

    public static void celsiusToFahrenheit(double currentCelsius) {
        System.out.println(currentCelsius * 9 / 5 + 32);
    }

    public static void evenOrOdd(int number) {
        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } 
        else {
            System.out.println(number + " is odd.");
        }
    }


    public static void maxOfThree(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        System.out.println("The maximum of " + a + ", " + b + ", and " + c + " is: " + max);
    }

    public static void factorial(int n) {
        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        System.out.println("Factorial of " + n + " is: " + result);
    }

    public static void multiplicationTable(int number) {
        System.out.println("Multiplication table for " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }

    public static void starTriangle(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    public static void isPrime(int number) {
        if (number <= 1) {
            System.out.println(number + " is not a prime number.");
            return;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                System.out.println(number + " is not a prime number.");
                return;
            }
        }
        System.out.println(number + " is a prime number.");
    }


    public static void reverseNumber(int number) {
        String reversed = new StringBuilder(String.valueOf(number)).reverse().toString();
        int result = Integer.parseInt(reversed);
        System.out.println("Reversed number: " + result);
    }

    public static void numberPyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                menu();
                System.out.print("Choose an option: ");

                if (!scanner.hasNextLine()) {
                    break;
                }

                String choice = scanner.nextLine().trim();
                switch (choice) {
                    case "1":
                        System.out.println("Enter temperature in Celsius: ");
                        int input = Integer.parseInt(scanner.nextLine());
                        celsiusToFahrenheit(input);
                        break;
                    case "2":
                        System.out.println("Enter a number to check if it's even or odd: ");
                        int number = Integer.parseInt(scanner.nextLine());
                        evenOrOdd(number);
                        break;
                    case "3":
                        System.out.println("Enter three numbers to find the maximum: ");
                        int num1 = Integer.parseInt(scanner.nextLine());
                        int num2 = Integer.parseInt(scanner.nextLine());
                        int num3 = Integer.parseInt(scanner.nextLine());
                        maxOfThree(num1, num2, num3);
                        break;
                    case "4":
                        System.out.println("Enter a number to display its factorial: ");
                        int factorialNumber = Integer.parseInt(scanner.nextLine());
                        factorial(factorialNumber);
                        break;
                    case "5":
                        System.out.println("Enter a number to display its multiplication table: ");
                        int tableNumber = Integer.parseInt(scanner.nextLine());
                        multiplicationTable(tableNumber);
                        break;
                    case "6":
                        System.out.println("Enter the number of rows for the star triangle: ");
                        int rows = Integer.parseInt(scanner.nextLine());
                        starTriangle(rows);
                        break;
                    case "7":
                        System.out.println("Enter a number to check if it's prime: ");
                        int primeNumber = Integer.parseInt(scanner.nextLine());
                        isPrime(primeNumber);
                        break;
                    case "8":
                        System.out.println("Enter a number to reverse: ");
                        int reverseNumber = Integer.parseInt(scanner.nextLine());
                        reverseNumber(reverseNumber);
                        break;
                    case "9":
                        System.out.println("Enter the number of rows for the number pyramid: ");
                        int rows2 = Integer.parseInt(scanner.nextLine());
                        numberPyramid(rows2);
                        break;
                    case "0":
                        running = false;    
                    default:
                        System.out.println("Invalid option. Please choose 1, 2, 3, 4, 5, 6, 7, or 8.");
                }
            }
        }
    }
}
