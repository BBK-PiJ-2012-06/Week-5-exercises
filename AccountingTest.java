import org.junit.*;
import static org.junit.Assert.*;
public class AccountingTest {
	@Test
	public void testsBill() {
		String inputConcept = "one";
		int inputAmount = 1;
		Bill b = new Bill(inputConcept, inputAmount);
		assertEquals(inputConcept, b.getConcept());
		assertEquals(inputAmount, b.getAmount());		
	}
	@Test
	public void testsBillCount() {
		Accounting acc = new Accounting();
		int output = acc.billCount();
		int expected = 2;
		assertEquals(output, expected);
	}
	@Test
	public void testsListLength() {
		Accounting acc = new Accounting();
		int output = acc.listLength();
		int expected = 2;
		assertEquals(expected, output);
	}
	@Test
	public void testsTotalDebt() {
		Accounting acc = new Accounting();
		int output = acc.totalDebt();
		int expected = 3;
		assertEquals(expected, output);
	}
}