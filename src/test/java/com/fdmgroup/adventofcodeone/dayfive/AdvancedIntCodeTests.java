package com.fdmgroup.adventofcodeone.dayfive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AdvancedIntCodeTests {

	List<Integer> intCode;
	List<Integer> processedIntCode;
	List<Integer> expectedOutput;

	@Test
	void test_InputCommandThreeWorks() {
		List<Integer> intCode = Arrays.asList(3, 0, 99);
		int input = 1;
		expectedOutput = Arrays.asList(input, 0, 99);
		processedIntCode = AdvancedIntCodeProcessor.processIntCode(intCode, input);
		assertEquals(expectedOutput, processedIntCode);
	}

	@Test
	void test_IntCodeOfJust_99_ReturnsTheExactInput() {
		intCode = new ArrayList<>();
		intCode.add(99);
		processedIntCode = AdvancedIntCodeProcessor.processIntCode(intCode);
		assertEquals(intCode, processedIntCode);
	}

	@Test
	void test_IntCodeProcessorCorrectlyProcessesOpCodeOfOne() {
		intCode = Arrays.asList(1, 0, 0, 3, 99);
		expectedOutput = Arrays.asList(1, 0, 0, 2, 99);
		processedIntCode = AdvancedIntCodeProcessor.processIntCode(intCode);
		assertEquals(expectedOutput, processedIntCode);
	}

	@Test
	void test_IntCodeProcessorCorrectlyProcessesOpCodeTwo() {
		intCode = Arrays.asList(2, 0, 0, 3, 99);
		expectedOutput = Arrays.asList(2, 0, 0, 4, 99);
		processedIntCode = AdvancedIntCodeProcessor.processIntCode(intCode);
		assertEquals(expectedOutput, processedIntCode);
	}

	@Test
	void test_IntCodeProssorCorrectlyProcessesMultipleOperations() {
		intCode = Arrays.asList(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50);
		expectedOutput = Arrays.asList(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50);
		processedIntCode = AdvancedIntCodeProcessor.processIntCode(intCode);
		assertEquals(expectedOutput, processedIntCode);
	}

	@Test
	void test_IntCodeProcessorDoesNotContinueBeyond99() {
		intCode = Arrays.asList(1, 0, 0, 3, 99, 2, 0, 0, 3);
		expectedOutput = Arrays.asList(1, 0, 0, 2, 99, 2, 0, 0, 3);
		processedIntCode = AdvancedIntCodeProcessor.processIntCode(intCode);
		assertEquals(expectedOutput, processedIntCode);
	}

	@Test
	void test_IntCodeExampleOne() {
		intCode = Arrays.asList(1, 1, 1, 4, 99, 5, 6, 0, 99);
		expectedOutput = Arrays.asList(30, 1, 1, 4, 2, 5, 6, 0, 99);
		processedIntCode = AdvancedIntCodeProcessor.processIntCode(intCode);
		assertEquals(expectedOutput, processedIntCode);
	}

	@Test
	void test_IntCodeExampleTwo() {
		intCode = Arrays.asList(1, 0, 0, 0, 99);
		expectedOutput = Arrays.asList(2, 0, 0, 0, 99);
		processedIntCode = AdvancedIntCodeProcessor.processIntCode(intCode);
		assertEquals(expectedOutput, processedIntCode);
	}

	@Test
	void test_AdvancedIntCodeExampleOneForEight() {
		intCode = Arrays.asList(3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8);
		List<Integer> output = AdvancedIntCodeProcessor.processIntCodeGetOutputs(intCode, 8);
		assertEquals(1, output.get(output.size() - 1));
	}

	@Test
	void test_AdvancedIntCodeExampleOneForNotEight() {
		intCode = Arrays.asList(3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 4);
		List<Integer> output = AdvancedIntCodeProcessor.processIntCodeGetOutputs(intCode, 7);
		assertEquals(0, output.get(output.size() - 1));
	}

	@Test
	void test_AdvancedIntCodeExampleForLessThanEight() {
		intCode = Arrays.asList(3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8);
		List<Integer> output = AdvancedIntCodeProcessor.processIntCodeGetOutputs(intCode, 7);
		assertEquals(1, output.get(output.size() - 1));
	}

	@Test
	void test_AdvancedIntCodeExampleForGreaterThanEight() {
		intCode = Arrays.asList(3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8);
		List<Integer> output = AdvancedIntCodeProcessor.processIntCodeGetOutputs(intCode, 9);
		assertEquals(0, output.get(output.size() - 1));
	}

	@Test
	void test_AdvancedCodeExampleThreeForEqualToEight() {
		intCode = Arrays.asList(3, 3, 1108, -1, 8, 3, 4, 3, 99);
		List<Integer> output = AdvancedIntCodeProcessor.processIntCodeGetOutputs(intCode, 8);
		assertEquals(1, output.get(output.size() - 1));
	}

	@Test
	void test_AdvancedIntCodeExampleThreeForNotEight() {
		intCode = Arrays.asList(3, 3, 1108, -1, 8, 3, 4, 3, 99);
		List<Integer> output = AdvancedIntCodeProcessor.processIntCodeGetOutputs(intCode, 9);
		assertEquals(0, output.get(output.size() - 1));
	}

	@Test
	void test_AdvancedIntCodeExampleFourForLessThanEight() {
		intCode = Arrays.asList(3, 3, 1107, -1, 8, 3, 4, 3, 99);
		List<Integer> output = AdvancedIntCodeProcessor.processIntCodeGetOutputs(intCode, 7);
		assertEquals(1, output.get(output.size() - 1));
	}

	@Test
	void test_AdvancedIntCodeExampleFourForGreaterThanEight() {
		intCode = Arrays.asList(3, 3, 1107, -1, 8, 3, 4, 3, 99);
		List<Integer> output = AdvancedIntCodeProcessor.processIntCodeGetOutputs(intCode, 9);
		assertEquals(0, output.get(output.size() - 1));
	}

	@Test
	void test_AdvancedIntCodeExampleFiveForZero() {
		intCode = Arrays.asList(3, 12, 6, 12, 15, 1, 13, 14, 13, 4, 13, 99, -1, 0, 1, 9);
		List<Integer> output = AdvancedIntCodeProcessor.processIntCodeGetOutputs(intCode, 0);
		assertEquals(0, output.get(output.size() - 1));
	}

	@Test
	void test_AdvancedIntCodeExampleFiveForNonZero() {
		intCode = Arrays.asList(3, 12, 6, 12, 15, 1, 13, 14, 13, 4, 13, 99, -1, 0, 1, 9);
		List<Integer> output = AdvancedIntCodeProcessor.processIntCodeGetOutputs(intCode, 5);
		assertEquals(1, output.get(output.size() - 1));
	}

	@Test
	void test_AdvancedIntCodeExampleFiveImmediateForZero() {
		intCode = Arrays.asList(3, 3, 1105, -1, 9, 1101, 0, 0, 12, 4, 12, 99, 1);
		List<Integer> output = AdvancedIntCodeProcessor.processIntCodeGetOutputs(intCode, 0);
		assertEquals(0, output.get(output.size() - 1));
	}

	@Test
	void test_AdvancedIntCodeExampleFiveImmediateForNonZero() {
		intCode = Arrays.asList(3, 3, 1105, -1, 9, 1101, 0, 0, 12, 4, 12, 99, 1);
		List<Integer> output = AdvancedIntCodeProcessor.processIntCodeGetOutputs(intCode, 5);
		assertEquals(1, output.get(output.size() - 1));
	}

	@Test
	void test_AdvancedIntCodeExampleSixForLessThanEight() {
		intCode = Arrays.asList(3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31, 1106, 0, 36, 98, 0,
				0, 1002, 21, 125, 20, 4, 20, 1105, 1, 46, 104, 999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46,
				98, 99);
		List<Integer> output = AdvancedIntCodeProcessor.processIntCodeGetOutputs(intCode, 5);
		assertEquals(999, output.get(output.size() - 1));
	}

	@Test
	void test_AdvancedIntCodeExampleSixForEqualsEight() {
		intCode = Arrays.asList(3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31, 1106, 0, 36, 98, 0,
				0, 1002, 21, 125, 20, 4, 20, 1105, 1, 46, 104, 999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46,
				98, 99);
		List<Integer> output = AdvancedIntCodeProcessor.processIntCodeGetOutputs(intCode, 8);
		assertEquals(1000, output.get(output.size() - 1));
	}

	@Test
	void test_AdvancedIntCodeExampleSixForGreaterThanEight() {
		intCode = Arrays.asList(3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31, 1106, 0, 36, 98, 0,
				0, 1002, 21, 125, 20, 4, 20, 1105, 1, 46, 104, 999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46,
				98, 99);
		List<Integer> output = AdvancedIntCodeProcessor.processIntCodeGetOutputs(intCode, 9);
		assertEquals(1001, output.get(output.size() - 1));
	}

}
