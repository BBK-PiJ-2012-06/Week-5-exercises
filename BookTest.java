import org.junit.*;
import static org.junit.Assert.*;
public class BookTest {
	private Book book;
	@Before
	public void buildUp() {
		book = new Book("Charles Dickens","Great Expectations");
	}
	@After
	public void cleanUp() {
		book = null;
	}
	@Test
	public void testsGetters() {
		assertEquals("Charles Dickens", book.getAuthor());
		assertEquals("Great Expectations", book.getTitle());		
	}
}