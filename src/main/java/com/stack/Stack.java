package com.stack;

import java.util.Optional;

/**
 * Generic Interface defining stack methods
 *
 * @param <T>
 */
public interface Stack<T> {

	T push(T element);
	
	Optional<T> pop();
	
	void clear();
	
	void print();
	
	Optional<T> top();
}
