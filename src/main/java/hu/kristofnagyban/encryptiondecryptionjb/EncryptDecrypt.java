package hu.kristofnagyban.encryptiondecryptionjb;

public interface EncryptDecrypt {

    public void shift(String text, int step, FileOperation fileOperation);

    public void unicode(String text, int step, FileOperation fileOperation);

    public void generateOutput(String output, FileOperation fileOperation);
}
