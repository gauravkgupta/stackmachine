package com.stack.command;

import java.math.BigDecimal;
import java.util.Optional;
import com.stack.Stack;
import com.stack.beans.DecimalStackUndo;

public class PrintStackOperation implements StackOperation<BigDecimal, DecimalStackUndo> {
	
	/**
	 * Prints the contents of stack. Undo is ignored for this. 
	 */
	@Override
	public Optional<DecimalStackUndo> performOperation(Stack<BigDecimal> stack, Optional<BigDecimal> stackValue) {
		stack.print();
		return Optional.empty();
	}
}
