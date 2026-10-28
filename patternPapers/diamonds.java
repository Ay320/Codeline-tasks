package patternPapers;

import java.util.Scanner;

public class diamonds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose a pattern:");
            System.out.println("1. Hollow Square");
            System.out.println("2. Repeated Number Triangle");
            System.out.println("3. Reverse Number Triangle");
            System.out.println("4. Full Diamond");
            System.out.println("5. Hollow Diamond");
            System.out.println("6. X Pattern");
            System.out.println("7. Hourglass");
            System.out.println("8. Descending Alphabet Triangle");
            System.out.println("9. Odd Number Triangle");
            System.out.println("10. Plus Sign");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            if (choice >= 1 && choice <= 10) {
                System.out.print("Enter n: ");
                int size = scanner.nextInt();

                switch (choice) {
                    case 1:
                        printHollowSquare(size);
                        break;
                    case 2:
                        printRepeatedNumberTriangle(size);
                        break;
                    case 3:
                        printReverseNumberTriangle(size);
                        break;
                    case 4:
                        printFullDiamond(size);
                        break;
                    case 5:
                        printHollowDiamond(size);
                        break;
                    case 6:
                        printXPattern(size);
                        break;
                    case 7:
                        printHourglass(size);
                        break;
                    case 8:
                        printDescendingAlphabetTriangle(size);
                        break;
                    case 9:
                        printOddNumberTriangle(size);
                        break;
                    case 10:
                        if (size % 2 == 1) {
                            printPlusSign(size);
                        } else {
                            System.out.println("n must be odd for the plus sign.");
                        }
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    private static void printHollowSquare(int size) {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (row == 0 || row == size - 1 || column == 0 || column == size - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void printRepeatedNumberTriangle(int size) {
        for (int row = 1; row <= size; row++) {
            for (int column = 1; column <= row; column++) {
                if (column > 1) {
                    System.out.print(" ");
                }
                System.out.print(row);
            }
            System.out.println();
        }
    }

    private static void printReverseNumberTriangle(int size) {
        for (int row = size; row >= 1; row--) {
            for (int number = 1; number <= row; number++) {
                if (number > 1) {
                    System.out.print(" ");
                }
                System.out.print(number);
            }
            System.out.println();
        }
    }

    private static void printFullDiamond(int size) {
        for (int row = 1; row <= size; row++) {
            printDiamondRow(size - row, 2 * row - 1);
        }
        for (int row = size - 1; row >= 1; row--) {
            printDiamondRow(size - row, 2 * row - 1);
        }
    }

    private static void printDiamondRow(int spaces, int stars) {
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < stars; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    private static void printHollowDiamond(int size) {
        for (int row = 1; row <= size; row++) {
            printHollowDiamondRow(size - row, row);
        }
        for (int row = size - 1; row >= 1; row--) {
            printHollowDiamondRow(size - row, row);
        }
    }

    private static void printHollowDiamondRow(int spaces, int row) {
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        System.out.print("*");
        if (row > 1) {
            for (int i = 0; i < 2 * row - 3; i++) {
                System.out.print(" ");
            }
            System.out.print("*");
        }
        System.out.println();
    }

    private static void printXPattern(int size) {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (column == row || column == size - row - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void printHourglass(int size) {
        for (int row = size; row >= 1; row--) {
            printDiamondRow(size - row, 2 * row - 1);
        }
        for (int row = 2; row <= size; row++) {
            printDiamondRow(size - row, 2 * row - 1);
        }
    }

    private static void printDescendingAlphabetTriangle(int size) {
        for (int row = 1; row <= size; row++) {
            for (int letter = 0; letter < row; letter++) {
                System.out.print((char) ('A' + size - 1 - letter));
            }
            System.out.println();
        }
    }

    private static void printOddNumberTriangle(int size) {
        int number = 1;
        for (int row = 1; row <= size; row++) {
            for (int column = 1; column <= row; column++) {
                if (column > 1) {
                    System.out.print(" ");
                }
                System.out.print(number);
                number += 2;
            }
            System.out.println();
        }
    }

    private static void printPlusSign(int size) {
        int center = size / 2;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (row == center || column == center) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
