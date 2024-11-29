package utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    public static void writeToFile(String filename, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(data);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static String readFromFile(String filename) {
        StringBuilder content = new StringBuilder();
        try {
            Files.lines(Path.of(filename)).forEach(line -> content.append(line).append("\n"));
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return content.toString();
    }
}
