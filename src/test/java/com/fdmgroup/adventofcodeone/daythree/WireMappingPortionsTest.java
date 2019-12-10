package com.fdmgroup.adventofcodeone.daythree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WireMappingPortionsTest {
	
	private int steps = 5400;
	private String wireInstructions;
	Position startingPosition;
	List<Position> expected;
	List<Position> wirePath;
	
	@BeforeEach
	void init() {
		startingPosition = new Position(0,0);
		expected = new ArrayList<>();
	}

	@Test
	void test_GetWireMappingWorksWhenTheWireIsGoingUp(){
		wireInstructions = "U"+steps;
		wirePath = WireMapping.getWirePathPortion(wireInstructions, startingPosition);
		for(int i=0; i<steps;i++) {
			expected.add(new Position(0, i+1));
		}
		assertEquals(expected, wirePath);
	}
	
	@Test
	void test_GetWireMappingPortionWorksWhenTheWireIsGoingDown() {
		wireInstructions = "D"+steps;
		wirePath = WireMapping.getWirePathPortion(wireInstructions, startingPosition);
		for (int i=1;i<=steps;i++) {
			expected.add(new Position(startingPosition.getXposition(),startingPosition.getYposition()-i));
		}
		assertEquals(expected, wirePath);
	}
	
	@Test
	void test_GetWireMappingPortionWorksWhenTheWireIsGoingLeft() {
		wireInstructions = "L"+steps;
		wirePath = WireMapping.getWirePathPortion(wireInstructions, startingPosition);
		for (int i=1; i<=steps;i++) {
			expected.add(new Position(startingPosition.getXposition()-i,startingPosition.getYposition()));
		}
		assertEquals(expected, wirePath);
	}
	
	@Test
	void test_GetWireMappingPortionWorksWhenWireIsGoingRight() {
		wireInstructions = "R"+steps;
		wirePath = WireMapping.getWirePathPortion(wireInstructions, startingPosition);
		for (int i=1; i<=steps;i++) {
			expected.add(new Position(startingPosition.getXposition()+i,startingPosition.getYposition()));
		}
		assertEquals(expected, wirePath);
	}
}
