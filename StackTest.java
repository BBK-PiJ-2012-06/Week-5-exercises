import org.junit.*;
import static org.junit.Assert.*;
public class StackTest {
	@Test
	public void testsEmptyArrayStack() {
		StringStack stack = new ArrayStringStack();
		assertEquals(null, stack.pop());
		assertEquals(null, stack.peek());
		assertEquals(true, stack.isEmpty());
	}
	@Test
	public void testsEmptyPointerStack() {
		StringStack stack = new PointerStringStack();
		assertEquals(null, stack.pop());
		assertEquals(null, stack.peek());
		assertEquals(true, stack.isEmpty());
	}
	@Test
	public void testsFullArrayStack() {
		StringStack stack = new ArrayStringStack();
		String str1 = "First";
		String str2 = "Second";
		String str3 = "Third";
		
		stack.push(str1);
		stack.push(str2);
		stack.push(str3);
		
		assertEquals( str3, stack.peek() );
		assertEquals( str3, stack.pop() );
		assertEquals( str2, stack.peek() );
		assertEquals( str2, stack.pop() );
		assertEquals( str1, stack.peek() );
		assertEquals( str1, stack.pop() );
	}
	@Test
	public void testsFullPointerStack() {
		StringStack stack = new ArrayStringStack();
		String str1 = "First";
		String str2 = "Second";
		String str3 = "Third";
		
		stack.push(str1);
		stack.push(str2);
		stack.push(str3);
		
		assertEquals( str3, stack.peek() );
		assertEquals( str3, stack.pop() );
		assertEquals( str2, stack.peek() );
		assertEquals( str2, stack.pop() );
		assertEquals( str1, stack.peek() );
		assertEquals( str1, stack.pop() );
	}
}
