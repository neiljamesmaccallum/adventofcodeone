package com.fdmgroup.adventofcodeone.daysix;

import java.util.List;

public class AmplifierProcessor {

	private int intCodeReadingPosition;

	private List<Integer> inputs;
	private List<Integer> intCode;
	private boolean isRunning;

	public AmplifierProcessor(List<Integer> inputs, List<Integer> intCode) {
		this.intCode = intCode;
		this.inputs = inputs;
		intCodeReadingPosition = 0;
	}

	public int processIntCode() {
		if (!isRunning) {
			intCodeReadingPosition = 0;
		}
		isRunning = true;
		while (isRunning) {
			Integer fullOpCode = intCode.get(intCodeReadingPosition);
			Integer firstParamaterMode = 0;
			Integer secondParameterMode = 0;
			Integer opCode;
			if (fullOpCode > 99) {
				char[] opCodeCharArray = fullOpCode.toString().toCharArray();
				if (fullOpCode > 999) {
					secondParameterMode = Integer.parseInt(opCodeCharArray[0] + "");
					opCodeCharArray[0] = opCodeCharArray[1];
					opCodeCharArray[1] = opCodeCharArray[2];
					opCodeCharArray[2] = opCodeCharArray[3];
				}
				firstParamaterMode = Integer.parseInt(opCodeCharArray[0] + "");
				opCode = Integer.parseInt(opCodeCharArray[1] + opCodeCharArray[2] + "");
			} else {
				opCode = fullOpCode;
			}
			return 0;
		}
	}

}
