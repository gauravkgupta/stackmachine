package com.stack.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import com.stack.Stack;
import com.stack.StackImpl;
import com.stack.beans.DecimalStackUndo;

public class UndoStackOperationTest {

	private Stack<BigDecimal> stack;
	private UndoOperation<BigDecimal, DecimalStackUndo> undoStackOperation = new UndoStackOperation();

	@Before
	public void setUp() throws Exception {
		stack = new StackImpl<BigDecimal>();
	}


	@Test
	public void testUndoAdd() {
		// Current stack : 11
		// Expected Stack after undo 10 1
		List<BigDecimal> pushNumbers = new ArrayList<>();
		DecimalStackUndo undo = new DecimalStackUndo(true, pushNumbers);
		pushNumbers.add(BigDecimal.ONE);
		pushNumbers.add(BigDecimal.TEN);
		stack.push(new BigDecimal("11"));
		undoStackOperation.performUndoOperation(stack, Optional.of(undo));
		assertEquals("10", stack.top().get().toPlainString());
	}

	@Test
	public void testUndoNegate() {
		// Current stack : -10
		// Expected Stack after undo 10
		stack.push(new BigDecimal("-10"));
		List<BigDecimal> pushNumbers = new ArrayList<>();
		pushNumbers.add(BigDecimal.TEN);
		DecimalStackUndo undo = new DecimalStackUndo(true, pushNumbers);
		undoStackOperation.performUndoOperation(stack, Optional.of(undo));
		assertEquals("10", stack.top().get().toPlainString());
	}
	
	@Test
	public void testUndoPush() {
		// Current stack : 10
		// Expected Stack after undo empty
		stack.push(BigDecimal.TEN);
		DecimalStackUndo undo = new DecimalStackUndo(true, Collections.emptyList());
		undoStackOperation.performUndoOperation(stack, Optional.of(undo));
		assertThrows(NoSuchElementException.class, () -> stack.top().get());
	}
	
	@Test
	public void testUndoPop() {
		// Current stack : empty
		// Expected Stack after undo 10
		List<BigDecimal> pushNumbers = new ArrayList<>();
		pushNumbers.add(BigDecimal.TEN);
		DecimalStackUndo undo = new DecimalStackUndo(false, pushNumbers);
		undoStackOperation.performUndoOperation(stack, Optional.of(undo));
		assertEquals("10", stack.top().get().toPlainString());
	}
}
