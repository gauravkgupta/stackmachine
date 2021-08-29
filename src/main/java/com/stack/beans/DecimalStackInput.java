package com.stack.beans;

import java.math.BigDecimal;
import java.util.Optional;

import com.stack.command.Command;

/**
 * Class to hold the inputs that stack machine receives.
 *
 */
public class DecimalStackInput {

	final Command command;
	final Optional<BigDecimal> arg;
	
	public DecimalStackInput(Command command, Optional<BigDecimal> arg) {
		this.command = command;
		this.arg = arg;
	}

	public Command getCommand() {
		return command;
	}

	public Optional<BigDecimal> getArg() {
		return arg;
	}
}
