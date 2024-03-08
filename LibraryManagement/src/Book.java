//This class represents a book in the library
public class Book {
    private String id;
    private String title;
    private boolean available;

    //This constructor is used to create a book object
    public Book(String id, String title) {
        this.id = id;
        this.title = title;
        this.available = true;
    }

    //This method is used to set the availability of a book.
    public void setAvailable(boolean available, Book book) {
        if (book.isAvailable() != available) {
            if (available) {
                System.out.println("The book " + book.getTitle() + " is now available");
            } else {
                System.out.println("The book " + book.getTitle() + " is not available");
            }
            this.available = available;
           //LibraryManager.getInstance().notifyObservers(this);
        } else {
            System.out.println("The book " + book.getTitle() + " is already " + (available ? "available" : "not available"));
        }
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }
}