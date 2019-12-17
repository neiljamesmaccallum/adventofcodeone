package com.fdmgroup.adventofcodeone.daysix;

import java.util.Map;

public class OrbitCounter {

	public static int countOrbits(Map<String, AstronomicalObject> orbitalMap) {
		int orbits = 0;
		for(String labels: orbitalMap.keySet()) {
			orbits+=countOrbits(orbitalMap, labels);
		}
		return orbits;
	}

	public static int countOrbits(Map<String, AstronomicalObject> orbitalmap, String label) {
		int orbits = 0;
		AstronomicalObject orbittingObject = orbitalmap.get(label);
		for (AstronomicalObject astronomicalObject : orbitalmap.values()) {
			if (astronomicalObject.getSatelites().contains(orbittingObject)) {
				orbits++;
				orbits += countOrbits(orbitalmap, astronomicalObject.getLabel());
			}
		}
		return orbits;
	}

}
