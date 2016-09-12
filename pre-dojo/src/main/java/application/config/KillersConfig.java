package application.config;

import java.util.ArrayList;
import java.util.List;

import models.Killer;
import models.Ninja;
import models.Soldier;

/**
 * We can add killers name as much as we can.
 * 
 * @author edneyroldao
 */
public class KillersConfig {

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
