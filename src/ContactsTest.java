import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import util.Input;



public class ContactsTest {
    public static void main(String[] args) throws IOException {

        Input input = new Input();
        int option;

        String contactsPathName = "contacts";
        String contactsFileName = "contacts.txt";


        Path contactsPath = Paths.get(contactsPathName, contactsFileName);
        if (!Files.exists(contactsPath)) {
            Files.createDirectory(contactsPath);
        }


        // Create a file
        Path contactsFilePath = Paths.get(contactsPathName, contactsFileName);

        List<String> listOfContacts = Files.readAllLines(contactsFilePath);


        HashMap<String, String> contactsHash = new HashMap<>();
        for (String contact : listOfContacts) {
            // Seperate name from phone #
            String[] thisLine = contact.split("\\|");
            String name = thisLine[0];
            String phoneNum = thisLine[1];
            contactsHash.put(name, phoneNum);
        }


        do {
            System.out.println("\n*------------------Contacts List---------------------*");
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
            System.out.print("");
            System.out.println(">");
            option = input.getInt();


            switch (option) {
                case 1:  // Lists the Contacts
                    System.out.println("\n*--------------------Case 1--------------------------*");
                    ReadContacts.displayContacts();

                    // Back to main
                    option = BackToMain.navigateToMain();
                    break;


                case 2:  // Adds user input to the list of Contacts
                    System.out.println("\n*--------------------Case 2--------------------------*");

                    System.out.println("Enter the name of your contact: ");
                    String newName = input.getString();
                    System.out.println("Enter " + newName + "'s phone number: ");
                    String newNumber = input.getString();
                    String newContact = newName + " | " + newNumber + " |";
                    contactsHash.put(newName, newNumber);

                    contactsHash.values().removeAll(Collections.singleton(null));
                    List<String> addedContacts = new ArrayList<>();

                    Iterator hmIterator = contactsHash.entrySet().iterator();

                    while (hmIterator.hasNext()) {
                        Map.Entry thisContact = (Map.Entry)hmIterator.next();
                        if (thisContact.getKey() != null &&  thisContact.getValue() != null) {
                             addedContacts.add(thisContact.getKey() + "|" + thisContact.getValue());
                            Files.write(contactsPath,addedContacts);
                        }
                    }
                    System.out.println("\nHere are the updated contacts\n");
                    ReadContacts.displayContacts();

                    // Back to main
                    option = BackToMain.navigateToMain();
                    break;


                case 3:  // Search for an existing contact
                    System.out.println("\n*--------------------Case 3--------------------------*");
                    System.out.println("Enter name you would like to search for: ");
                    String userSearch = input.getString(); // Input word to be searched
                    if (!contactsHash.containsKey(userSearch)){
                        System.out.println("User not found");
                    } else {
                        String searchName = userSearch.substring(0,1).toUpperCase() + userSearch.substring(1);
                        System.out.println(searchName + "'s phone number is: " + contactsHash.get(userSearch) );
                    }
                    // Back to main
                    option = BackToMain.navigateToMain();
                    break;


                case 4:  // Delete an existing contact
                    System.out.println("\n*--------------------Case 4--------------------------*");
                    System.out.println("Who would you like to remove from your contacts?");
                    String userDelete = input.getString();
                    if (!contactsHash.containsKey(userDelete)){
                        System.out.println("User not found");
                    } else {
                        System.out.println(userDelete + " has been deleted from the list of contacts.");
                        contactsHash.remove(userDelete);
                        List<String> newContactsList = new ArrayList<>();
                        Iterator dhmIterator = contactsHash.entrySet().iterator();

                        while(dhmIterator.hasNext()){
                            Map.Entry delContact = (Map.Entry)dhmIterator.next();
                            if (delContact.getKey() != null &&  delContact.getValue() != null) {
                                newContactsList.add(delContact.getKey() + "|" + delContact.getValue());
                                Files.write(contactsPath,newContactsList);
                            }
                        }
                        Files.write(contactsPath, newContactsList);
                    }
                    // Back to main
                    option = BackToMain.navigateToMain();
                    break;


                case 5:  // Exit from main menu
                    option = 0;
                    break;
                default:
                    System.out.println("I'm sorry, that wasn't a valid input");
                    option = BackToMain.navigateToMain();
                    break;
            }
        } while (option != 0);

        System.out.println("Have a good day!");

    }
}
