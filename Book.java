/**
 * A Book is a simple structure containing two Strings: its author and title.
 * These Strings are set on construction and are immutable. 
 * Use getters getAuthor(), getTitle() for access.
 */


public class Book {
	private final String AUTHOR, TITLE;
	private boolean isTaken;
	
	public Book(String author, String title) {
		this.AUTHOR = author;
		this.TITLE = title;
		isTaken = false;
		User reader = null;
	}
	
	/**
	 * Returns this book's author.
	 * @return author the author of the book.
	 */
	public String getAuthor() {
		return AUTHOR;
	}
	
	/**
	 * Returns this book's title.
	 * @return title the title of the book.
	 */
	public String getTitle() {
		return TITLE;
	}
	
	/**
	 * Returns this book's status in a library.
	 * @return true if book is taken from the library, false if available.
	 */
	public boolean isTaken() {
		return isTaken;
	}
	
	/**
	 * Sets this book to be taken by the given user.
	 * @param the user taking the book.
	 */
	public void setTakenBy(User user) {
		isTaken = true;
		reader = user;
	}
	
	/**
	 * Sets this book to be returned.
	 */
	public void setReturned() {
		isTaken = false;
		reader = null;
	}
	
	/**
	 * Returns the user reading this book.
	 * @return the reading user.
	 */
	public User getReader() {
		return reader;
	}
}