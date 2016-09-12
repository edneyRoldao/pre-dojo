package application.config;

import java.util.ArrayList;
import java.util.List;

import models.Explosive;
import models.Gun;
import models.Knife;
import models.Sword;
import models.Weapon;

/**
 * We can add weapons name as much as we can.
 * Each Killer will use these randomly.
 * 
 * @author edneyroldao
 */
public class WeaponsConfig {

	public static List<Weapon> getWeaponList() {
		List<Weapon> weapons = new ArrayList<>();
		weapons.add(new Knife("special knife"));
		weapons.add(new Sword("Masamune blade"));
		weapons.add(new Gun("AK 47"));
		weapons.add(new Explosive("C4"));
		
		return weapons;
	}
	
}
