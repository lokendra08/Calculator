package com.domain.calc.service;

import com.domain.calc.exception.CalculatorOperandException;
import com.domain.calc.exception.CalculatorValidatorException;

/**
 * Service to perform calculation based on expression
 */
public interface ICalculationService {

	/**
	 * Returns the result after computation based on expression provided.
	 * 
	 * expression and be of three type: infix, prefix and postfix.
	 * 
	 * @param expression expression indicating arithmetic expression
	 * @return Double
	 * @exception CalculatorOperandException
	 * @exception CalculatorValidatorException
	 */
	public Double evaluate(String expression) throws CalculatorOperandException, CalculatorValidatorException;

}
