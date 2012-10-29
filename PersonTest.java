import org.junit.*;
import static org.junit.Assert.*;
public class PersonTest {
	@Test
	public void testsNormalName() {
		Person p = new Person();
		String input = "Dereck Robert Yssirt";
		String output = p.getInitials(input);
		String expected = "DRY";
		assertEquals(output, expected);
	}
	@Test
	public void testsBadName() {
		Person p = new Person();
		String input = " Jeremy David  Walker";
		String output = p.getInitials(input);
		String expected = "JDW";
		assertEquals(output, expected);
	}
}