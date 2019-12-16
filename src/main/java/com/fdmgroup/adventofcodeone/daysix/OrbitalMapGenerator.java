package com.fdmgroup.adventofcodeone.daysix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrbitalMapGenerator {

	public static Map<String, AstronomicalObject> generateOrbitalMap(List<String> mapInstructions) {
		Map<String, AstronomicalObject> orbitalMap = new HashMap<String, AstronomicalObject>();
		for(String instruction : mapInstructions) {
			char[] instructionCharArray = instruction.toCharArray();
			String orbittingLabel ="";
			String orbitterLabel ="";
			int pointerPosition = 0;
			while(instructionCharArray[pointerPosition]!=')') {
				orbittingLabel += instructionCharArray[pointerPosition];
				pointerPosition++;
			}
			for(int i = pointerPosition+1; i<instructionCharArray.length;i++) {
				orbitterLabel+= instructionCharArray[i];
			}
			if(!orbitalMap.containsKey(orbittingLabel)) {
				orbitalMap.put(orbittingLabel, new AstronomicalObject(orbittingLabel));
			}
			AstronomicalObject orbitterObject = new AstronomicalObject(orbitterLabel);
			orbitalMap.get(orbittingLabel).addSatelite(orbitterObject);
			orbitalMap.put(orbitterLabel, orbitterObject);
		}
		System.out.println(orbitalMap);
		return orbitalMap;
	}

}
