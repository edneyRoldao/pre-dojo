package business;

import java.util.List;
import java.util.Random;

import models.Killer;
import models.Weapon;

/**
 * @author edneyroldao
 */
public abstract class Match {

	// Attributes
	private int id;
	private List<Killer> killers;
	private List<Weapon> weapons;
	protected Random rd = new Random();
	protected StringBuilder sb = new StringBuilder();

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<Killer> getKillers() {
		return killers;
	}

	public void setKillers(List<Killer> killers) {
		this.killers = killers;
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}

}
