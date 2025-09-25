package lms;
import java.util.Scanner;
public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // Sample data
        library.addBook(new Book(1, "Java Basics", "James Gosling"));
        library.addBook(new Book(2, "Effective Java", "Joshua Bloch"));
        library.addUser(new User(1, "Alice"));
        library.addUser(new User(2, "Bob"));

        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Available Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bid, title, author));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();
                    library.addUser(new User(uid, name));
                    System.out.println("User registered successfully!");
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    int uId = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bId = sc.nextInt();
                    library.issueBookToUser(uId, bId);
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    int uId2 = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bId2 = sc.nextInt();
                    library.returnBookFromUser(uId2, bId2);
                    break;

                case 5:
                    library.displayAvailableBooks();
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}