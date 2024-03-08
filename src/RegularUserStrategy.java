//This class implements the IBorrowingStrategy interface and defines the borrowBook method for regular users.
public class RegularUserStrategy implements IBorrowingStrategy {
    @Override
    public void borrowBook(User user, Book book) {
          // Regular users can borrow one book at a time
            if (book.isAvailable()) {
            if(user.getBooksBorrowed().size() == 0 ){
                System.out.println(user.getName() + " borrowed the book '" + book.getTitle() + "'.");
                book.setAvailable(false, book );
                user.addBorrowedBook(book);
            }
            else{
                System.out.println("Sorry, regular users can only borrow up to one book at a time.");
            }
        } else {
            System.out.println("Sorry, the book '" + book.getTitle() + "' is not available.");
        }
    }
}













