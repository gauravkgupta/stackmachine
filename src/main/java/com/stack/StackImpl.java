package com.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

/**
 * Generic implementation of Stack interface.
 *
 * @param <T>
 */
public class StackImpl<T> implements Stack<T> {
	
	private Deque<T> stack;

	public StackImpl() {
		this.stack = new LinkedList<T>();
	}

	public T push(T element) {
		stack.push(element);
		return element;
	}

	public Optional<T> pop() {
		if (!stack.isEmpty()) {
			return Optional.of(stack.pop());
		}
		return Optional.empty();
	}

	public void clear() {
		stack.clear();
	}

	@Override
	public void print() {
		System.out.println(stack);
	}

	@Override
	public Optional<T> top() {
		T top = stack.peekFirst();
		return top == null ? Optional.empty() : Optional.of(top);
	}

}
