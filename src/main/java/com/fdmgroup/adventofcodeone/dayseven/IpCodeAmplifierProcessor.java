package com.fdmgroup.adventofcodeone.dayseven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IpCodeAmplifierProcessor {
	private static int pointerPosition;
	private static int opCode;
	private static int firstParameterMode;
	private static int secondParameterMode;
	private static List<Integer> outputs;
	private static int firstParameter;
	private static int secondParameter;
	private static List<Integer> intCodeReading;
	private static int inputsPointer;

	public static List<Integer> processIntCodeGetOutputs(List<Integer> intCode, List<Integer> inputs) {
		inputsPointer = 0;
		outputs = new ArrayList<Integer>();
		intCodeReading = intCode;
		pointerPosition = 0;
		System.err.println(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28));
		while (intCodeReading.get(pointerPosition) != 99) {
			System.err.println(intCodeReading);
			System.err.println(pointerPosition);
			firstParameterMode = 0;
			secondParameterMode = 0;
			getOpcodeAndParamaterModesForCurrentPositionIn(intCodeReading);
			if (firstParameterMode == 1) {
				firstParameter = intCodeReading.get(pointerPosition + 1);
			} else {
				firstParameter = intCodeReading.get(intCodeReading.get(pointerPosition + 1));
			}
			operateIfOpCodeIsThreeAtPointer(inputs);
		}
		System.out.println("finished read");
		return outputs;
	}

	private static void operateIfOpCodeIsThreeAtPointer(List<Integer> inputs) {
		if (opCode == 3) {
			int input = inputs.get(inputsPointer);
			intCodeReading.set(intCodeReading.get(pointerPosition + 1), input);
			inputsPointer++;
			pointerPosition += 2;
		} else {
			operateIfOpCodeIsFourAtPointer();
		}
	}

	private static void operateIfOpCodeIsFourAtPointer() {
		if (opCode == 4) {
			if (firstParameterMode == 1) {
				outputs.add(intCodeReading.get(pointerPosition + 1));
			} else {
				outputs.add(intCodeReading.get(intCodeReading.get(pointerPosition + 1)));
			}
			pointerPosition += 2;
		} else {
			operateIfOpCodeIsFiveAtPointer();
		}
	}

	private static void operateIfOpCodeIsFiveAtPointer() {
		if (secondParameterMode == 1) {
			secondParameter = intCodeReading.get(pointerPosition + 2);
		} else {
			secondParameter = intCodeReading.get(intCodeReading.get(pointerPosition + 2));
		}
		if (opCode == 5) {
			if (firstParameter != 0) {
				pointerPosition = secondParameter;
			} else {
				pointerPosition += 3;
			}
		} else {
			operateIfOpCodeIsSixAtPointer();
		}
	}

	private static void operateIfOpCodeIsSixAtPointer() {
		if (opCode == 6) {
			if (firstParameter == 0) {
				pointerPosition = secondParameter;
			} else {
				pointerPosition += 3;
			}
		} else {
			operateIfOpCodeIsSevenOrEightAtPointer();
		}
	}

	private static void operateIfOpCodeIsSevenOrEightAtPointer() {
		Integer thirdParameter = intCodeReading.get(pointerPosition + 3);
		if (opCode == 7) {
			if (firstParameter < secondParameter) {
				intCodeReading.set(thirdParameter, 1);
			} else {
				intCodeReading.set(thirdParameter, 0);
			}
			pointerPosition+=4;
		} else if (opCode == 8) {
			if (firstParameter == secondParameter) {
				intCodeReading.set(thirdParameter, 1);
			} else {
				intCodeReading.set(thirdParameter, 0);
			}
			pointerPosition+=4;
		} else {
			operateIfOpCodeIsOneOrTwoAtPointer(thirdParameter);
		}
	}

	private static void operateIfOpCodeIsOneOrTwoAtPointer(Integer thirdParameter) {
		if (opCode == 1) {
			intCodeReading.set(thirdParameter, firstParameter + secondParameter);
		} else if (opCode == 2) {
			intCodeReading.set(thirdParameter, firstParameter * secondParameter);
		}
		pointerPosition += 4;
	}

	private static void getOpcodeAndParamaterModesForCurrentPositionIn(List<Integer> intCode) {
		if (intCodeReading.get(pointerPosition) > 99) {
			String fullOpCode = intCodeReading.get(pointerPosition).toString();
			int opCodeStringLength = fullOpCode.length();
			String opCodeString = (fullOpCode.charAt(opCodeStringLength - 2) + ""
					+ fullOpCode.charAt(opCodeStringLength - 1));
			opCode = Integer.parseInt(opCodeString);
			firstParameterMode = Integer.parseInt(fullOpCode.charAt(opCodeStringLength - 3) + "");
			if (opCodeStringLength > 3) {
				secondParameterMode = Integer.parseInt(fullOpCode.charAt(opCodeStringLength - 4) + "");
			}
		} else {
			opCode = intCodeReading.get(pointerPosition);
		}
	}

}
