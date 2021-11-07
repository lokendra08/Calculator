package com.domain.calc.objectfactory;

import java.util.Objects;
import java.util.Stack;

import com.domain.calc.constant.CalculatorConstants;
import com.domain.calc.service.AirthmaticOperation;
import com.domain.calc.service.ICalculationService;
import com.domain.calc.service.impl.CalculatorInfixService;
import com.domain.calc.validation.IValidationService;

/**
 * handles object creation This is factory of classes implementing
 * ICalculationService.
 */
public class CalculationServiceFactory extends AbstractFactory {

	/**
	 * Returns an object implementing ICalculationService based on passed operator.
	 * 
	 * @param service           service type
	 * @param values            stack to hold operands
	 * @param operators         stack to hold operators
	 * @param validationService validation service for respective calculation
	 *                          service
	 * @return ICalculationService
	 */
	@Override
	public ICalculationService getCalculationService(String service, Stack<Double> values, Stack<Character> operators,
			IValidationService validationService) {
		if (Objects.isNull(service)) {
			return null;
		} else if (service.equals(CalculatorConstants.INFIX)) {
			return new CalculatorInfixService(values, operators, validationService);
		} else {
			return null;
		}
	}

	@Override
	public AirthmaticOperation getAirthmaticOperation(Character operator) {
		return null;
	}

}
