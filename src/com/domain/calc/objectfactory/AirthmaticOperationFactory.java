package com.domain.calc.objectfactory;

import java.util.Objects;
import java.util.Stack;

import com.domain.calc.constant.CalculatorConstants;
import com.domain.calc.service.AirthmaticOperation;
import com.domain.calc.service.ICalculationService;
import com.domain.calc.service.impl.AddOperation;
import com.domain.calc.service.impl.DivisionOperation;
import com.domain.calc.service.impl.MultiplyOperation;
import com.domain.calc.service.impl.SubtractOperation;
import com.domain.calc.validation.IValidationService;

/**
 * handles object creation This is factory of classes implementing
 * AirthmaticOperation.
 */
public class AirthmaticOperationFactory extends AbstractFactory {

	/**
	 * Returns an object implementing AirthmaticOperation based on passed operator.
	 * 
	 * @param operator operator indication type of operator class
	 * @return AirthmaticOperation
	 */
	@Override
	public AirthmaticOperation getAirthmaticOperation(Character operator) {
		if (Objects.isNull(operator)) {
			return null;
		} else if (operator.equals(CalculatorConstants.ADDITION)) {
			return new AddOperation();
		} else if (operator.equals(CalculatorConstants.MULTIPLICATION)) {
			return new MultiplyOperation();
		} else if (operator.equals(CalculatorConstants.SUBTRACTION)) {
			return new SubtractOperation();
		} else if (operator.equals(CalculatorConstants.DIVISION)) {
			return new DivisionOperation();
		} else {
			return null;
		}
	}

	@Override
	public ICalculationService getCalculationService(String service, Stack<Double> values, Stack<Character> operators,
			IValidationService validationService) {
		return null;
	}
}
