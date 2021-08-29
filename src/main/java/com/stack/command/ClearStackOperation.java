package com.stack.command;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stack.Stack;
import com.stack.beans.DecimalStackUndo;

public class ClearStackOperation implements StackOperation<BigDecimal, DecimalStackUndo> {

	private static final Logger logger = LoggerFactory.getLogger(ClearStackOperation.class);
	
	/**
	 * Performs CLEAR operation and returns data that can do this operation.
	 */
	@Override
	public Optional<DecimalStackUndo> performOperation(Stack<BigDecimal> stack, Optional<BigDecimal> stackValue) {
		logger.info("Clearing Stack");
		List<BigDecimal> pushData = new ArrayList<BigDecimal>();
		Optional<BigDecimal> top = stack.pop();
		while(! top.isEmpty()) {
			pushData.add(top.get());
			top = stack.pop();
		}
		Collections.reverse(pushData); // reverse to maintain order of stack
		logger.info("Cleared Stack by popping values " + pushData);
		return Optional.of(new DecimalStackUndo(true, pushData));
	}
}
