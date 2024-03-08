import java.util.Scanner;


//This class is used to test the library management system
public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager libraryManager = LibraryManager.getInstance();


        addDefaultBooks(libraryManager);
        addDefaultUsers(libraryManager);
    
        while (true) {
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            String login = sc.nextLine(); 

            if (login.equals("1")) {
                adminMenu(libraryManager, sc);
            } else if (login.equals("2")) {
                userMenu(libraryManager, sc);
            }
        }
        
    }
    public static void adminMenu(LibraryManager libraryManager, Scanner sc){

        System.out.println("1. Add a book");
        System.out.println("2. Add a user");
        System.out.println("3. Add to Notification List");
        System.out.println("4. Remove from Notification List");
        System.out.println("5. Exit");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1:
                addBookToLibrary(libraryManager, option, sc);
                break;
            case 2:
                addUserToLibrary(libraryManager,  sc);
                break;
            
            case 3:
                String usName = sc.nextLine();
                libraryManager.addObserver(libraryManager.findUser(usName));
                break;
            
            case 4:
                String usName2 = sc.nextLine();
                libraryManager.removeObserver(libraryManager.findUser(usName2));
                break;
                
            case 5:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
        }
    }

public static void userMenu(LibraryManager libraryManager, Scanner sc){
    System.out.println("User Name: ");
    String userName = sc.nextLine();
    if(libraryManager.findUser(userName) == null) {
        System.out.println("This user does not exist.");
    } else {
    System.out.println("1. Borrow Book");
    System.out.println("2. Return Book");
    System.out.println("3. Exit");
    int option = sc.nextInt();
    sc.nextLine();

    switch (option) {
        
        case 1:
            UserBorrowinBook(libraryManager, sc, userName);
            break;
        case 2:
            UserReturnBook(libraryManager, sc, userName);
            break;
        case 3:
            System.out.println("Exiting...");
            System.exit(0);
            break;
        default:
            System.out.println("Invalid option. Please choose again.");
    }
}
}

    public static void addDefaultBooks(LibraryManager libraryManager) {
        libraryManager.addBook(new Book("0", "Java"));
        libraryManager.addBook(new Book("1", "Python"));
        libraryManager.addBook(new Book("2", "Design Patterns"));
        libraryManager.addBook(new Book("3", "Game Programming"));
    }

    public static void addDefaultUsers(LibraryManager libraryManager) {
        User premiumUser = new User("Doruk", new PremiumUserStrategy(), libraryManager);
        libraryManager.addUser(premiumUser);
        libraryManager.addObserver(premiumUser);

        User regularUser = new User("Nigar", new RegularUserStrategy(), libraryManager);
        libraryManager.addUser(regularUser);
        libraryManager.addObserver(regularUser);
        libraryManager.removeObserver(regularUser);
    }

    // This method is used to add a book to the library
    public static Integer addBookToLibrary(LibraryManager libraryManager,int x,   Scanner sc) {
        while (true) {
            System.out.println("Enter the name of the book (type '3' to exit): ");
            String bookName = sc.nextLine();

            if (bookName.equals("3")) {
                System.out.println("Exiting...");
            return x;
            
            } else {
                Book book = new Book(Integer.toString(0), bookName);
                libraryManager.addBook(book);
                libraryManager.notifyObservers(book);
                libraryManager.displayInventory();
            
            }
            
        }
    }
    
    // This method is used to add a user to the library
    public static Integer addUserToLibrary(LibraryManager libraryManager, Scanner sc) {
        while (true) {
            System.out.println("Enter the type of the user: ");
            System.out.println("1. Premium User ");
            System.out.println("2. Regular User ");
            System.out.println("3. Exit ");
            
            
            String userType = sc.nextLine();
            if(userType.equals("1")) {
                System.out.println("Enter the name of the user");
                String userName = sc.nextLine();   
                
                if(libraryManager.findUser(userName) != null) {
                    System.out.println("This user already exist.");
                }else { 
                
                User premiumUser = new User(userName , new PremiumUserStrategy() , libraryManager);
                libraryManager.addUser(premiumUser);
                libraryManager.displayUsers();
                }
            }else if(userType.equals("2")) {
                System.out.println("Enter the name of the user");
                String userName = sc.nextLine();    
                
                if(libraryManager.findUser(userName) != null) {
                    System.out.println("This user already exist.");
                }else { 
                
                User regularUser = new User(userName , new RegularUserStrategy() , libraryManager);
                libraryManager.addUser(regularUser);
                libraryManager.displayUsers();
                }
            }else {
                return 0;
            }
        }
    }
    
    //This method is used to borrow a book from the library
    public static Integer UserBorrowinBook(LibraryManager libraryManager, Scanner sc , String userName) {
        while (true) {
            libraryManager.displayInventory();
                        
            System.out.println("Enter the name of the book: (type '3' to exit) ");
            String bookName = sc.nextLine();
            
            if(bookName.equals("3")) {
                return 0;
            }
            libraryManager.borrowBook(libraryManager.findUser(userName), libraryManager.findBook(bookName) , libraryManager.findUser(userName).getBorrowingStrategy() );
            
        }
    }
    
    //This method is used to return a book to the library
    public static Integer UserReturnBook(LibraryManager libraryManager, Scanner sc , String userName) {
        while (true) {
            libraryManager.displayInventory();
            
                            
                System.out.println("Enter the name of the book: (type '3' to exit) ");
                String bookName = sc.nextLine();
                
                
                libraryManager.returnBook(libraryManager.findUser(userName), libraryManager.findBook(bookName) );
                libraryManager.findUser(userName).displayBorrowedBooks();
            
            
            
            }
    }
    
    
    
}
