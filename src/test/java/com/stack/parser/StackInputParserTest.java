package com.stack.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;
import com.stack.beans.DecimalStackInput;
import com.stack.command.Command;
import com.stack.exception.InputValidationException;

public class StackInputParserTest {

	private StackInputParser parser = new StackInputParser();


	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPush() {
		DecimalStackInput input = null;
		try {
			input = parser.parse("PUSH 1");
		} catch (InputValidationException e) {
			fail("Unexpected Exception");
		}
		assertEquals(Command.PUSH, input.getCommand());
		assertEquals("1", input.getArg().get().toPlainString());
	}
	
	@Test
	public void testPushWithoutCommand() {
		DecimalStackInput input = null;
		try {
			input = parser.parse("1");
		} catch (InputValidationException e) {
			fail("Unexpected Exception");
		}
		assertEquals(Command.PUSH, input.getCommand());
		assertEquals("1", input.getArg().get().toPlainString());
	}
	
	@Test
	public void testAdd() {
		try {
			DecimalStackInput input = parser.parse("ADD");
			assertEquals(Command.ADD, input.getCommand());
			assertThrows(NoSuchElementException.class, () -> input.getArg().get());
		} catch (InputValidationException e) {
			fail("Unexpected Exception");
		}
	}	
}
