import org.junit.*;
import static org.junit.Assert.*;
public class HashTest {
	@Test
	public void testsShortHash() {
		for( int i = 0; i<2000; i++ ) {
			int testNum = (int) (Math.random() * 100000);
			int output = HashUtilities.shortHash(testNum);
			assertTrue( 0 <= output && output <= 1000 );
		}
	}
	@Test
	public void testsBorders() {
		int outputZero = HashUtilities.shortHash(0);
		assertTrue( 0 <= outputZero && outputZero <= 1000);
		
		int outputThousand = HashUtilities.shortHash(1000);
		assertTrue( 0 <= outputThousand && outputThousand <= 1000 );
	}
}