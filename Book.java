/**
 * A Book is a simple structure containing two Strings: its author and title.
 * These Strings are set on construction and are immutable. 
 * Use getters getAuthor(), getTitle() for access.
 */


public class Book {
	private final String author;
	private final String title;
	
	public Book(String author, String title) {
		this.author = author;
		this.title = title;
	}
	
	/**
	 * Returns this book's author.
	 * @return author the author of the book.
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Returns this book's title.
	 * @return title the title of the book.
	 */
	public String getTitle() {
		return title;
	}
}