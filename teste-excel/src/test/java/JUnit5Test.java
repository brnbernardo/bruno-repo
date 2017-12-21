import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class JUnit5Test {

	int expected = 4;
	int actual = 2 + 2;
	Object nullValue = null;

	@Test
	@DisplayName("My First Test")
	void myFirstTest(TestInfo testInfo) {
		NumericCalculator calculator = new NumericCalculator();
		Assertions.assertEquals(4, calculator.add(2, 2), "1 + 1 = 5");
		Assertions.assertEquals("My First Test", testInfo.getDisplayName(), () -> "TestInfo is injected correctly");
	}

	@Test
	void exceptionTesting() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			throw new IllegalArgumentException("a message");
		});
		assertEquals("a message", exception.getMessage());
		assertAll("Assert All of these", () -> assertEquals(expected, actual, "INCONCEIVABLE!"),
				() -> assertFalse(nullValue != null), () -> assertNull(nullValue),
				() -> assertNotNull("A String", "INCONCEIVABLE!"),
				() -> assertTrue(nullValue == null));
	}

	@Test
	@DisplayName("This test is only run on Fridays")
	public void testAdd_OnlyOnFriday() {
	  LocalDateTime ldt = LocalDateTime.now();
	  assumeTrue(ldt.getDayOfWeek().getValue() == 4);
	  // Remainder of test (only executed if assumption holds)...
	}
	
}
