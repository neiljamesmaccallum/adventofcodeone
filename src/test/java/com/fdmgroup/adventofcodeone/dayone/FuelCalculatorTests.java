package com.fdmgroup.adventofcodeone.dayone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FuelCalculatorTests {
	
	int mass;
	int requiredFuel;
	int module1;
	int module2;

	@Test
	void test_CalculateFuelForModuleOfMassTwelve_ReturnsTwo() {
		mass = 12;
		requiredFuel = FuelCalculator.calculateFuelForModuleOfMass(mass);
		assertEquals(2, requiredFuel);
	}
	
	@Test
	void test_CalculateFuelForModulesOfMass_FourteenReturnsTwo() {
		mass = 14;
		requiredFuel = FuelCalculator.calculateFuelForModuleOfMass(mass);
		assertEquals(2, requiredFuel);
	}
	
	@Test
	void test_CalculateFuelForModulesOfMass_ThirdExample() {
		mass = 1969;
		requiredFuel = FuelCalculator.calculateFuelForModuleOfMass(mass);
		assertEquals(654, requiredFuel);
	}
	
	@Test
	void test_CalculatedFuelForModulesOfMass_ExampleFour() {
		mass = 100756;
		requiredFuel = FuelCalculator.calculateFuelForModuleOfMass(mass);
		assertEquals(33583, requiredFuel);
	}
	
	@Test
	void test_CalculatedFuelForMultipleModules_ReturnsCorrectResult() {
		module1 = 12;
		module2 = 14;
		List<Integer> moduleMasses = Arrays.asList(module1,module2);
		requiredFuel = FuelCalculator.calculateFuelForModules(moduleMasses);
		int expectedFuel = FuelCalculator.calculateFuelForModuleOfMass(module1)+FuelCalculator.calculateFuelForModuleOfMass(module2);
		assertEquals(expectedFuel, requiredFuel);
	}
	
	@Test
	void test_CalculatedFuelForMultipleModules_ReturnsCorrectResult_DifferentInputs() {
		module1 = 1969;
		module2 = 100756;
		List<Integer> moduleMasses = Arrays.asList(module1,module2);
		requiredFuel = FuelCalculator.calculateFuelForModules(moduleMasses);
		int expectedFuel = FuelCalculator.calculateFuelForModuleOfMass(module1)+FuelCalculator.calculateFuelForModuleOfMass(module2);
		assertEquals(expectedFuel, requiredFuel);
	}
}
