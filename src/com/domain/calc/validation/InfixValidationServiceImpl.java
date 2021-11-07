package com.domain.calc.validation;

import java.util.Arrays;
import java.util.List;

import com.domain.calc.exception.CalculatorValidatorException;

/**
 * Implementation class to validate input request checks for valid infix
 * expression
 */
public class InfixValidationServiceImpl implements IValidationService {

	private static List<Character> validChracters;

	static {
		validChracters = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '*', '/', '(', ')',
				'.');
	}

	/**
	 * validate request input expression
	 * 
	 * @param request request as input
	 * @return void
	 * @exception CalculatorValidatorException
	 */
	@Override
	public void validateRequest(Character[] request) throws CalculatorValidatorException {
		validateSupportedCharacters(request);
	}

	/**
	 * validate request and check for valid infix notation characters
	 * 
	 * @param request request as character array
	 * @return void
	 * @exception CalculatorValidatorException
	 */
	private void validateSupportedCharacters(Character[] request) throws CalculatorValidatorException {
		for (int i = 0; i < request.length; i++) {
			if (!validChracters.contains(request[i])) {
				throw new CalculatorValidatorException("Invalid expression : " + request[i] + " is not supported");
			}
		}
	}

}
