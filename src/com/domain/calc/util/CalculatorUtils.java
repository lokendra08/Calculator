package com.domain.calc.util;

import java.util.regex.Pattern;

import com.domain.calc.constant.CalculatorConstants;

/**
 * Utility class
 */
public class CalculatorUtils {

	/**
	 * Returns string after removing white spaces if any, with provided delimiter
	 * 
	 * @param input     user input as infix notation
	 * @param delimiter delimiter to replace with
	 * @return String
	 */
	public static String removeWhiteSpaces(String input, String delimiter) {
		return input.replaceAll(CalculatorConstants.WHITE_SPACES, delimiter);
	}

	/**
	 * Breaks line with provided number
	 * 
	 * @param lineBreaks lineBreaks indicates number of line breaks
	 * @return void
	 */
	public static void lineBreaks(int lineBreaks) {
		for (int i = 0; i <= lineBreaks; i++) {
			System.out.println(" ");
		}
	}

	/**
	 * Returns string after adding zero as prefix this is to handle scenario when
	 * expression starts with minus sign.
	 * 
	 * @param input user input as infix notation
	 * @param zero  zero as prefix
	 * @return String
	 */
	public static String addZeroAsPrefix(String input, char zero) {
		if (input.startsWith("-")) {
			return zero + input;
		} else {
			return input;
		}
	}

	/**
	 * Returns boolean indication whether input is numeric or not including decimal
	 * numbers
	 * 
	 * @param strNum strNum as input
	 * @return boolean
	 */
	public static boolean isNumeric(String strNum) {
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
		if (strNum == null) {
			return false;
		}
		return pattern.matcher(strNum).matches();
	}
}
