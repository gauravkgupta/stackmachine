package com.stack.command;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stack.Stack;
import com.stack.beans.DecimalStackUndo;

public class NegateStackOperation implements StackOperation<BigDecimal, DecimalStackUndo> {

	private static final Logger logger = LoggerFactory.getLogger(NegateStackOperation.class);
	
	/**
	 * Performs NEG operation and returns data that can do this operation.
	 */
	@Override
	public Optional<DecimalStackUndo> performOperation(Stack<BigDecimal> stack, Optional<BigDecimal> stackValue) {
		Optional<BigDecimal> value = stack.pop();
		if (value.isPresent()) {
			BigDecimal result = value.get().negate();
			stack.push(result);
			return undoData(value);
		} else {
			logger.warn("Invalid Operation ignoring NEG.");
		}
		
		return Optional.empty();
	}
	
	private Optional<DecimalStackUndo> undoData(Optional<BigDecimal> value) {
		List<BigDecimal> pushData = new ArrayList<BigDecimal>(2);
		pushData.add(value.get());
		return Optional.of(new DecimalStackUndo(true, pushData));
	}
}
