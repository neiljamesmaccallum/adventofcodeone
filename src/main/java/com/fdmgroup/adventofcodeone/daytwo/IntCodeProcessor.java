package com.fdmgroup.adventofcodeone.daytwo;

import java.util.List;

public class IntCodeProcessor {

	public static List<Integer> processIntCode(List<Integer> intCode) {

		for (int i = 0; intCode.get(i) != 99; i += 4) {
			if (intCode.get(i).equals(1)) {
				intCode = processCommandOne(intCode, i);
			} else if (intCode.get(i).equals(2)) {
				intCode = processCommandTwo(intCode, i);
			}
		}
		return intCode;
	}

	private static List<Integer> processCommandOne(List<Integer> intCode, int position) {
		int valueLocationOne = intCode.get(position + 1);
		int valueLocationTwo = intCode.get(position + 2);
		int locationForCalculatedValue = intCode.get(position + 3);
		int calculatedValue = intCode.get(valueLocationOne) + intCode.get(valueLocationTwo);
		intCode.set(locationForCalculatedValue, calculatedValue);
		return intCode;
	}

	private static List<Integer> processCommandTwo(List<Integer> intCode, int position) {
		int valueLocationOne = intCode.get(position + 1);
		int valueLocationTwo = intCode.get(position + 2);
		int locationForCalculatedValue = intCode.get(position + 3);
		int calculatedValue = intCode.get(valueLocationOne) * intCode.get(valueLocationTwo);
		intCode.set(locationForCalculatedValue, calculatedValue);
		return intCode;
	}
}
