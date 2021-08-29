package com.stack.validation;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import org.junit.Test;
import com.stack.exception.InputValidationException;

public class StackInputValidatorTest {

	private StackInputValidator validator = new StackInputValidator();

	@Test
	public void testPush() {
		try {
			validator.validate("PUSH 1");
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}
	
	@Test
	public void testPushWithoutCommand() {
		try {
			assertThrows(InputValidationException.class, () -> validator.validate("PUSH"));
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}
	
	@Test
	public void testAdd() {
		try {
			validator.validate("ADD");
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}	
}
