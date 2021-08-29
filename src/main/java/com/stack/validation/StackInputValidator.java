package com.stack.validation;

import static com.stack.util.CommandUtil.isDecimalNumber;
import static com.stack.util.CommandUtil.isPushCommand;
import static com.stack.util.CommandUtil.isValidCommand;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.stack.exception.InputValidationException;
import com.stack.util.CommonConstants;

/**
 * Validator to validate inputs for stack machine. 
 *
 */
public class StackInputValidator implements Validator<String> {
	
	private static final Logger logger = LoggerFactory.getLogger(StackInputValidator.class);
	
	public void validate(String input) throws InputValidationException {
		validateNullInput(input);
		validateNonNullInput(input);
	}

	private void validateNullInput(String input) throws InputValidationException {
		if (StringUtils.isBlank(input)) {
			String message = String.format(CommonConstants.ERROR_INVALID_COMMAND, input);
			 InputValidationException exception = new InputValidationException(message);
			 logger.error(message, exception);
			 throw exception;
		}
	}

	private void validateNonNullInput(String input) throws InputValidationException {
		String[] values = input.split(CommonConstants.SPACE);
		switch (values.length) {
			case 1: validateSingleValue(values[0]);
					break;
					
			case 2: validateTwoValues(values);
			
					break;
					
			default: String message = String.format(CommonConstants.ERROR_INVALID_NUMBER_ARGS, input);
					 InputValidationException exception = new InputValidationException(message);
					 logger.error(message, exception);
					 throw exception;
		}
	}

	private void validateTwoValues(String[] values) throws InputValidationException {
		if (!isPushCommand(values[0]) || !isDecimalNumber(values[1])) {
			String message = String.format(CommonConstants.ERROR_INVALID_PUSH_COMMAND, values[0]);
			InputValidationException exception = new InputValidationException(message);
			logger.error(message, exception);
			throw exception;
		}
	}

	private void validateSingleValue(String value) throws InputValidationException {
		if ( ( !isValidCommand(value) && !isDecimalNumber(value))
				|| (isPushCommand(value))) {
			String message = String.format(CommonConstants.ERROR_INVALID_COMMAND, value);
			InputValidationException exception = new InputValidationException(message);
			logger.error(message, exception);
			throw exception;
		}
	}
}
