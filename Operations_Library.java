public interface Operations_Library {
    public void AddBook(Book book, double price);
    public boolean remove(int index);
    public boolean contains(Book book);
    public int size();
    public boolean isEmpty();
    public int indexOf(int bookCode);
    public void updatePrice(int bookCode, double price);
}
