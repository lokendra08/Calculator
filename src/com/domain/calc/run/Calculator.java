package com.domain.calc.run;

import java.util.Scanner;
import java.util.Stack;

import com.domain.calc.constant.CalculatorConstants;
import com.domain.calc.exception.CalculatorOperandException;
import com.domain.calc.exception.CalculatorValidatorException;
import com.domain.calc.objectfactory.ObjectCreationFactory;
import com.domain.calc.service.ICalculationService;
import com.domain.calc.util.CalcDisplayBanner;
import com.domain.calc.util.CalculatorUtils;
import com.domain.calc.validation.IValidationService;
import com.domain.calc.validation.InfixValidationServiceImpl;

/**
 * Main program to run calculator
 * @author Lokendra Rawat
 * @version 1.0
 * @since   2021-11-07
 */
public class Calculator {
	
	static {
		CalcDisplayBanner.displayInfo();
	}

	public static void main(String[] args) {
		run();
	}
	
   /**
	* Takes user input from console as an string and invoke calculator service.
	* this method also remove white spaces if any present in the input expression.
	* this method also add 0 as prefix  to the use input to handle infix expression starting with minus sign
	* 
	* @return void
	* @exception CalculatorOperandException, CalculatorValidatorException
	*/
	private static void run(){
		String input;
		try(Scanner scan = new Scanner(System.in)){		
    	do {
    		CalculatorUtils.lineBreaks(1);
    		System.out.println("Enter arithmatic expression Or Enter 'exit' to terminate the program : "); 
    		CalculatorUtils.lineBreaks(1);
            input = scan.next();
            if(input.equals(CalculatorConstants.EXIT)) {
    			break;
    		}
    		input = CalculatorUtils.removeWhiteSpaces(input, CalculatorConstants.NO_SPACE);  
    		input = CalculatorUtils.addZeroAsPrefix(input, CalculatorConstants.ZERO);
    		try {
				invokeCalculatorService(input, new Stack<Double>(), new Stack<Character>(), new InfixValidationServiceImpl());
    		}catch(CalculatorValidatorException cvex) {
    			System.out.println(cvex.getMessage());
				System.out.println(CalculatorConstants.ERROR_MESSAGE);
    		}catch(CalculatorOperandException coex) {
				System.out.println(coex.getMessage());
				System.out.println(CalculatorConstants.ERROR_MESSAGE);
			} catch (Exception ex) {
				System.out.println(CalculatorConstants.ERROR_MESSAGE);
			} 
    	}while(true);
	  }
   }

	
   /**
	* Takes user input from console as an string and invoke calculator service.
	* this method also remove white spaces if any present in the input expression.
	* this method also add 0 as prefix  to the use input to handle infix expression starting with minus sign
	* 
	* @param input   user input expression as infix notation
	* @param values  stack to hold operands
	* @param operators stack to hold operators
	* @param validationService  validation service for respective calculation service
	* @return void
	* @exception CalculatorOperandException, CalculatorValidatorException
	*/
	private static void invokeCalculatorService(String input, Stack<Double> values, Stack<Character> operators, IValidationService validationService) throws CalculatorOperandException, CalculatorValidatorException {
		ICalculationService calculatorService = ObjectCreationFactory.getObjectfactory(CalculatorConstants.CALCULATION_SERVICE).getCalculationService(CalculatorConstants.INFIX, values, operators, validationService);
		System.out.println("Answer: "+calculatorService.evaluate(input));
	}
}
