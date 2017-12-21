import static org.junit.Assert.*;
import org.junit.*;

public class Test_1510481 {

	@Test
	public void testPound2Kg() {
		assertTrue(calculator.Celsius2Fahrenheit(40)==104);
	}
	
	@Test
	public void testYesNo() {
		assertTrue(calculator.YesNo("Y")==true);
	}

}
