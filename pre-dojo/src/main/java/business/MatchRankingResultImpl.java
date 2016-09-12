package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import interfaces.MatchRankingResult;
import models.Killer;

@Component
public class MatchRankingResultImpl implements MatchRankingResult {

	private MatchCompiler compiler;

	/**
	 * This method must be called before others methods.
	 * 
	 * @param fileLocation
	 */
	@Override
	public void init() {
		compiler = new MatchCompiler();
	}

	@Override
	public int getMatchId() {
		return compiler.getMatchId();
	}

	@Override
	public List<String> getMurdersRanking() {
		List<String> murders = new ArrayList<>();

		Comparator<Killer> murderComparator = (k1, k2) -> {
			Integer murder = k1.getMurdersNumber();
			return murder.compareTo(k2.getMurdersNumber());
		};

		Collections.sort(compiler.getKillers(), Collections.reverseOrder(murderComparator));

		compiler.getKillers().forEach(k -> {
			murders.add("Killer Name: " + k.getName() + "  -  Murders number: " + k.getMurdersNumber());
		});

		return murders;
	}

	@Override
	public List<String> getDeadRanking() {
		List<String> deaths = new ArrayList<>();

		Comparator<Killer> deathComparator = (d1, d2) -> {
			Integer death = d1.getDeathsNumber();
			return death.compareTo(d2.getDeathsNumber());
		};

		Collections.sort(compiler.getKillers(), Collections.reverseOrder(deathComparator));
		compiler.getKillers()
				.forEach(k -> deaths.add("Dead Name: " + k.getName() + "  -  Deaths number: " + k.getDeathsNumber()));

		return deaths;
	}

	@Override
	public Killer getChampionKiller() {

		Comparator<Killer> murderComparator = (k1, k2) -> {
			Integer murders = k1.getMurdersNumber();
			return murders.compareTo(k2.getMurdersNumber());
		};

		Collections.sort(compiler.getKillers(), Collections.reverseOrder(murderComparator));
		
		return compiler.getKillers().get(0);
	}
	
	@Override
	public List<String> getBestWeaponFromWinner(Killer k) {
		List<String> list = new ArrayList<>();

		k.getWeaponMoreUsed().forEach(s -> {
			String[] token = s.split(";");
			list.add("Weapon more used: " + token[1].trim() + "  -  It was used ( " + token[0].trim() + " )" + " times" + "\n");
		});

		return list;
	}

	@Override
	public List<String> getGreaterMurdersSequenceBeforeDie() {
		List<String> list = new ArrayList<>();

		Comparator<Killer> greaterMurderSeq = (s1, s2) -> {
			Integer seq = s1.getMurderSequence();
			return seq.compareTo(s2.getMurderSequence());
		};

		Collections.sort(compiler.getKillers(), Collections.reverseOrder(greaterMurderSeq));

		int control = compiler.getKillers().get(0).getMurderSequence();

		compiler.getKillers().forEach(k -> {
			if (k.getMurderSequence() == control)
				list.add("killer name: " + k.getName() + " - greater sequence: ( " + k.getMurderSequence() + " )");
		});

		return list;
	}

	@Override
	public List<String> getAwardsEarnedByFiveMurdersIntoOneMinute() {
		List<String> awards = new ArrayList<>();

		Comparator<Killer> awardsComparator = (a1, a2) -> {
			Integer award = a1.getAwardFiveMurdersOneMinute();
			return award.compareTo(a2.getAwardFiveMurdersOneMinute());
		};

		Collections.sort(compiler.getKillers(), Collections.reverseOrder(awardsComparator));

		compiler.getKillers().forEach(k -> {
			if (k.getAwardFiveMurdersOneMinute() > 0)
				awards.add("Killer name: " + k.getName() + "   - awards earned by five murders in a minute ( "
						+ k.getAwardFiveMurdersOneMinute() + " )");
		});

		return awards;
	}

	@Override
	public List<String> getKillersThatHasNotDied() {
		List<String> awards = new ArrayList<>();

		Comparator<Killer> awardsComparator = (a1, a2) -> {
			Integer award = a1.getAwardMatchWithoutDeath();
			return award.compareTo(a2.getAwardMatchWithoutDeath());
		};

		Collections.sort(compiler.getKillers(), Collections.reverseOrder(awardsComparator));

		compiler.getKillers().forEach(k -> {
			if (k.getAwardMatchWithoutDeath() > 0)
				awards.add("Killer name: (" + k.getName() + ")  won an award by not die into a match");
		});

		return awards;
	}

}
