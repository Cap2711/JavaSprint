import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String dob;
    private List<LibraryItem> itemsWritten;

    public Author(String name, String dob) {
        this.name = name;
        this.dob = dob;
        this.itemsWritten = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }
    public List<LibraryItem> getItemsWritten() { return itemsWritten; }

    public void addItemWritten(LibraryItem item) {
        itemsWritten.add(item);
    }
}
