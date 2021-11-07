package com.domain.calc.service.impl;

import com.domain.calc.exception.CalculatorOperandException;
import com.domain.calc.service.AirthmaticOperation;

/**
 * Implementations class to perform division operation
 */
public class DivisionOperation extends AirthmaticOperation {

	/**
	 * Validates operands. Validates if divisor is zero.
	 * 
	 * @param firstNumber  first operand
	 * @param secondNumber second operands
	 * @return void
	 * @exception CalculatorOperandException
	 */
	@Override
	public void validateOperand(Double firstNumber, Double secondNumber) throws CalculatorOperandException {
		super.validateOperand(firstNumber, secondNumber);
		if (secondNumber == 0.0) {
			throw new CalculatorOperandException("Cannot divide by zero.");
		}
	}

	/**
	 * Return result after performing division on the given numbers.
	 * 
	 * @param firstNumber  first operand
	 * @param secondNumber second operands
	 * @return double
	 * @exception CalculatorOperandException
	 */
	@Override
	public double compute(Double firstNumber, Double secondNumber) throws CalculatorOperandException {
		validateOperand(firstNumber, secondNumber);
		return firstNumber / secondNumber;
	}

}