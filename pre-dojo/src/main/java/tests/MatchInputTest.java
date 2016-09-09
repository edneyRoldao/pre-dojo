package tests;


import business.MatchInput;
import models.Killer;

public class MatchInputTest {

	public static void main(String[] args) {
		
		MatchInput match = new MatchInput("/Users/edneyroldao/workspace/JAVA/projects/pre-dojo/logFiles/log.txt");
		
		System.out.println(match.getId());
		
		System.out.println();
		
		for(Killer k : match.getKillers()) {
			System.out.println("/////////////////////////////////////////////////////////");
			System.out.println(k.getName());
			System.out.println("Murders: " + k.getMurdersNumber());
			System.out.println("Deaths: " + k.getDeathsNumber());

			for(String key : k.getWeapons().keySet()) {
				System.out.println("Weapon: " + key + " (murders " + k.getWeapons().get(key) + ")");
			}
			
			System.out.println("Greater murder sequence: " + k.getMurderSequence());
			System.out.println("awards: " + k.getAwardNumber());
			System.out.println();
		}
		
	}
	
}
