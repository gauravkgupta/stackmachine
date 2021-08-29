package com.stack.validation;

import com.stack.exception.InputValidationException;

/**
 * Interface to define methods for validation. 
 *
 * @param <T>
 */
public interface Validator<T> {

	void validate(T input) throws InputValidationException;
}
