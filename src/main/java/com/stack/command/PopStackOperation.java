package com.stack.command;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stack.Stack;
import com.stack.beans.DecimalStackUndo;

public class PopStackOperation implements StackOperation<BigDecimal, DecimalStackUndo> {

	private static final Logger logger = LoggerFactory.getLogger(PopStackOperation.class);
	
	/**
	 * Performs POP operation and returns data that can do this operation.
	 */
	@Override
	public Optional<DecimalStackUndo> performOperation(Stack<BigDecimal> stack, Optional<BigDecimal> stackValue) {
		Optional<BigDecimal> popValue = stack.pop();
		if (popValue.isPresent()) {
			return undoData(popValue);
		} else {
			logger.warn("Stack is empty - Ignoring POP.");
		}
		
		return Optional.empty();
	}
	
	private Optional<DecimalStackUndo> undoData(Optional<BigDecimal> value) {
		List<BigDecimal> pushData = new ArrayList<BigDecimal>(2);
		pushData.add(value.get());
		return Optional.of(new DecimalStackUndo(false, pushData));
	}
}
