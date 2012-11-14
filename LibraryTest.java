import org.junit.*;
import static org.junit.Assert.*;
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
		lib.setMaxBooksPerUser(12);
		assertEquals(12, lib.getMaxBooksPerUser());
	}
	@Test
	public void testsBadMBPU() {
		System.out.println("Max books per user is unchanged for non-positive input");
		lib.setMaxBooksPerUser(-13);
		assertEquals(10, lib.getMaxBooksPerUser());
	}
	@Test
	public void testsGetID() {
		String ac = "Alice Cooper";
		lib.getID(ac);
		assertEquals(0, lib.getID(ac));
		
		String oo = "Ozzy Osbourne";
		lib.getID(oo);
		assertEquals(1, lib.getID(oo));
	}
	@Test
	public void testsBookInteractions() {
		String author = "Kurt Vonnegut";
		String title = "Cat's Cradle";
		lib.addBook(author, title);
		Book takenBook = lib.takeBook(title);
		Book nullBook = lib.takeBook(title);
		assertEquals(author, takenBook.getAuthor());
		assertEquals(title, takenBook.getTitle());
		assertNull(nullBook);
		
		lib.returnBook(takenBook);
		assertNotNull(lib.takeBook(title));
	}
	@Test
	public void testsCounters() {
		assertEquals(1, lib.getReaderCount());
		assertEquals(2, lib.getBookCount());
		assertEquals(3, lib.getBookBorrowedCount());
	}
}