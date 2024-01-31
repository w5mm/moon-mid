package pratise;
import java.util.Scanner;

public class CheckStringIsInteger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

// Read a string from the user
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();

// Check if the string is an integer
        boolean isInteger = true;
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            isInteger = false;
        }

// Print the result
        if (isInteger) {
            System.out.println("The string is an integer.");
        } else {
            System.out.println("The string is not an integer.");
        }
    }
}

