import java.io.*;
import java.util.Scanner;

public class UserInterface {

    private Library library;

    public UserInterface() {
        library = new Library();
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Please choose an option:");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Check if book exists");
            System.out.println("4. Get library size");
            System.out.println("5. Update book price");
            System.out.println("6. Clear library");
            System.out.println("7. Save library to file");
            System.out.println("8. Load library from file");
            System.out.println("0. Exit");

            input = scanner.nextLine();

            switch (input) {
                case "1":
                    addBook(scanner);
                    break;
                case "2":
                    removeBook(scanner);
                    break;
                case "3":
                    checkIfBookExists(scanner);
                    break;
                case "4":
                    size();
                    break;
                case "5":
                    updatePrice(scanner);
                    break;
                case "6":
                    clearLibrary();
                    break;
                case "7":
                    saveToFile(scanner);
                    break;
                case "8":
                    loadFromFile(scanner);
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        } while (!input.equals("0"));
    }

    private void addBook(Scanner scanner) {
        System.out.println("Please enter the book details:");

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Writer: ");
        String writer = scanner.nextLine();

        System.out.print("Year of publication: ");
        int yearOfPublication = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Number of pages: ");
        int numOfPages = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Book code: ");
        int bookCode = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Book book = new Book(yearOfPublication, numOfPages, bookCode, title, writer);
        library.AddBook(book, price);

        System.out.println("Book added successfully!");
    }

    private void removeBook(Scanner scanner) {
        System.out.print("Please enter the book code to remove: ");
        int bookCode = scanner.nextInt();
        scanner.nextLine();

        int index = library.indexOf(bookCode);
        if (index == -1) {
            System.out.println("Book not found in library.");
        } else {
            library.remove(index);
            System.out.println("Book removed successfully.");
        }
    }

    private void checkIfBookExists(Scanner scanner) {
        System.out.println("Please enter the book details:");
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Writer: ");
        String writer = scanner.nextLine();

        System.out.print("Year of publication: ");
        int yearOfPublication = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Number of pages: ");
        int numOfPages = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Book code: ");
        int bookCode = scanner.nextInt();
        scanner.nextLine();

        Book book = new Book(yearOfPublication, numOfPages, bookCode, title, writer);
        boolean exists = library.contains(book);

        if (exists) {
            System.out.println("Book exists in library.");
        } else {
            System.out.println("Book not found in library.");
        }
    }

    private void size() {
        int size = library.size();
        System.out.println("Library size: " + size);
    }

    private void updatePrice(Scanner scanner) {
        System.out.print("Please enter the book code to update price: ");
        int bookCode = scanner.nextInt();
        scanner.nextLine();

        int index = library.indexOf(bookCode);
        if (index == -1) {
            System.out.println("Book not found in library.");
        } else {
            System.out.print("Please enter the new price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            library.updatePrice(index, price);
            System.out.println("Price updated successfully.");
        }
    }

    private void clearLibrary() {
        library.clear();
        System.out.println("Library cleared successfully.");
    }

    private void saveToFile(Scanner scanner) {
        System.out.print("Please enter the file name: ");
        String fileName = scanner.nextLine();

        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(library);
            objectOut.close();
            fileOut.close();
            System.out.println("Library saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving library to file.");
        }
    }

    private void loadFromFile(Scanner scanner) {
        System.out.print("Please enter the file name: ");
        String fileName = scanner.nextLine();

        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            library = (Library) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("Library loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading library from file.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading library from file.");
        }
    }




    @Override
    public String toString() {
        return "UserInterface{" +
                "library=" + library +
                '}';
    }
}



