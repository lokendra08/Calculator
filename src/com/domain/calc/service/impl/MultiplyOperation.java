package com.domain.calc.service.impl;

import com.domain.calc.exception.CalculatorOperandException;
import com.domain.calc.service.AirthmaticOperation;

/**
 * Implementations class to perform multiplication operation.
 */
public class MultiplyOperation extends AirthmaticOperation {

	/**
	 * Return result after performing multiplication on the given numbers. this also
	 * validates the operands.
	 * 
	 * @param firstNumber  first operand
	 * @param secondNumber second operands
	 * @return double
	 * @exception CalculatorOperandException
	 */
	@Override
	public double compute(Double firstNumber, Double secondNumber) throws CalculatorOperandException {
		validateOperand(firstNumber, secondNumber);
		return firstNumber * secondNumber;
	}

}
