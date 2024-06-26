import java.util.Scanner;

public class LibraryMenu {
    private Library library;

    public LibraryMenu(Library library) {
        this.library = library;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to the Library Management System");
            System.out.println("1. Add Library Item");
            System.out.println("2. Edit Library Item");
            System.out.println("3. Delete Library Item");
            System.out.println("4. Borrow Library Item");
            System.out.println("5. Return Library Item");
            System.out.println("6. Manage Authors");
            System.out.println("7. Manage Patrons");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addLibraryItem(scanner);
                    break;
                case 2:
                    editLibraryItem(scanner);
                    break;
                case 3:
                    deleteLibraryItem(scanner);
                    break;
                case 4:
                    borrowLibraryItem(scanner);
                    break;
                case 5:
                    returnLibraryItem(scanner);
                    break;
                case 6:
                    manageAuthors(scanner);
                    break;
                case 7:
                    managePatrons(scanner);
                    break;
                case 8:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }

    private void addLibraryItem(Scanner scanner) {
        System.out.print("Enter item ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();
        Author author = library.findAuthorByName(authorName);
        if (author == null) {
            System.out.print("Enter author DOB: ");
            String dob = scanner.nextLine();
            author = new Author(authorName, dob);
            library.addAuthor(author);
        }
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter number of copies: ");
        int numberOfCopies = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter format (book or periodical): ");
        String format = scanner.nextLine();

        LibraryItem item = new Book(id, title, author, isbn, publisher, numberOfCopies, format);
        library.addItem(item);

        System.out.println("Library item added successfully.");
    }

    private void editLibraryItem(Scanner scanner) {
        System.out.print("Enter item ID to edit: ");
        String id = scanner.nextLine();
        LibraryItem existingItem = library.findItemById(id);
        if (existingItem != null) {
            System.out.print("Enter new title: ");
            String title = scanner.nextLine();
            System.out.print("Enter new author name: ");
            String authorName = scanner.nextLine();
            Author author = library.findAuthorByName(authorName);
            if (author == null) {
                System.out.print("Enter author DOB: ");
                String dob = scanner.nextLine();
                author = new Author(authorName, dob);
                library.addAuthor(author);
            }
            System.out.print("Enter new ISBN: ");
            String isbn = scanner.nextLine();
            System.out.print("Enter new publisher: ");
            String publisher = scanner.nextLine();
            System.out.print("Enter new number of copies: ");
            int numberOfCopies = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new format (book or periodical): ");
            String format = scanner.nextLine();

            LibraryItem updatedItem = new Book(id, title, author, isbn, publisher, numberOfCopies, format);
            library.editItem(id, updatedItem);

            System.out.println("Library item updated successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    private void deleteLibraryItem(Scanner scanner) {
        System.out.print("Enter item ID to delete: ");
        String id = scanner.nextLine();
        library.deleteItem(id);
        System.out.println("Library item deleted successfully.");
    }

    private void borrowLibraryItem(Scanner scanner) {
        System.out.print("Enter patron name: ");
        String patronName = scanner.nextLine();
        System.out.print("Enter item ID to borrow: ");
        String itemId = scanner.nextLine();
        library.borrowItem(patronName, itemId);
    }

    private void returnLibraryItem(Scanner scanner) {
        System.out.print("Enter patron name: ");
        String patronName = scanner.nextLine();
        System.out.print("Enter item ID to return: ");
        String itemId = scanner.nextLine();
        library.returnItem(patronName, itemId);
    }

    private void manageAuthors(Scanner scanner) {
        System.out.println("Author Management");
        System.out.println("1. Add Author");
        System.out.println("2. Edit Author");
        System.out.println("3. Delete Author");
        System.out.print("Enter your choice (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter author name: ");
                String name = scanner.nextLine();
                System.out.print("Enter author DOB: ");
                String dob = scanner.nextLine();
                Author author = new Author(name, dob);
                library.addAuthor(author);
                System.out.println("Author added successfully.");
                break;
            case 2:
                System.out.print("Enter author name to edit: ");
                name = scanner.nextLine();
                Author existingAuthor = library.findAuthorByName(name);
                if (existingAuthor != null) {
                    System.out.print("Enter new DOB: ");
                    dob = scanner.nextLine();
                    existingAuthor.setDob(dob);
                    library.editAuthor(name, existingAuthor);
                    System.out.println("Author updated successfully.");
                } else {
                    System.out.println("Author not found.");
                }
                break;
            case 3:
                System.out.print("Enter author name to delete: ");
                name = scanner.nextLine();
                library.deleteAuthor(name);
                System.out.println("Author deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void managePatrons(Scanner scanner) {
        System.out.println("Patron Management");
        System.out.println("1. Add Patron");
        System.out.println("2. Edit Patron");
        System.out.println("3. Delete Patron");
        System.out.print("Enter your choice (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter patron name: ");
                String name = scanner.nextLine();
                System.out.print("Enter address: ");
                String address = scanner.nextLine();
                System.out.print("Enter phone number: ");
                String phoneNumber = scanner.nextLine();
                Patron patron = new Patron(name, address, phoneNumber);
                library.addPatron(patron);
                System.out.println("Patron added successfully.");
                break;
            case 2:
                System.out.print("Enter patron name to edit: ");
                name = scanner.nextLine();
                Patron existingPatron = library.findPatronByName(name);
                if (existingPatron != null) {
                    System.out.print("Enter new address: ");
                    address = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    phoneNumber = scanner.nextLine();
                    existingPatron.setAddress(address);
                    existingPatron.setPhoneNumber(phoneNumber);
                    library.editPatron(name, existingPatron);
                    System.out.println("Patron updated successfully.");
                } else {
                    System.out.println("Patron not found.");
                }
                break;
            case 3:
                System.out.print("Enter patron name to delete: ");
                name = scanner.nextLine();
                library.deletePatron(name);
                System.out.println("Patron deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
