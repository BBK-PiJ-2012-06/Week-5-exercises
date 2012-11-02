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
}