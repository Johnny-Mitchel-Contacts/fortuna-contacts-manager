import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadContacts {
    public static void displayContacts() throws IOException {

        String contactsPathName = "contacts";
        String contactsFileName = "contacts.txt";

        Path contactsPath = Paths.get(contactsPathName);
        if (!Files.exists(contactsPath)) {
            Files.createDirectory(contactsPath);
        }
        Path contactsFilePath = Paths.get(contactsPathName, contactsFileName);


        List<String> contactsString = Files.readAllLines(contactsFilePath);

        for( String str :  contactsString) {
            System.out.println(str);
        }
    }



//    public ReadContacts() throws FileNotFoundException {
//        }



}
