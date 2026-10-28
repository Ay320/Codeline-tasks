import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FeedbackPortal {
    private static String[] customerNames = new String[100];
    private static int [] ratings = new int[100];
    private static String [] comments = new String[100];
    private static int count = 0;
    private static final Scanner SCANNER = new Scanner(System.in);


    public static void menu() {
        System.out.println("===== CUSTOMER FEEDBACK PORTAL =====");
        System.out.println("1. Add Feedback");
        System.out.println("2. Show all Feedback");
        System.out.println("3. Show average rating");
        System.out.println("4. Search by rating");
        System.out.println("5. Delete Feedback");
        System.out.println("6. Save to file");
        System.out.println("7. Save and exit");
    }

    public static void addFeedback(String name, int rating, String comment) {
        if (count < customerNames.length) {
            if (rating < 1 || rating > 5) {
                System.out.println("Rating must be between 1 and 5.");
                return;
            }
            customerNames[count] = name;
            ratings[count] = rating;
            comments[count] = comment;
            count++;
        } else {
            System.out.println("Feedback storage is full.");
        }
    }

    public static void showAllFeedback() {
        if (count == 0) {
            System.out.println("No feedback available.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Customer: " + customerNames[i]);
            System.out.println("Rating: " + ratings[i]);
            System.out.println("Comment: " + comments[i]);
            System.out.println("---------------------------");
        }
    }

    public static void showAverageRating() {
        if (count == 0) {
            System.out.println("No feedback available.");
            return;
        }
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += ratings[i];
        }
        double average = (double) sum / count;
        System.out.printf("Average Rating: %.2f%n", average);
    }

    public static void searchByRating(int rating) {
        if (count == 0) {
            System.out.println("No feedback available.");
            return;
        }
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (ratings[i] == rating) {
                System.out.println("Customer: " + customerNames[i]);
                System.out.println("Rating: " + ratings[i]);
                System.out.println("Comment: " + comments[i]);
                System.out.println("---------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No feedback found with rating: " + rating);
        }
    }

    public static void deleteFeedback(int index) {
        if (index < 0 || index >= count) {
            System.out.println("Invalid index.");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            customerNames[i] = customerNames[i + 1];
            ratings[i] = ratings[i + 1];
            comments[i] = comments[i + 1];
        }
        count--;
        System.out.println("Feedback deleted successfully.");
    }

    public static void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < count; i++) {
                writer.write(customerNames[i] + "," + ratings[i] + "," + comments[i]);
                writer.newLine();
            }
            System.out.println("Feedback saved to file: " + filename);
        } catch (IOException e) {
            System.err.println("Error saving feedback to file: " + e.getMessage());
        }
    }

    public static void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 3);
                if (parts.length == 3) {
                    String name = parts[0];
                    int rating = Integer.parseInt(parts[1]);
                    String comment = parts[2];
                    addFeedback(name, rating, comment);
                }
            }
            System.out.println("Feedback loaded from file: " + filename);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid rating format in file.");
        }
    }

    public static void runMenu() {
        loadFromFile("feedback.txt");
        boolean exit = false;
        while (!exit) {
            menu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    String name = readLine("Enter customer name: ");
                    int rating = readInt("Enter rating (1-5): ");
                    String comment = readLine("Enter comment: ");
                    addFeedback(name, rating, comment);
                    break;
                case 2:
                    showAllFeedback();
                    break;
                case 3:
                    showAverageRating();
                    break;
                case 4:
                    int searchRating = readInt("Enter rating to search for: ");
                    searchByRating(searchRating);
                    break;
                case 5:
                    int indexToDelete = readInt("Enter index of feedback to delete: ");
                    deleteFeedback(indexToDelete);
                    break;
                case 6:
                    saveToFile("feedback.txt");
                    break;
                case 7:
                    saveToFile("feedback.txt");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        if (!SCANNER.hasNextLine()) {
            throw new NoSuchElementException("No more input.");
        }
        return SCANNER.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            String input = readLine(prompt);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }



    public static void main(String[] args) {
        try {
            runMenu();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
