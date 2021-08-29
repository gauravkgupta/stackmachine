package com.stack.command;

import java.util.Optional;

import com.stack.Stack;

public interface StackOperation<T, K> {
	
	/**
	 * Performs operation on stack by using the stackValue if needed.
	 * If the operation cannot be performed and instruction is ignored 
	 * then return empty undo list. 
	 * @param stack Stack to carry the operation on.
	 * @param stackValue value to be used.
	 * @return Data that can undo this operation.
	 */
	Optional<K> performOperation(Stack<T> stack, Optional<T> stackValue);

}
