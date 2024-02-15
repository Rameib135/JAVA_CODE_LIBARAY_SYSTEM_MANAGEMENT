public class Book extends Book_Properties{

    public Book(int yearOfUp, int numOfPages, int bookCode, String title, String writer) {
        super(yearOfUp, numOfPages, bookCode, title, writer);
    }

    public boolean isEqual(Book book){
       return book.getBookCode()==this.getBookCode()&&
               book.getTitle()==this.getTitle()&&
               book.getWriter()==this.getWriter()&&
               book.getYearOfUp()==this.getYearOfUp()&&
               book.getNumOfPages()==this.getNumOfPages();

    }

}
