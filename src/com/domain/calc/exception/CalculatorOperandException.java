package com.domain.calc.exception;

/**
 * Exception class to hold operand related exceptions
 */
public class CalculatorOperandException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5981912771190716921L;

	/**
	 * Constructs an CalculatorException with no detail message.
	 */
	public CalculatorOperandException() {
	}

	/**
	 * Constructs an CalculatorException with the specified detail message.
	 *
	 * @param message the detail message
	 */
	public CalculatorOperandException(String message) {
		super(message);
	}

}
