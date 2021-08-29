package com.stack.command;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import com.stack.Stack;
import com.stack.StackImpl;
import com.stack.beans.DecimalStackUndo;

public class MultiplyStackOperationTest {

	private Stack<BigDecimal> stack;
	private StackOperation<BigDecimal, DecimalStackUndo> multiplyStackOperation = new MultiplyStackOperation();

	@Before
	public void setUp() throws Exception {
		stack = new StackImpl<BigDecimal>();
	}


	@Test
	public void testMultiply() {
		stack.push(BigDecimal.ONE);
		stack.push(BigDecimal.TEN);
		multiplyStackOperation.performOperation(stack, Optional.empty());
		assertEquals("10", stack.top().get().toPlainString());
	}

	@Test
	public void testIgnoreOperation() {
		stack.push(BigDecimal.TEN);
		multiplyStackOperation.performOperation(stack, Optional.empty());
		assertEquals("10", stack.top().get().toPlainString());
	}
}
