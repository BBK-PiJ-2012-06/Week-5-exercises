import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class LibraryImp implements Library {
	private final String NAME;
	private static final int DEFAULT_MAX_BPU = 10;
	private int maxBooksPerUser;
	private Map<User, Integer> userMap = new HashMap<User, Integer>();
	private Map<String, List<Book>> bookMap = new HashMap<String, List<Book>>();
	private int nextID = 0;
	
	public LibraryImp(String name) {
		this.NAME = name;
		this.maxBooksPerUser = DEFAULT_MAX_BPU;
	}
	
	@Override
	public String getName() {
		return NAME;
	}
	
	@Override
	public int getMaxBooksPerUser() {
		return maxBooksPerUser;
	}
	
	@Override
	public List<User> setMaxBooksPolicy(int new_max_bpu) {
		if( new_max_bpu > 0 )
			maxBooksPerUser = new_max_bpu;
		List<User> violatingUsers = new LinkedList<User>;
		for(User testUser : userMap.keySet()) {
			if(testUser.getBooksBorrowed().size() > maxBooksPerUser) {
				violatingUsers.add(testUser);
			}
		}
		return violatingUsers;
	}
	
	@Override
	public int getID(User user) {
		if( userMap.containsKey(user) )
			return userMap.get(user);
		userMap.put(user, nextID);
		return nextID++;
	}
	
	@Override
	public void addBook(String author, String title) {
		Book newBook = new Book(author, title);
		
		if(!bookMap.containsKey(title)) {
			List<Book> addList = new LinkedList<Book>();
			addList.add(newBook);
			bookMap.put(title, addList);
		}
		else {
			bookMap.get(title).add(newBook);
		}
	}
	
	@Override
	public void addBook(Book book) {
		addBook(book.getAuthor(), book.getTitle());
	}
	
	@Override
	public Book takeBook(String title, User user) {
		if(!userMap.containsKey(user)) {
			System.out.println("User " + user.getName() + " is not registered!");
			return null;
		}
		List<Book> booksRequested = bookMap.get(title);
		if(booksRequested == null) {
			return null;
		}
		
		for(Book testBook : booksRequested) {
			if(!testBook.isTaken()) {
				testBook.setTakenBy(user);
				user.borrows(testBook);
				return testBook;
			}
		}
		
		return null;
	}
	
	@Override
	public void returnBook(Book book) {
		List<Book> books_with_this_title = bookMap.get(book.getTitle());
		book.getReader().returns(book);
		book.setReturned();
		
		// If the library doesn't have the book, it'll take it as a dontation...
		if(books_with_this_title == null) {
			books_with_this_title = new LinkedList<Book>();
			books_with_this_title.add(book);
			bookMap.put(book.getTitle(), books_with_this_title);
		} else {
			for(Book testBook : books_with_this_title) {
				if(testBook == book) {
					return;
				}
			}
			books_with_this_title.add(book);
		}
	}
	
	@Override
	public int getReaderCount() {
		return userMap.size();
	}
	
	@Override
	public int getBookCount() {
		int bookCount = 0;
		if(bookMap.size() == 0) {
			return 0;
		}
		for(List<Book> currentTitle : bookMap.values()) {
			bookCount += currentTitle.size();
		}
		return bookCount;
	}
	 
	@Override
	public int getBookBorrowedCount() {
		int borrowedCount = 0;
		if(bookMap.size() == 0) {
			return 0;
		}
		for(List<Book> currentTitle : bookMap.values()) {
			for(Book currentBk : currentTitle) {
				if(currentBk.isTaken()) {
					borrowedCount++;
				}
			}
		}
		return borrowedCount;
	}
	
	@Override
	public Set<User> getBorrowingUsers() {
		Set<User> usersBorrowing = new HashSet<User>();
		for(User testUser : userMap.keySet()) {
			if(testUser.getBooksBorrowed().size() > 0) {
				usersBorrowing.add(testUser);
			}
		}
		return usersBorrowing;
	}
	
	@Override
	public Set<User> getUsers() {
		return userMap.keySet();
	}
	
	@Override
	public User getUserBorrowing(Book book) {
		List<Book> bk_lst = bookMap.get(book.getTitle());
		for(Book testBook : bk_lst) {
			if(testBook == book) {
				return book.getReader();
			}
		}
		return null;
	}
}