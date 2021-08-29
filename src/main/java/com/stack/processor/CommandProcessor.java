package com.stack.processor;

public interface CommandProcessor<T> {

	boolean process(T input);
}
