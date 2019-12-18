package com.fdmgroup.adventofcodeone.dayseven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThrusterSignalMaximizer {

	public static int maximizedThrusterSignal(List<Integer> intCode) {
		int maxThrusterSignal = 0;
		List<Integer> possibleInputs = Arrays.asList(0, 1, 2, 3, 4);
		List<List<Integer>> possibleCombinations = getAllPossibleCombinations(possibleInputs);
		for (List<Integer> phaseSetting : possibleCombinations) {
			int signal = 0;
			for (int n = 0; n < 5; n++) {
				List<Integer> outputs = IpCodeAmplifierProcessor.processIntCodeGetOutputs(intCode,
						Arrays.asList(phaseSetting.get(n), signal));
				signal = outputs.get(outputs.size() - 1);
			}
			if (maxThrusterSignal < signal) {
				maxThrusterSignal = signal;
				System.out.println(phaseSetting);
				System.out.println(signal);
			}
		}
		return maxThrusterSignal;
	}

	public static int maximizedThrusterSignalFeedBackLoopVersion(List<Integer> intCode) {
		int maxThrusterSignal = 0;
		List<Integer> possibleInputs = Arrays.asList(5, 6, 7, 8, 9);
		List<List<Integer>> possibleCombinations = getAllPossibleCombinations(possibleInputs);
		for (List<Integer> phaseSetting : possibleCombinations) {
			int signal = 0;
			int previousSignal = -1;
			while (signal > previousSignal) {
				for (int n = 0; n < 5; n++) {
					List<Integer> outputs = IpCodeAmplifierProcessor.processIntCodeGetOutputs(intCode,
							Arrays.asList(phaseSetting.get(n), signal));
					previousSignal = signal;
					signal = outputs.get(outputs.size() - 1);
				}
			}
			if (maxThrusterSignal < signal) {
				maxThrusterSignal = signal;
				System.out.println(phaseSetting);
				System.out.println(signal);
			}

		}
		return maxThrusterSignal;
	}

	private static List<List<Integer>> getAllPossibleCombinations(List<Integer> possibleInputs) {
		List<List<Integer>> possibleCombinations = new ArrayList<List<Integer>>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j != i) {
					for (int k = 0; k < 5; k++) {
						if (k != i && k != j) {
							for (int l = 0; l < 5; l++) {
								if (l != i && l != k && l != j) {
									for (int m = 0; m < 5; m++) {
										if (m != i && m != l && m != k && m != j) {
											Integer firstInput = possibleInputs.get(i);
											Integer secondInput = possibleInputs.get(j);
											Integer thirdInput = possibleInputs.get(k);
											Integer fourthInput = possibleInputs.get(l);
											Integer fifthInput = possibleInputs.get(m);
											List<Integer> inputs = Arrays.asList(firstInput, secondInput, thirdInput,
													fourthInput, fifthInput);
											possibleCombinations.add(inputs);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return possibleCombinations;
	}
}
