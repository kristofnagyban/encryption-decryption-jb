package hu.kristofnagyban.encryptiondecryptionjb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class DataHandler {

    public static String readData(String filename) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            String data = scanner.nextLine();
            return data;
        } catch (FileNotFoundException e) {
            return "No file found: " + filename;
        }
    }

    public static String inputText(HashMap<String, String> control) {
        if (control.containsKey("-data")) {
            return control.get("-data");
        } else if (control.containsKey("-in")) {
            return readData(control.get("-in"));
        } else {
            return null;
        }
    }

    public static void exportData(String filename, String data) {
        File file = new File(filename);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(data);
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }
}
