package business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import models.Killer;
import models.Ninja;
import models.Soldier;
import parser.LogLineData;
import parser.LogFileMatchParser;
import util.DateUtil;
import util.ReadAndWriteFileUtil;

/**
 * @author edneyroldao
 */
public class MatchInput extends Match {

	// Attributes
	private final List<LogLineData> dataList;
	private final LogFileMatchParser parser;
	private List<Killer> killers = new ArrayList<>();

	// Constructor
	public MatchInput(String filePath) {
		List<String> list = ReadAndWriteFileUtil.readLogFile(filePath);
		parser = new LogFileMatchParser(list);
		dataList = parser.getParsedList();
		setId(parser.retrieveMatchId());
		posConstruct();
	}

	private void posConstruct() {
		countMurdersAndWeapons();
		countDeaths();
		addAwardKillerNotDead();
		setGreatMurderSequence();
		addAwardFiveMurders();
		setKillers(killers);
		addPreferedWeapon();
	}

	/**
	 * This method does the murders count and the weapon used.
	 */
	public void countMurdersAndWeapons() {
		for (LogLineData d : dataList) {
			int killerIdex = getKillerIndex(d.getKillerName());
			if (!d.getKillerName().equals("<WORLD>")) {
				if (killerIdex == -1) {
					Soldier s = new Soldier(d.getKillerName());
					s.getWeapons().put(d.getWeaponName(), 1);
					s.setMurdersNumber(1);
					killers.add(s);
				} else {
					int murder = killers.get(killerIdex).getMurdersNumber();
					killers.get(killerIdex).setMurdersNumber(murder + 1);

					if (killers.get(killerIdex).getWeapons().containsKey(d.getWeaponName())) {
						int value = killers.get(killerIdex).getWeapons().get(d.getWeaponName());
						killers.get(killerIdex).getWeapons().put(d.getWeaponName(), value + 1);
					} else {
						killers.get(killerIdex).getWeapons().put(d.getWeaponName(), 1);
					}

				}
			}
		}
	}

	/**
	 * This method does the deaths count.
	 */
	public void countDeaths() {
		for (LogLineData d : dataList) {

			if (!d.getDeadName().equals("<WORLD>")) {
				int deadIndex = getKillerIndex(d.getDeadName());

				if (deadIndex == -1) {
					Ninja n = new Ninja(d.getDeadName());
					n.setDeathsNumber(1);
					killers.add(n);
				} else {
					int death = killers.get(deadIndex).getDeathsNumber();
					killers.get(deadIndex).setDeathsNumber(death + 1);
				}
			}
		}
	}

	// Support method ( countDeaths() and countMurdersAndWeapons() )
	private int getKillerIndex(String killer) {
		for (int i = 0; i < killers.size(); i++) {
			if (killers.get(i).getName().equals(killer))
				return i;
		}
		return -1;
	}

	/**
	 * This method add an award when the killer wasn't dead in a whole match.
	 */
	public void addAwardKillerNotDead() {
		for (int i = 0; i < killers.size(); i++) {
			if (killerHasNotDeath(killers.get(i).getName())) {
				int awards = killers.get(i).getAwardNumber();
				killers.get(i).setAwardNumber(awards + 1);
			}

		}
	}

	// Support method ( addAwardKillerNotDead() )
	private boolean killerHasNotDeath(String killer) {
		for (LogLineData d : dataList) {
			if (d.getDeadName().equals(killer)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * add greater murders sequence without death.
	 */
	public void setGreatMurderSequence() {
		for (int i = 0; i < killers.size(); i++) {
			int sequence = getMurderSequence(killers.get(i).getName());
			killers.get(i).setMurderSequence(sequence);
		}
	}

	// Support method ( setGreatMurderSequence() )
	private int getMurderSequence(String killer) {
		List<Integer> murders = new ArrayList<>();
		int sequence = 0;

		for (LogLineData d : dataList) {
			if (killer.equals(d.getKillerName())) {
				sequence += 1;
			} else {
				murders.add(sequence);
				sequence = 0;
			}
		}

		Collections.sort(murders);

		return murders.get(murders.size() - 1);
	}

	/**
	 * Add awards when the killer has five murders in a minute.
	 */
	public void addAwardFiveMurders() {
		for (int i = 0; i < killers.size(); i++) {
			int awards = getAwardsFiveMurdersOneMinute(killers.get(i).getName());
			int award = killers.get(i).getAwardNumber();
			killers.get(i).setAwardNumber(award + awards);
		}
	}

	// Support method ( addAwardFiveMurders() )
	private int getAwardsFiveMurdersOneMinute(String killer) {
		List<LogLineData> dataSubList = dataList;
		int awards = 0;

		while (!dataSubList.isEmpty()) {
			Calendar calendar = DateUtil.stringToCalendar(dataSubList.get(0).getActionTime());
			calendar.add(Calendar.MINUTE, 1);
			List<LogLineData> subList = new ArrayList<>();
			int countMurder = 0;

			for (LogLineData d : dataSubList) {
				Calendar c = DateUtil.stringToCalendar(d.getActionTime());
				if (c.compareTo(calendar) <= 0) {
					subList.add(d);
				}
			}

			for (LogLineData d : subList) {
				if (d.getKillerName().equals(killer))
					countMurder += 1;
			}

			if (countMurder >= 5)
				awards += 1;

			dataSubList.removeAll(subList);
		}

		return awards;
	}

	/**
	 * This keep only prefered weapon. 
	 * @param killer
	 */
	public void addPreferedWeapon() {
		for(int i = 0; i < killers.size(); i++) {
			final List<Entry<String, Integer>> entries = new ArrayList<Entry<String, Integer>>(
					killers.get(i).getWeapons().entrySet());
			Entry<String, Integer> lastEntry = entries.get(entries.size() - 1);
			Map<String, Integer> entry = new HashMap<>();
			entry.put(lastEntry.getKey(), lastEntry.getValue());
			
			killers.get(i).setWeapons(entry);
		}
	}

}
