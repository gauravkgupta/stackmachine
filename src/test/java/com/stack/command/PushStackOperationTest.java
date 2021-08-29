package com.stack.command;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import com.stack.Stack;
import com.stack.StackImpl;
import com.stack.beans.DecimalStackUndo;

public class PushStackOperationTest {

	private Stack<BigDecimal> stack;
	private StackOperation<BigDecimal, DecimalStackUndo> stackOperation = new PushStackOperation();

	@Before
	public void setUp() throws Exception {
		stack = new StackImpl<BigDecimal>();
	}

	@Test
	public void testPush1Element() {
		stackOperation.performOperation(stack, Optional.of(BigDecimal.ONE));
		assertEquals("1", stack.top().get().toPlainString());
	}

	@Test
	public void testPush2Elements() {
		stackOperation.performOperation(stack, Optional.of(BigDecimal.ONE));
		stackOperation.performOperation(stack, Optional.of(BigDecimal.TEN));
		assertEquals("10", stack.top().get().toPlainString());
	}
}
