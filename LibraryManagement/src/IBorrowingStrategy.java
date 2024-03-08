//This interface is used to implement the Strategy Pattern. It is used to borrow a book.
//The borrowing strategy is different for regular users and premium users.
public interface IBorrowingStrategy {
    void borrowBook(User user, Book book);
}

