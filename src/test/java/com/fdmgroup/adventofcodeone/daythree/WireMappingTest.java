package com.fdmgroup.adventofcodeone.daythree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WireMappingTest {

	@Test
	void test_GetWireMappingWorksWhenTheWireIsGoingRight(){
		int steps = 5;
		String direction = "U"+steps ;
		String wireInstructions = direction;
		List<Position> wirePath = WireMapping.getWirePathPortion(wireInstructions);
		List<Position> expected = new ArrayList<>();
		for(int i=0; i<steps;i++) {
			expected.add(new Position(0, i+1));
		}
		assertEquals(expected, wirePath);
	}
//	,[0,1],[0,2],[0,3],[0,4],[0,5]
}
