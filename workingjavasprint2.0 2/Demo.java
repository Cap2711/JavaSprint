
public class Demo {
    public static void main(String[] args) {
        // Create the library instance
        Library library = new Library();

        // Adding authors
        Author author1 = new Author("George Orwell", "1903-06-25");
        Author author2 = new Author("J.K. Rowling", "1965-07-31");
        Author author3 = new Author("Isaac Asimov", "1920-01-02");

        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addAuthor(author3);

        // Adding books with String IDs
        Book book1 = new Book("1", "1984", author1, "1234567890", "Secker & Warburg", 10, "Printed");
        Book book2 = new Book("2", "Animal Farm", author1, "1234567891", "Secker & Warburg", 5, "Printed");
        Book book3 = new Book("3", "Harry Potter and the Sorcerer's Stone", author2, "1234567892", "Bloomsbury", 20, "Printed");
        Book book4 = new Book("4", "Harry Potter and the Chamber of Secrets", author2, "1234567893", "Bloomsbury", 15, "Printed");
        Book book5 = new Book("5", "Foundation", author3, "1234567894", "Gnome Press", 7, "Printed");
        Book book6 = new Book("6", "Foundation and Empire", author3, "1234567895", "Gnome Press", 5, "Printed");
        Book book7 = new Book("7", "Second Foundation", author3, "1234567896", "Gnome Press", 5, "Printed");
        Book book8 = new Book("8", "Prelude to Foundation", author3, "1234567897", "Bantam Spectra", 10, "Electronic");
        Book book9 = new Book("9", "Forward the Foundation", author3, "1234567898", "Bantam Spectra", 8, "Electronic");
        Book book10 = new Book("10", "The Caves of Steel", author3, "1234567899", "Doubleday", 12, "Audio");

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(book4);
        library.addItem(book5);
        library.addItem(book6);
        library.addItem(book7);
        library.addItem(book8);
        library.addItem(book9);
        library.addItem(book10);


        // Adding patrons
        Patron patron1 = new Patron("Alice Smith", "123 Main St", "555-1234");
        Patron patron2 = new Patron("Bob Johnson", "456 Elm St", "555-5678");

        library.addPatron(patron1);
        library.addPatron(patron2);

        // Show library menu
        LibraryMenu menu = new LibraryMenu(library);
        menu.showMenu();
    }
}
