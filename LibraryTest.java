import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.LinkedList;

public class LibraryTest {
	Library lib;
	@Before
	public void buildUp() {
		lib = new LibraryImp("Test library");		
	}
	@After
	public void cleanUp() {
		lib = null;
	}
	@Test
	public void testsGetters() {
		assertEquals("Test library", lib.getName());
		assertEquals(10, lib.getMaxBooksPerUser());		
	}
	@Test
	public void testsSetters() {
		lib.setMaxBookPolicy(12);
		assertEquals(12, lib.getMaxBooksPerUser());
	}
	@Test
	public void testsBadMBPU() {
		System.out.println("Max books per user is unchanged for non-positive input");
		lib.setMaxBookPolicy(-13);
		assertEquals(10, lib.getMaxBooksPerUser());
	}
	@Test
	public void testsGetID() {
		User ac = new User("Alice Cooper");
		lib.getID(ac);
		assertEquals(0, lib.getID(ac));
		
		User oo = new User("Ozzy Osbourne");
		lib.getID(oo);
		assertEquals(1, lib.getID(oo));
	}
	@Test
	public void testsBookInteractions() {
		String author = "Kurt Vonnegut";
		String title = "Cat's Cradle";
		User ac = new User("Alice Cooper");
		lib.getID(ac);
		lib.addBook(author, title);
		Book takenBook = lib.takeBook(title, ac);
		Book nullBook = lib.takeBook(title, ac);
		assertEquals(author, takenBook.getAuthor());
		assertEquals(title, takenBook.getTitle());
		assertNull(nullBook);
		
		lib.returnBook(takenBook);
		assertNotNull(lib.takeBook(title, ac));
	}
	@Test
	public void testsCounters() {
		User ac = new User("Alice Cooper");
		lib.getID(ac);
		User oo = new User("Ozzy Osbourne");
		lib.getID(oo);
		assertEquals(2, lib.getReaderCount());
		
		String author1 = "Kurt Vonnegut";
		String title1 = "Cat's Cradle";
		lib.addBook(author1, title1);
		lib.addBook(author1, title1);
		String author2 = "Charles Dickens";
		String title2 = "Great Expectations";
		lib.addBook(author2, title2);
		assertEquals(3, lib.getBookCount());
		
		Book takenBook = lib.takeBook(title1, ac);
		assertEquals(1, lib.getBookBorrowedCount());
		lib.returnBook(takenBook);
		assertEquals(0, lib.getBookBorrowedCount());
	}
	@Test
	public void testsUserMethods() {
		User ac = new User("Alice Cooper");
		lib.getID(ac);
		User oo = new User("Ozzy Osbourne");
		lib.getID(oo);
		String author1 = "Kurt Vonnegut";
		String title1 = "Cat's Cradle";
		lib.addBook(author1, title1);
		lib.addBook(author1, title1);
		String author2 = "Charles Dickens";
		String title2 = "Great Expectations";
		Book book2 = new Book(author2, title2);
		lib.addBook(book2);
		Book takenBook = lib.takeBook(title1, ac);
		
		assertTrue(lib.getUsers().contains(ac));
		assertTrue(lib.getUsers().contains(oo));
		assertTrue(lib.getBorrowingUsers().contains(ac));
		assertSame(lib.getUserBorrowing(takenBook), ac);
		assertNull(lib.getUserBorrowing(book2));
	}
	@Test
	public void testsMaxBookPolicy() {
		User john = new User("John Smith");
		User dave = new User("Dave Jones");
		lib.getID(john);
		lib.getID(dave);
		assertEquals(0, lib.setMaxBookPolicy(2).size());
		
		Book b1 = new Book("author1", "title1");
		Book b2 = new Book("author2", "title2");
		
		lib.takeBook("title1", john);
		lib.takeBook("title2", john);
		assertEquals(0, lib.setMaxBookPolicy(2).size());
		
		List<User> badUsers = new LinkedList<User>;
		badUsers = lib.setMaxBookPolicy(1);
		
		assertEquals(1, badUsers.size());
		assertTrue(badUsers.contains(john));
	}
}