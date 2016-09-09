package business;

import java.util.ArrayList;
import java.util.List;

import models.Killer;
import models.Weapon;
import util.DateUtil;

/**
 * @author edneyroldao
 */
public class MatchOutput extends Match {

	// Attributes
	private Killer killer01 = null;
	private Killer killer02 = null;
	private Weapon weapon = null;
	private int index01 = 0;
	private int index02 = 0;

	
	// Constructor
	public MatchOutput(List<Killer> killers, List<Weapon> weapons) {
		setKillers(killers);
		setWeapons(weapons);
		setId(rd.nextInt(100000000));
	}

	public String matchGenerator(int battlesNumber) {
		
		sb.append(DateUtil.getFormattedDate() + " - New match " + getId() + " has started \n");
		addInterval();

		for(int i = 0; i < battlesNumber; i++)
			startBatle();
		
		sb.append(DateUtil.getFormattedDate() + " - Match " + getId() + " has ended \n");
		addInterval();
		
		return sb.toString();
	}

	
	/**
	 * This method will simulate a battle.
	 * Each battle ends when just one Killer from the list is alive.
	 */
	private void startBatle() {
		
		List<Killer> Deadkillers = new ArrayList<>();
		
		while(getKillers().size() > 1) {
			
			index01 = rd.nextInt(getKillers().size());
			index02 = rd.nextInt(getKillers().size());
			killer01 = getKillers().get(index01);
			killer02 = getKillers().get(index02);
			weapon = getWeaponRandomly();
			
			if(index01 != index02) {
				int attackPoints = killer01.attack(weapon);
				int damagePoints = killer02.getDamagePoint();
				killer02.setDamagePoint(damagePoints - attackPoints);
				System.out.print(killer01.getName().toUpperCase() + " attacks " + killer02.getName().toUpperCase());
				System.out.println(" with " + weapon.getName() + " damage: " + attackPoints);
			}
			
			if(killer02.getDamagePoint() <= 0) {
				String action = " - " + killer01.getName() + " killed " + killer02.getName() + " using " + weapon.getName() + "\n";
				sb.append(DateUtil.getFormattedDate() + action);
				addInterval();
				
				Deadkillers.add(killer02);
				getKillers().remove(killer02);
			}
			
		}

		getKillers().addAll(Deadkillers);
	}
	
	/**
	 * 
	 * @return Weapon from a list randomly
	 */
	private Weapon getWeaponRandomly() {
		return getWeapons().get(rd.nextInt(getWeapons().size()));
	}
	
	/**
	 * Add an interval between each death
	 */
	private void addInterval() {
		long interval = 1000 + rd.nextInt(6000);
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
