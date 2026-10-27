package tryCatch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class tryCatch {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));  // auto close when try ends
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }catch (FileNotFoundException e) {
            System.err.println("Error: Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}