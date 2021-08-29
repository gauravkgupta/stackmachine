package com.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class StackImplTest {

	private Stack<BigDecimal> stack;

	@Before
	public void setUp() throws Exception {
		stack = new StackImpl<BigDecimal>();
	}


	@Test
	public void testPush() {
		stack.push(BigDecimal.ONE);
		stack.push(BigDecimal.TEN);
		assertEquals("10", stack.top().get().toPlainString());
	}

	@Test
	public void testPop() {
		stack.push(BigDecimal.TEN);
		Optional<BigDecimal> pop = stack.pop();
		assertEquals("10", pop.get().toPlainString());
	}
	
	@Test
	public void testClear() {
		stack.push(BigDecimal.ONE);
		stack.push(BigDecimal.TEN);
		stack.clear();
		assertThrows(NoSuchElementException.class, () -> stack.top().get());
	}
}
