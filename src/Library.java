import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book borrowBook(String title) throws BookNotAvailableException {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.setAvailable(false);
                return book;
            }
        }
        throw new BookNotAvailableException("Book not available: " + title);
    }

    public void returnBook(Book book) {
        book.setAvailable(true);
    }
}
