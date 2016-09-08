package models;

import java.io.Serializable;

/**
 * @author edneyroldao
 */
public abstract class Weapon implements Serializable, Comparable<Weapon> {

	private static final long serialVersionUID = 1L;
	
	// Attributes
	private String name;
	private int powerPoints;
	
	// Constructor
	public Weapon(String name, int powerPoints) {
		this.name = name;
		this.powerPoints = powerPoints;
	}

	
	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPowerPoints() {
		return powerPoints;
	}

	public void setPowerPoints(int powerPoints) {
		this.powerPoints = powerPoints;
	}
	
	@Override
	public int compareTo(Weapon other) {
		return this.name.compareToIgnoreCase(other.name);
	}
	
	
}
