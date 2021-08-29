package com.stack.util;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.stack.command.Command;

public class CommandUtil {

	public static boolean isPushCommand(String command) {
		return Command.PUSH.name().equalsIgnoreCase(command);

	}
	
	public static boolean isDecimalNumber(String command) {
		return NumberUtils.isCreatable(command);
	}
	

	public static boolean isValidCommand(String string) {
		return EnumUtils.isValidEnum(Command.class, string.toUpperCase());
//		return Arrays.stream(Command.values()).anyMatch(e -> e.name().equalsIgnoreCase(string));
	}	
}
