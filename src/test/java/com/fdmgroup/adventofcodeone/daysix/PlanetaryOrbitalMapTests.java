package com.fdmgroup.adventofcodeone.daysix;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
		assertTrue(orbitalMap.containsKey("B") && orbitalMap.containsValue(centerOfMass));
	}

	@Test
	public void test_TwoLinearInputsProducesOnePlanetOrbittingAnotherPlanetOrbittingCOM() {
		List<String> mapInstructions = Arrays.asList("COM)B", "B)C");
		Map<String, AstronomicalObject> orbitalMaps = OrbitalMapGenerator.generateOrbitalMap(mapInstructions);
		AstronomicalObject centreOfMass = new AstronomicalObject("COM");
		AstronomicalObject planetB = new AstronomicalObject("B");
		planetB.addSatelite(new AstronomicalObject("C"));
		centreOfMass.addSatelite(planetB);
		assertTrue(orbitalMaps.containsValue(centreOfMass));
	}

	@Test
	public void test_TwoDivergingInputsProducesTwoPlanetsOrbittingCOM() {
		List<String> mapInstructions = Arrays.asList("COM)B", "COM)C");
		Map<String, AstronomicalObject> orbitalMaps = OrbitalMapGenerator.generateOrbitalMap(mapInstructions);
		AstronomicalObject centreOfMass = new AstronomicalObject("COM");
		centreOfMass.addSatelite(new AstronomicalObject("B"));
		centreOfMass.addSatelite(new AstronomicalObject("C"));
		assertTrue(orbitalMaps.containsValue(centreOfMass));
	}

	@Test
	public void test_ComplexInputExample() {
		AstronomicalObject centreOfMass = new AstronomicalObject("COM");
		AstronomicalObject planetB = new AstronomicalObject("B");
		AstronomicalObject planetC = new AstronomicalObject("C");
		AstronomicalObject planetD = new AstronomicalObject("D");
		AstronomicalObject planetE = new AstronomicalObject("E");
		AstronomicalObject planetF = new AstronomicalObject("F");
		AstronomicalObject planetG = new AstronomicalObject("G");
		AstronomicalObject planetH = new AstronomicalObject("H");
		AstronomicalObject planetI = new AstronomicalObject("I");
		AstronomicalObject planetJ = new AstronomicalObject("J");
		AstronomicalObject planetK = new AstronomicalObject("K");
		AstronomicalObject planetL = new AstronomicalObject("L");
		centreOfMass.addSatelite(planetB);
		planetB.addSatelite(planetG);
		planetB.addSatelite(planetC);
		planetD.addSatelite(planetI);
		planetC.addSatelite(planetD);
		planetD.addSatelite(planetE);
		planetE.addSatelite(planetF);
		planetE.addSatelite(planetJ);
		planetG.addSatelite(planetH);
		planetJ.addSatelite(planetK);
		planetK.addSatelite(planetL);
		List<String> mapInstructions = Arrays.asList("C)D", "B)C", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K",
				"K)L", "COM)B");
		Map<String, AstronomicalObject> orbitalMaps = OrbitalMapGenerator.generateOrbitalMap(mapInstructions);
		System.out.println(orbitalMaps.get("COM").getSatelites());
		System.out.println(centreOfMass.getSatelites());
//		assertTrue(orbitalMaps.containsValue(centreOfMass));
		assertEquals(centreOfMass, orbitalMaps.get("COM"));
	}
}
