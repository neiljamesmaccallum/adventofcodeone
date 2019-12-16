package com.fdmgroup.adventofcodeone.dayfive;

import java.util.ArrayList;
import java.util.List;

public class AdvancedIntCodeProcessor {

	public static List<Integer> processIntCode(List<Integer> intCode) {
		return processIntCode(intCode, 0);
	}

	public static List<Integer> processIntCode(List<Integer> intCode, int input) {
		for (int i = 0; intCode.get(i) != 99;) {
			Integer opCode;
			Integer firstParameterMode = 0;
			Integer secondParameterMode = 0;
			if (intCode.get(i) > 99) {
				String fullOpCode = intCode.get(i).toString();
				int opCodeStringLength = fullOpCode.length();
				String opCodeString = (fullOpCode.charAt(opCodeStringLength - 2) + ""
						+ fullOpCode.charAt(opCodeStringLength - 1));
				opCode = Integer.parseInt(opCodeString);
				firstParameterMode = Integer.parseInt(fullOpCode.charAt(opCodeStringLength - 3) + "");
				if (opCodeStringLength > 3) {
					secondParameterMode = Integer.parseInt(fullOpCode.charAt(opCodeStringLength - 4) + "");
				}
			} else {
				opCode = intCode.get(i);
			}
			if (opCode == 3) {
				intCode.set(intCode.get(i + 1), input);
				i += 2;
			} else if (opCode == 4) {
				if (firstParameterMode == 1) {
					System.out.println(intCode.get(i + 1));
				} else {
					System.out.println(intCode.get(intCode.get(i + 1)));
				}
				i += 2;
			} else {
				Integer firstParameter;
				if (firstParameterMode == 1) {
					firstParameter = intCode.get(i + 1);
				} else {
					firstParameter = intCode.get(intCode.get(i + 1));
				}
				Integer secondParameter;
				if (secondParameterMode == 1) {
					secondParameter = intCode.get(i + 2);
				} else {
					secondParameter = intCode.get(intCode.get(i + 2));
				}
				Integer thirdParameter = intCode.get(i + 3);
				if (opCode == 1) {
					intCode.set(thirdParameter, firstParameter + secondParameter);
				}
				if (opCode == 2) {
					intCode.set(thirdParameter, firstParameter * secondParameter);
				}
				i += 4;
			}
		}
		return intCode;
	}

	private static int pointerPosition;
	private static int opCode;
	private static int firstParameterMode;
	private static int secondParameterMode;
	private static List<Integer> outputs;
	private static int firstParameter;
	private static int secondParameter;
	private static List<Integer> intCodeReading;

	public static List<Integer> processIntCodeGetOutputs(List<Integer> intCode, int input) {
		outputs = new ArrayList<Integer>();
		intCodeReading = intCode;
		pointerPosition = 0;
		while (intCodeReading.get(pointerPosition) != 99) {
			firstParameterMode = 0;
			secondParameterMode = 0;
			getOpcodeAndParamaterModesForCurrentPositionIn(intCodeReading);
			if (firstParameterMode == 1) {
				firstParameter = intCodeReading.get(pointerPosition + 1);
			} else {
				firstParameter = intCodeReading.get(intCodeReading.get(pointerPosition + 1));
			}
			operateIfOpCodeIsThreeAtPointer(input);
		}
		return outputs;
	}

	private static void operateIfOpCodeIsThreeAtPointer(int input) {
		if (opCode == 3) {
			intCodeReading.set(intCodeReading.get(pointerPosition + 1), input);
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
		} else if (opCode == 8) {
			if (firstParameter == secondParameter) {
				intCodeReading.set(thirdParameter, 1);
			} else {
				intCodeReading.set(thirdParameter, 0);
			}
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
