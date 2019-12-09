package com.fdmgroup.adventofcodeone;

import java.util.List;

public class FuelCalculator {

	public static int calculateFuelForModuleOfMass(int mass) {
		int fuelRequired = (int) (mass/3-2);
		return fuelRequired;
	}

	public static int calculateFuelForModules(List<Integer> moduleMasses) {
		int requiredFuel = 0;
		for(Integer mass : moduleMasses) {
			requiredFuel+=calculateFuelForModuleOfMass(mass);
		}
		return requiredFuel;
	}

}
