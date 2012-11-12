import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class LibraryImp implements Library {
	private final String NAME;
	private static final int DEFAULT_MAX_BPU = 10;
	private int maxBooksPerUser;
	private Map<String, Integer> userMap = new HashMap<String, Integer>();
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
	public void setMaxBooksPerUser(int new_max_bpu) {
		if( new_max_bpu > 0 )
			maxBooksPerUser = new_max_bpu;
	}
	
	@Override
	public int getID(String username) {
		if( userMap.containsKey(username) )
			return userMap.get(username);
		userMap.put(username, nextID);
		return nextID++;
	}
	
	@Override
	public void addBook(String author, String title) {
		Book newBook = new Book(author, title);
		
		if(!bookMap.containsKey(title)) {
			List addList = new LinkedList<Book>();
			addList.add(newBook);
			bookMap.put(title, addList);
		}
		else {
			bookMap.get(title).add(newBook);
		}
	}
	
	@Override
	public Book takeBook(String title) {
		List<Book> booksRequested = bookMap.get(title);
		if(booksRequested == null) {
			return null;
		}
		
		for(Book testBook : booksRequested) {
			if(!testBook.isTaken()) {
				testBook.setTaken(true);
				return testBook;
			}
		}
		
		return null;
	}
	
	@Override
	public void returnBook(Book book) {
		List<Book> books_with_this_title = bookMap.get(title);
		book.setReturned();
		
		// If the library doesn't have the book, it'll take it as a dontation...
		if(books_with_this_title == null) {
			books_with_this_title = new LinkedList<Book>;
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
}