import org.junit.*;
import static org.junit.Assert.*;
public class QueueTest {
	@Test
	public void testsBasicFunctionality() {
		PersonQueue q = new PersonQueueImp();
		Person nobody = q.retrieve();
		assertEquals(null, nobody);
		
		Person p1 = new Person( "Bob", 28 );
		q.insert(p1);
		assertSame(p1, q.retrieve());
		
		Person nobodyAgain = q.retrieve();
		assertEquals(null, nobodyAgain);
	}
}