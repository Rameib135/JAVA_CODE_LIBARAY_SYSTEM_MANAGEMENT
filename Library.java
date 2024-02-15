import java.util.Vector;
import java.io.*;
import java.util.*;
public class Library implements Operations_Library{
    private Vector<Book> books;
    private Vector<Double> prices;

    public void saveToFile(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < books.size(); i++) {
                String line = books.get(i).toString() + "," + prices.get(i);
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method to load data from a file
    public void loadFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int yearOfUp = Integer.parseInt(parts[0]);
                    int numOfPages = Integer.parseInt(parts[1]);
                    int bookCode = Integer.parseInt(parts[2]);
                    String title = parts[3];
                    String writer = parts[4];
                    double price = Double.parseDouble(parts[5]);
                    Book book = new Book(yearOfUp, numOfPages, bookCode, title, writer);
                    AddBook(book, price);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // constructor
    public Library() {
        books = new Vector<>();
        prices = new Vector<>();
    }


    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", prices $ =" + prices +
                '}';
    }

    // implemented methods from the operations_Library interface
    // method that adds book and the price of the book to Vector books:
    @Override
    public void AddBook(Book book, double price) {
        this.books.add(book);
        this.prices.add(price);
    }

    // method that removes book from Vector books and removes the price from the Vector prices by the index:
    public boolean remove(int index) {
        if (index < 0 || index >= books.size()) {
            return false;
        }
        books.remove(index);
        prices.remove(index);
        return true;
    }


    // method returns if the book exists in the library(Vector books):
    @Override
    public boolean contains(Book book){
        for (Book library1:books) {
            if (library1.isEqual(book)) return true;
        }
        return false;
    }


    // return the amount of the books in the library(Vector books):
    @Override
    public int size() {
        return books.size();
    }

    // returns if the library is empty:
    @Override
    public boolean isEmpty(){
        if (books.size()==0) return true;
        else return false;
    }

    // method returns the location of the book in the library by the code of the book:
    @Override
    public int indexOf(int bookCode) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookCode() == bookCode) {
                return i;
            }
        }
        return -1;
    }
    // method updates the price of the book by the book code:
    public void updatePrice(int bookCode, double price) {
        int index = indexOf(bookCode);
        if (index != -1) {
            prices.set(index, price);
        }
    }

    // method that removed the elements of prices and books
    public void clear(){
        books.clear();
        prices.clear();
    }


    public Operations_Library getLibrary() {
        return getLibrary();
    }


}









