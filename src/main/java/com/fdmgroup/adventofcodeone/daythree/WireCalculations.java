package com.fdmgroup.adventofcodeone.daythree;

import java.util.ArrayList;
import java.util.List;

public class WireCalculations {

	public static List<Position> overLapPositions(List<String> instructions1, List<String> instructions2) {
		List<Position> overlapPositions = new ArrayList<Position>();
		Position startingPosition = new Position(0, 0);
		List<Position> pathOfWire1 = WireMapping.getWirePath(instructions1, startingPosition);
		List<Position> pathOfWire2 = WireMapping.getWirePath(instructions2, startingPosition);
		for (Position position : pathOfWire1) {
			if (pathOfWire2.contains(position)) {
				overlapPositions.add(position);
			}
		}
		return overlapPositions;
	}

	public static Position closestOverlap(List<String> instructions1, List<String> instructions2) {
		List<Position> overlapPosition = overLapPositions(instructions1, instructions2);
		Position closestPosition = null;
		double distanceFromOrigin = -1;
		for (Position overlap : overlapPosition) {
			if (distanceFromOrigin == -1 || absoluteDistanceFromOrigin(overlap) < distanceFromOrigin) {
				distanceFromOrigin = absoluteDistanceFromOrigin(overlap);
				closestPosition = overlap;
			}
		}
		return closestPosition;
	}

	private static int absoluteDistanceFromOrigin(Position overlap) {
		return Math.abs(overlap.getXposition()) + Math.abs(overlap.getYposition());
	}

	public static int closestOverlapManhattanDistance(List<String> instructions1, List<String> instructions2) {
		Position closestOverlap = closestOverlap(instructions1, instructions2);
		int manhattanDistance = closestOverlap.getXposition() + closestOverlap.getYposition();
		return manhattanDistance;
	}

	public static int minimumSignalDelay(List<String> instructions1, List<String> instructions2) {
		Position startingPosition = new Position(0, 0);
		List<Position> wireOnePositions =WireMapping.getWirePath(instructions1, startingPosition);
		List<Position> wireTwoPositions = WireMapping.getWirePath(instructions2, startingPosition);
		List<Position> overlapPositions = overLapPositions(instructions1, instructions2);
		int minimumSignalDelay = -1;
		for(Position overlap : overlapPositions) {
			int signalDelay = wireOnePositions.indexOf(overlap)+wireTwoPositions.indexOf(overlap)+2;
			if(minimumSignalDelay == -1 || signalDelay<minimumSignalDelay) {
				minimumSignalDelay=signalDelay;
			}
		}
		return minimumSignalDelay;
	}

}
