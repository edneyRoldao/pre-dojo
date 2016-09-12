package business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import application.config.AppConfig;
import models.Killer;
import models.Weapon;
import util.DateUtil;

/**
 * @author edneyroldao
 */
public class MatchGenerator {

	// Attributes
	private int matchId;
	private int index01 = 0;
	private int index02 = 0;
	private List<Killer> killers;
	private List<Weapon> weapons; 
	private Weapon weapon = null;
	private Killer killer01 = null;
	private Killer killer02 = null;
	private Random rd = new Random();
	private StringBuilder sb = new StringBuilder();

	
	// Constructor
	public MatchGenerator(List<Killer> killers, List<Weapon> weapons) {
		this.killers = killers;
		this.weapons = weapons;
		matchId = rd.nextInt(100000000);
	}

	public String matchGenerator() {
		
		String initMatch = DateUtil.getFormattedDate().toString() + " - New match " + matchId + " has started \n";
		System.out.println(initMatch + "\n");
		sb.append(initMatch);
		addInterval();

		for(int i = 0; i < AppConfig.WRESTLE_NUMBER; i++)
			startBatle();
		
		String endMatch = DateUtil.getFormattedDate().toString() + " - Match " + matchId + " has ended \n";
		System.out.println(endMatch);
		sb.append(endMatch + "\n");
		addInterval();
		
		return sb.toString();
	}

	
	/**
	 * This method will simulate a battle.
	 * Each battle ends when just one Killer from the list is alive.
	 */
	private void startBatle() {
		
		List<Killer> Deadkillers = new ArrayList<>();
		
		while(killers.size() > 1) {
			
			index01 = rd.nextInt(killers.size());
			index02 = rd.nextInt(killers.size());
			killer01 = killers.get(index01);
			killer02 = killers.get(index02);
			weapon = getWeaponRandomly();
			
			if(index01 != index02) {
				int attackPoints = killer01.attack(weapon);
				int damagePoints = killer02.getDamagePoint();
				killer02.setDamagePoint(damagePoints - attackPoints);
				System.out.print(killer01.getName().toUpperCase() + " attacks " + killer02.getName().toUpperCase());
				System.out.println(" with " + weapon.getName() + " damage: " + attackPoints);
			}
			
			if(killer02.getDamagePoint() <= 0 && !killer01.getName().equals(killer02.getName())) {
				String date = DateUtil.getFormattedDate().toString();
				String action = date + " - " + killer01.getName() + " killed " + killer02.getName() + " using " + weapon.getName() + "\n";
				System.out.println(action + "\n");
				sb.append(action);
				addInterval();
				
				Deadkillers.add(killer02);
				killers.remove(killer02);
			}
		}

		killers.addAll(Deadkillers);
	}
	
	/**
	 * 
	 * @return Weapon from a list randomly
	 */
	private Weapon getWeaponRandomly() {
		return weapons.get(rd.nextInt(weapons.size()));
	}
	
	/**
	 * Add an interval between each death
	 */
	private void addInterval() {
		
		long interval = 1000 + rd.nextInt(AppConfig.INTERVAL_ACTIONS_IN_SECONDS * 1000);
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
