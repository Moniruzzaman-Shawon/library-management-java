import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<Book> books;;
    private final List<Member> members;

    public Library() {
        books = new ArrayList<>();
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));

        members = new ArrayList<>();
        members.add(new Member("Alice", "1"));
        members.add(new Member("Bob", "2"));
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

    public Book returnBook(String title) throws BookNotAvailableException {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.setAvailable(true);
                return book;
            }
        }
        throw new BookNotAvailableException("Book not borrowed: " + title);
    }

    public Member checkMemberAvailability(String memberName) throws MemberNotFoundException {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(memberName)) {
                return member;
            }
        }
        throw new MemberNotFoundException("Member not found: " + memberName);
    }
}
