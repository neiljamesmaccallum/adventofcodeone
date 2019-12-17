package com.fdmgroup.adventofcodeone.daysix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrbitalJumpsCalculator {

	public static int calculateJumpsFromYouToSan(Map<String, AstronomicalObject> orbitalMap) {
		List<String> objectsYouAreOrbitting = new ArrayList<String>();
		List<String> objectsSantaIsOrbitting = new ArrayList<String>();
		String currentBodyYou = "YOU";
		String currentBodySan = "SAN";
		for (int i = 0; i < OrbitCounter.countOrbits(orbitalMap, "YOU"); i++) {
			String nextBody = "YOU";
			for (AstronomicalObject astronomicalObject : orbitalMap.values()) {
				for (AstronomicalObject orbitters : astronomicalObject.getSatelites()) {
					if (orbitters.getLabel().equals(currentBodyYou) &&  !objectsYouAreOrbitting.contains(astronomicalObject.getLabel())) {
						objectsYouAreOrbitting.add(astronomicalObject.getLabel());
						nextBody = astronomicalObject.getLabel();
					}
				}
			}
			currentBodyYou=nextBody;
		}
		for (int i = 0; i < OrbitCounter.countOrbits(orbitalMap, "SAN"); i++) {
			String nextBody = "SAN";
			for (AstronomicalObject astronomicalObject : orbitalMap.values()) {
				for (AstronomicalObject orbitters : astronomicalObject.getSatelites()) {
					if (orbitters.getLabel().equals(currentBodySan) &&  !objectsSantaIsOrbitting.contains(astronomicalObject.getLabel())) {
						objectsSantaIsOrbitting.add(astronomicalObject.getLabel());
						nextBody = astronomicalObject.getLabel();
					}
				}
			}
			currentBodySan=nextBody;
		}
		List<String> overlappingOrbits = new ArrayList<String>();
		for(String label : objectsYouAreOrbitting) {
			if( objectsSantaIsOrbitting.contains(label)) {
				overlappingOrbits.add(label);
			}
		}
		int santaOrbits = objectsSantaIsOrbitting.size();
		int yourOrbits = objectsYouAreOrbitting.size();
		int overlappingOrbitsNumber = overlappingOrbits.size();
		return santaOrbits+yourOrbits-2*overlappingOrbitsNumber;
	}

}
