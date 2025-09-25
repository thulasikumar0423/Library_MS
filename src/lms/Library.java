package lms;
import java.util.*;
public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book b : books) {
            if (!b.isIssued()) {
                System.out.println(b);
            }
        }
    }

    public void issueBookToUser(int userId, int bookId) {
        User user = findUserById(userId);
        Book book = findBookById(bookId);

        if (user != null && book != null && !book.isIssued()) {
            book.issue();
            user.issueBook(book);
            System.out.println("Book issued successfully to " + user.getName());
        } else {
            System.out.println("Cannot issue book (check book availability or user).");
        }
    }

    public void returnBookFromUser(int userId, int bookId) {
        User user = findUserById(userId);
        Book book = findBookById(bookId);

        if (user != null && book != null && book.isIssued() && user.getIssuedBooks().contains(book)) {
            book.returnBook();
            user.returnBook(book);
            System.out.println("Book returned successfully by " + user.getName());
        } else {
            System.out.println("Cannot return book (check if user has issued it).");
        }
    }

    private User findUserById(int id) {
        for (User u : users) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    private Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }
}
