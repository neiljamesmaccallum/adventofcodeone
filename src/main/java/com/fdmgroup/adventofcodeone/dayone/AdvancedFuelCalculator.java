package com.fdmgroup.adventofcodeone.dayone;

import java.util.List;

public class AdvancedFuelCalculator {

	public static int fuelRequiredForModuleOfMass(int moduleMass) {
		int requiredFuel = 0;
		while (moduleMass > 0) {
			int fuelMass = FuelCalculator.calculateFuelForModuleOfMass(moduleMass);
			if(fuelMass>0) {
				requiredFuel+=fuelMass;
			}
			moduleMass=fuelMass;
		}
		return requiredFuel;
	}

	public static int fuelRequiredForModulesWithMasses(List<Integer> moduleMasses) {
		int requiredFuel = 0;
		for(Integer mass : moduleMasses) {
			requiredFuel+=fuelRequiredForModuleOfMass(mass);
		}
		return requiredFuel;
	}

}
