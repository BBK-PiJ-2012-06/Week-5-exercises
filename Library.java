

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
	
	
}