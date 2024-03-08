import java.util.ArrayList;
import java.util.List;

//This class is used to user objects. It implements the IBookObserver interface. 
public class User implements IBookObserver {
    private String name;
    private List<Book> booksBorrowed;
    private IBorrowingStrategy borrowingStrategy;
    ArrayList<Book> observeBooks = new ArrayList<>();
    
    public User(String name) {
        this.name = name;
        this.booksBorrowed = new ArrayList<>();  
    }
    
    // This constructor is used to set the borrowing strategy for the user.
    public User(String name , IBorrowingStrategy borrowingStrategy , LibraryManager instance) {
        this.name = name;
        this.borrowingStrategy = borrowingStrategy;
        this.booksBorrowed = new ArrayList<>(); 
    }
    
    public void setBorrowingStrategy(IBorrowingStrategy borrowingStrategy) {
        this.borrowingStrategy = borrowingStrategy;
    }
    
    public void borrowBook(Book book) {
        borrowingStrategy.borrowBook(this, book);
    }

    public String getName() {
        return name;
    }
    
    public IBorrowingStrategy getBorrowingStrategy() {
        return borrowingStrategy;
    }

    public List<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void addBorrowedBook(Book book) {
        if (!booksBorrowed.contains(book)) {
            booksBorrowed.add(book);
        }
        displayBorrowedBooks();
    }

    //This method is used for displaying the books borrowed by the user.
    public void displayBorrowedBooks() {
        if (!booksBorrowed.isEmpty()) {
            System.out.print(name + "'s Borrowed Books: ");
            for (Book book : booksBorrowed) {
                System.out.print(book.getTitle() + " ");
            }
            System.out.println();
        } else {
            System.out.println(name + " has not borrowed any books.");
        }
    }
    
    //This method is used for observing the books in the library.
    public void displayObserveBooks() {
    	
        if (!observeBooks.isEmpty()) {
            
            for (Book book : observeBooks) {
                System.out.print(" New book in library: " + book.getTitle() + " ");
            }
            System.out.println();
        } else {
            System.out.println("There is no notification.");
        }
    }

    //This method is used for updating the user about the new books in the library.
    @Override
    public Book update(Book book) {
    	System.out.println(name + " New book in library: " + book.getTitle());
    	
   	    observeBooks.add(book);
    	return book;
      
    }
      //  System.out.println(name + ", the book '" + book.getTitle() + "' is now available!");
    }
    
    // public void borrowBook(Book book){
    //     LibraryManager.getInstance().borrowBook(this, book);
    // }