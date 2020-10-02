package smartcardDemo.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator calculator = new Calculator();

		int a = 123;
		int b = 123;

		int result = calculator.add(a, b);

		int expected = 246;

		assertEquals(expected, result);
	}

}
