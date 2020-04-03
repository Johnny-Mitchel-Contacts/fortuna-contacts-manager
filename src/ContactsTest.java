import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import util.Input;



public class ContactsTest {
    public static void main(String[] args) throws IOException {

        Input input = new Input();
        int option;

        System.out.println("\nContacts List:\n");

        String contactsPathName = "contacts";
        String contactsFileName = "contacts.txt";


        Path contactsPath = Paths.get(contactsPathName);
        if (!Files.exists(contactsPath)) {
            Files.createDirectory(contactsPath);
        }


        // Create a file
        Path contactsFilePath = Paths.get(contactsPathName, contactsFileName);
        String line = "Name | Number";
        Files.write(contactsFilePath, Arrays.asList(line));

        // Break groceries into its own file
        Path groceriesPath = Paths.get(contactsPathName, contactsFileName);
        List<String> groceries = Arrays.asList("Joe | 123-4567", "Randy | 111-1111", "Sandy | 222-2222");
        Files.write(groceriesPath, groceries, StandardOpenOption.APPEND);

        // Append to contacts
        line = "Mark | 765-4321";
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
            option = input.getInt();


            switch (option) {
                case 1:
                    ReadContacts.displayContacts();
                    System.out.println("Go back to main menu? [y/n]");
                    if (!input.yesNo()) {
                        option = 0;
                    }

                    break;
                case 2:
                    System.out.println("\nCase 2\n*----------------------------------------------------*");
                    System.out.println("Enter the name of your contact: ");
                    String newName = input.getString();
                    System.out.println("Enter " + newName + "'s phone number: ");
                    String newNumber = input.getString();
                    String newContact = newName + " | " + newNumber;

                    Files.write(groceriesPath, Arrays.asList(newContact), StandardOpenOption.APPEND);

                    System.out.println("\nHere are the updated contacts\n");
                    ReadContacts.displayContacts();
                    System.out.println("Go back to main menu? [y/n]");
                    if (!input.yesNo()) {
                        option = 0;
                    }

                    break;
                case 3:
                    System.out.println("\nCase 3:\n*----------------------------------------------------*");
                    break;
                case 4:
                    System.out.println("\nCase 4\n*----------------------------------------------------*");
                    break;
                case 5:
                    option = 0;
                    break;
            }

            System.out.println();
        } while (option != 0);

        System.out.println("Have a good day!");

    }

}
