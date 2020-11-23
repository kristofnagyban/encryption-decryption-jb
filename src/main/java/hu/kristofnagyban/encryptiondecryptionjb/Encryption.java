package hu.kristofnagyban.encryptiondecryptionjb;

public class Encryption implements EncryptDecrypt {

    @Override
    public void shift(String text, int step, FileOperation fileOperation) {
        String output = "";
        String firstCircle = "abcdefghijklmnopqrstuvwxyz";
        String secondCircle = firstCircle.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            String charToConvert = Character.toString(text.charAt(i));
            if (firstCircle.contains(charToConvert)) {
                int index = firstCircle.indexOf(charToConvert);
                if (index + step <= firstCircle.length() - 1) {
                    charToConvert = Character.toString(firstCircle.charAt(index + step));
                } else {
                    charToConvert = Character.toString(firstCircle.charAt(index + step - firstCircle.length()));
                }
            } else if (secondCircle.contains(charToConvert)) {
                int index = secondCircle.indexOf(charToConvert);
                if (index + step <= secondCircle.length() - 1) {
                    charToConvert = Character.toString(secondCircle.charAt(index + step));
                } else {
                    charToConvert = Character.toString(secondCircle.charAt(index + step - secondCircle.length()));
                }
            }
            output += charToConvert;
        }

        generateOutput(output, fileOperation);
    }

    @Override
    public void unicode(String text, int step, FileOperation fileOperation) {
        String output = "";
        for (int i = 0; i < text.length(); i++) {
            char charToConvert = text.charAt(i);
            int charCode = (int) charToConvert;
            char charToAppend = ' ';
            String stringToAppend = "";
            charToAppend = (char) (charCode + step);
            stringToAppend = Character.toString(charToAppend);
            output = output + stringToAppend;
        }
        generateOutput(output, fileOperation);
    }

    @Override
    public void generateOutput(String output, FileOperation fileOperation) {
        if (fileOperation.isToFile()) {
            DataHandler.exportData(fileOperation.getFileName(), output);
        } else {
            System.out.println(output);
        }
    }

    public void performEncryption(String data, int step, String algorithm, FileOperation fileOperation) {
        switch (algorithm) {
            case "unicode":
                unicode(data, step, fileOperation);
                break;
            case "shift":
            default:
                shift(data, step, fileOperation);
        }
    }
}
