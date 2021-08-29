package com.stack.processor;

import java.math.BigDecimal;
import java.util.Optional;
import com.stack.Stack;
import com.stack.StackImpl;
import com.stack.beans.DecimalStackInput;
import com.stack.beans.DecimalStackUndo;
import com.stack.command.AddStackOperation;
import com.stack.command.ClearStackOperation;
import com.stack.command.Command;
import com.stack.command.InverseStackOperation;
import com.stack.command.MultiplyStackOperation;
import com.stack.command.NegateStackOperation;
import com.stack.command.PopStackOperation;
import com.stack.command.PrintStackOperation;
import com.stack.command.PushStackOperation;
import com.stack.command.StackOperation;
import com.stack.command.UndoOperation;
import com.stack.command.UndoStackOperation;

/**
 * Class to process all the commands that a stack machine can handle.
 * 
 * This class handles unlimited undo of all commands. 
 * .
 */
public class StackCommandAllUndoProcessor implements CommandProcessor<DecimalStackInput> {
	
	private Stack<BigDecimal> stack;
	private StackOperation<BigDecimal, DecimalStackUndo> addStackOperation;
	private StackOperation<BigDecimal, DecimalStackUndo> clearStackOperation;
	private StackOperation<BigDecimal, DecimalStackUndo> invertStackOperation;
	private StackOperation<BigDecimal, DecimalStackUndo> multiplyStackOperation;
	private StackOperation<BigDecimal, DecimalStackUndo> negateStackOperation;
	private StackOperation<BigDecimal, DecimalStackUndo> popStackOperation;
	private StackOperation<BigDecimal, DecimalStackUndo> printStackOperation;
	private StackOperation<BigDecimal, DecimalStackUndo> pushStackOperation;
	private UndoOperation<BigDecimal, DecimalStackUndo> undoStackOperation;
	private Stack<Optional<DecimalStackUndo>> undoStack;

	public StackCommandAllUndoProcessor() {
		stack = new StackImpl<>();
		addStackOperation = new AddStackOperation();
		clearStackOperation = new ClearStackOperation();
		invertStackOperation = new InverseStackOperation();
		multiplyStackOperation = new MultiplyStackOperation();
		negateStackOperation = new NegateStackOperation();
		popStackOperation = new PopStackOperation();
		printStackOperation = new PrintStackOperation();
		pushStackOperation = new PushStackOperation();
		undoStackOperation = new UndoStackOperation();
		undoStack = new StackImpl<>();
	}

	public boolean process(DecimalStackInput input) {
		Command command = input.getCommand();
		Optional<DecimalStackUndo> undoLastCommand;
		switch(command) {
			
			case ADD:   undoLastCommand = addStackOperation.performOperation(stack, Optional.empty());
						printTopOfStack();
						undoStack.push(undoLastCommand);
					    break;
			
			case CLEAR: undoLastCommand = clearStackOperation.performOperation(stack, Optional.empty());
						printTopOfStack();
						undoStack.push(undoLastCommand);
						break;
			
			case INV:   undoLastCommand = invertStackOperation.performOperation(stack, Optional.empty());
						printTopOfStack();
						undoStack.push(undoLastCommand);
						break;
			
			case MUL:   undoLastCommand = multiplyStackOperation.performOperation(stack, Optional.empty());
						printTopOfStack();
						undoStack.push(undoLastCommand);
						break;
			
			case NEG:   undoLastCommand = negateStackOperation.performOperation(stack, Optional.empty());
						printTopOfStack();
						undoStack.push(undoLastCommand);
						break;
			
			case POP:   undoLastCommand = popStackOperation.performOperation(stack, Optional.empty());
						printTopOfStack();
						undoStack.push(undoLastCommand);
						break;
			
			case PRINT: printStackOperation.performOperation(stack, Optional.empty()); 
						break;
				
			case PUSH:  undoLastCommand = pushStackOperation.performOperation(stack, input.getArg());
						printTopOfStack();
						undoStack.push(undoLastCommand);
					    break;

			case QUIT:  return false;

			case UNDO:  undoStackOperation.performUndoOperation(stack, undoStack.pop().get());
						printTopOfStack();
						undoLastCommand = Optional.empty();
						break;

			default:	break;
		
		}
		return true;
	}

	private void printTopOfStack() {
		Optional<BigDecimal> top = stack.top();
		top.ifPresent(System.out::println);
	}
}
