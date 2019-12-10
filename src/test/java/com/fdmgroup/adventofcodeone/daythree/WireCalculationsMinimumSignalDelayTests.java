package com.fdmgroup.adventofcodeone.daythree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WireCalculationsMinimumSignalDelayTests {

	
	@Test
	void test_MinimumSignalDelay_ReturnsCorrectResult() {
		List<String> instructions1 = Arrays.asList("R8","U5","L5","D3");
		List<String> instructions2 = Arrays.asList("U7","R6","D4","L4");
		int signalDelay = WireCalculations.minimumSignalDelay(instructions1,instructions2);
		assertEquals(30, signalDelay);
	}
	
	@Test
	void test_MinimumSignalDelay_ExampleOne() {
		List<String> instructions1 = Arrays.asList("R75","D30","R83","U83","L12","D49","R71","U7","L72");
		List<String> instructions2 = Arrays.asList("U62","R66","U55","R34","D71","R55","D58","R83");
		int signalDelay = WireCalculations.minimumSignalDelay(instructions1, instructions2);
		assertEquals(610, signalDelay);
	}
	
	@Test
	void test_MinimumSignalDelay_ExampleTwo() {
		List<String> instructions1 = Arrays.asList("R98","U47","R26","D63","R33","U87","L62","D20","R33","U53","R51");
		List<String> instructions2 = Arrays.asList("U98","R91","D20","R16","D67","R40","U7","R15","U6","R7");
		int signalDelay = WireCalculations.minimumSignalDelay(instructions1, instructions2);
		assertEquals(410, signalDelay);
	}
}
