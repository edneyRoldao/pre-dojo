package models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import interfaces.Ability;
import util.MapUtil;

/**
 * @author edneyroldao
 */
public abstract class Killer implements Serializable, Comparable<Killer>, Ability {

	private static final long serialVersionUID = 1L;

	protected static final int BONUS_ATTACK = 500;
	
	// Attributes
	private String name;
	private Map<String, Integer> weapons = new HashMap<>();
	private int damagePoint;
	private int deathsNumber;
	private int murdersNumber;
	private int awardNumber;
	private int murderSequence;
	
	// Constructor
	public Killer(String name, int damagePoint) {
		this.name = name;
		this.damagePoint = damagePoint;
	}

	
	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Integer> getWeapons() {
		return weapons;
	}
	
	
	public void setWeapons(Map<String, Integer> weapons) {
		this.weapons = MapUtil.sortByValue(weapons);
	}

	public int getDamagePoint() {
		return damagePoint;
	}



	public void setDamagePoint(int damagePoint) {
		this.damagePoint = damagePoint;
	}

	public int getDeathsNumber() {
		return deathsNumber;
	}

	public void setDeathsNumber(int deathsNumber) {
		this.deathsNumber = deathsNumber;
	}

	public int getMurdersNumber() {
		return murdersNumber;
	}

	public void setMurdersNumber(int murdersNumber) {
		this.murdersNumber = murdersNumber;
	}

	public int getAwardNumber() {
		return awardNumber;
	}

	public void setAwardNumber(int awardNumber) {
		this.awardNumber = awardNumber;
	}

	public int getMurderSequence() {
		return murderSequence;
	}
	
	public void setMurderSequence(int murderSequence) {
		this.murderSequence = murderSequence;
	}
	
	@Override
	public int compareTo(Killer other) {
		return this.name.compareToIgnoreCase(other.name);
	}
	
}
