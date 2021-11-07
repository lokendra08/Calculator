package com.domain.calc.service;

import com.domain.calc.exception.CalculatorOperandException;
import com.domain.calc.validation.IOperandValidator;

/**
 * service to perform arithmetic operations
 */
public abstract class AirthmaticOperation implements IOperandValidator {

	/**
	 * Returns the result after computation based on actual implementing arithmetic
	 * operation class.
	 * 
	 * @param firstNumber  first operand
	 * @param secondNumber second operands
	 * @return double
	 * @exception CalculatorOperandException
	 */
	public abstract double compute(Double firstNumber, Double secondNumber) throws CalculatorOperandException;
}
