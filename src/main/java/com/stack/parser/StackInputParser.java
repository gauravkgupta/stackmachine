package com.stack.parser;

import java.math.BigDecimal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stack.beans.DecimalStackInput;
import com.stack.command.Command;
import com.stack.exception.InputValidationException;
import com.stack.util.CommandUtil;
import com.stack.util.CommonConstants;
import com.stack.validation.StackInputValidator;
import com.stack.validation.Validator;

/**
 * Class to define the logic for parsing the input to stack machine. 
 *
 */
public class StackInputParser implements Parser<String, DecimalStackInput> {

	private static final Logger logger = LoggerFactory.getLogger(StackInputParser.class);
	private Validator<String> validator = new StackInputValidator();

	public DecimalStackInput parse(String input) throws InputValidationException {
		
		DecimalStackInput decimalInput;
		validator.validate(input);
		String[] values = input.split(CommonConstants.SPACE);
		switch (values.length) {
			case 1: if(CommandUtil.isDecimalNumber(values[0])) {
						BigDecimal number = new BigDecimal(values[0]);
						decimalInput = new DecimalStackInput(Command.PUSH, Optional.of(number));
					} else {
						decimalInput = new DecimalStackInput(Command.valueOf(values[0].toUpperCase()), Optional.empty());
					}
					break;
					
			case 2: BigDecimal number = new BigDecimal(values[1]);
					decimalInput = new DecimalStackInput(Command.valueOf(values[0].toUpperCase()), Optional.of(number));
					break;
					
			default: String message = String.format(CommonConstants.ERROR_INVALID_NUMBER_ARGS, values[0]);
					 InputValidationException exception = new InputValidationException(message);
					 logger.error(message, exception);
					 throw exception;
		}

		return decimalInput;
	}
}

