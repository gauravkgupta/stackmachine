package com.stack.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import com.stack.Stack;
import com.stack.StackImpl;
import com.stack.beans.DecimalStackUndo;

public class InvertStackOperationTest {

	private Stack<BigDecimal> stack;
	private StackOperation<BigDecimal, DecimalStackUndo> stackOperation = new InverseStackOperation();

	@Before
	public void setUp() throws Exception {
		stack = new StackImpl<BigDecimal>();
	}

	@Test
	public void testPop() {
		stack.push(BigDecimal.TEN);
		stackOperation.performOperation(stack, Optional.empty());
		assertEquals("0.1000", stack.top().get().toPlainString());
	}

	@Test
	public void testIgnoreOperation() {
		stackOperation.performOperation(stack, Optional.empty());
		assertThrows(NoSuchElementException.class, () -> stack.top().get());
	}
}
