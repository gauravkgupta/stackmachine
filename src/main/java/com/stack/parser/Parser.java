package com.stack.parser;

import com.stack.exception.InputValidationException;

/**
 * Interface to define methods to parse and value. Implementations can define the logic. 
 *
 * @param <T>
 * @param <K>
 */
public interface Parser<T, K> {

	K parse(T value) throws InputValidationException;
}
