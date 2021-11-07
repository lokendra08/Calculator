package com.domain.calc.service.impl;

import static com.domain.calc.constant.CalculatorConstants.ADDITION;
import static com.domain.calc.constant.CalculatorConstants.AIRTHMATIC_OPERATION;
import static com.domain.calc.constant.CalculatorConstants.DIVISION;
import static com.domain.calc.constant.CalculatorConstants.DOT;
import static com.domain.calc.constant.CalculatorConstants.LEFT_PARENTHISIS;
import static com.domain.calc.constant.CalculatorConstants.MULTIPLICATION;
import static com.domain.calc.constant.CalculatorConstants.NINE;
import static com.domain.calc.constant.CalculatorConstants.RIGHT_PARENTHISIS;
import static com.domain.calc.constant.CalculatorConstants.SUBTRACTION;
import static com.domain.calc.constant.CalculatorConstants.ZERO;

import java.util.Stack;
import java.util.function.BiPredicate;

import com.domain.calc.exception.CalculatorOperandException;
import com.domain.calc.exception.CalculatorValidatorException;
import com.domain.calc.objectfactory.ObjectCreationFactory;
import com.domain.calc.service.AirthmaticOperation;
import com.domain.calc.service.ICalculationService;
import com.domain.calc.validation.IValidationService;

/**
 * Implementation class to perform arithmetic operation on an infix expression
 */
public class CalculatorInfixService implements ICalculationService {

	private Stack<Double> values;
	private Stack<Character> operators;
	private IValidationService validateService;

	public CalculatorInfixService(Stack<Double> values, Stack<Character> ops, IValidationService validateService) {
		super();
		this.values = values;
		this.operators = ops;
		this.validateService = validateService;
	}

	/**
	 * Returns the result after computation based on infix expression provided.
	 * validates input expression.
	 * 
	 * @param expression expression indicating arithmetic expression
	 * @return Double
	 * @exception CalculatorOperandException
	 * @exception CalculatorValidatorException
	 */
	@Override
	public Double evaluate(String expression) throws CalculatorOperandException, CalculatorValidatorException {
		char[] characterArray = expression.toCharArray();
		invokeValidationService(expression);
		return compute(characterArray);
	}

	/**
	 * Returns the result after computation.
	 * 
	 * @param characterArray characterArray holding all characters from input
	 *                       expression
	 * @return Double
	 * @exception CalculatorOperandException
	 */
	private Double compute(char[] characterArray) throws CalculatorOperandException {
		for (int i = 0; i < characterArray.length; i++) {
			if ((characterArray[i] >= ZERO && characterArray[i] <= NINE) || (characterArray[i] == DOT)) {
				StringBuffer sbuf = new StringBuffer();

				while (i < characterArray.length
						&& ((characterArray[i] >= ZERO && characterArray[i] <= NINE) || (characterArray[i] == DOT))) {
					sbuf.append(characterArray[i++]);
				}

				values.push(Double.parseDouble(sbuf.toString()));
				if (i == characterArray.length) {
					break;
				}
			}

			if (characterArray[i] == LEFT_PARENTHISIS) {
				operators.push(characterArray[i]);
			}

			if (characterArray[i] == RIGHT_PARENTHISIS) {
				while (operators.peek() != '(') {
					Double value = applyOperator(operators.pop(), values.pop(), values.pop());
					values.push(value);
				}
				operators.pop();
			}

			if (characterArray[i] == ADDITION || characterArray[i] == SUBTRACTION || characterArray[i] == MULTIPLICATION
					|| characterArray[i] == DIVISION) {
				while (!operators.empty() && hasPrecedencePredicate.test(characterArray[i], operators.peek())) {
					Double value = applyOperator(operators.pop(), values.pop(), values.pop());
					values.push(value);
				}
				operators.push(characterArray[i]);
			}
		}
		while (!operators.empty()) {
			Double value = applyOperator(operators.pop(), values.pop(), values.pop());
			values.push(value);
		}
		return values.pop();
	}

	/**
	 * Validates the input expression.
	 * 
	 * @param expression expression indicating arithmetic expression
	 * @return void
	 * @exception CalculatorValidatorException
	 */
	private void invokeValidationService(String expression) throws CalculatorValidatorException {
		Character[] charArray = expression.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
		validateService.validateRequest(charArray);
	}

	/**
	 * Returns the result after computation based on arithmetic operator. create
	 * implementation object based on the operator provided from the factory.
	 * 
	 * @param operator     operator indicates arithmetic operator
	 * @param secondNumber secondNumber indicating second operand
	 * @param firstNumber  firstNumber indicating first operand
	 * @return Double
	 * @exception CalculatorOperandException
	 */
	public static Double applyOperator(char operator, Double secondNumber, Double firstNumber)
			throws CalculatorOperandException {
		AirthmaticOperation airthmaticOperation = ObjectCreationFactory.getObjectfactory(AIRTHMATIC_OPERATION)
				.getAirthmaticOperation(operator);
		return airthmaticOperation.compute(firstNumber, secondNumber);
	}

	/**
	 * Bipredicate to check operator precedence.
	 * 
	 * @param operatorFirst  operatorFirst as first argument
	 * @param operatorSecond operatorSecond as second argument
	 * @return boolean
	 */
	private BiPredicate<Character, Character> hasPrecedencePredicate = (operatorFirst, operatorSecond) -> {
		if (operatorSecond == LEFT_PARENTHISIS || operatorSecond == RIGHT_PARENTHISIS) {
			return false;
		}
		if ((operatorFirst == MULTIPLICATION || operatorFirst == DIVISION)
				&& (operatorSecond == ADDITION || operatorSecond == SUBTRACTION)) {
			return false;
		} else {
			return true;
		}
	};

}
