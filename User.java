/**
 * The User class represents a user of a library. Each has to have a 
 * unique name and ID number.
 * These user's name is set on construction, the ID number later. 
 * Use getters getName(), getID(), and setID(int id) for access.
 */


public class User {
	private final String name;
	private int id = -1;
	private Library lib;
	
	public User(String name) {
		this.name = name;
		lib = null;
	}
	
	/**
	 * Returns this user's name.
	 * @return name the name of the user.
	 */
	public String getName() {
		return name;
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
		id = lib.getID(name);
	}
	
	/**
	 * Returns a pointer to the library to which this user is registered.
	 * @return the user's registered library.
	 */
	public Library getLibrary() {
		return lib;
	}
}