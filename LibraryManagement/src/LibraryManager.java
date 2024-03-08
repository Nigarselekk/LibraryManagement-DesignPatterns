import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class LibraryManager  {


    private static LibraryManager instance;

    private Map<String, Book> bookInventory;
    private List<User> users;

    
    public List<IBookObserver> observers = new ArrayList<>();
    
    private IBorrowingStrategy borrowingStrategy;

    private LibraryManager(IBorrowingStrategy borrowingStrategy) {
        this.borrowingStrategy = borrowingStrategy;
    }

    private LibraryManager() {
        bookInventory = new HashMap<>();
        users = new ArrayList<>();
    }

    public static synchronized LibraryManager getInstance() {
        if (instance == null) {
            instance = new LibraryManager();
        }
        return instance;
    }

    public void addBook(Book book) {
        bookInventory.put(book.getId(), book);
    }

    public void addUser(User user) {
        users.add(user);
        
    }

    public void displayInventory() {
        System.out.println("Library Inventory:");
        for (Book book : bookInventory.values()) {
            System.out.println(book.getTitle() + " - Available: " + book.isAvailable());
        }
        System.out.println(); 
    }
    
    public void displayUsers() {
        System.out.println("All Users:" );
        for (User user : users) {
            System.out.println(user.getName() + "  " + user.getBorrowingStrategy());
        }
        System.out.println(); 
    }
    
    
    public User findUser(String name) {
        
        for (User user : users) {
            if(user.getName().equals(name)) {
            	return user;
            }
        }
		return null;
    }
    
public Book findBook(String name) {
        
	for (Book book : bookInventory.values()) {
            if(book.getTitle().equals(name)) {
            	return book;
            }
        }
		return null;
    }
    
    public void addObserver(IBookObserver observer) {
        observers.add(observer);
        
    }

    public void removeObserver(IBookObserver observer) {
        observers.remove(observer);
        
    }

    public void notifyObservers(Book book) {
        for (IBookObserver observer : observers) {
        observer.update(book);
        }
        System.out.println(); 
    }
    

    public void setBorrowingStrategy(IBorrowingStrategy borrowingStrategy) {
        this.borrowingStrategy = borrowingStrategy;
    }
    
    // public void borrowBook(User user, Book book) {
    //     LibraryManager.getInstance().borrowingStrategy.borrowBook(user, book);
    // }
    
    
    public void returnBook(User user, Book book) {


        if (user.getBooksBorrowed().contains(book)) {
            user.getBooksBorrowed().remove(book);
            book.setAvailable(true, book);
            System.out.println(user.getName() + " returned the book '" + book.getTitle() + "'.");
        } else {
            System.out.println(user.getName() + " has not borrowed the book '" + book.getTitle() + "'.");
        }
    }
    
    public void borrowBook(User user, Book book , IBorrowingStrategy borrowingStrategy) {
    	    if(book == null) {
    		System.out.println("This book is not exist in library inventory.");
    		
    	}else if (borrowingStrategy != null) {
        	
            borrowingStrategy.borrowBook(user, book);
           // user.update(book);
        } else {
            System.out.println("Borrowing strategy is not set. Cannot borrow the book.");
        }
    }
    
}