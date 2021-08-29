package com.stack.beans;

import java.math.BigDecimal;
import java.util.List;

/**
 * Class to hold the push value and if pop is needed to do undo a command 
 * that stack machine receives.
 *
 */
public class DecimalStackUndo {
	
	private final boolean pop;
	private final List<BigDecimal> pushList;

	public DecimalStackUndo(boolean pop, List<BigDecimal> pushList) {
		this.pop = pop;
		this.pushList = pushList;
	}
	public boolean isPop() {
		return pop;
	}
	public List<BigDecimal> getPushList() {
		return pushList;
	}
}
