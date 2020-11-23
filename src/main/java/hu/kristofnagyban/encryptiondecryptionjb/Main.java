package hu.kristofnagyban.encryptiondecryptionjb;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String operation = "";

    public static HashMap<String, String> controlSetup(String[] args) {
        HashMap<String, String> control = new HashMap<String, String>();
        for (int i = 0; i < args.length; i = i + 2) {
            control.put(args[i], args[i + 1]);
        }
        return control;
    }

    public static void main(String[] args) {
        HashMap<String, String> control = controlSetup(args);

        operation = control.get("-mode");
        int key = Integer.parseInt(control.get("-key"));
        String data = DataHandler.inputText(control);
        FileOperation fileOperation = control.containsKey("-out") ? new FileOperation(control.get("-out")) : new FileOperation();
        String algorithm = control.containsKey("-alg") ? control.get("-alg") : "default";

        switch (operation) {
            case "enc":
                new Encryption().performEncryption(data, key, algorithm, fileOperation);
                break;
            case "dec":
                new Decryption().performDecryption(data, key, algorithm, fileOperation);
                break;
        }
    }
}

