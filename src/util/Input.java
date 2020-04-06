package util;

import java.util.Scanner;

public class Input {

    private Scanner scanner;
    private String prompt;

    public Input() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    public String getString() {
        return scanner.nextLine();
    }

    // The yesNo method should return true if the user enters y, yes, or variants thereof, and false otherwise.
    public boolean yesNo(){
        String userString = scanner.nextLine();
        return userString.equalsIgnoreCase("y") || userString.equalsIgnoreCase("yes");
    }


    public int getInt() {
        String s = getString();
        int var = 0;
        try {
            var = Integer.parseInt(s);
        } catch (Exception e) {
            System.err.println("This is not an Integer");
            System.err.println("Enter again:");
            return getInt();
        }
        return var;
    }


}
