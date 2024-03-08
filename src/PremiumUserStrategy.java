//This class implements the IBorrowingStrategy interface and defines the borrowBook method for premium users.
public class PremiumUserStrategy implements IBorrowingStrategy {
    @Override
    public void borrowBook(User user, Book book) {
        if (book.isAvailable()) {
            // Premium users have the privilege of borrowing two books at a time
            if (user.getBooksBorrowed().size() < 3) {
                System.out.println(user.getName() + " borrowed the book '" + book.getTitle() + "'.");
                book.setAvailable(false, book);
                user.addBorrowedBook(book);
            } else {
                System.out.println("Sorry, premium users can only borrow up to two books at a time.");
            }
        } else {
            System.out.println("Sorry, the book '" + book.getTitle() + "' is not available.");
        }
    }
}










