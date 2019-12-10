package com.fdmgroup.adventofcodeone.daythree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WireCalculationsOverlapsTests {

	@Test
	void test_wireCalculations_OverlapPositions_ReturnsCorrectResultForOneOverlap() {
		String instruction1 = "U2";
		String instruction2 = "R3";
		List<String> instructions1 = Arrays.asList(instruction1, instruction2);
		List<String> instructions2 = Arrays.asList(instruction2, instruction1);
		List<Position> overLapPositions = WireCalculations.overLapPositions(instructions1, instructions2);
		List<Position> expectedOutput = Arrays.asList(new Position(3, 2));
		assertEquals(expectedOutput, overLapPositions);
	}

	@Test
	void test_wireCalculations_OverlapPositions_ReturnsCorrectResultForOneOverlap_DifferentInputs() {
		String instruction1 = "R2";
		String instruction2 = "U3";
		List<String> instructions1 = Arrays.asList(instruction1, instruction2);
		List<String> instructions2 = Arrays.asList(instruction2, instruction1);
		List<Position> overLapPositions = WireCalculations.overLapPositions(instructions1, instructions2);
		List<Position> expectedOutput = Arrays.asList(new Position(2, 3));
		assertEquals(expectedOutput, overLapPositions);
	}
	
	@Test
	void test_wireCalculations_OverlapPositions_ReturnsTheWirePath_IfBothWiresInstructionsAreTheSame() {
		String instruction1 = "U2";
		String instruction2 = "R3";
		List<String> instructions1 = Arrays.asList(instruction1, instruction2);
		List<String> instructions2 = Arrays.asList(instruction1, instruction2);
		List<Position> overLapPositions = WireCalculations.overLapPositions(instructions1, instructions2);
		List<Position> expectedOutput = WireMapping.getWirePath(instructions1, new Position(0,0));
		assertEquals(expectedOutput, overLapPositions);
	}
	
	@Test
	void test_wireCalculations_OverlapPositions_ReturnsCorrectResults_WhenThereAreTwoDIstinctOverlapPoints() {
		String instruction1 = "U2";
		String instruction2 = "R3";
		List<String> instructions1 = Arrays.asList(instruction1, instruction2, instruction2, instruction1);
		List<String> instructions2 = Arrays.asList(instruction2, instruction1, instruction1, instruction2);
		List<Position> overLapPositions = WireCalculations.overLapPositions(instructions1, instructions2);
		List<Position> expectedOutput = Arrays.asList(new Position(3, 2), new Position(6, 4));
		assertEquals(expectedOutput, overLapPositions);
	}
	
	@Test
	void test_wireCalculations_OverlapPosititions_ReturnsEmptyList_WhenThereIsNoOVerlap() {
		String instruction1 = "U2";
		String instruction2 = "R3";
		List<String> instructions1 = Arrays.asList(instruction1 );
		List<String> instructions2 = Arrays.asList(instruction2);
		List<Position> overLapPositions = WireCalculations.overLapPositions(instructions1, instructions2);
		assertTrue(overLapPositions.isEmpty());
	}
	
}
