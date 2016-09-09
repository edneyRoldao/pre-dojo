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
		StringBuilder sb = new StringBuilder();
		
		Comparator<Killer> murderComparator = (k1, k2) -> {
			Integer murders = k1.getMurdersNumber(); 
			return murders.compareTo(k2.getMurdersNumber());
		};

		Collections.sort(match.getKillers(), Collections.reverseOrder(murderComparator));
		Killer k = match.getKillers().get(0);
		
		sb.append("Winner name: " + k.getName() + "\n");
		
		k.getWeaponMoreUsed().forEach(s -> {
			String[] token = s.split(";");
			sb.append("Weapon more used: " + token[1].trim() + " Weapon more used: ( " + token[0].trim() + " )" + "\n");
		});
		
		return sb.toString();
	}

	@Override
	public List<String> getGreaterMurdersSequenceBeforeDeath() {
		List<String> list = new ArrayList<>();
		
		Comparator<Killer> greaterMurderSeq = (s1, s2) -> {
			Integer seq = s1.getMurderSequence();
			return seq.compareTo(s2.getMurderSequence());
		};
		
		Collections.sort(match.getKillers(), Collections.reverseOrder(greaterMurderSeq));
		
		int control = match.getKillers().get(0).getMurderSequence();
		
		match.getKillers().forEach(k -> {
			if(k.getMurderSequence() == control)
				list.add("Greater sequence murders killer name: " + k.getName() + " - greater sequence: ( " + k.getMurderSequence() + " )");
		});

		return list;
	}

	@Override
	public List<String> getAwardsEarnedByFiveMurders() {
		List<String> awards = new ArrayList<>();
		
		Comparator<Killer> awardsComparator = (a1, a2) -> {
			Integer award = a1.getAwardFiveMurdersOneMinute();
			return award.compareTo(a2.getAwardFiveMurdersOneMinute());
		};

		Collections.sort(match.getKillers(), Collections.reverseOrder(awardsComparator));
		
		match.getKillers().forEach(k -> {
			if(k.getAwardFiveMurdersOneMinute() > 0)
				awards.add("Killer name: " + k.getName() + "   - awards earned by five murders in a minute ( " + k.getAwardFiveMurdersOneMinute() + " )");
		});
		
		return awards;
	}
	
	@Override
	public List<String> getAwardsEarnedByMatchWithoutDeath() {
		List<String> awards = new ArrayList<>();
		
		Comparator<Killer> awardsComparator = (a1, a2) -> {
			Integer award = a1.getAwardMatchWithoutDeath();
			return award.compareTo(a2.getAwardMatchWithoutDeath());
		};

		Collections.sort(match.getKillers(), Collections.reverseOrder(awardsComparator));
		
		match.getKillers().forEach(k -> {
			if(k.getAwardMatchWithoutDeath() > 0)
				awards.add("Killer name: " + k.getName() + "   - awards obtained by win a match without death ( " + k.getAwardMatchWithoutDeath() + " )");
		});
		
		return awards;
	}
	
}
