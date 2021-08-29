package com.stack.command;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import com.stack.Stack;
import com.stack.beans.DecimalStackUndo;

public class PushStackOperation implements StackOperation<BigDecimal, DecimalStackUndo> {

	/**
	 * Performs PUSH operation and returns data that can do this operation.
	 */
	@Override
	public Optional<DecimalStackUndo> performOperation(Stack<BigDecimal> stack, Optional<BigDecimal> stackValue) {
		stack.push(stackValue.get());
		return Optional.of(new DecimalStackUndo(true, Collections.emptyList()));
	}
}
