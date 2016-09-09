package util;

import java.util.ArrayList;
import java.util.List;

import models.Explosive;
import models.Gun;
import models.Killer;
import models.Knife;
import models.Ninja;
import models.Soldier;
import models.Sword;
import models.Weapon;

/**
 * @author Edney Roldao
 */
public class MockUtil {

	public static List<Weapon> getWeaponList() {
		
		List<Weapon> weapons = new ArrayList<>();
		weapons.add(new Knife("special knife"));
		weapons.add(new Sword("Masamune blade"));
		weapons.add(new Gun("AK 47"));
		weapons.add(new Explosive("C4"));
		
		return weapons;
	}
	
	public static List<Killer> getKillerList() {
	
		List<Killer> killers = new ArrayList<>();
		killers.add(new Soldier("<WORLD>"));
		killers.add(new Ninja("Roman Reigns"));
		killers.add(new Soldier("Kevin Owens"));
		killers.add(new Ninja("Seth Rollins"));
		killers.add(new Soldier("The Undertaker"));

		return killers;
	}
	
}
