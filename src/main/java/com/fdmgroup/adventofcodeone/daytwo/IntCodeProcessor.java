package com.fdmgroup.adventofcodeone.daytwo;

import java.util.List;

public class IntCodeProcessor {

	public static List<Integer> processIntCode(List<Integer> intCode) {

		for (int i = 0; intCode.get(i) != 99; i += 4) {
			int valueLocationOne = intCode.get(i+1);
			int valueLocationTwo = intCode.get(i+2);
			int locationForCalculatedValue = intCode.get(i+3);
			if (intCode.get(i).equals(1)) {
				int calculatedValue = intCode.get(valueLocationOne) + intCode.get(valueLocationTwo);
				intCode.set(locationForCalculatedValue, calculatedValue);
			} else if (intCode.get(i).equals(2)) {
				int calculatedValue = intCode.get(valueLocationOne) * intCode.get(valueLocationTwo);
				intCode.set(locationForCalculatedValue, calculatedValue);
			}
		}
		return intCode;
	}

}
