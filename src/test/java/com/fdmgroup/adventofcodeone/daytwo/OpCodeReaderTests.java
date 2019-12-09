package com.fdmgroup.adventofcodeone.daytwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fdmgroup.adventofcodeone.daytwo.IntCodeProcessor;

public class OpCodeReaderTests {

	List<Integer> intCode;
	List<Integer> expectedOutput;
	List<Integer> processedIntCode;

	@Test
	void test_IntCodeOfJust_99_ReturnsTheExactInput() {
		intCode = new ArrayList<>();
		intCode.add(99);
		processedIntCode = IntCodeProcessor.processIntCode(intCode);
		assertEquals(intCode, processedIntCode);
	}

	@Test
	void test_IntCodeProcessorCorrectlyProcessesOpCodeOfOne() {
		intCode = Arrays.asList(1, 0, 0, 3, 99);
		expectedOutput = Arrays.asList(1, 0, 0, 2, 99);
		processedIntCode = IntCodeProcessor.processIntCode(intCode);
		assertEquals(expectedOutput, processedIntCode);
	}

	@Test
	void test_IntCodeProcessorCorrectlyProcessesOpCodeTwo() {
		intCode = Arrays.asList(2, 0, 0, 3, 99);
		expectedOutput = Arrays.asList(2, 0, 0, 4, 99);
		processedIntCode = IntCodeProcessor.processIntCode(intCode);
		assertEquals(expectedOutput, processedIntCode);
	}

	@Test
	void test_IntCodeProssorCorrectlyProcessesMultipleOperations() {
		intCode = Arrays.asList(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50);
		expectedOutput = Arrays.asList(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50);
		processedIntCode = IntCodeProcessor.processIntCode(intCode);
		assertEquals(expectedOutput, processedIntCode);
	}
	
	@Test
	void test_IntCodeProcessorDoesNotContinueBeyond99() {
		intCode = Arrays.asList(1,0,0,3,99,2,0,0,3);
		expectedOutput = Arrays.asList(1,0,0,2,99,2,0,0,3);
		processedIntCode = IntCodeProcessor.processIntCode(intCode);
		assertEquals(expectedOutput, processedIntCode);
	}
	
	@Test
	void test_IntCodeExampleOne() {
		intCode = Arrays.asList(1,1,1,4,99,5,6,0,99);
		expectedOutput = Arrays.asList(30,1,1,4,2,5,6,0,99);
		processedIntCode = IntCodeProcessor.processIntCode(intCode);
		assertEquals(expectedOutput, processedIntCode);
	}
	
	@Test
	void test_IntCodeExampleTwo() {
		intCode = Arrays.asList(1,0,0,0,99);
		expectedOutput = Arrays.asList(2,0,0,0,99);
		processedIntCode = IntCodeProcessor.processIntCode(intCode);
		assertEquals(expectedOutput, processedIntCode);
	}
}
