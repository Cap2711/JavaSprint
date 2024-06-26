public class Book extends LibraryItem {
    private String format; // book or periodical

    public Book(String id, String title, Author author, String isbn, String publisher, int numberOfCopies, String format) {
        super(id, title, author, isbn, publisher, numberOfCopies);  // Change `int` to `String`
        this.format = format;
    }

    // Getters and Setters
    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }
}


