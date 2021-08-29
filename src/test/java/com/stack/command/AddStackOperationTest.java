package com.stack.command;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import com.stack.Stack;
import com.stack.StackImpl;
import com.stack.beans.DecimalStackUndo;

public class AddStackOperationTest {

	private Stack<BigDecimal> stack;
	private StackOperation<BigDecimal, DecimalStackUndo> addStackOperation = new AddStackOperation();

	@Before
	public void setUp() throws Exception {
		stack = new StackImpl<BigDecimal>();
	}


	@Test
	public void testAdd() {
		stack.push(BigDecimal.ONE);
		stack.push(BigDecimal.TEN);
		addStackOperation.performOperation(stack, Optional.empty());
		assertEquals("11", stack.top().get().toPlainString());
	}

	@Test
	public void testIgnoreOperation() {
		stack.push(BigDecimal.TEN);
		addStackOperation.performOperation(stack, Optional.empty());
		assertEquals("10", stack.top().get().toPlainString());
	}
}
