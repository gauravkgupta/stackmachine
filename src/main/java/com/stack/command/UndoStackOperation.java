package com.stack.command;

import java.math.BigDecimal;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.stack.Stack;
import com.stack.beans.DecimalStackUndo;

/**
 * Class uses undo data to perform actions on stack.
 * @author GKG
 *
 */
public class UndoStackOperation implements UndoOperation<BigDecimal, DecimalStackUndo> {

	private static final Logger logger = LoggerFactory.getLogger(ClearStackOperation.class);

	@Override
	public void performUndoOperation(Stack<BigDecimal> stack, Optional<DecimalStackUndo> undoDataOptional) {
		undoDataOptional.ifPresentOrElse((undoData) -> {
			if(undoData.isPop()) {
				stack.pop();
			}
			undoData.getPushList().forEach(element -> stack.push(element));	
		},
        () ->  logger.info("Nothing to undo currenty.") );
		logger.info("Undo Done");
	}
}
