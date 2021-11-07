package com.domain.calc.objectfactory;

import java.util.Stack;

import com.domain.calc.service.AirthmaticOperation;
import com.domain.calc.service.ICalculationService;
import com.domain.calc.validation.IValidationService;

/**
 * handles object creation 
 * This is factory of factory for AirthmaticOperation and ICalculationService
 */
public abstract class AbstractFactory {
	
	   /**
		* Returns an object implementing AirthmaticOperation based on passed operator.
		* 
		* @param operator   user input expression as infix notation
		* @return AirthmaticOperation
		*/
	    public abstract AirthmaticOperation getAirthmaticOperation(Character operator);
	    
	   /**
		* Returns an object implementing ICalculationService based on passed parameter.
		* 
		* @param service   service type
	    * @param values    stack to hold operands
	    * @param operators  stack to hold operators
	    * @param validationService  validation service for respective calculation service
		* @return ICalculationService
		*/
	    public abstract ICalculationService getCalculationService(String service,  Stack<Double> values, Stack<Character> operators, IValidationService validationService);
}
