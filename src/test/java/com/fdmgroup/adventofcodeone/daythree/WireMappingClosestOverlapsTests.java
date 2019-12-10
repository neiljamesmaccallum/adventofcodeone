package com.fdmgroup.adventofcodeone.daythree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WireMappingClosestOverlapsTests {
	
	String instruction1;
	String instruction2;
	List<String> instructions1;
	List<String> instructions2;
	Position trueClosestOverlap;
	Position closestOverlap;
	

	@Test
	void test_WireCalculations_ClosestOverlap_ReturnsOnlyOverlap_WhenThereIsOneOverlap() {
		instruction1 = "U2";
		instruction2 = "R3";
		instructions1 = Arrays.asList(instruction1, instruction2);
		instructions2 = Arrays.asList(instruction2, instruction1);
		List<Position> overLapPositions = WireCalculations.overLapPositions(instructions1, instructions2);
		closestOverlap = WireCalculations.closestOverlap(instructions1, instructions2);
		assertEquals(overLapPositions, Arrays.asList(closestOverlap));
	}

	@Test
	void test_WireCalculations_ClosestOverlap_returnsClosestOverlapForTwoOverlaps() {
		instruction1 = "U4";
		instruction2 = "R6";
		String instruction3 = "D2";
		String instruction4 = "L3";
		instructions1 = Arrays.asList(instruction1, instruction2, instruction4, instruction3);
		instructions2 = Arrays.asList(instruction2, instruction1, instruction3, instruction4);
		trueClosestOverlap = new Position(3,2);
		closestOverlap = WireCalculations.closestOverlap(instructions1, instructions2);
		assertEquals(trueClosestOverlap, closestOverlap);
	}
	
	@Test
	void test_WireCalculations_ClosestOverlap_ReturnsClosestOverlap_GivenExample() {
		instructions1 = Arrays.asList("R8","U5","L5","D3");
		instructions2 = Arrays.asList("U7","R6","D4","L4");
		trueClosestOverlap = new Position(3,3);
		closestOverlap = WireCalculations.closestOverlap(instructions1, instructions2);
		assertEquals(trueClosestOverlap, closestOverlap);
	}

}
