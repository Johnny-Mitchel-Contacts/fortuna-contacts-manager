import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ReadContacts {
    public static void main(String[] args) {
        // PrintWriter works like System.out
        PrintWriter pw = new PrintWriter(new FileOutputStream(new File("contacts/contacts.txt"), true));
        pw.println("second test");
        pw.close();
    }



    public ReadContacts() throws FileNotFoundException {
        }



}
