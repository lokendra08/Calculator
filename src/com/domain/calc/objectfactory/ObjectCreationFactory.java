package com.domain.calc.objectfactory;

/**
 * handles object creation (factory of factory) This is factory of factory for
 * AirthmaticOperation and ICalculationService
 */
public class ObjectCreationFactory {

	/**
	 * Returns an object which represent factory of CalculationService and
	 * AirthmaticOperation based on passed parameter.
	 * 
	 * @param indicator indicator indication type of factory
	 * @return AbstractFactory
	 */
	public static AbstractFactory getObjectfactory(String indicator) {
		if (indicator.equalsIgnoreCase("CalculationService")) {
			return new CalculationServiceFactory();
		} else if (indicator.equalsIgnoreCase("AirthmaticOperation")) {
			return new AirthmaticOperationFactory();
		}
		return null;
	}

}
