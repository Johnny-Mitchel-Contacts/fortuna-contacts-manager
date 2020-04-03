import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class ContactsTest {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("\nContacts List:\n");

        String contactsPathName = "contactsList";
        String contactsFileName = "contactsList.txt";


        Path contactsPath = Paths.get(contactsPathName);
        if (!Files.exists(contactsPath)) {
            Files.createDirectory(contactsPath);
        }
        System.out.println(Files.exists(contactsPath));

        // Create a file
        Path contactsFilePath = Paths.get(contactsPathName, contactsFileName);
        String line = "test";
        Files.write(contactsFilePath, Arrays.asList(line));

        // Break groceries into its own file
        Path groceriesPath = Paths.get(contactsPathName, contactsFileName);
        List<String> groceries = Arrays.asList("eggs", "toilet paper", "sanitizer");
        Files.write(groceriesPath, groceries);

        // Append to contacts
        line = "tissues";
        Files.write(groceriesPath, Arrays.asList(line), StandardOpenOption.APPEND);

//        // read the list
//        List<String> readList = Files.readAllLines(contactsPath);
//        System.out.println(readList);



        do {
            System.out.println("*----------------------------------------------------*");
            System.out.printf("|%-26s %25s|","","");
            System.out.printf("\n|\t%-44s %4s|"," What would you like to do?","");
            System.out.printf("\n|%-26s %25s|","","");
            System.out.printf("\n|\t%-44s %4s|"," 1 - View contacts.","");
            System.out.printf("\n|\t%-44s %4s|"," 2 - Add a new contact.","");
            System.out.printf("\n|\t%-44s %4s|"," 3 - Search a contact by name.","");
            System.out.printf("\n|\t%-44s %4s|"," 4 - Delete an existing contact.","");
            System.out.printf("\n|\t%-44s %4s|"," 5 - Exit.","");
            System.out.printf("\n|%-26s %25s|","","");
            System.out.println("\n*----------------------------------------------------*\n");
            option = input.nextInt();


            switch (option) {
                case 1:
                    System.out.println("Case 1");
                    break;
                case 2:
                    System.out.println("\nCase 2\n*----------------------------------------------------*");

                    break;
                case 3:
                    System.out.println("\nCase 3:\n*----------------------------------------------------*");
                    break;
                case 4:
                    System.out.println("\nCase 4\n*----------------------------------------------------*");
                    break;
                case 5:
                    System.out.println("\nCase 5\n*----------------------------------------------------*");
                    option = 0;
                    break;
            }

            System.out.println();
        } while (option != 0);
    }

}
