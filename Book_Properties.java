public class Book_Properties implements Comparable<Book_Properties> {
    private int YearOfUp;

    private int NumOfPages;
    private int bookCode;
    private String title;
    private String writer;

    // constructor to the Book_Properties

    public Book_Properties(int yearOfUp, int numOfPages, int bookCode, String title, String writer) {
        YearOfUp = yearOfUp;
        NumOfPages = numOfPages;
        this.bookCode = bookCode;
        this.title = title;
        this.writer = writer;
    }

    // Getters/setters

    public int getYearOfUp() {
        return YearOfUp;
    }

    public void setYearOfUp(int yearOfUp) {
        YearOfUp = yearOfUp;
    }

    public int getNumOfPages() {
        return NumOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        NumOfPages = numOfPages;
    }

    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    // to-string method

    @Override
    public String toString() {
        return "Book_Properties{" +
                "YearOfUp=" + YearOfUp +
                ", NumOfPages=" + NumOfPages +
                ", bookCode=" + bookCode +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }

    @Override
    public int compareTo(Book_Properties o) {
        return this.title.compareTo(o.title);
    }
}
