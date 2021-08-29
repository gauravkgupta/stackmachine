package com.stack.processor;

import java.util.Scanner;
import com.stack.beans.DecimalStackInput;
import com.stack.exception.InputValidationException;
import com.stack.parser.Parser;
import com.stack.parser.StackInputParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * StackMachine which accepts inputs and processes them on a decimal stack implementation.
 *
 */
public class StackMachine {
	
	private static final Logger logger = LoggerFactory.getLogger(StackMachine.class);
	
	public static void main(String[] args) {
		logger.info("Stack Machine Started");
		
		CommandProcessor<DecimalStackInput> processor = new StackCommandProcessor();
		
		Scanner scanner = new Scanner(System.in);
		boolean continueProcess = true;
		while(continueProcess) {
			String input = scanner.nextLine();
			
			Parser<String, DecimalStackInput> parser = new StackInputParser();
			try {
				DecimalStackInput validatedInput = parser.parse(input);
				continueProcess = processor.process(validatedInput);
			} catch (InputValidationException e) {
				logger.info("Invalid Command - Ignored " + input);
			}
		}
		logger.info("Stack Machine Closed");
		scanner.close();
	}
}
