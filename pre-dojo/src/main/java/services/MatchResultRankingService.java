package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import business.MatchInput;
import interfaces.DisplayMatchResults;
import models.Killer;

/**
 * @author Edney Roldao
 */
public class MatchResultRankingService implements DisplayMatchResults {

	
	private MatchInput match;
	
	/**
	 * This method must be called before others methods.
	 * @param fileLocation 
	 */
	public void init(String fileLocation, String fileName) {
		match = new MatchInput(fileLocation, fileName);
	}
	
	/**
	 * @return match ID.
	 */
	public int getMatchId() {
		return match.getId();
	}
	
	@Override
	public List<String> getMurdersRanking() {
		List<String> murders = new ArrayList<>();
		
		Comparator<Killer> murderComparator = (k1, k2) -> {
			Integer murder = k1.getMurdersNumber(); 
			return murder.compareTo(k2.getMurdersNumber());
		};
		
		Collections.sort(match.getKillers(), Collections.reverseOrder(murderComparator));
		match.getKillers().forEach(k -> murders.add("Killer Name: " + k.getName() + "  -  Murders number: " + k.getMurdersNumber()));
		
		return murders;
	}

	@Override
	public List<String> getDeadRanking() {
		List<String> deaths = new ArrayList<>();
		
		Comparator<Killer> deathComparator = (d1, d2) -> {
			Integer death = d1.getDeathsNumber(); 
			return death.compareTo(d2.getDeathsNumber());
		};
		
		Collections.sort(match.getKillers(), Collections.reverseOrder(deathComparator));
		match.getKillers().forEach(k -> deaths.add("Dead Name: " + k.getName() + "  -  Deaths number: " + k.getDeathsNumber()));
		
		return deaths;
	}

	@Override
	public String getBestWeaponFromWinner() {
		
		Comparator<Killer> murderComparator = (k1, k2) -> {
			Integer murders = k1.getMurdersNumber(); 
			return murders.compareTo(k2.getMurdersNumber());
		};

		match.getKillers().sort(murderComparator);
		
		int index = match.getKillers().size() - 1;
		Killer k = match.getKillers().get(index);
		
		String weapon = "";
		
		for(String key : k.getWeapons().keySet()) {
			weapon = key + "  murders number: ( " + k.getWeapons().get(key) + " )";
		}
		
		return new String("Winner name: " + k.getName() + "  -  Weapon more used: " + weapon);
	}

	@Override
	public String getGreaterMurdersSequenceBeforeDeath() {
		
		Comparator<Killer> greaterMurderSeq = (s1, s2) -> {
			Integer seq = s1.getMurderSequence();
			return seq.compareTo(s2.getMurderSequence());
		};
		
		Collections.sort(match.getKillers(), Collections.reverseOrder(greaterMurderSeq));

		int index = match.getKillers().size() - 1;
		Killer k = match.getKillers().get(index);
		
		return new String("Greater sequence murders killer name: " + k.getName() + " - greater sequence: ( " + k.getMurderSequence() + " )");
	}

	@Override
	public List<String> getAwardsEarnedRanking() {
		List<String> awards = new ArrayList<>();
		
		Comparator<Killer> awardsComparator = (a1, a2) -> {
			Integer award = a1.getAwardNumber();
			return award.compareTo(a2.getAwardNumber());
		};

		Collections.sort(match.getKillers(), Collections.reverseOrder(awardsComparator));
		match.getKillers().forEach(k -> awards.add("Killer name: " + k.getName() + " awards earned: ( " + k.getAwardNumber() + ") ") );
		
		return awards;
	}
	
}
