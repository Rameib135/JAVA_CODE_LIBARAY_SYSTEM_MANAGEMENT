import java.util.EnumMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Library librarySystem = new Library();
        UserInterface userInterface = new UserInterface();
        EmployeeTextualUserInterface employeeTextualUserInterface = new EmployeeTextualUserInterface();

        // use the text-based menu IN the userInterface to interact with the library
        userInterface.start();

    }
}
