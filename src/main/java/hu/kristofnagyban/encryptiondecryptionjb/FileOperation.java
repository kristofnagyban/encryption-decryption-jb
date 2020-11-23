package hu.kristofnagyban.encryptiondecryptionjb;

public class FileOperation {

    private boolean toFile;
    private String fileName;

    public FileOperation() {
        this.toFile = false;
        this.fileName = null;
    }

    public FileOperation(String fileName) {
        this.toFile = true;
        this.fileName = fileName;
    }

    public boolean isToFile() {
        return toFile;
    }

    public String getFileName() {
        return fileName;
    }
}
