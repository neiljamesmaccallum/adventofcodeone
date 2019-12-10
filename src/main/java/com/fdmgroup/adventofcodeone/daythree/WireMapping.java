package com.fdmgroup.adventofcodeone.daythree;

import java.util.ArrayList;
import java.util.List;

public class WireMapping {

	public static List<Position> getWirePath(List<String> wireInstructions, Position startingPosition) {
		List<Position> wirePath = new ArrayList<Position>();
		for (String instruction : wireInstructions) {
			wirePath.addAll(getWirePathPortion(instruction, startingPosition));
			startingPosition = wirePath.get(wirePath.size() - 1);
		}
		return wirePath;
	}

	public static List<Position> getWirePathPortion(String wireInstructions, Position position) {
		List<Position> wirePathPortion = new ArrayList<Position>();
		char[] wireInstructionsChar = wireInstructions.toCharArray();
		String stepsAsString = "";
		for (int i = 1; i < wireInstructionsChar.length; i++) {
			stepsAsString += wireInstructionsChar[i];
		}
		int steps = Integer.parseInt(stepsAsString);
		return downwardMotion(position, wirePathPortion, wireInstructionsChar, steps);

	}

	private static List<Position> downwardMotion(Position position, List<Position> wirePathPortion,
			char[] wireInstructionsChar, int steps) {
		if (wireInstructionsChar[0] == 'D') {
			while (steps > 0) {
				Position steppedPosition = new Position(position.getXposition(), position.getYposition() - 1);
				wirePathPortion.add(steppedPosition);
				position = steppedPosition;
				steps--;
			}
			return wirePathPortion;
		}
		return upwardMotion(position, wirePathPortion, wireInstructionsChar, steps);
	}

	private static List<Position> upwardMotion(Position position, List<Position> wirePathPortion,
			char[] wireInstructionsChar, int steps) {
		if (wireInstructionsChar[0] == 'U') {
			while (steps > 0) {
				Position steppedPosition = new Position(position.getXposition(), position.getYposition() + 1);
				wirePathPortion.add(steppedPosition);
				position = steppedPosition;
				steps--;
			}
			return wirePathPortion;
		} 
		return leftwardMotion(position, wirePathPortion, wireInstructionsChar, steps);
	}

	private static List<Position> leftwardMotion(Position position, List<Position> wirePathPortion,
			char[] wireInstructionsChar, int steps) {
		if (wireInstructionsChar[0] == 'L') {
			while (steps > 0) {
				Position steppedPosition = new Position(position.getXposition() - 1, position.getYposition());
				wirePathPortion.add(steppedPosition);
				position = steppedPosition;
				steps--;
			}
			return wirePathPortion;
		}  
		return rightwardMotion(position, wirePathPortion, wireInstructionsChar, steps);
	}

	private static List<Position> rightwardMotion(Position position, List<Position> wirePathPortion,
			char[] wireInstructionsChar, int steps) {
		if (wireInstructionsChar[0] == 'R') {
			while (steps > 0) {
				Position steppedPosition = new Position(position.getXposition() + 1, position.getYposition());
				wirePathPortion.add(steppedPosition);
				position = steppedPosition;
				steps--;
			}
		}
		return wirePathPortion;
	}
}
