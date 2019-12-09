package com.fdmgroup.adventofcodeone.daythree;

public class Position {

	private Integer xposition;
	private Integer yposition;
	public Position(Integer xposition, Integer yposition) {
		super();
		this.xposition = xposition;
		this.yposition = yposition;
	}
	public Integer getXposition() {
		return xposition;
	}
	public void setXposition(Integer xposition) {
		this.xposition = xposition;
	}
	public Integer getYposition() {
		return yposition;
	}
	public void setYposition(Integer yposition) {
		this.yposition = yposition;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((xposition == null) ? 0 : xposition.hashCode());
		result = prime * result + ((yposition == null) ? 0 : yposition.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (xposition == null) {
			if (other.xposition != null)
				return false;
		} else if (!xposition.equals(other.xposition))
			return false;
		if (yposition == null) {
			if (other.yposition != null)
				return false;
		} else if (!yposition.equals(other.yposition))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "[" + xposition + "," + yposition + "]";
	}
	
	
}
