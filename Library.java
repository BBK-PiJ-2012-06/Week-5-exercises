import java.util.Set;

public interface Library {
	/**
	 * @return the name of the library.
	 */
	String getName();
	
	/**
	 * Gets the user's unique ID.
	 * If the user is already registered, their ID is returned.
	 * If the user is not registered, a new ID is returned.
	 *
	 * @param the user.
	 * @return the user's ID.
	 */
	int getID(User user);
		
	/**
	 * Gets the maximum number of books a user can have from the Library
	 * at one time.
	 *
	 * @return the maximum number of books per user.
	 */
	int getMaxBooksPerUser();
	
	/**
	 * Sets the maximum number of books a user can have from the Library
	 * at one time.
	 * For nonsensical input (less than or equal to zero) the maximum number
     * is left unchanged.	 
	 *
	 * @param the new maximum number of books per user (positive non-zero).
	 */
	List<User> setMaxBooksPolicy(int newMaxBooks);
	
	/**
	 * Adds a new book to the list of books in this library.
	 *
	 * @param author - the author of the book to be added
	 * @param title - the title of the book to be added
	 */
	void addBook(String author, String title);
	
	/**
	 * Adds a new book to the list of books in this library.
	 *
	 * @param the book to be added
	 */
	void addBook(Book book);
	
	/**
	 * If the book is not taken, marks the book as taken by the given user 
	 * and returns it.
	 * If the book is taken, null is returned.
	 *
	 * @param title the title of the book to be taken
	 * @param user the user taking the book
	 * @return the book, if not already taken; null otherwise
	 */
	Book takeBook(String title, User user);
	 
	/**
	 * Returns the book to the library, marking it as not taken.
	 *
	 * @param the book to return
	 */
	void returnBook(Book book);
	  
	/**
	 * Returns the number of users registered in this library.
	 *
	 * @return the number of readers
	 */
	int getReaderCount();
	
	/**
	 * Returns the number of books in this library.
	 *
	 * @return the number of books
	 */
	int getBookCount();
	 
	/**
	 * Returns the number of borrowed books in this library.
	 *
	 * @return the number of borrowed books
	 */
	int getBookBorrowedCount();
	  
	/**
	 * Returns a set of all the users that are borrowing books at the moment.
	 *
	 * @return the set of users currently borrowing books
	 */
	Set<User> getBorrowingUsers();
	
	/**
	 * Returns a set of all the users, borrowing or not.
	 *
	 * @return the set of all users
	 */
	Set<User> getUsers();
	
	/**
	 * Returns the user that is borrowing a specific title at the moment;
	 * if nobody is borrowing the book, or the book does not exist in the
	 * library, returns null.
	 *
	 * @return the user borrowing the book
	 */
	User getUserBorrowing(Book book);
}