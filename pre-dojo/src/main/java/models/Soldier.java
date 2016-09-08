package models;

import interfaces.Ability;

/**
 * @author edneyroldao
 */
public class Soldier extends Killer implements Ability {

	private static final long serialVersionUID = 1L;
	
	public Soldier(String name) {
		super(name, 7777);
	}

	@Override
	public int attack(Weapon weapon) {
		
		if(weapon instanceof Gun || weapon instanceof Explosive)
			return weapon.getPowerPoints() + BONUS_ATTACK;
		
		return weapon.getPowerPoints();
	}

}