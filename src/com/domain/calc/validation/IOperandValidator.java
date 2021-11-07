package com.domain.calc.validation;

import com.domain.calc.exception.CalculatorOperandException;
import com.domain.calc.util.CalculatorUtils;

/**
 * Service to perform validation on operands
 */
public interface IOperandValidator {

	/**
	 * default method to validate operands
	 * 
	 * @param firstNumber  firstNumber as input
	 * @param secondNumber secondNumber as input
	 * @return void
	 * @exception CalculatorOperandException
	 */
	public default void validateOperand(Double firstNumber, Double secondNumber) throws CalculatorOperandException {

		if (!CalculatorUtils.isNumeric(String.valueOf(firstNumber))) {
			throw new CalculatorOperandException("Invalid oprand: " + firstNumber);
		}
		if (!CalculatorUtils.isNumeric(String.valueOf(secondNumber))) {
			throw new CalculatorOperandException("Invalid oprand: " + secondNumber);
		}
	}
}
