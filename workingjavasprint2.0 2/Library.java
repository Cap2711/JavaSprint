import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> items;
    private List<Author> authors;
    private List<Patron> patrons;

    public Library() {
        items = new ArrayList<>();
        authors = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    // Methods for managing items
    public void addItem(LibraryItem item) {
        items.add(item);
        item.getAuthor().addItemWritten(item);
    }

    public void editItem(String id, LibraryItem updatedItem) {  // Change `int` to `String`
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {  // Change `int` to `String`
                items.set(i, updatedItem);
                return;
            }
        }
    }

    public void deleteItem(String id) {  // Change `int` to `String`
        items.removeIf(item -> item.getId().equals(id));  // Change `int` to `String`
    }

    // Methods for managing authors
    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void editAuthor(String name, Author updatedAuthor) {
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).getName().equals(name)) {
                authors.set(i, updatedAuthor);
                return;
            }
        }
    }

    public void deleteAuthor(String name) {
        authors.removeIf(author -> author.getName().equals(name));
    }

    public Author findAuthorByName(String name) {
        for (Author author : authors) {
            if (author.getName().equals(name)) {
                return author;
            }
        }
        return null;
    }

    // Methods for managing patrons
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public void editPatron(String name, Patron updatedPatron) {
        for (int i = 0; i < patrons.size(); i++) {
            if (patrons.get(i).getName().equals(name)) {
                patrons.set(i, updatedPatron);
                return;
            }
        }
    }

    public void deletePatron(String name) {
        patrons.removeIf(patron -> patron.getName().equals(name));
    }

    public Patron findPatronByName(String name) {
        for (Patron patron : patrons) {
            if (patron.getName().equals(name)) {
                return patron;
            }
        }
        return null;
    }

    // Methods for borrowing and returning items
    public void borrowItem(String patronName, String itemId) {  // Change `int` to `String`
        Patron patron = findPatronByName(patronName);
        LibraryItem item = findItemById(itemId);  // Change `int` to `String`

        if (patron != null && item != null && item.getNumberOfCopies() > 0) {
            patron.borrowItem(item);
            item.setNumberOfCopies(item.getNumberOfCopies() - 1);
        } else {
            System.out.println("Item not available or not found.");
        }
    }

    public void returnItem(String patronName, String itemId) {  // Change `int` to `String`
        Patron patron = findPatronByName(patronName);
        LibraryItem item = findItemById(itemId);  // Change `int` to `String`

        if (patron != null && item != null && patron.getBorrowedItems().contains(item)) {
            patron.returnItem(item);
            item.setNumberOfCopies(item.getNumberOfCopies() + 1);
        } else {
            System.out.println("Item not borrowed or not found.");
        }
    }

    private LibraryItem findItemById(String id) {  // New method
        for (LibraryItem item : items) {
            if (item.getId().equals(id)) {  // Change `int` to `String`
                return item;
            }
        }
        return null;
    }

    // Getters for lists of items, authors, and patrons
    public List<LibraryItem> getItems() {
        return items;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }
}
