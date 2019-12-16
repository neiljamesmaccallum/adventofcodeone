package com.fdmgroup.adventofcodeone.daysix;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class PlanetaryOrbitalMapTests {

	@Test
	public void test_ASimpleInputProducesOnePlanetOrbittingTheCOM() {
		List<String> mapInstructions = Arrays.asList("COM)B");
		Map<String, AstronomicalObject> orbitalMap = OrbitalMapGenerator.generateOrbitalMap(mapInstructions);
		AstronomicalObject centerOfMass = new AstronomicalObject("COM");
		centerOfMass.addSatelite(new AstronomicalObject("B"));
		assertTrue(orbitalMap.containsKey("B")&&orbitalMap.containsValue(centerOfMass));
	}
}
