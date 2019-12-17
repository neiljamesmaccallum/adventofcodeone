package com.fdmgroup.adventofcodeone.daysix;

import java.util.ArrayList;
import java.util.List;

public class AstronomicalObject {

	private List<AstronomicalObject> satelites;
	private String label;

	public AstronomicalObject(String label) {
		this.label = label;
		satelites = new ArrayList<AstronomicalObject>();
	}

	public void addSatelite(AstronomicalObject astronomicalObjects) {
		satelites.add(astronomicalObjects);
	}

	public List<AstronomicalObject> getSatelites() {
		return satelites;
	}

	public void setSatelites(List<AstronomicalObject> satelites) {
		this.satelites = satelites;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((satelites == null) ? 0 : satelites.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AstronomicalObject other = (AstronomicalObject) obj;
		if (label == null) {
			if (other.label != null) {
				return false;
			}
		} else if (!label.equals(other.label)) {
			return false;
		}
		if (satelites == null) {
			if (other.satelites != null) {
				return false;
			}
		} else {
			for (AstronomicalObject othersatellite : other.satelites) {
				if (!satelites.contains(othersatellite)) {
					return false;
				}
			}
			for (AstronomicalObject satellite : satelites) {
				if (!other.satelites.contains(satellite)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "AstronomicalObject [satelites=" + satelites.size() + ", label=" + label + "]";
	}

}
