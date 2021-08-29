package com.stack.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.stack.beans.DecimalStackInput;
import com.stack.command.Command;

public class StackCommandProcessorTest {

	private StackCommandProcessor processor;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;


	@Before
	public void setUp() throws Exception {
		processor = new StackCommandProcessor();
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(originalOut);
	}

	@Test
	public void testPushAndAdd() {
		DecimalStackInput input1 = new DecimalStackInput(Command.PUSH, Optional.of(BigDecimal.ONE));
		boolean process = processor.process(input1);
		assertTrue(process);
		assertEquals("1",  outContent.toString().trim());
		outContent.reset();
		DecimalStackInput input2 = new DecimalStackInput(Command.PUSH, Optional.of(BigDecimal.TEN));
		processor.process(input2);
		assertEquals("10",  outContent.toString().trim());
		outContent.reset();
		DecimalStackInput input3 = new DecimalStackInput(Command.ADD, Optional.empty());
		processor.process(input3);
		assertEquals("11",  outContent.toString().trim());
	}

	@Test
	public void testPushAndMul() {
		DecimalStackInput input1 = new DecimalStackInput(Command.PUSH, Optional.of(BigDecimal.TEN));
		boolean process = processor.process(input1);
		assertTrue(process);
		assertEquals("10",  outContent.toString().trim());
		outContent.reset();
		DecimalStackInput input2 = new DecimalStackInput(Command.PUSH, Optional.of(BigDecimal.TEN));
		processor.process(input2);
		assertEquals("10",  outContent.toString().trim());
		outContent.reset();
		DecimalStackInput input3 = new DecimalStackInput(Command.MUL, Optional.empty());
		processor.process(input3);
		assertEquals("100",  outContent.toString().trim());
	}
}
