package com.fdmgroup.adventofcodeone.daysix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class MinimumNumberOfJumpsTests {

	@Test
	void test_MinimumDistanceIsZeroWhenYOUAndSANOrbitSamePLanet() {
		List<String> mapInstructions = Arrays.asList("COM)B", "B)SAN", "B)YOU");
		Map<String, AstronomicalObject> orbitalMap = OrbitalMapGenerator.generateOrbitalMap(mapInstructions);
		int numberOfJumps = OrbitalJumpsCalculator.calculateJumpsFromYouToSan(orbitalMap);
		assertEquals(0, numberOfJumps);
	}

	@Test
	void test_MinimumDistanceIsOneWhenSantaIsOnAPlanetThatYourPlanetIsOrbitting() {
		List<String> mapInstructions = Arrays.asList("COM)B", "B)C", "B)SAN", "C)YOU");
		Map<String, AstronomicalObject> orbitalMap = OrbitalMapGenerator.generateOrbitalMap(mapInstructions);
		int numberOfJumps = OrbitalJumpsCalculator.calculateJumpsFromYouToSan(orbitalMap);
		assertEquals(1, numberOfJumps);
	}

	@Test
	void test_MinimumDistanceIsOneWhenSantaIsOnAPlanetThatIsOrbittingYourPlanet() {
		List<String> mapInstructions = Arrays.asList("COM)B", "B)C", "C)SAN", "B)YOU");
		Map<String, AstronomicalObject> orbitalMap = OrbitalMapGenerator.generateOrbitalMap(mapInstructions);
		int numberOfJumps = OrbitalJumpsCalculator.calculateJumpsFromYouToSan(orbitalMap);
		assertEquals(1, numberOfJumps);
	}

	@Test
	void test_MinimumDistanceIsTwoWhenSantaAndYouAreBothOnSeperatePlanetsThatOrbitTheSamePlanet() {
		List<String> mapInstructions = Arrays.asList("COM)B", "B)C", "B)D", "D)SAN", "C)YOU");
		Map<String, AstronomicalObject> orbitalMap = OrbitalMapGenerator.generateOrbitalMap(mapInstructions);
		int numberOfJumps = OrbitalJumpsCalculator.calculateJumpsFromYouToSan(orbitalMap);
		assertEquals(2, numberOfJumps);
	}

	@Test
	void test_ExampleOne() {
		List<String> mapInstructions = Arrays.asList("COM)B","B)C","C)D","D)E","E)F","B)G","G)H","D)I","E)J","J)K","K)L","K)YOU","I)SAN");
		Map<String, AstronomicalObject> orbitalMap = OrbitalMapGenerator.generateOrbitalMap(mapInstructions);
		int numberOfJumps = OrbitalJumpsCalculator.calculateJumpsFromYouToSan(orbitalMap);
		assertEquals(4, numberOfJumps);
	}
	

}
