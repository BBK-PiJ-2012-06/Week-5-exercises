/**
 * The User class represents a user of a library. Each has to have a 
 * unique name and ID number, plus a list of books they are currently borrowing.
 * These user's name is set on construction, the ID number later. 
 * Use methods getName(), getID(), setID(int id), getBooksBorrowed(), borrows(Book bk) for access.
 */

import java.util.List;
import java.util.LinkedList;

public class User {
	private final String NAME;
	private int id = -1;
	private Library lib;
	private LinkedList<Book> borrowed;
	
	public User(String name) {
		this.NAME = name;
		lib = null;
		borrowed = new LinkedList<Book>();
	}
	
	/**
	 * Returns this user's name.
	 * @return name the name of the user.
	 */
	public String getName() {
		return NAME;
	}
	
	/**
	 * Returns this user's ID number, or -1 if not set.
	 * @return id the ID of the user.
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Sets this user's ID number.
	 * @param id the ID to be assigned to the user.
	 */
	public void setID(int id) {
		if(id < 0)
			this.id = -1;
		else
			this.id = id;
	}
	
	/**
	 * Registers this user with a library, and assigns them an ID number.
	 * @param the library to be registered with.
	 */
	public void register(Library lib) {
		this.lib = lib;
		id = lib.getID(this);
	}
	
	/**
	 * Returns a pointer to the library to which this user is registered.
	 * @return the user's registered library.
	 */
	public Library getLibrary() {
		return lib;
	}
	
	/**
	 * Returns a list of books currently borrowed by the user.
	 * @return the list of books borrowed.
	 */
	public LinkedList<Book> getBooksBorrowed() {
		return borrowed;
	}
	
	/**
	 * Adds a book to the list of books borrowed by the user.
	 * @param the book being borrowed.
	 */
	public void borrows(Book bk) {
		if(bk == null)
			return;
		borrowed.add(bk);
	}
	
	/**
	 * Removes a book from the list of books borrowed.
	 * @param the book to return to the library.
	 */
	public void returns(Book bk) {
		if(borrowed.contains(bk))
			borrowed.remove(bk);
	}
}