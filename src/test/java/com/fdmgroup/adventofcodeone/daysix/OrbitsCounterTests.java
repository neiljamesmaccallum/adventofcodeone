package com.fdmgroup.adventofcodeone.daysix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrbitsCounterTests {

	Map<String, AstronomicalObject> exampleOrbitalMap;
	Map<String, AstronomicalObject> orbitalMap;

	@BeforeEach
	void init() {
		exampleOrbitalMap = OrbitalMapGenerator.generateOrbitalMap(
				Arrays.asList("COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L"));
	}

	@Test
	void test_NumberOfOrbitsIsZeroForMapWithJustCOM() {
		orbitalMap = new HashMap<String, AstronomicalObject>();
		orbitalMap.put("COM", new AstronomicalObject("COM"));
		int numberOfOrbits = OrbitCounter.countOrbits(orbitalMap);
		assertEquals(0, numberOfOrbits);
	}

	@Test
	void test_OrbitCountForIndividualPlanetBOrbittingCOMReturnsOne() {
		orbitalMap = OrbitalMapGenerator.generateOrbitalMap(Arrays.asList("COM)B"));
		int numberOfOrbits = OrbitCounter.countOrbits(orbitalMap, "B");
		assertEquals(1, numberOfOrbits);
	}

	@Test
	void test_OrbitCountForSecondPlanetOrbitingPlanetOrbittingCOMRetunrsOne() {
		orbitalMap = OrbitalMapGenerator.generateOrbitalMap(Arrays.asList("COM)B", "B)C"));
		int numberOfOrbits = OrbitCounter.countOrbits(orbitalMap, "C");
		assertEquals(2, numberOfOrbits);
	}

	@Test
	void test_OrbitCountForExampleOrbitalMapForD() {
		int numberOfOrbits = OrbitCounter.countOrbits(exampleOrbitalMap, "D");
		assertEquals(3, numberOfOrbits);
	}

	@Test
	void test_OrbitCountForExampleOrbitalMapForL() {
		int numberOfOrbits = OrbitCounter.countOrbits(exampleOrbitalMap, "L");
		assertEquals(7, numberOfOrbits);
	}

	@Test
	void test_OrbitCountForExampleOrbitalMapForCOM() {
		int numberOfOrbits = OrbitCounter.countOrbits(exampleOrbitalMap, "COM");
		assertEquals(0, numberOfOrbits);
	}

	@Test
	void test_OrbitCountForTwoPlanetsOrbittingCOMReturnsTwo() {
		List<String> mapInstructions = Arrays.asList("COM)B", "COM)C");
		orbitalMap = OrbitalMapGenerator.generateOrbitalMap(mapInstructions);
		int numberOfOrbits = OrbitCounter.countOrbits(orbitalMap);
		assertEquals(2, numberOfOrbits);
	}
	
	@Test
	void test_OrbitCountForTwoPlanetsOneOrbittingTheOtherOrbittingCOMRetunrsThree() {
		List<String> mapInstructions = Arrays.asList("COM)B", "B)C");
		orbitalMap = OrbitalMapGenerator.generateOrbitalMap(mapInstructions);
		int numberOfOrbits = OrbitCounter.countOrbits(orbitalMap);
		assertEquals(3, numberOfOrbits);
	}
	
	@Test
	void test_OrbitCountForExampleOrbitalMap() {
		int numberOfOrbits = OrbitCounter.countOrbits(exampleOrbitalMap);
		assertEquals(42, numberOfOrbits);
	}

}
