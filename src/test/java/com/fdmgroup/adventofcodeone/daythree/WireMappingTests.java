package com.fdmgroup.adventofcodeone.daythree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WireMappingTests {

	@Test
	void test_WireMappingCanTakeInTwoInstructions() {
		String pathInstruction1 = "U5";
		String pathInstruction2 = "R3";
		Position startingPosition = new Position(0, 0);
		List<String> pathInstructions = Arrays.asList(pathInstruction1,pathInstruction2);
		List<Position> expectedPath = new ArrayList<Position>();
		expectedPath.addAll(WireMapping.getWirePathPortion(pathInstruction1, startingPosition));
		expectedPath.addAll(WireMapping.getWirePathPortion(pathInstruction2, expectedPath.get(expectedPath.size()-1)));
		List<Position> returnedPath = WireMapping.getWirePath(pathInstructions, startingPosition);
		assertEquals(expectedPath, returnedPath);
	}
	
	@Test
	void test_WireMapingCanTakeInMultipleInstructions() {
		String pathInstruction1 = "U5";
		String pathInstruction2 = "R7";
		String pathInstruction3 = "D3";
		String pathInstruction4 = "L9";
		Position startingPosition = new Position(0, 0);
		List<String> pathInstructions = Arrays.asList(pathInstruction1, pathInstruction2, pathInstruction3, pathInstruction4);
		List<Position> expectedPath = new ArrayList<>();
		expectedPath.addAll(WireMapping.getWirePathPortion(pathInstruction1, startingPosition));
		expectedPath.addAll(WireMapping.getWirePathPortion(pathInstruction2, expectedPath.get(expectedPath.size()-1)));
		expectedPath.addAll(WireMapping.getWirePathPortion(pathInstruction3, expectedPath.get(expectedPath.size()-1)));
		expectedPath.addAll(WireMapping.getWirePathPortion(pathInstruction4, expectedPath.get(expectedPath.size()-1)));
		List<Position> returnedPath = WireMapping.getWirePath(pathInstructions, startingPosition);
		assertEquals(expectedPath, returnedPath);
	}
}
