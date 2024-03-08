Library Management System

Project Purpose:
The purpose of the project is to create a flexible and modular library management system that handles book and user management, borrowing strategies, and user notifications.
The system allows users to borrow and return books, with different borrowing rules for regular and premium users.

Project Scope:
The scope includes the creation, updating, and deletion of books and users. It also covers the borrowing and returning of books, with strategies for regular and premium users. The system aims to be easily extendable for future enhancements.

System Overview
The library management system is a system that facilitates the management of books, user registration, book borrowing, and return processes. The key components include:
Books: Adding, deleting, updating, and tracking the status of books.
Users: Adding and updating user information.
Borrowing and Returning Operations: User processes for borrowing and returning books.

1.	Observer Pattern:

Purpose:
The Observer Pattern is employed to establish a one-to-many dependency between objects, ensuring that when one object changes its state, all its dependents are notified and updated automatically. The Observer Pattern is used to implement a notification mechanism for users when the status of a book changes.

Implementation:

BookObserver Interface:
Defines the update(Book book) method that is implemented by concrete observers.
User Class:
Implements the IBookObserver .
Gets notified when the book status changes.
LibraryManager Class:
Maintains a list of book observers (users) and notifies them when a book's status changes.
The notifyObservers(Book book) method triggers the update method in each registered observer.


Benefits:
Loose Coupling: Users are decoupled from the library manager and books. They only depend on the BookObserver interface.
Extensibility: New types of observers can be added without modifying existing code.
Real-time Updates: Users receive immediate updates when a book's status changes.


2. Strategy Pattern:

   
Purpose:
The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. It allows the client to choose the appropriate algorithm at runtime.The Strategy pattern is used to implement for encapsulates the borrowing behaviors of users with different borrowing strategies (regular user, premium user). It allows the borrowing logic to vary independently from users, making it easy to introduce new strategies in the future.

Implementation:
BorrowingStrategy Interface:
Declares the borrowBook(User user, Book book) method.

RegularUserStrategy and PremiumUserStrategy Classes:
Implement the BorrowingStrategy interface, providing different algorithms for book borrowing.

LibraryManager Class:
Reference to a BorrowingStrategy and delegates the borrowBook operation to it.

Benefits:
Flexibility: The borrowing strategy can be easily changed or extended without modifying the library manager.
Encapsulation: Each borrowing strategy is encapsulated, making it easy to understand and maintain.
Dynamic Behavior: Strategies can be switched at runtime based on user types.


3. Singleton Pattern:

   
Purpose:
The Singleton Pattern ensures a class has only one instance and provides a global point of access to that instance. Singleton Pattern is used to implement for provide single-point control of library management by creating a single Library Manager instance.

Implementation:
LibraryManager Class:
The class is designed as a singleton with a private constructor and a static method getInstance() to return the single instance.
The instance is created land subsequent calls to getInstance() return the existing instance.

Benefits:
Single Point of Control: Guarantees only one library manager instance, preventing conflicting states.
Global Access: Provides a global point of access to the library manager, simplifying communication.


