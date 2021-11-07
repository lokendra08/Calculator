package com.domain.calc.validation;

import com.domain.calc.exception.CalculatorValidatorException;

/**
 * Service to perform validation on request input
 */
public interface IValidationService {
	
	/**
	 * validate request input expression
	 * 
	 * @param request  request as input
	 * @return void
	 * @exception CalculatorValidatorException
	 */
	 public void validateRequest(Character[] request) throws CalculatorValidatorException;
}
