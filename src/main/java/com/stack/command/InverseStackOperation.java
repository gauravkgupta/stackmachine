package com.stack.command;

import static com.stack.util.CommonConstants.SCALE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stack.Stack;
import com.stack.beans.DecimalStackUndo;

public class InverseStackOperation implements StackOperation<BigDecimal, DecimalStackUndo> {

	private static final Logger logger = LoggerFactory.getLogger(InverseStackOperation.class);
	
	/**
	 * Performs INV operation and returns data that can do this operation.
	 */
	@Override
	public Optional<DecimalStackUndo> performOperation(Stack<BigDecimal> stack, Optional<BigDecimal> stackValue) {
		Optional<BigDecimal> value = stack.pop();
		if (value.isPresent()) {
			try {
				BigDecimal result = BigDecimal.ONE.divide(value.get(), SCALE, RoundingMode.HALF_UP);
				stack.push(result);
				return undoData(value);
			} catch (ArithmeticException e) {
				e.printStackTrace();
				logger.warn("Operation canot be performed- ignoring command INV.");
				stack.push(value.get());
			}
		} else {
			logger.warn("Invalid Operation as Stack is Empty ignoring INV.");
		}
		
		return Optional.empty();
	}
	
	private Optional<DecimalStackUndo> undoData(Optional<BigDecimal> value) {
		List<BigDecimal> pushData = new ArrayList<BigDecimal>(2);
		pushData.add(value.get());
		return Optional.of(new DecimalStackUndo(true, pushData));
	}
}
