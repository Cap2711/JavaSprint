public class LibraryItem {
    private String id;
    private String title;
    private Author author;
    private String isbn;
    private String publisher;
    private int numberOfCopies;

    public LibraryItem(String id, String title, Author author, String isbn, String publisher, int numberOfCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public int getNumberOfCopies() { return numberOfCopies; }
    public void setNumberOfCopies(int numberOfCopies) { this.numberOfCopies = numberOfCopies; }
}
