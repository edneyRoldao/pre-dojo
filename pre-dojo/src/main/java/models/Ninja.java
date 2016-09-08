package models;

/**
 * @author edneyroldao
 */
public class Ninja extends Killer {

	private static final long serialVersionUID = 1L;
	
	public Ninja(String name) {
		super(name, 7777);
	}

	@Override
	public int attack(Weapon weapon) {
		
		if(weapon instanceof Sword || weapon instanceof Knife)
			return weapon.getPowerPoints() + BONUS_ATTACK;
		
		return weapon.getPowerPoints();
	}

}
