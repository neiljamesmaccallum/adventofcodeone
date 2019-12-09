package com.fdmgroup.adventofcodeone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AdvancedFuelCalculatorTests {
	
	int moduleMass;
	int expectedFuel;
	int requiredFuel;

	@Test
	void test_CalculateFuelForModuleOfMass_Fourteen_ReturnsTwo(){
		moduleMass = 14;
		expectedFuel = 2;
		requiredFuel = AdvancedFuelCalculator.fuelRequiredForModuleOfMass(moduleMass);
		assertEquals(expectedFuel, requiredFuel);
	}
	
	@Test
	void test_CalculatedFuelForModuleOfMass_1969_Returns_966() {
		moduleMass = 1969;
		expectedFuel = 966;
		requiredFuel = AdvancedFuelCalculator.fuelRequiredForModuleOfMass(moduleMass);
		assertEquals(expectedFuel, requiredFuel);
	}
	
	@Test
	void test_CalculatedFUelForModuleOfDifferentMassReturnsCorrectResult() {
		moduleMass = 100756;
		expectedFuel = 50346;
		requiredFuel = AdvancedFuelCalculator.fuelRequiredForModuleOfMass(moduleMass);
		assertEquals(expectedFuel, requiredFuel);
	}
	
	@Test
	void test_CalculatedFuelForMultipleModulesReturnsCorrectResult() {
		int module1 = 14;
		int module2 = 1969;
		int module3 = 100756;
		List<Integer> moduleMasses = Arrays.asList(module1,module2,module3);
		expectedFuel= AdvancedFuelCalculator.fuelRequiredForModuleOfMass(module1)+AdvancedFuelCalculator.fuelRequiredForModuleOfMass(module2)+AdvancedFuelCalculator.fuelRequiredForModuleOfMass(module3);
		requiredFuel = AdvancedFuelCalculator.fuelRequiredForModulesWithMasses(moduleMasses);
		assertEquals(expectedFuel, requiredFuel);
	}
}
