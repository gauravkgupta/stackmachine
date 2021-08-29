package com.stack.command;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stack.Stack;
import com.stack.beans.DecimalStackUndo;

/**
 * Class to handle ADD command. 
 *
 */
public class AddStackOperation implements StackOperation<BigDecimal, DecimalStackUndo> {

	private static final Logger logger = LoggerFactory.getLogger(AddStackOperation.class);
	
	/**
	 * Performs ADD operation and returns data that can do this operation.
	 */
	@Override
	public Optional<DecimalStackUndo> performOperation(Stack<BigDecimal> stack, Optional<BigDecimal> stackValue) {
		
		Optional<BigDecimal> value1 = stack.pop();
		if (value1.isPresent()) {
			Optional<BigDecimal> value2 = stack.pop();
			if (value2.isPresent()) {
				BigDecimal result = value1.get().add(value2.get());
				stack.push(result);
				return undoData(value1, value2);
			} else {
				logger.warn("Invalid Operation only 1 value in stack - Ignoring ADD.");
				stack.push(value1.get());
			}
		} else {
			logger.warn("Invalid Operation - Ignoring ADD.");
		}
		
		return Optional.empty();
	}

	private Optional<DecimalStackUndo> undoData(Optional<BigDecimal> value1, Optional<BigDecimal> value2) {
		List<BigDecimal> pushData = new ArrayList<BigDecimal>(2);
		pushData.add(value2.get());
		pushData.add(value1.get());
		return Optional.of(new DecimalStackUndo(true, pushData));
	}
}
