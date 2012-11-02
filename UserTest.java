import org.junit.*;
import static org.junit.Assert.*;
public class UserTest {
	private User user;
	@Before
	public void buildUp() {
		user = new User("Joe Bloggs");
	}
	@After
	public void cleanUp() {
		user = null;
	}
	@Test
	public void testsGetters() {
		assertEquals("Joe Bloggs", user.getName());
		assertEquals(-1, user.getID());		
	}
	@Test
	public void testsSetters() {
		user.setID(123);
		assertEquals(123, user.getID());
	}
	@Test
	public void testsBadID() {
		user.setID(-13);
		assertEquals(-1, user.getID());
	}
	@Test
	public void testsRegistration() {
		Library lib = new MockLibraryImp();
		user.register(lib);
		assertEquals("Mock library", user.getLibrary().getName());
		assertEquals(13, user.getID());		
	}
}