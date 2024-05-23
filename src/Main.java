import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an ArrayList of Book objects
        List<Book> books = new ArrayList<>();

        // Add some books to the list


        // Print all books
        for (Book book : books) {
            System.out.println(book);
        }

        // Find a specific book by title
        String titleToFind = "1984";
        Book foundBook = findBookByTitle(books, titleToFind);
        if (foundBook != null) {
            System.out.println("Found book: " + foundBook);
        } else {
            System.out.println("Book not found: " + titleToFind);
        }
    }

    // Method to find a book by title
    public static Book findBookByTitle(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
}
