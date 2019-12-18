package com.fdmgroup.adventofcodeone.dayseven;

import java.util.Arrays;
import java.util.List;

public class AmplifierProcessor {

	public static int generateThrusterSignal(List<Integer> thrusterInputs, List<Integer> intCode) {
		int initialInput = 0;
		List<Integer> inputs;
		List<Integer> amplifierOutputs;
		for(int i=0;i<thrusterInputs.size();i++) {
			inputs = Arrays.asList(thrusterInputs.get(i),initialInput);
			amplifierOutputs = IpCodeAmplifierProcessor.processIntCodeGetOutputs(intCode, inputs);
			initialInput = amplifierOutputs.get(amplifierOutputs.size()-1);
		}
		return initialInput;
	}
}
