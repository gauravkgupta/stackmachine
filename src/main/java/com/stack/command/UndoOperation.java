package com.stack.command;

import java.util.Optional;
import com.stack.Stack;

/**
 * Interface to define undo methods. 
 *
 * @param <T>
 * @param <K>
 */
public interface UndoOperation<T, K> {

	void performUndoOperation(Stack<T> stack, Optional<K> undoData);
}
