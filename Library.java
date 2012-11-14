

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
	 * @param username.
	 * @return the user's ID.
	 */
	int getID(String username);
		
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
	void setMaxBooksPerUser(int new_max_bpu);
	
	/**
	 * Adds a new book to the list of books in this library.
	 *
	 * @param author - the author of the book to be added
	 * @param title - the title of the book to be added
	 */
	void addBook(String author, String title);
	
	/**
	 * If the book is not taken, marks the book as taken and returns it.
	 * If the book is taken, null is returned.
	 *
	 * @param the title of the book to be taken
	 * @return the book, if not already taken; null otherwise
	 */
	Book takeBook(String title);
	 
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
}